package edu.cvtc.jdiederich2.workorders;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class WorkOrderListActivity extends Activity {

    private Button viewWorkOrder;

    private WorkOrderViewModel mWorkOrderViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_workorderlist );

        mWorkOrderViewModel = ViewModelProviders.of(this).get(WorkOrderViewModel.class);

        mWorkOrderViewModel.getAllWorkOrders().observe(this, new Observer<List<WorkOrderModel>>() {
            @Override
            public void onChanged(@Nullable List<WorkOrderModel> workOrders) {

            }
        });
        viewWorkOrder = (Button) findViewById( R.id.button_ViewWorkOrders );

        viewWorkOrder.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        } );
    }
}
