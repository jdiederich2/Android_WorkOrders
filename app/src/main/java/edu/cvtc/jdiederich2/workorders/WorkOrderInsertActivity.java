package edu.cvtc.jdiederich2.workorders;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class WorkOrderInsertActivity extends Activity {

    private Button addWorkOrder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.fragment_work_order_insert);

        addWorkOrder = (Button) findViewById( R.id.button_AddWorkOrder );

        addWorkOrder.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        } );

        // TODO: Show WorkOrderListFragment and push WorkOrderInsertFragment to backstack.
//        // Create new fragment and transaction
//        Fragment newFragment = new ExampleFragment();
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//        // Replace whatever is in the fragment_container view with this fragment,
//        // and add the transaction to the back stack
//        transaction.replace(R.id.fragment_container, newFragment);
//        transaction.addToBackStack(null);
//
//        // Commit the transaction
//        transaction.commit();

    }

    // Separate non-UI thread for queries to run on.
    private static class insertWorkOrderAsyncTask extends AsyncTask<WorkOrder, Void, Void> {

        private WorkOrdersDao mAsyncTaskDao;

        insertWorkOrderAsyncTask(WorkOrdersDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final WorkOrder... params) {
            mAsyncTaskDao.insertWorkOrder(params[0]);
            return null;
        }
    }
}
