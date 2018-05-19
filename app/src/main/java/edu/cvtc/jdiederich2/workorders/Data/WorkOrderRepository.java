package edu.cvtc.jdiederich2.workorders.Data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import edu.cvtc.jdiederich2.workorders.Controllers.WorkOrdersDao;
import edu.cvtc.jdiederich2.workorders.Models.WorkOrderModel;
import edu.cvtc.jdiederich2.workorders.Models.User;
import edu.cvtc.jdiederich2.workorders.Controllers.UserDao;

public class WorkOrderRepository {

    private UserDao mUserDao;
    private LiveData<List<User>> mUser;

    private WorkOrdersDao mWorkOrderDao;
    private LiveData<List<WorkOrderModel>> mAllWorkOrders;
    private LiveData<List<WorkOrderModel>> mSingleWorkOrder;

    // Respository constructor
    public WorkOrderRepository(Application application) {
        WorkOrdersDatabase db = WorkOrdersDatabase.getDatabaseInstance(application);

        mWorkOrderDao = db.workOrderModelDao();
        mAllWorkOrders =  mWorkOrderDao.getAllWorkOrders();
        mSingleWorkOrder = mWorkOrderDao.getSingleWorkOrder();
    }

    // LiveData Observer to refresh workOrders list when changed
    public LiveData<List<WorkOrderModel>> getAllWorkOrders() {
        return mAllWorkOrders;
    }

    // LiveData Observer for workOrder insert
    public void insertWorkOrder(WorkOrderModel workOrder) {
        new insertWorkOrderAsyncTask(mWorkOrderDao).execute(workOrder);
    }

    public LiveData<List<User>> getUser() {
        return mUser;
    }

    public void insertUser(User user) {

    }

    private static class insertWorkOrderAsyncTask extends AsyncTask<WorkOrderModel, Void, Void> {

        private WorkOrdersDao mAsyncTaskDao;

        insertWorkOrderAsyncTask(WorkOrdersDao dao) {
            mAsyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final WorkOrderModel... params) {
            mAsyncTaskDao.insertWorkOrder( params[0] );
            return null;
        }
    }
}