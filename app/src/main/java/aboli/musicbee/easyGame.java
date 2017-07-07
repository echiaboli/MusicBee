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
        Bundle extras = intent.getExtras();
        timer = extras.getInt("EXTRA_TIMER");
        showKeys = extras.getBoolean("HAS_LETTERS");
    }
}
