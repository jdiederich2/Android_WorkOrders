package edu.cvtc.jdiederich2.workorders;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class WorkOrderViewModel extends AndroidViewModel {


    private WorkOrderRepository mWorkOrderRepository;
    private LiveData<List<WorkOrder>> mAllWorkOrders;

    // Constructor. References the repository and gets the work orders from the repository.
    public WorkOrderViewModel(@NonNull Application application) {
        super(application);
        mWorkOrderRepository = new WorkOrderRepository(application);
        mAllWorkOrders = mWorkOrderRepository.getAllWorkOrders();
    }

    LiveData<List<WorkOrder>> getmAllWorkOrders() {return mAllWorkOrders; }

    public void insert(WorkOrder workOrder) {mWorkOrderRepository.insert(workOrder);}
}
