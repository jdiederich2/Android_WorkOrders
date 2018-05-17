package edu.cvtc.jdiederich2.workorders;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class WorkOrderViewModel extends AndroidViewModel {

    private WorkOrderRepository mWorkOrderRepository;

    private LiveData<List<WorkOrderModel>> mSingleWorkOrder;
    private LiveData<List<WorkOrderModel>> mAllWorkOrders;

    private WorkOrdersDatabase db;

    // Constructor. References the repository and gets the work orders from the repository.
    public WorkOrderViewModel(@NonNull Application application) {
        super(application);

        db = WorkOrdersDatabase.getDatabaseInstance(this.getApplication());
        mWorkOrderRepository = new WorkOrderRepository(application);
        mAllWorkOrders = mWorkOrderRepository.getAllWorkOrders();
        mSingleWorkOrder = mWorkOrderRepository.getSingleWorkOrder();
    }


    LiveData<List<WorkOrderModel>> getAllWorkOrders() {return mAllWorkOrders; }

    public void insertWorkOrder(WorkOrderModel workOrder){
        mWorkOrderRepository.insertWorkOrder(workOrder);
    }
}
