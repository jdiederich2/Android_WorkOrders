package edu.cvtc.jdiederich2.workorders;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class WorkOrderInsertFragment extends Fragment{

    private Button addWorkOrder;

    public WorkOrderInsertFragment() {
        // Required empty public constructor
    }


    /* Main activity in charge of controlling this. */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate( R.layout.fragment_work_order_insert, container, false );
    }
}
