package edu.cvtc.jdiederich2.workorders.Views;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

import edu.cvtc.jdiederich2.workorders.Adapters.WorkOrderListRecyclerViewAdapter;
import edu.cvtc.jdiederich2.workorders.Models.WorkOrderModel;
import edu.cvtc.jdiederich2.workorders.R;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class WorkOrderListFragment extends Fragment {

    private int mColumnCount = 7;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public WorkOrderListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate( R.layout.fragment_workorderlist_list, container, false );
    }
}
