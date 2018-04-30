package edu.cvtc.jdiederich2.workorders;

import android.content.Intent;
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
    private Button login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscreen);

        userName = (EditText) findViewById(R.id.editText_UserName);
        password = (EditText) findViewById(R.id.editText_Password);
        numOfLogAttempts = (TextView) findViewById(R.id.textView_LoginAttempts);
        login = (Button) findViewById(R.id.button_Login);

        numOfLogAttempts.setText("Number of attempts remaining: 5");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateUser(userName.getText().toString(), password.getText().toString());
            }
        });
    }

    private void validateUser(String userName, String password) {
        if ((userName == "jdiederich") && (password == "1234")) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            counter --;

            numOfLogAttempts.setText("No of attempts remaining: " + valueOf(counter));

            if(counter == 0) {
                login.setEnabled(false);

            }
        }
    }
}
