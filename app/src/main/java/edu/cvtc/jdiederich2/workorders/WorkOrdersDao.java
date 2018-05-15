package edu.cvtc.jdiederich2.workorders;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WorkOrdersDao {

    @Insert
    void insertWorkOrder(WorkOrder workOrder);

    @Query("SELECT * FROM WorkOrder")
    List<WorkOrder> getAllWorkOrders();

    // TODO: @Insert(onConflict = OnConflictStrategy.REPLACE)
}
