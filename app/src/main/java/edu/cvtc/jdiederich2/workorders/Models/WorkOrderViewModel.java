package edu.cvtc.jdiederich2.workorders.Models;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import edu.cvtc.jdiederich2.workorders.Data.WorkOrderRepository;

public class WorkOrderViewModel extends AndroidViewModel {

    private WorkOrderRepository mWorkOrderRepository;

    private LiveData<List<WorkOrderModel>> mWorkOrderList;

    public WorkOrderViewModel(@NonNull Application application) {
        super( application );
        mWorkOrderRepository = new WorkOrderRepository(application);
        mWorkOrderList = mWorkOrderRepository.getAllWorkOrders();
    }

    public LiveData<List<WorkOrderModel>> getAllWorkOrders() {
        return mWorkOrderList;
    }

    public void insert(WorkOrderModel workOrder) {
        mWorkOrderRepository.insertWorkOrder(workOrder);
    }
}
