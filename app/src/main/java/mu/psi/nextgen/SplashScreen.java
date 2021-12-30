package mu.psi.nextgen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import mu.psi.nextgen.databinding.ActivitySplashScreenBinding;

public class SplashScreen extends AppCompatActivity {

    ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());

        // to hide top status bar (system), use below line
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.binding.splashScreenLogo.setX(-2000);
        this.binding.splashScreenLogo.animate().translationX(0).setDuration(2000);

        int SPLASH_SCREEN_DISPLAY_LENGTH = 2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashIntent = new Intent(SplashScreen.this, Authentication.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(splashIntent);
                finish();
            }
        }, SPLASH_SCREEN_DISPLAY_LENGTH);
    }
}