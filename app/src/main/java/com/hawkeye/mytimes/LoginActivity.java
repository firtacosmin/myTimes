package com.hawkeye.mytimes;

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
    String emailLoginString;
    String passwordLoginString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email_Login = findViewById(R.id.loginEditText);
        password_Login = findViewById(R.id.passwordEditText);
        errorTextViewLogin = findViewById(R.id.errorTextViewLogin);
        loginButton = findViewById(R.id.login_button);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailLoginString = email_Login.getText().toString();
                passwordLoginString = password_Login.getText().toString();
                validateLoginFields();
            }
        });
    }

    private void validateLoginFields() {
        if (areLoginFieldsEmpy()) {
            printError("Fields should not be empty!");
        } else {
            Toast.makeText(this, "E-mail and password have been successfully registered ", Toast.LENGTH_LONG).show();
            clearAllFilds();

        }
    }
    private void printError(String errorLogin) {
        errorTextViewLogin.setText(errorLogin);
    }

    private boolean areLoginFieldsEmpy() {
        if(emailLoginString.isEmpty() || passwordLoginString.isEmpty()){
            return true;
        }
        return false;
    }
    private void clearAllFilds(){
        email_Login.getText().clear();
        password_Login.getText().clear();
        errorTextViewLogin.setText("");
    }
}

