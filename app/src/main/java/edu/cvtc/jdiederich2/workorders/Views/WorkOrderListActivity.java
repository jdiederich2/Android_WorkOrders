package edu.cvtc.jdiederich2.workorders.Views;

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

import edu.cvtc.jdiederich2.workorders.Models.WorkOrderModel;
import edu.cvtc.jdiederich2.workorders.R;
import edu.cvtc.jdiederich2.workorders.Adapters.WorkOrderListRecyclerViewAdapter;
import edu.cvtc.jdiederich2.workorders.Models.WorkOrderViewModel;

public class WorkOrderListActivity extends AppCompatActivity {

    private Button viewWorkOrders;

    private WorkOrderViewModel mWorkOrderViewModel;
    private WorkOrderListRecyclerViewAdapter mWorkOrderViewAdapter;
    private RecyclerView mRecyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.fragment_workorderlist_list );

        mRecyclerView = (RecyclerView) findViewById( R.id.list );
        mWorkOrderViewAdapter = new WorkOrderListRecyclerViewAdapter( this );
        mRecyclerView.setAdapter( mWorkOrderViewAdapter );
        mRecyclerView.setLayoutManager( new LinearLayoutManager( this ) );

        // Get view model
        mWorkOrderViewModel = ViewModelProviders.of( this ).get( WorkOrderViewModel.class );

        mWorkOrderViewModel.getAllWorkOrders().observe( this, new Observer<List<WorkOrderModel>>() {

            WorkOrderListRecyclerViewAdapter adapter;

            @Override
            public void onChanged(@Nullable List<WorkOrderModel> workOrders) {
                adapter.setWorkOrderList( workOrders );
            }
        } );
    }
}