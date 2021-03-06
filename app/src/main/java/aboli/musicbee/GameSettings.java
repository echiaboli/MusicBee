package aboli.musicbee;

import android.media.MediaPlayer;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Activity that shows a user what settings the game can run with and allows them to select the ones
 * that they wish to use within their game.
 *
 * @author Jesse Scott
 */
public class GameSettings extends AppCompatActivity {

    MediaPlayer select;
    private Integer timer;
    private String difficulty;
    public static final String EXTRA_TIMER = "EXTRA_TIMER_SAVE";
    public static final String EXTRA_LETTERS = "EXTRA_LETTERS_SAVE";
    public static final String EXTRA_DIFFICULTY = "EXTRA_DIFFICULTY_SAVE";
    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_settings);
        //default values for the base game
        timer = 60;
        difficulty = "Easy";
        select = MediaPlayer.create(this, R.raw.rondo);
        select.start();
    }

    protected void easyPress(View view) {
        difficulty = "Easy";
        t = (TextView) findViewById(R.id.displayDiff);
        t.setText(difficulty);
    }

    protected void hardPress(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Button currently doesn't work, sorry.";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        /*difficulty = "Hard";
        t = (TextView) findViewById(R.id.displayDiff);
        t.setText(difficulty);*/
    }

    protected void press30(View view) {
        timer = 30;
        t = (TextView) findViewById(R.id.textTime);
        String temp = Integer.toString(timer) + " Seconds";
        t.setText(temp);
    }

    protected void press45(View view) {
        timer = 45;
        t = (TextView) findViewById(R.id.textTime);
        String temp = Integer.toString(timer) + " Seconds";
        t.setText(temp);
    }

    protected void press60(View view) {
        timer = 60;
        t = (TextView) findViewById(R.id.textTime);
        String temp = Integer.toString(timer) + " Seconds";
        t.setText(temp);
    }

    protected void onSubmit(View view) {
        select.stop();
        final CheckBox instructions = (CheckBox) findViewById(R.id.showInstructions);
        final CheckBox letters = (CheckBox) findViewById(R.id.showLetters);
        Boolean lettersBool;

        if (!letters.isChecked() && instructions.isChecked()) {
            Log.d("GameSettings", "!!! Entered is not checked letters, isChecked instructions");
            Intent intent = new Intent(getApplicationContext(), Instruction_Page.class);
            intent.putExtra(EXTRA_TIMER, timer);
            intent.putExtra(EXTRA_DIFFICULTY, difficulty);
            //the user does not want letters on their keyboard
            //GIVE THE POOR PERSON SOME POINTS
            lettersBool = letters.isChecked();
            intent.putExtra(EXTRA_LETTERS, lettersBool);
            startActivity(intent);
        }
        // if the user doesn't want letters and wants to skip instructions move to easy/hard
        else if (!letters.isChecked() && !instructions.isChecked()) {
            Log.d("GameSettings", "!!! Entered is not checked letters, is not checked instructions");
            Intent intent;
            if (difficulty.equals("Hard")) {
                intent = new Intent(getApplicationContext(), hardGame.class);
            }
            else if (difficulty.equals("Easy")) {
                intent = new Intent(getApplicationContext(), easyGame.class);
            }
            else
            {
                Log.e("GameSettings", "!!! Intent was not initalized");
                //something's wrong, restart the activity
                intent = new Intent(getApplicationContext(), GameSettings.class);
                Toast errToast = Toast.makeText(getApplicationContext(), "Error changing screens, try again", Toast.LENGTH_LONG);
                errToast.show();
            }
            intent.putExtra(EXTRA_TIMER, timer);
            lettersBool = letters.isChecked();
            intent.putExtra(EXTRA_LETTERS, lettersBool);
            startActivity(intent);
        }
        else if (letters.isChecked() && instructions.isChecked()) {
            Log.d("GameSettings", "!!! Entered is checked letters, is checked instructions");
            Intent intent = new Intent(getApplicationContext(), Instruction_Page.class);
            intent.putExtra(EXTRA_TIMER, timer);
            intent.putExtra(EXTRA_DIFFICULTY, difficulty);
            lettersBool = letters.isChecked();
            intent.putExtra(EXTRA_LETTERS, lettersBool);
            startActivity(intent);
        }
        else if (letters.isChecked() && !instructions.isChecked()) {
            Log.d("GameSettings", "!!! Entered is checked letters, is not checked instructions");
            Intent intent;
            if (difficulty.equals("Hard")) {
                intent = new Intent(getApplicationContext(), hardGame.class);
            }
            else if (difficulty.equals("Easy")) {
                intent = new Intent(getApplicationContext(), easyGame.class);
            }
            else
            {
                Log.e("GameSettings", "!!! Intent was not initalized");
                //something's wrong, restart the activity
                intent = new Intent(getApplicationContext(), GameSettings.class);
                Toast errToast = Toast.makeText(getApplicationContext(), "Error changing screens, try again", Toast.LENGTH_LONG);
                errToast.show();
            }
            intent.putExtra(EXTRA_TIMER, timer);
            lettersBool = letters.isChecked();
            intent.putExtra(EXTRA_LETTERS, lettersBool);
            startActivity(intent);
        }
        else {
            String display = "GameSettings";
            Log.w(display, "!!! Entered catchall else statement in GameSettings.Java");
            Intent intent = new Intent(getApplicationContext(), Instruction_Page.class);
            intent.putExtra(EXTRA_TIMER, timer);
            intent.putExtra(EXTRA_DIFFICULTY, difficulty);
            //the user does not want letters on their keyboard
            //GIVE THE POOR PERSON SOME POINTS
            lettersBool = letters.isChecked();
            intent.putExtra(EXTRA_LETTERS, lettersBool);
            startActivity(intent);
        }
    }
    @Override
    public void onBackPressed() {
        Intent tempInt = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(tempInt);
    }
}
