package edu.cvtc.jdiederich2.workorders;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class UserRegisterActivity extends AppCompatActivity {

    private Button addUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_userregister );

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
