package edu.cvtc.jdiederich2.workorders;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class WorkOrderListActivity extends AppCompatActivity implements View.OnClickListener {

    private Button viewWorkOrders;

    private WorkOrderViewModel mWorkOrderViewModel;
    private WorkOrderListRecyclerViewAdapter mWorkOrderViewAdapter;
    private RecyclerView mRecyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_workorderlist );

        mRecyclerView = (RecyclerView) findViewById( R.id.list );
        mWorkOrderViewAdapter = new WorkOrderListRecyclerViewAdapter( new ArrayList<WorkOrderModel>(), this );
        mRecyclerView.setLayoutManager( new LinearLayoutManager( this ));

        mRecyclerView.setAdapter( mWorkOrderViewAdapter );

        mWorkOrderViewModel = ViewModelProviders.of(this).get(WorkOrderViewModel.class);

        mWorkOrderViewModel.getAllWorkOrders().observe(this, new Observer<List<WorkOrderModel>>() {
            @Override
            public void onChanged(@Nullable List<WorkOrderModel> workOrders) {
  ;
            }
        });


        viewWorkOrders = (Button) findViewById( R.id.button_ViewWorkOrders );

        viewWorkOrders.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                WorkOrderModel workOrderModel = (WorkOrderModel) v.getTag();
                mWorkOrderViewModel.getAllWorkOrders();
            }
        } );
    }

    @Override
    public void onClick(View v) {

    }
}
