package edu.cvtc.jdiederich2.workorders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

   private Button enterWorkOrder;
   private Button lookUpWorkOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterWorkOrder = (Button) findViewById( R.id.button_EnterWorkOrder );
        lookUpWorkOrder = (Button) findViewById( R.id.button_ViewWorkOrders );

        enterWorkOrder.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, WorkOrderInsertActivity.class );
                startActivity( intent );
            }
        });

        lookUpWorkOrder.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, WorkOrderListActivity.class );
            }
        } );

    }
}
