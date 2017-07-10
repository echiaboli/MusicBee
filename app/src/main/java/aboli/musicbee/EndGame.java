package aboli.musicbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EndGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
    }

    protected void restartGame(View view) {
        Intent intent = new Intent(getApplicationContext(), GameSettings.class);
        startActivity(intent);
    }
}
