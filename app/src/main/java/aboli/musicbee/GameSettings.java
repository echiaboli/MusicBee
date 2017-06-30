package aboli.musicbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Activity that shows a user what settings the game can run with and allows them to select the ones
 * that they wish to use within their game.
 *
 * @author Jesse Scott
 */
public class GameSettings extends AppCompatActivity {


    private Integer timer;
    private Intent intent;
    private String difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_settings);
        timer = 30;
        difficulty = "Easy";
    }

    /**
     * A method for when the user presses the "Easy" difficulty button
     *
     */
    protected void easyPress(View view) {
        difficulty = "Easy";
        TextView t = (TextView) findViewById(R.id.displayDiff);
        t.setText(difficulty);
    }

    protected void hardPress(View view) {
        difficulty = "Hard";
        TextView t = (TextView) findViewById(R.id.displayDiff);
        t.setText(difficulty);
    }

    protected void press30(View view) {
        timer = 30;
    }

    protected void press45(View view) {
        timer = 45;
    }

    protected void press60(View view) {
        timer = 60;
    }

    public void onSubmit(View view) {
        Intent intent = new Intent(getApplicationContext(), Instruction_Page.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_TIMER", timer);
        extras.putString("EXTRA_DIFFICULTY", difficulty);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
