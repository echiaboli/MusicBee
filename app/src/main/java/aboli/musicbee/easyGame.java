package aboli.musicbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class easyGame extends AppCompatActivity {

    private Intent intent;
    private Integer timer;
    private Boolean showKeys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_game);
        intent = getIntent();
        timer = intent.getIntExtra(GameSettings.EXTRA_TIMER, 60);
        showKeys = intent.getBooleanExtra(GameSettings.EXTRA_LETTERS, true);
    }
}
