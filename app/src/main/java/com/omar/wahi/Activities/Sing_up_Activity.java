package com.omar.wahi.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.omar.wahi.LoadingDialog;
import com.omar.wahi.R;

import java.util.Objects;

public class Sing_up_Activity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout userName, inputEmail, inputPass, inputConfirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        setInitializing();

    }

    private void setInitializing() {

        userName = findViewById(R.id.textInputUserName_SingUp);
        Objects.requireNonNull(userName.getEditText()).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                userName.setErrorEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputEmail = findViewById(R.id.textInputEmail_SignUp);
        Objects.requireNonNull(inputEmail.getEditText()).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                inputEmail.setErrorEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputPass = findViewById(R.id.textInputPass_SingUp);
        Objects.requireNonNull(inputPass.getEditText()).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                inputPass.setErrorEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputConfirmPass = findViewById(R.id.textInputPassConfirm_SingUp);
        Objects.requireNonNull(inputConfirmPass.getEditText()).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                inputConfirmPass.setErrorEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        MaterialButton btn_SignUp = findViewById(R.id.btn_create_account);
        btn_SignUp.setOnClickListener(this);

        TextView intent_login = findViewById(R.id.intent_login);
        intent_login.setOnClickListener(this);

    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_create_account:
                CreateAccount();
                break;

            case R.id.intent_login:
                super.onBackPressed();
                break;

        }
    }

    private void CreateAccount() {

        String name = Objects.requireNonNull(userName.getEditText()).getText().toString().trim();
        String email = Objects.requireNonNull(inputEmail.getEditText()).getText().toString().trim();
        String pass = Objects.requireNonNull(inputPass.getEditText()).getText().toString().trim();
        String confirmPass = Objects.requireNonNull(inputConfirmPass.getEditText()).getText().toString().trim();

        if (name.isEmpty()){
            ShowError(userName,getString(R.string.enter_name));
            return;
        }

        if (email.isEmpty()){
            ShowError(inputEmail,getString(R.string.enter_email));
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            ShowError(inputEmail,getString(R.string.email_valid));
            return;
        }

        if (pass.isEmpty()){
            ShowError(inputPass,getString(R.string.enter_pass));
            return;
        }

        if (pass.length() < 6){
            ShowError(inputPass,getString(R.string.minimum_pass));
            return;
        }

        if (confirmPass.isEmpty()){
            ShowError(inputConfirmPass,getString(R.string.u_should_confirm_pass));
            return;
        }

        if (!Objects.equals(pass, confirmPass)){
            ShowError(inputConfirmPass,getString(R.string.password_not_matched));
            return;
        }

        LoadingDialog loadingDialog = new LoadingDialog(Sing_up_Activity.this);
        loadingDialog.startLoadingDialog();

    }

    private void ShowError(TextInputLayout layout, String error){
        layout.setError(error);
        layout.requestFocus();
    }
}