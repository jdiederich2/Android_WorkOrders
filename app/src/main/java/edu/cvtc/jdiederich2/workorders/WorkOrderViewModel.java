package edu.cvtc.jdiederich2.workorders;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.List;

public class WorkOrderViewModel extends AndroidViewModel {

    private WorkOrderRepository mWorkOrderRepository;

    private LiveData<List<WorkOrderModel>> workOrderList;

    private WorkOrdersDatabase db;

    // Constructor. References the repository and gets the work orders from the repository.
    public WorkOrderViewModel(@NonNull Application application) {
        super(application);

        db = WorkOrdersDatabase.getDatabaseInstance(this.getApplication());
        mWorkOrderRepository = new WorkOrderRepository(application);
        workOrderList = mWorkOrderRepository.getAllWorkOrders();
//        mSingleWorkOrder = mWorkOrderRepository.getSingleWorkOrder();
    }


    public LiveData<List<WorkOrderModel>> getAllWorkOrders() {return workOrderList; }

    public void insertWorkOrder(WorkOrderModel workOrder){
        mWorkOrderRepository.insertWorkOrder(workOrder);
    }

    private static class workOrderAsyncTask extends AsyncTask<WorkOrderModel, Void, Void> {

        private WorkOrdersDatabase db;

        workOrderAsyncTask(WorkOrdersDatabase db) {
            this.db = db;
        }


        @Override
        protected Void doInBackground(WorkOrderModel... workOrderModels) {
            db.workOrdersModel().getAllWorkOrders();
            return null;
        }
    }
}
