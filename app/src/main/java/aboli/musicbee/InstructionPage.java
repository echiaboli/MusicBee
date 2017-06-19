package aboli.musicbee;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by caleb on 6/14/2017.
 */

public class InstructionPage {
    String intro;
    public void IntoMessage(String difficulty){
    if (difficulty == "Easy"){
        Context context = getApplicationContext();
        CharSequence text = "Try and press the correct keys on the keyboard according to the words displayed above! After you enter the notes hit submit. If the answers is correct" +
                " you will gain 5 seconds. If you guess wrong it's minus 5 seconds! Try to get as many correct before the time runs out!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
    else if (difficulty == "Intermediate"){

    }
    else if (difficulty == "Hard"){
        Context context = getApplicationContext();
        CharSequence text = "The staff will appear with notes on it. Try and guess the word above with the letters below. After you enter the letters hit submit. If the answers is correct" +
                " you will gain 5 seconds. If you guess wrong it's minus 5 seconds! Try to get as many correct before the time runs out!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
    }


}
