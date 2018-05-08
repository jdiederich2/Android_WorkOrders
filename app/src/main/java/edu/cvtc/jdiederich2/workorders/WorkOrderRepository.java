package edu.cvtc.jdiederich2.workorders;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WorkOrderRepository {

    private WorkOrdersDao mWorkOrdersDao;
    private LiveData<List<WorkOrder>> mAllWorkOrders;

    // Respository constructor
    WorkOrderRepository(Application application) {
        WorkOrdersDatabase db = WorkOrdersDatabase.getDatabaes(application);

        mWorkOrdersDao = db.workOrdersDao();
        mAllWorkOrders = mWorkOrdersDao.getAllWorkOrders();
    }

    // LiveData Observer to refresh workOrders list when changed
    LiveData<List<WorkOrder>> getAllWorkOrders() {
        return mAllWorkOrders;
    }

    // LiveData Observer for workOrder insert
    public void insert(WorkOrder workOrder) {
        new insertAsyncTask(mWorkOrdersDao).execute(workOrder);
    }

    // Separate non-UI thread for queries to run on.
    private static class insertAsyncTask extends AsyncTask<WorkOrder, Void, Void> {

        private WorkOrdersDao mAsyncTaskDao;

        insertAsyncTask(WorkOrdersDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final WorkOrder... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
