package aboli.musicbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Activity that shows a user what settings the game can run with and allows them to select the ones
 * that they wish to use within their game.
 *
 * @author Jesse Scott
 */
public class GameSettings extends AppCompatActivity {


    private Integer timer;
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
        TextView t = (TextView) findViewById(R.id.textTime);
        t.setText(Integer.toString(timer) + " Seconds");
    }

    protected void press45(View view) {
        timer = 45;
        TextView t = (TextView) findViewById(R.id.textTime);
        t.setText(Integer.toString(timer) + " Seconds");
    }

    protected void press60(View view) {
        timer = 60;
        TextView t = (TextView) findViewById(R.id.textTime);
        t.setText(Integer.toString(timer) + " Seconds");
    }

    protected void onSubmit(View view) {
        final CheckBox instructions = (CheckBox) findViewById(R.id.showInstructions);
        final CheckBox letters = (CheckBox) findViewById(R.id.showLetters);

        if (!letters.isChecked() && instructions.isChecked()) {
            Log.d("GameSettings", "!!! Entered is not checked letters, isChecked instructions");
            Intent intent = new Intent(getApplicationContext(), Instruction_Page.class);
            Bundle extras = new Bundle();
            intent.putExtra("EXTRA_TIMER", timer);
            intent.putExtra("EXTRA_DIFFICULTY", difficulty);
            //the user does not want letters on their keyboard
            //GIVE THE POOR PERSON SOME POINTS
            intent.putBoolean("HAS_LETTERS", false);
            //intent.putExtras(extras);
            startActivity(intent);
        }
        // if the user doesn't want letters and wants to skip instructions move to easy/hard
        else if (!letters.isChecked() && !instructions.isChecked()) {
            Log.d("GameSettings", "!!! Entered is not checked letters, is not checked instructions");
            if (difficulty == "Hard") {
                //Intent intent = new Intent(getApplicationContext(), HardGame.class);
            }
            else if (difficulty == "Easy") {
                Intent intent = new Intent(getApplicationContext(), easyGame.class);
                Bundle extras = new Bundle();
                extras.putInt("EXTRA_TIMER", timer);
                extras.putBoolean("HAS_LETTERS", false);
                intent.putExtra("EXTRA_INFO", extras);
                startActivity(intent);
            }
        }
        else {
            String display = "GameSettings";
            Log.w(display, "!!! Entered catchall else statement in GameSettings.Java");
            Intent intent = new Intent(getApplicationContext(), Instruction_Page.class);
            Bundle extras = new Bundle();
            extras.putInt("EXTRA_TIMER", timer);
            extras.putString("EXTRA_DIFFICULTY", difficulty);
            //the user does not want letters on their keyboard
            //GIVE THE POOR PERSON SOME POINTS
            extras.putBoolean("HAS_LETTERS", false);
            intent.putExtras(extras);
            startActivity(intent);
        }
    }
}
