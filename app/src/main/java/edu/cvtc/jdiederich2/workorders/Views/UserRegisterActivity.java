package edu.cvtc.jdiederich2.workorders.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.cvtc.jdiederich2.workorders.R;

public class UserRegisterActivity extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private TextView userName;
    private EditText password;
    private Button addUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_userregister );

        firstName = (EditText) findViewById( R.id.editText_FirstName );
        lastName = (EditText) findViewById( R.id.editText_LastName );
        email = (EditText) findViewById( R.id.editText_Email );
        userName = (EditText) findViewById(R.id.editText_UserName);
        password = (EditText) findViewById(R.id.editText_Password);
        addUser = (Button) findViewById( R.id.button_AddUser );

        addUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserRegisterActivity.this, SuccessActivity.class);
                startActivity(intent);
            }
        });
    }
}
