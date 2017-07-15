package aboli.musicbee;
import android.media.MediaPlayer;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    MediaPlayer title;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = MediaPlayer.create(this, R.raw.allegro);
        title.start();
    }

    public void clickStart(View view) {
        intent = new Intent(getApplicationContext(), GameSettings.class);
        startActivity(intent);
        title.stop();
    }


}
