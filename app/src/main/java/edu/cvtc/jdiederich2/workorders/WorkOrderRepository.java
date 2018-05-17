package edu.cvtc.jdiederich2.workorders;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WorkOrderRepository {

    private WorkOrdersDao mWorkOrdersDao;
    private List<WorkOrderModel> mAllWorkOrders;
    private List<WorkOrderModel> mSingleWorkOrder;

    // Respository constructor
    WorkOrderRepository(Application application) {
        WorkOrdersDatabase db = WorkOrdersDatabase.getDatabaseInstance(application);

        mWorkOrdersDao = db.WorkOrdersDao();
        mAllWorkOrders = mWorkOrdersDao.getAllWorkOrders();
        mSingleWorkOrder = mWorkOrdersDao.getSingleWorkOrder();
    }

    // LiveData Observer to refresh workOrders list when changed
    LiveData<List<WorkOrderModel>> getAllWorkOrders() {
        return (LiveData<List<WorkOrderModel>>) mAllWorkOrders;
    }

    // LiveData Observer for workOrder insert
    public void insertWorkOrder(WorkOrderModel workOrder) {
        new insertWorkOrderAsyncTask(mWorkOrdersDao).execute(workOrder);
    }

    public LiveData<List<WorkOrderModel>> getSingleWorkOrder() {
        return (LiveData<List<WorkOrderModel>>) mSingleWorkOrder;
    }

    // Separate non-UI thread for queries to run on.
    private static class insertWorkOrderAsyncTask extends AsyncTask<WorkOrderModel, Void, Void> {

        private WorkOrdersDao mAsyncTaskDao;

        insertWorkOrderAsyncTask(WorkOrdersDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final WorkOrderModel... params) {
            mAsyncTaskDao.insertWorkOrder(params[0]);
            mAsyncTaskDao.getAllWorkOrders();
            mAsyncTaskDao.getSingleWorkOrder();
            return null;
        }
    }
}
