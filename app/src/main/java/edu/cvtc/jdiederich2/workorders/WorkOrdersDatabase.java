package edu.cvtc.jdiederich2.workorders;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;


@Database(entities = {User.class, WorkOrder.class}, version = 1)

public abstract class WorkOrdersDatabase extends RoomDatabase {

    private static final String DB_NAME = "WorkOrdersDatabase.db";
    private static WorkOrdersDatabase INSTANCE;

    static synchronized WorkOrdersDatabase getDatabaseInstance(Context context) {
        if(INSTANCE == null) {
            synchronized (WorkOrdersDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = create( context );
                }
            }
        }

        return INSTANCE;
    }

    private static WorkOrdersDatabase create(final Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                WorkOrdersDatabase.class, DB_NAME)
                // TODO: May not need this. Check it out.
                // .addCallback( sWorkOrdersDatabaseCallback )
                .build();
    }

    public abstract UserDao getUserDao();

    public abstract WorkOrdersDao getWorkOrdersDao();



    // TODO: may not need callback. Database will only be populated at creation
    private static WorkOrdersDatabase.Callback sWorkOrdersDatabaseCallback = new RoomDatabase.Callback(){

        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
        }
    };


    // TODO: may not need. Database will only be populated at creation
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final UserDao mUserDao;
        private final WorkOrdersDao mWorkOrdersDao;

        PopulateDbAsync(WorkOrdersDatabase db) {
            mUserDao = db.getUserDao();
            mWorkOrdersDao = db.getWorkOrdersDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            return null;
        }
    }
}
