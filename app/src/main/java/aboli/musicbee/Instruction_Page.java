package aboli.musicbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import static aboli.musicbee.GameSettings.EXTRA_DIFFICULTY;

public class Instruction_Page extends AppCompatActivity {
    private Intent intent;
    String tempSet;
    protected void clickButton(View view) {
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction__page);
        intent = getIntent();
        String difficulty = intent.getStringExtra(EXTRA_DIFFICULTY);
        TextView t1 = (TextView) findViewById(R.id.directionsTitle);
        tempSet = "Directions for " + difficulty;
        t1.setText(tempSet);
        TextView t = (TextView) findViewById(R.id.thingHere);
        //after everything's been all set, change the intent! -js
        intent.setClass(getApplicationContext(), easyGame.class);
        if (difficulty.equals("Easy")) {

            t.setText("-Try and press the correct keys on the keyboard according to the words displayed " +
                    "above!\n-After you enter the notes hit \"Got it!\".\n-If the answers is correct" +
                    " you will gain 5 seconds.\n-If you guess wrong it's minus 5 seconds!\n-Try to get" +
                    "as many correct before the time runs out!");
        } /*else if(difficulty.equals("Intermediate")) {

        }*/ else if(difficulty.equals("Hard")) {
            t = (TextView) findViewById(R.id.displayDiff);
            t.setText("-The staff will appear with notes on it.\n-Try and guess the word above with the" +
                    " letters below.\n-After you enter the letters hit submit.\n-If the answers is correct" +
                    " you will gain 5 seconds.\n-If you guess wrong it's minus 5 seconds!\n-Try to get " +
                    "as many correct before the time runs out!");

        }

    }

}
