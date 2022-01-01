package mu.psi.nextgen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import mu.psi.nextgen.databinding.ActivityAuthenticationBinding;

public class Authentication extends AppCompatActivity {

    ActivityAuthenticationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityAuthenticationBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());

        this.binding.authenticationScreenLogo.animate().alpha(1).setDuration(1800);
    }
}