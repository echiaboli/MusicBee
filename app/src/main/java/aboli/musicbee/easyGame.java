package aboli.musicbee;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import static aboli.musicbee.GameSettings.EXTRA_LETTERS;
import static aboli.musicbee.GameSettings.EXTRA_TIMER;

public class easyGame extends AppCompatActivity {
    private CountDownTimer mCountDownTimer;
    private int i = 0;
    private TextView t;
    private TextView t1;
    private Intent intent;
    private Integer timer;
    private Boolean showKeys;
    private String input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_game);
        intent = getIntent();
        timer = intent.getIntExtra(EXTRA_TIMER, 60);
        showKeys = intent.getBooleanExtra(EXTRA_LETTERS, true);
        t1 = (TextView) findViewById(R.id.word);
        input = " ";
        startTimer();
    }

    private void startTimer() {
        t = (TextView) findViewById(R.id.timerText);

        String initial = "Time: " + Integer.toString(timer);
        t.setText(initial);
        Integer timerMS = timer * 1000;
        mCountDownTimer = new CountDownTimer(timerMS, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.v("Log_tag", "Tick of Progress " + i + millisUntilFinished);
                timer--;
                String temp = "Time: " + Integer.toString(timer);
                t.setText(temp);
            }
            @Override
            public void onFinish() {
                Intent intent = new Intent(getApplicationContext(), EndGame.class);
                startActivity(intent);
            }
        };
        mCountDownTimer.start();
    }
    @Override
    public void onBackPressed() {
        mCountDownTimer.cancel();
        Intent tempInt = new Intent(getApplicationContext(), GameSettings.class);
        startActivity(tempInt);
    }

    public void onClickA(View view) {
        input += "A";
        t1.setText(input);
    }
    public void onClickB(View view) {
        input += "B";
        t1.setText(input);
    }
    public void clickC(View view) {
        input += "C";
        t1.setText(input);
    }
    public void onClickD(View view) {
        input += "D";
        t1.setText(input);
    }
    public void onClickE(View view) {
        input += "E";
        t1.setText(input);
    }
    public void onClickF(View view) {
        input += "F";
        t1.setText(input);
    }
    public void onClickG(View view) {
        input += "G";
        t1.setText(input);
    }
    public void clickClear(View view) {
        input = " ";
        t1.setText(input);
    }
}
