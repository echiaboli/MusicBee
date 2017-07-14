package aboli.musicbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import static aboli.musicbee.easyGame.EXTRA_SCORE;

public class EndGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        Intent intent = getIntent();
        Integer score = intent.getIntExtra(EXTRA_SCORE, 0);

        TextView t = (TextView) findViewById(R.id.FinalScoreDisplay);
        t.setText("Score: " + score);
    }

    protected void restartGame(View view) {
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
    }
}
