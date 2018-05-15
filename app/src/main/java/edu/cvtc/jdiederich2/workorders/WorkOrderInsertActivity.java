package edu.cvtc.jdiederich2.workorders;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.arch.lifecycle.LiveData;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class WorkOrderInsertActivity extends Activity {


    private EditText mFirstName;
    private EditText mLastName;
    private EditText mPhone;
    private EditText mAddress;
    private EditText mCity;
    private EditText mAccountNumber;
    private EditText mInstallDate;

    private Button mAddWorkOrder;

    private static WorkOrder workOrderObject;

    WorkOrdersDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.fragment_work_order_insert);

        mFirstName = findViewById( R.id.editText_FirstName);
        mLastName = findViewById( R.id.editText_LastName);
        mPhone = findViewById( R.id.editText_Phone);
        mAddress = findViewById( R.id.editText_Address);
        mCity = findViewById(R.id.editText_City);
        mAccountNumber = findViewById( R.id.editText_AcctNumber);
        mInstallDate = findViewById( R.id.editText_InstallDate);

        mAddWorkOrder = findViewById( R.id.button_AddWorkOrder );

        mAddWorkOrder.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                // Add Work Order
                WorkOrder workOrder = new WorkOrder();
//                workOrder.setCsFirstName(mFirstName.getText().toString());
//                workOrder.setCsLastName(mLastName.getText().toString());
//                workOrder.setCsPhoneNumber(mPhone.getText().toString());
//                workOrder.setCsAddress(mAddress.getText().toString());
//                workOrder.setCsCity(mCity.getText().toString());
//                workOrder.setCsAccountNum(Integer.parseInt(mAccountNumber.getText().toString()));
//                workOrder.setCsInstallDate(mInstallDate.getText().toString());
//                workOrderObject = workOrder;
//                db.WorkOrdersDao().insertWorkOrder(workOrder);

                db = WorkOrdersDatabase.getDatabaseInstance(getApplication());
                InsertWorkOrderAsyncTask insertWorkOrderAsyncTask = new InsertWorkOrderAsyncTask(
                    workOrder.setCsFirstName(mFirstName.getText().toString());
                    workOrder.setCsLastName(mLastName.getText().toString());
                    workOrder.setCsPhoneNumber(mPhone.getText().toString());
                    workOrder.setCsAddress(mAddress.getText().toString());
                    workOrder.setCsCity(mCity.getText().toString());
                    workOrder.setCsAccountNum(Integer.parseInt(mAccountNumber.getText().toString()));
                    workOrder.setCsInstallDate(mInstallDate.getText().toString());

                );

                insertWorkOrderAsyncTask.execute();

//                InsertWorkOrderAsyncTask insertWorkOrderAsyncTask = new InsertWorkOrderAsyncTask(workOrderObject);
//                insertWorkOrderAsyncTask.execute();
            }
        });



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


    private void showWorkOrder() {
        LiveData<List<WorkOrder>> workOrders = (LiveData<List<WorkOrder>>) db.WorkOrdersDao().getAllWorkOrders();
        Log.d("list", workOrders.toString());
    }

    // Separate non-UI thread for queries to run on.
    private static class InsertWorkOrderAsyncTask extends AsyncTask<WorkOrder, Void, Void> {

        private WorkOrdersDao mAsyncTaskDao;
        private WorkOrder workOrder;
        private WorkOrderInsertActivity workOrderInsert;

        InsertWorkOrderAsyncTask(WorkOrdersDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final WorkOrder... params) {

            workOrderObject = workOrder;
            WorkOrderInsertActivity.workOrderObject.setCsFirstName(workOrderInsert.mFirstName.getText().toString());
            WorkOrderInsertActivity.workOrderObject.setCsLastName(workOrderInsert.mLastName.getText().toString());
            WorkOrderInsertActivity.workOrderObject.setCsPhoneNumber(workOrderInsert.mPhone.getText().toString());
            WorkOrderInsertActivity.workOrderObject.setCsAddress(workOrderInsert.mAddress.getText().toString());
            WorkOrderInsertActivity.workOrderObject.setCsCity(workOrderInsert.mCity.getText().toString());
            WorkOrderInsertActivity.workOrderObject.setCsAccountNum(Integer.parseInt(workOrderInsert.mAccountNumber.getText().toString()));
            WorkOrderInsertActivity.workOrderObject.setCsInstallDate(workOrderInsert.mInstallDate.getText().toString());

            return null;
        }
    }
}
