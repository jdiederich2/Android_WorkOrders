package edu.cvtc.jdiederich2.workorders;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorkOrderListActivity extends Activity {

    private Button viewWorkOrder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_workorderlist );

        viewWorkOrder = (Button) findViewById( R.id.button_ViewWorkOrders );

        viewWorkOrder.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        } );
    }
}
