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
        WorkOrdersDatabase db = WorkOrdersDatabase.getDatabaes( application );

        mUserDao = db.userDao();
        mUser = mUserDao.getUser();
    }

    // LiveData Observer to refresh workOrders list when changed
    MutableLiveData<List<User>> getUser() {
        return mUser;
    }
}
