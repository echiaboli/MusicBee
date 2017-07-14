package aboli.musicbee;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static aboli.musicbee.GameSettings.EXTRA_DIFFICULTY;
import static aboli.musicbee.GameSettings.EXTRA_LETTERS;
import static aboli.musicbee.GameSettings.EXTRA_TIMER;

public class Instruction_Page extends AppCompatActivity {
    private String difficulty;
    private Intent intent;
    private TextView t;

    protected void clickButton(View view) {
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction__page);
        intent = getIntent();
        difficulty = "Easy";
        TextView t1 = (TextView) findViewById(R.id.directionsTitle);
        t1.setText("Directions for " + difficulty);
        t = (TextView) findViewById(R.id.thingHere);
        //after everything's been all set, change the intent! -js
        intent.setClass(getApplicationContext(), easyGame.class);
        if (difficulty == "Easy") {

            t.setText("-Try and press the correct keys on the keyboard according to the words displayed " +
                    "above!\n-After you enter the notes hit \"Got it!\".\n-If the answers is correct" +
                    " you will gain 5 seconds.\n-If you guess wrong it's minus 5 seconds!\n-Try to get" +
                    "as many correct before the time runs out!");
        } else if(difficulty == "Intermediate") {

        } else if(difficulty == "Hard") {
            t = (TextView) findViewById(R.id.displayDiff);
            t.setText("The staff will appear with notes on it. Try and guess the word above with the letters below. After you enter the letters hit submit. If the answers is correct" +
                    " you will gain 5 seconds. If you guess wrong it's minus 5 seconds! Try to get as many correct before the time runs out!");

        }

    }
    /**
    public void IntroMessage() {

    }
     */

}
