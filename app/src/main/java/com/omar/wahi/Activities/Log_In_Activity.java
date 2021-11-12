package com.omar.wahi.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

public class Log_In_Activity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout inputEmail,inputPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        setInitializing();

    }

    private void setInitializing() {

        TextView intent_create_account = findViewById(R.id.intent_create_account);
        intent_create_account.setOnClickListener(this);

        MaterialButton btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);

        inputEmail = findViewById(R.id.textInputEmail_login);
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

        inputPass = findViewById(R.id.textInputPass_login);
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

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.intent_create_account:
                startActivity(new Intent(Log_In_Activity.this,Sing_up_Activity.class));
                break;

            case R.id.btn_login:
                Authentication();
                break;

        }
    }

    private void Authentication() {

        String email = Objects.requireNonNull(inputEmail.getEditText()).getText().toString().trim();
        String pass = Objects.requireNonNull(inputPass.getEditText()).getText().toString().trim();

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

        LoadingDialog loadingDialog = new LoadingDialog(Log_In_Activity.this);
        loadingDialog.startLoadingDialog();

        Handler h = new Handler();
        h.postDelayed(() -> {

            loadingDialog.dismissDialog();

            startActivity(new Intent(Log_In_Activity.this,MainActivity.class));

            //finish();

        }, 5000);

    }

    private void ShowError(TextInputLayout layout, String error){
        layout.setError(error);
        layout.requestFocus();
    }
}