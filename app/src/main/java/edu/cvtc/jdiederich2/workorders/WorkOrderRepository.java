package edu.cvtc.jdiederich2.workorders;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;

import java.util.List;

public class WorkOrderRepository {

    private WorkOrdersDao mWorkOrdersDao;
    private LiveData<List<WorkOrder>> mAllWorkOrders;

    // Respository constructor
    WorkOrderRepository(Application application) {
        WorkOrdersDatabase db = WorkOrdersDatabase.getDatabaseInstance(application);

        mWorkOrdersDao = db.WorkOrdersDao();
        mAllWorkOrders = mWorkOrdersDao.getAllWorkOrders();
    }

    // LiveData Observer to refresh workOrders list when changed
    LiveData<List<WorkOrder>> getAllWorkOrders() {
        return mAllWorkOrders;
    }

    // LiveData Observer for workOrder insert
    public void insertWorkOrder(WorkOrder workOrder) {
        new insertWorkOrderAsyncTask(mWorkOrdersDao).execute(workOrder);
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
