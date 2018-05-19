package edu.cvtc.jdiederich2.workorders.Controllers;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import edu.cvtc.jdiederich2.workorders.Models.WorkOrderModel;

@Dao
public interface WorkOrdersDao {

    @Insert
    void insertWorkOrder(WorkOrderModel workOrder);

    @Query("SELECT * FROM WorkOrderModel")
    LiveData<List<WorkOrderModel>> getSingleWorkOrder();

    @Query("SELECT * FROM WorkOrderModel")
    LiveData<List<WorkOrderModel>> getAllWorkOrders();

    @Query( "DELETE FROM WorkOrderModel" )
    void deleteAll();
}
