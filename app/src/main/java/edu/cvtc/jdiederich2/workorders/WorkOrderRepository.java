package edu.cvtc.jdiederich2.workorders;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;

import java.util.List;

public class WorkOrderRepository {

    private WorkOrdersDao mWorkOrdersDao;
    private MutableLiveData<List<WorkOrder>> mAllWorkOrders;

    // Respository constructor
    WorkOrderRepository(Application application) {
        WorkOrdersDatabase db = WorkOrdersDatabase.getDatabaseInstance(application);

        mWorkOrdersDao = db.getWorkOrdersDao();
        mAllWorkOrders = mWorkOrdersDao.getAllWorkOrders();
    }

    // LiveData Observer to refresh workOrders list when changed
    MutableLiveData<List<WorkOrder>> getAllWorkOrders() {
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
