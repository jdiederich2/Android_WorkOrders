package edu.cvtc.jdiederich2.workorders.Views;

import android.arch.lifecycle.LiveData;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import edu.cvtc.jdiederich2.workorders.Adapters.WorkOrderListRecyclerViewAdapter;
import edu.cvtc.jdiederich2.workorders.Controllers.WorkOrdersDao;
import edu.cvtc.jdiederich2.workorders.Data.WorkOrderRepository;
import edu.cvtc.jdiederich2.workorders.Data.WorkOrdersDatabase;
import edu.cvtc.jdiederich2.workorders.Models.WorkOrderModel;
import edu.cvtc.jdiederich2.workorders.Models.WorkOrderViewModel;
import edu.cvtc.jdiederich2.workorders.R;

public class WorkOrderInsertActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.reply";

    private EditText mFirstName;
    private EditText mLastName;
    private EditText mPhone;
    private EditText mAddress;
    private EditText mCity;
    private EditText mAccountNumber;
    private EditText mInstallDate;

    private WorkOrderViewModel mWorkOrderViewModel;
    private WorkOrderListRecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;

    private static WorkOrderModel workOrderObject;

    WorkOrderRepository db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_workorderinsert);

        recyclerView = (RecyclerView) findViewById( R.id.list );

        recyclerViewAdapter = new WorkOrderListRecyclerViewAdapter();
        mFirstName = findViewById( R.id.editText_FirstName);
        mLastName = findViewById( R.id.editText_LastName);
        mPhone = findViewById( R.id.editText_Phone);
        mAddress = findViewById( R.id.editText_Address);
        mCity = findViewById(R.id.editText_City);
        mAccountNumber = findViewById( R.id.editText_AcctNumber);
        mInstallDate = findViewById( R.id.editText_InstallDate);
        Button mAddWorkOrderButton = findViewById( R.id.button_AddWorkOrder );

        mAddWorkOrderButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            WorkOrderModel workOrder = new WorkOrderModel();
                workOrder.setCsFirstName( mFirstName.getText().toString());
                workOrder.setCsLastName(mLastName.getText().toString());
                workOrder.setCsPhoneNumber(mPhone.getText().toString());
                workOrder.setCsAddress(mAddress.getText().toString());
                workOrder.setCsCity(mCity.getText().toString());
                workOrder.setCsAccountNum(mAccountNumber.getText().toString());
                workOrder.setCsInstallDate(mInstallDate.getText().toString());

                valueOf( workOrder );

                workOrderObject = workOrder;

                db.insertWorkOrder(workOrder);

//                db = WorkOrdersDatabase.getDatabaseInstance(getApplication());
//                InsertWorkOrderAsyncTask insertWorkOrderAsyncTask = new InsertWorkOrderAsyncTask( (WorkOrdersDao) workOrder );
//
//                insertWorkOrderAsyncTask.execute();

                Intent intent = new Intent( WorkOrderInsertActivity.this, SuccessActivity.class );
                startActivity( intent );

            }

        } );

    }

    public static String valueOf(Object obj) {
        return (obj == null) ? "null" : obj.toString();
    }


    private void showWorkOrder() {
        LiveData<List<WorkOrderModel>> workOrders = (LiveData<List<WorkOrderModel>>) db.getAllWorkOrders();
        Log.d("list", workOrders.toString());
    }


    // Separate non-UI thread for queries to run on.
    private static class InsertWorkOrderAsyncTask extends AsyncTask<WorkOrderModel, Void, Void> {

        private WorkOrdersDao mAsyncTaskDao;
        private WorkOrderInsertActivity workOrderInsert;

        private WorkOrderViewModel workOrderViewModel;

        InsertWorkOrderAsyncTask(WorkOrdersDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final WorkOrderModel... params) {

            mAsyncTaskDao.insertWorkOrder(workOrderObject);

            mAsyncTaskDao.getSingleWorkOrder();

            return null;
        }
    }
}
