package aboli.musicbee;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Currently a test class where Jesse tests concepts
 * current concept: timers.
 * Coming soon: Timers AND progress bars.
 * SRC: https://stackoverflow.com/questions/10241633/android-progressbar-countdown
 */
public class hardGame extends AppCompatActivity {
    CountDownTimer mCountDownTimer;
    int i = 0;
    Integer time = 30;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_game);
        t = (TextView) findViewById(R.id.timer);
        mCountDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.v("Log_tag", "Tick of Progress " + i + millisUntilFinished);
                time--;
                String temp = "Time" + Integer.toString(time);
                t.setText(temp);
            }

            @Override
            public void onFinish() {
                i++;
            }
        };
        mCountDownTimer.start();
    }
}