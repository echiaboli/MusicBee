package aboli.musicbee;

import android.media.MediaPlayer;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static aboli.musicbee.GameSettings.EXTRA_LETTERS;
import static aboli.musicbee.easyGame.EXTRA_SCORE;

public class EndGame extends AppCompatActivity {

    MediaPlayer gameover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        gameover = MediaPlayer.create(this, R.raw.andante);
        gameover.start();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        Intent intent = getIntent();
        Integer score = intent.getIntExtra(EXTRA_SCORE, 0);
        Boolean showKeys = intent.getBooleanExtra(EXTRA_LETTERS, true);

        TextView t = (TextView) findViewById(R.id.FinalScoreDisplay);
        if(!showKeys) {
            t.setText("Score: " + score);
        }
        else {
            t.setText(" ");
        }
    }

    protected void restartGame(View view) {
        gameover.stop();
        Intent intent = new Intent(getApplicationContext(), GameSettings.class);
        startActivity(intent);
    }

    /*
     * When the back button is pressed, jump back to the settings page.
     * YOU SHALL NOT PASS -js
     */
    @Override
    public void onBackPressed() {
        Intent tempInt = new Intent(getApplicationContext(), GameSettings.class);
        startActivity(tempInt);
        gameover.stop();
    }
}
