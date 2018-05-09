package edu.cvtc.jdiederich2.workorders;


import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;

import java.util.List;

public class UserRepository  {

    private UserDao mUserDao;
    private MutableLiveData<List<User>> mUser;

    // Repository constructor
    UserRepository(Application application) {
        WorkOrdersDatabase db = WorkOrdersDatabase.getDatabaseInstance( application );

        mUserDao = db.getUserDao();
        mUser = mUserDao.getUser();
    }

    // LiveData Observer to refresh user list when changed
    MutableLiveData<List<User>> getUser() {
        return mUser;
    }

    // LiveData Observer for user insert
    public void insertUser(User user) {
        new insertUserAsyncTask(mUserDao).execute(user);
    }

    // Separate non-UI thread for queries to run on.
    private static class insertUserAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao mUserAsyncTaskDao;

        insertUserAsyncTask(UserDao dao) {
            mUserAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            mUserAsyncTaskDao.insertUser(params[0]);
            return null;
        }
    }
}
