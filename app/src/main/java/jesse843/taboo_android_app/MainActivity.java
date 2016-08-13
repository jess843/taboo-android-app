package jesse843.taboo_android_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // keeps track of whether info text is showing or not
    private boolean information_text_showing;
    // information text view
    private TextView infoTextView;
    // fade in animation
    private Animation animFadein;
    // fade out animation
    private Animation animFadeout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing
        information_text_showing = false;
        infoTextView = (TextView) findViewById(R.id.information_text_view);
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        animFadeout = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        ImageButton settings = (ImageButton)findViewById(R.id.settings_button);
        ImageButton information = (ImageButton) findViewById(R.id.info_button);
        assert settings != null;
        assert information != null;
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settings);
            }
        });

        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (information_text_showing){
                    infoTextView.startAnimation(animFadeout);
                    infoTextView.setVisibility(View.INVISIBLE);
                    information_text_showing = false;
                } else {
                    infoTextView.startAnimation(animFadein);
                    infoTextView.setVisibility(View.VISIBLE);
                    information_text_showing = true;
                }
            }
        });

    }



}
