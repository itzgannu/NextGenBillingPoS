package mu.psi.nextgen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

import mu.psi.nextgen.databinding.ActivityLandingScreenBinding;

public class LandingScreen extends AppCompatActivity {

    ActivityLandingScreenBinding binding;

    FirebaseAuth auth; String company_name = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.binding = ActivityLandingScreenBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());

        // to hide top status bar (system), use below line
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        auth = FirebaseAuth.getInstance();
        company_name = Objects.requireNonNull(auth.getCurrentUser()).getDisplayName();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        auth.signOut();
    }
}