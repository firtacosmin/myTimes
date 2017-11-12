
package com.hawkeye.mytimes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    //commit test
    EditText email ;
    EditText password ;
    EditText repassword ;
    TextView errorTextView ;
    Button register ;
    /**
     * The variable that will save teh newly registered user information
     */
    UserInfo userInfo = new UserInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
         email = findViewById(R.id.email_editText);
         password = findViewById(R.id.password_editText);
         repassword = findViewById(R.id.re_password_editText);
         errorTextView = findViewById(R.id.error_textView);
         register = findViewById(R.id.register_button);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateFilds();
            }
        });

    }
    private void hideError(){
        errorTextView.setVisibility(View.INVISIBLE);
        };

    private void printError( String error ){
        //set text to the error textview
        errorTextView.setText(error);

    }
    private void validateFilds() {
        if (areFildsEmpty()) {
            printError("Filds should not be empty!");
        } else if (!checkValidEmail()) {
            printError("Please enter a valid email!");
        } else  if (!checkValidPassword()) {
            printError("Please enter a valid password");
        } else if (!checkPasswordsCoincide()) {
            printError("Password and repassword are not coincide!");
        } else {
            String emailString = email.getText().toString();
            String passwordString = password.getText().toString();
            userInfo.saveEmailAndPassword(emailString ,passwordString);
            Log.d("RegisterActivity","ok");
        }
    }

    /**
     * return True if a fild is empty
     * @return true if at least one field is empty
     */
    private boolean areFildsEmpty() {
        if (email.getText().toString().isEmpty() ||
                password.getText().toString().isEmpty() ||
                repassword.getText().toString().isEmpty()) {
            return true;
        };
        return false;
    }

    private boolean checkValidEmail(){
        if(email.getText().toString().contains("@")&&
                email.getText().toString().contains(".")&&
                !email.getText().toString().startsWith("@")&&
                !email.getText().toString().endsWith("@")&&
                !email.getText().toString().startsWith(".")&&
                !email.getText().toString().endsWith(".")&&
                email.getText().toString().indexOf("@")+1 < email.getText().toString().indexOf(".")
                ){
            return true;
        };
        return false;
    }
    private boolean checkValidPassword(){
        String passwordString = password.getText().toString();
        if(passwordString.length()>= 6 &&
            hasStringNumber(passwordString) &&
                hasStringUpperCase(passwordString) &&
                hasStringSpecialChar(passwordString)){
            return true;
        }
        return false;
    }



    private boolean checkPasswordsCoincide(){
        if (password.getText().toString().equals(repassword.getText().toString())){
            return true;
        };
        return false;
    }
    private boolean hasStringNumber(String str){
//        for(int i =0;i <= str.length();i++){
//            if(48 <= str.charAt(i)&& str.charAt(i) < 57) {
//                return true;
//            }
//        }
//        return false;
        return hasStringCharInRange(str, (char)48, (char)57);

    }
    private boolean hasStringSpecialChar(String str) {
        for(int i = 0 ;i < str.length();i++){
            char c = str.charAt(i);
            if(21 <= c && c < 47 ||
                    58 <= c && c <= 64 ||
                    91 <= c && c <= 96 ||
                    123 <= c && c <= 125 ) {
                return true;
            }
        }
        return false;
    }
    private boolean hasStringUpperCase(String str) {
//        for(int i =0;i <= str.length();i++){
//            if(65 <= str.charAt(i)&& str.charAt(i) < 90) {
//                return true;
//            }
//        }
//        return false;
        return hasStringCharInRange(str, (char)65, (char)90);
    }

    private boolean hasStringCharInRange(String strtocheck, char start, char end){
        for(int i =0;i < strtocheck.length();i++){
            if(start <= strtocheck.charAt(i)&& strtocheck.charAt(i) < end) {
                return true;
            }
        }
        return false;
    }
}
