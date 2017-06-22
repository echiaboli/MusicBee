package aboli.musicbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameSettings extends AppCompatActivity {
    public Integer timer;
    public Intent intent;
    public String difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_settings);
        intent = new Intent(this, Instruction_Page.class);
    }

    public void easyPress() {
        difficulty = "Easy";
    }

    public void hardPress() {
        difficulty = "Hard";
    }

    public void press30() {
        timer = 30;
    }

    public void press45() {
        timer = 45;
    }

    public void press60() {
        timer = 60;
    }

    public void onSubmit(View view) {

        Bundle extras = new Bundle();
        extras.putInt("EXTRA_TIMER",timer);
        extras.putString("EXTRA_DIFFICULTY",difficulty);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
