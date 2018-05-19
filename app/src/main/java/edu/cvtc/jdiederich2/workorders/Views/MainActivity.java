package edu.cvtc.jdiederich2.workorders.Views;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import edu.cvtc.jdiederich2.workorders.Models.WorkOrderModel;
import edu.cvtc.jdiederich2.workorders.Models.WorkOrderViewModel;
import edu.cvtc.jdiederich2.workorders.R;

public class MainActivity extends AppCompatActivity {

    public static final int NEW_WORKORDER_ACTIVITY_REQUEST_CODE = 1;

    private Button enterWorkOrder;
    private Button lookUpWorkOrder;

    private WorkOrderViewModel mWorkOrderViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);

        enterWorkOrder = (Button) findViewById( R.id.button_EnterWorkOrder );
        lookUpWorkOrder = (Button) findViewById( R.id.button_ViewWorkOrders );

        enterWorkOrder.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, WorkOrderInsertActivity.class );
                startActivity(intent);
            }
        });

        lookUpWorkOrder.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, WorkOrderListActivity.class );
                startActivity( intent );
            }
        } );


    }

//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == NEW_WORKORDER_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
//            WorkOrderModel workOrder = new WorkOrderModel(data.g(WorkOrderInsertActivity.EXTRA_REPLY));
//            mWorkOrderViewModel.insert(workOrder);
//        } else {
//            Toast.makeText(
//                    getApplicationContext(),
//                    R.string.empty_not_saved,
//                    Toast.LENGTH_LONG).show();
//        }
//    }
}
