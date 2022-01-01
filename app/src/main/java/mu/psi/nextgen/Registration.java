package mu.psi.nextgen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.Objects;

import mu.psi.nextgen.databinding.ActivityRegistrationBinding;

public class Registration extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    ActivityRegistrationBinding binding;

    Dialog dialog;
    AlertDialog.Builder builder;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());

        builder = new AlertDialog.Builder(this);
        builder.setView(R.layout.progress_bar);
        dialog = builder.create();

        this.binding.registrationFullName.setError(null);
        this.binding.registrationEmailId.setError(null);
        this.binding.registrationPasscode.setError(null);
        this.binding.registrationCompanyName.setError(null);

        this.binding.registrationScreen.setOnTouchListener(this);
        this.binding.registrationRegisterButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.binding.registrationFullName.setError(null);
        this.binding.registrationEmailId.setError(null);
        this.binding.registrationPasscode.setError(null);
        this.binding.registrationCompanyName.setError(null);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        this.binding.registrationFullName.setError(null);
        this.binding.registrationEmailId.setError(null);
        this.binding.registrationPasscode.setError(null);
        this.binding.registrationCompanyName.setError(null);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.registration_register_button) {
            progress_bar(true);
            if (registrationFieldValidations()) {
                //firebase sign up
                //show dialog once registered successfully
                progress_bar(false);
            }
        }
    }

    void progress_bar(boolean show) {
        if (show) {
            dialog.show();
        } else {
            dialog.dismiss();
        }
    }

    boolean registrationFieldValidations() {
        String full_name = Objects.requireNonNull(this.binding.registrationFullName.getEditText()).getText().toString();
        String email = Objects.requireNonNull(this.binding.registrationEmailId.getEditText()).getText().toString();
        String code = Objects.requireNonNull(this.binding.registrationPasscode.getEditText()).getText().toString();
        String company_name = Objects.requireNonNull(this.binding.registrationCompanyName.getEditText()).getText().toString();
        String empty_field = getString(R.string.error_field_empty);
        String name_error = getString(R.string.error_name_minimum_two);
        String email_invalid = getString(R.string.error_invalid_email);
        String code_error = getString(R.string.error_password_minimum_six);
        String company_error = getString(R.string.error_company_minimum_two);
        if (full_name.isEmpty() && email.isEmpty() && code.isEmpty() && company_name.isEmpty()) {
            this.binding.registrationFullName.setError(empty_field);
            this.binding.registrationEmailId.setError(empty_field);
            this.binding.registrationPasscode.setError(empty_field);
            this.binding.registrationCompanyName.setError(empty_field);
            return false;
        } else if (full_name.isEmpty()) {
            this.binding.registrationFullName.setError(empty_field);
            this.binding.registrationEmailId.setError(null);
            this.binding.registrationPasscode.setError(null);
            this.binding.registrationCompanyName.setError(null);
            return false;
        } else if (email.isEmpty()) {
            this.binding.registrationFullName.setError(null);
            this.binding.registrationEmailId.setError(empty_field);
            this.binding.registrationPasscode.setError(null);
            this.binding.registrationCompanyName.setError(null);
            return false;
        } else if (code.isEmpty()) {
            this.binding.registrationFullName.setError(null);
            this.binding.registrationEmailId.setError(null);
            this.binding.registrationPasscode.setError(empty_field);
            this.binding.registrationCompanyName.setError(null);
            return false;
        } else if (company_name.isEmpty()) {
            this.binding.registrationFullName.setError(null);
            this.binding.registrationEmailId.setError(null);
            this.binding.registrationPasscode.setError(null);
            this.binding.registrationCompanyName.setError(empty_field);
            return false;
        } else if (full_name.length() < 2) {
            this.binding.registrationFullName.setError(name_error);
            this.binding.registrationEmailId.setError(null);
            this.binding.registrationPasscode.setError(null);
            this.binding.registrationCompanyName.setError(null);
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            this.binding.registrationFullName.setError(null);
            this.binding.registrationEmailId.setError(email_invalid);
            this.binding.registrationPasscode.setError(null);
            this.binding.registrationCompanyName.setError(null);
            return false;
        } else if (code.length() < 6) {
            this.binding.registrationFullName.setError(null);
            this.binding.registrationEmailId.setError(null);
            this.binding.registrationPasscode.setError(code_error);
            this.binding.registrationCompanyName.setError(null);
            return false;
        } else if (company_name.length() < 2) {
            this.binding.registrationFullName.setError(null);
            this.binding.registrationEmailId.setError(null);
            this.binding.registrationPasscode.setError(null);
            this.binding.registrationCompanyName.setError(company_error);
            return false;
        } else {
            this.binding.registrationFullName.setError(null);
            this.binding.registrationEmailId.setError(null);
            this.binding.registrationPasscode.setError(null);
            this.binding.registrationCompanyName.setError(null);
            return true;
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v.getId() == R.id.registration_screen) {
            InputMethodManager hideSoftKeyBoard = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            hideSoftKeyBoard.hideSoftInputFromWindow(v.getWindowToken(), 0);
            this.binding.registrationFullName.clearFocus();
            this.binding.registrationEmailId.clearFocus();
            this.binding.registrationPasscode.clearFocus();
            this.binding.registrationCompanyName.clearFocus();
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent splashIntent = new Intent(Registration.this, Authentication.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(splashIntent);
        finish();
    }
}