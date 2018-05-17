package edu.cvtc.jdiederich2.workorders;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
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


    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

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

                Intent replyIntent = new Intent();
                if(TextUtils.isEmpty(mFirstName.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String fName = mFirstName.getText().toString();
                    String lName = mLastName.getText().toString();
                    String phone = mPhone.getText().toString();
                    String address = mAddress.getText().toString();
                    String city = mCity.getText().toString();
                    String acctNumber = mAccountNumber.getText().toString();
                    String installDate = mInstallDate.getText().toString();

                    // Add Work Order
                    // WorkOrder workOrder = new WorkOrder();
//                    workOrder.setCsFirstName(v);
//                    workOrder.setCsLastName(mLastName.getText().toString());
//                    workOrder.setCsPhoneNumber(mPhone.getText().toString());
//                    workOrder.setCsAddress(mAddress.getText().toString());
//                    workOrder.setCsCity(mCity.getText().toString());
//                    workOrder.setCsAccountNum(Integer.parseInt(mAccountNumber.getText().toString()));
//                    workOrder.setCsInstallDate(mInstallDate.getText().toString());

                    replyIntent.putExtra(EXTRA_REPLY, fName);
                    setResult(RESULT_OK, replyIntent);


                }
                // Get the ViewModel.




//                workOrderObject = workOrder;
//                db.WorkOrdersDao().insertWorkOrder(workOrder);


//                db = WorkOrdersDatabase.getDatabaseInstance(getApplication());
//                InsertWorkOrderAsyncTask insertWorkOrderAsyncTask = new InsertWorkOrderAsyncTask(workOrder);
//
//                insertWorkOrderAsyncTask.execute();

                Log.e("WorkOrderInsert", mFirstName.getText().toString());
                Log.e("WorkOrderInsert", mLastName.getText().toString());
                Log.e("WorkOrderInsert", mPhone.getText().toString());
                Log.e("WorkOrderInsert", mAddress.getText().toString());
                Log.e("WorkOrderInsert", mCity.getText().toString());
                Log.e("WorkOrderInsert", mAccountNumber.getText().toString());
                Log.e("WorkOrderInsert", mInstallDate.getText().toString());


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

//    // Separate non-UI thread for queries to run on.
//    private static class InsertWorkOrderAsyncTask extends AsyncTask<WorkOrder, Void, Void> {
//
//        private WorkOrdersDao mAsyncTaskDao;
//        private WorkOrderInsertActivity workOrderInsert;
//
//        private WorkOrderViewModel workOrderViewModel;
//
//        InsertWorkOrderAsyncTask(WorkOrdersDao dao) {
//            mAsyncTaskDao = dao;
//        }
//
//        @Override
//        protected Void doInBackground(final WorkOrder... params) {
//
//            mAsyncTaskDao.insertWorkOrder(workOrderObject);
//
//
//
////            workOrderObject.setCsFirstName(workOrderInsert.mFirstName.getText().toString());
////            workOrderObject.setCsLastName(workOrderInsert.mLastName.getText().toString());
////            workOrderObject.setCsPhoneNumber(workOrderInsert.mPhone.getText().toString());
////            workOrderObject.setCsAddress(workOrderInsert.mAddress.getText().toString());
////            workOrderObject.setCsCity(workOrderInsert.mCity.getText().toString());
////            workOrderObject.setCsAccountNum(Integer.parseInt(workOrderInsert.mAccountNumber.getText().toString()));
////            workOrderObject.setCsInstallDate(workOrderInsert.mInstallDate.getText().toString());
//
//            mAsyncTaskDao.getAllWorkOrders();
//
//            return null;
//        }
//    }
}
