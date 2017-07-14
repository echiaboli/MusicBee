package aboli.musicbee;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import static aboli.musicbee.GameSettings.EXTRA_LETTERS;
import static aboli.musicbee.GameSettings.EXTRA_TIMER;

/**
 * @author Code: Jesse Scott, XML keyboard: Sam Despain
 *
 * A class that handles the interactions for the keyboard,
 * starts the timer for the game,
 * keeps score of the player
 */
public class easyGame extends AppCompatActivity {

    public static final String EXTRA_SCORE = "EXTRA_SCORE";

    private CountDownTimer mCountDownTimer;
    private int i = 10; //10 words, 10 indexes eventually will be modular for the file size
    private TextView t;//timer text
    private TextView t1;//word user enters -js
    private TextView score;
    private Intent intent;
    private Integer timer;
    private Integer scorePoints = 0;
    private Boolean showKeys;
    private String input;
    //private List<String> dictionary;
    private String matchWord;
    private String[] dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_game);
        intent = getIntent();
        timer = intent.getIntExtra(EXTRA_TIMER, 60);
        showKeys = intent.getBooleanExtra(EXTRA_LETTERS, true);
        t1 = (TextView) findViewById(R.id.word);
        score = (TextView)findViewById(R.id.scoreText);
        input = " ";
        //because of how input is handled, each word must start with a space
        //note for future, fix that kthxbai -js
        String [] tDictionary = {" ABC", " DAD", " ADA", " BBAC", " FACE", " GEDEA", " CFGABBA", " ACEFG",
                " DEDA", " EFGBCAE"};
        dictionary = tDictionary;
        /*The hope is to eventually read a file of words in to a string list and pick from there
        * so that adding new words to the list is much easier. The framework is there in the
        * wordDictionary.txt file and readFile function. For the moment though, a hard-coded
        * string will have to do the trick.
        * one day... one daaaay..... -js
        **/
//        dictionary = readFile();

        getRandomWord();

        if (!showKeys) {
            hideKeyTags();
            score.setText("Score: 0");
        }

        startTimer();



    }

    /*
     * changing the text of all the buttons, reusing textChange because allocation is really hard, ok? -js
     */
    private void hideKeyTags() {
        Button textChange = (Button)findViewById(R.id.A);
        textChange.setText(" ");
        textChange = (Button)findViewById(R.id.B);
        textChange.setText(" ");
        textChange = (Button)findViewById(R.id.C);
        textChange.setText(" ");
        textChange = (Button)findViewById(R.id.D);
        textChange.setText(" ");
        textChange = (Button)findViewById(R.id.E);
        textChange.setText(" ");
        textChange = (Button)findViewById(R.id.F);
        textChange.setText(" ");
        textChange = (Button)findViewById(R.id.G);
        textChange.setText(" ");
    }
/*
    private List<String> readFile() {
        BufferedReader reader = null;
        List<String> lines = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("wordDictionary.txt")));
            lines = new ArrayList<String>();
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                lines.add(mLine);
            }
            Log.d("easyGame.java", " !!! File has been written! (yay)");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.e("easyGame.java", "!!! Exception! Reader did not close");
                }
            }
        }

        Log.e ("easyGame.java", "!!! Dictionary file likely not found, Error!");
        return lines;
    }
*/

    /*
     * Checks the answer of the user against the randomly chosen string in the line. -js
     * Seriously, if I could get that file thing to work that'd be pretty frood.
     * *so* much less code.
     * Sorry, its one AM and I know very few people will venture here. hi.
     */
    protected void checkAnswer(View view) {

        if (matchWord.equals(input)) {
            Log.d("checkAnswer", "!!! inputs match! changing word, adding time!");
            if (!showKeys) {
                scorePoints = scorePoints + 1;
                String setScoreThing = "Score: " + Integer.toString(scorePoints);
                score.setText(setScoreThing);
            }
            getRandomWord();
            timer += 5;
            resetTimer();
            clearInput();
            //plan to get timer to work properly, stop and restart timer with new time value
            //inefficient, but can look for a better solution later.
            // ... do that here ... eventually -js
        } else {
          Log.w("checkAnswer", "!!! inputs did not match! changing word, subtracting time!");
            //change the time and reset the timer
            timer -= 5;
            resetTimer();
            if (timer < 1) {
                timer = 0;
                t.setText("Time: " + Integer.toString(timer));
            }
            getRandomWord();
            clearInput();
        }
    }

    private void getRandomWord() {
        Random rand = new Random();
        matchWord = dictionary[rand.nextInt(i)];
        TextView t = (TextView)findViewById(R.id.spellWord);
        t.setText(matchWord);
    }

    private void resetTimer() {
        mCountDownTimer.cancel();
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

    /*
     * clicky buttons!
     * code block that controls what *most* of the buttons do -js
     */
    private void clearInput() {
        input = " ";
        t1.setText(" ");
    }
    public void onClickA(View view) {
        input += "A";
        t1.setText(input);
    }
    public void onClickB(View view) {
        input += "B";
        t1.setText(input);
    }
    public void clickC(View view) {
        input += "C";
        t1.setText(input);
    }
    public void onClickD(View view) {
        input += "D";
        t1.setText(input);
    }
    public void onClickE(View view) {
        input += "E";
        t1.setText(input);
    }
    public void onClickF(View view) {
        input += "F";
        t1.setText(input);
    }
    public void onClickG(View view) {
        input += "G";
        t1.setText(input);
    }
    public void clickClear(View view) {
        input = " ";
        t1.setText(input);
    }
}
