package edu.cvtc.jdiederich2.workorders;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.String.valueOf;


public class LoginActivity extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private TextView numOfLogAttempts;
    private TextView loginError;
    private Button login;
    private int counter = 5;
    private Button resetUserName;
    private Button resetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscreen);

        userName = (EditText) findViewById(R.id.editText_UserName);
        password = (EditText) findViewById(R.id.editText_Password);
        numOfLogAttempts = (TextView) findViewById(R.id.textView_LoginAttempts);
        loginError = (TextView) findViewById(R.id.textView_loginError);
        login = (Button) findViewById(R.id.button_Login);
        resetUserName = (Button) findViewById(R.id.button_forgotUserName);
        resetPassword = (Button) findViewById(R.id.button_forgotPassword);

        numOfLogAttempts.setText("Number of attempts remaining: 5");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateUser(userName.getText().toString(), password.getText().toString());
            }
        });

        resetUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ResetUserNameActivity.this);
                startActivity(intent);
            }
        });

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ResetPasswordActivity.this);
                startActivity(intent);
            }
        });
    }

    private void validateUser(String userName, String password) {
        String userNameTest = "jdiederich";
        String passwordTest = "1234";

        if (userName.equals(userNameTest) || password.equals(passwordTest)) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

        } else {
            counter --;
            loginError.setVisibility(View.VISIBLE);
            loginError.setTextColor(Color.CYAN);
            loginError.setText("Incorrect user name or password");

            this.userName.setText("");
            this.password.setText("");

            numOfLogAttempts.setText("No of attempts remaining: " + valueOf(counter));

            if(counter == 0) {
                login.setEnabled(false);

            }
        }
    }
}
