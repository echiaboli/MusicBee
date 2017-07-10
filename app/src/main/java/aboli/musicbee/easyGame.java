package aboli.musicbee;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class easyGame extends AppCompatActivity {
    private CountDownTimer mCountDownTimer;
    private int i = 0;
    private TextView t;
    private Intent intent;
    private Integer timer;
    private Boolean showKeys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_game);
        intent = getIntent();
        timer = intent.getIntExtra(GameSettings.EXTRA_TIMER, 60);
        showKeys = intent.getBooleanExtra(GameSettings.EXTRA_LETTERS, true);

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
}
