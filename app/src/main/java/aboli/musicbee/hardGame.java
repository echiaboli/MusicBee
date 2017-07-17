package aboli.musicbee;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import static aboli.musicbee.GameSettings.EXTRA_LETTERS;
import static aboli.musicbee.GameSettings.EXTRA_TIMER;

/**
 * Currently a test class where Jesse tests concepts
 * current concept: timers.
 * Coming soon: Timers AND progress bars.
 * SRC: https://stackoverflow.com/questions/10241633/android-progressbar-countdown
 *
 * Eventually this will be an actual feature, but considering time constraints probably not
 * for a little while.
 */
public class hardGame extends AppCompatActivity {

    public static final String EXTRA_SCORE = "EXTRA_SCORE";
    CountDownTimer mCountDownTimer;
    Integer timer = 60;
    TextView t;
    Intent intent;
    Integer scorePoints;
    int i = 0;
    Boolean showKeys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_game);

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

                if (timer < 1) {
                    mCountDownTimer.cancel();
                    mCountDownTimer.onFinish();
                }
            }
            @Override
            public void onFinish() {
                intent = new Intent(getApplicationContext(), EndGame.class);
                intent.putExtra(EXTRA_SCORE, scorePoints);
                intent.putExtra(EXTRA_LETTERS, showKeys);
                startActivity(intent);
            }
        };
        mCountDownTimer.start();
    }
    //override the back button to make it so the game doesn't break! Yay!
    @Override
    public void onBackPressed() {
        mCountDownTimer.cancel();
        Intent tempInt = new Intent(getApplicationContext(), GameSettings.class);
        startActivity(tempInt);
    }
}