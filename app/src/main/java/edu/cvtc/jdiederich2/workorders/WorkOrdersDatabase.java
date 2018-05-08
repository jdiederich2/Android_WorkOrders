package edu.cvtc.jdiederich2.workorders;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {User.class, WorkOrder.class}, version = 1)

public abstract class WorkOrdersDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract WorkOrdersDao workOrdersDao();

    private static WorkOrdersDatabase INSTANCE;

    public static WorkOrdersDatabase getDatabaes(final Context context) {
        if(INSTANCE == null) {
            synchronized (WorkOrdersDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WorkOrdersDatabase.class, "workOrdersDatabase").build();
                }
            }
        }

        return INSTANCE;
    }
}
