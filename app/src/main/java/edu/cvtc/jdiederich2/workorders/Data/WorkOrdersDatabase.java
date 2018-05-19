package edu.cvtc.jdiederich2.workorders.Data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import edu.cvtc.jdiederich2.workorders.Controllers.LoginDao;
import edu.cvtc.jdiederich2.workorders.Controllers.WorkOrdersDao;
import edu.cvtc.jdiederich2.workorders.Models.WorkOrderModel;
import edu.cvtc.jdiederich2.workorders.Models.User;
import edu.cvtc.jdiederich2.workorders.Controllers.UserDao;

@Database(entities = {User.class, WorkOrderModel.class}, version = 1)


public abstract class WorkOrdersDatabase extends RoomDatabase {

    // Abstract Getters for DAO's
    public abstract UserDao userModelDao();
    public abstract WorkOrdersDao workOrderModelDao();
    public abstract LoginDao loginModel();

    private static final String DB_NAME = "WorkOrdersDatabase.db";
    private static WorkOrdersDatabase INSTANCE;

    // Gets an instance of the database to ensure only one
    public static WorkOrdersDatabase getDatabaseInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (WorkOrdersDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = createDb( context );
                }
            }
        }

        return INSTANCE;
    }


    // Separate db create method used in getDatabaseInstance above
    private static WorkOrdersDatabase createDb(final Context context) {
        return Room.databaseBuilder( context.getApplicationContext(),
                WorkOrdersDatabase.class, DB_NAME )
                .addCallback( sWorkOrdersDatabaseCallback )
                .build();
    }

    private static RoomDatabase.Callback sWorkOrdersDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onOpen (SupportSQLiteDatabase db) {
            super.onOpen( db );
            new PopulateDbAsync(INSTANCE).execute();
        }
    };


    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final WorkOrdersDao mDao;

        PopulateDbAsync(WorkOrdersDatabase db) {
            mDao = db.workOrderModelDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mDao.deleteAll();
            WorkOrderModel workOrder = new WorkOrderModel(
                    "Jen", "Diederich", "7153130962", "309 Washington St", "Stanley", "12345", "05/18/18" );
            mDao.insertWorkOrder( workOrder );
            return null;
        }
    }
}
