package com.hawkeye.mytimes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by CRM on 11/17/2017.
 */

public class LoginActivity extends AppCompatActivity {
    EditText email_Login;
    EditText password_Login;
    TextView errorTextViewLogin;
    Button loginButton;
    TextView registerAcount;
    String emailLoginString;
    String passwordLoginString;

    UserInfo userInfo = new UserInfo();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userInfo.createSharePref(this);
        email_Login = findViewById(R.id.loginEditText);
        password_Login = findViewById(R.id.passwordEditText);
        errorTextViewLogin = findViewById(R.id.errorTextViewLogin);
        loginButton = findViewById(R.id.login_button);
        registerAcount = findViewById(R.id.registerAcount_textView);

        autoLogin();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailLoginString = email_Login.getText().toString();
                passwordLoginString = password_Login.getText().toString();
                validateLoginFields();
            }
        });
        registerAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void autoLogin() {
        if(userInfo.isLoggedInUser()){
            Intent intent = new Intent(LoginActivity.this,TimeActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void validateLoginFields() {
        if (areLoginFieldsEmpy()) {
            printError("Fields should not be empty!");
        } else if (userInfo.loginUser(emailLoginString, passwordLoginString)) {
            performLogin();
        } else {
            Toast.makeText(this, "Entered credentials are not valid! ", Toast.LENGTH_LONG).show();

        }
    }

    private void performLogin() {
        Intent intent = new Intent(LoginActivity.this, TimeActivity.class);
        startActivity(intent);
        finish();
//            Toast.makeText(this, "E-mail and password have been successfully registered ", Toast.LENGTH_LONG).show();
        clearAllFields();
    }

    private void printError(String errorLogin) {
        errorTextViewLogin.setText(errorLogin);
    }

    private boolean areLoginFieldsEmpy() {
        if (emailLoginString.isEmpty() || passwordLoginString.isEmpty()) {
            return true;
        }
        return false;
    }

    private void clearAllFields() {
        email_Login.getText().clear();
        password_Login.getText().clear();
        errorTextViewLogin.setText("");
    }
}

