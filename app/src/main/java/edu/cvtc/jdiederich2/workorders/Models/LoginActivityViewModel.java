package edu.cvtc.jdiederich2.workorders.Models;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import edu.cvtc.jdiederich2.workorders.Data.WorkOrderRepository;
import edu.cvtc.jdiederich2.workorders.Controllers.LoginDao;
import edu.cvtc.jdiederich2.workorders.Models.User;

import static java.lang.String.valueOf;

public class LoginActivityViewModel extends AndroidViewModel implements LoginDao {
    private WorkOrderRepository mUserRepository;
    private LiveData<List<User>> mUser;


    private String dbUserName;
    private String dbPassword;

    // Constructor. References the repository and gets the user from the repository.
    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        mUserRepository = new WorkOrderRepository(application);
        mUser = mUserRepository.getUser();
    }

    public LiveData<List<User>> getUser() {
        return mUser;
    }

    @Override
    public User getUserNameAndPassword(String userName) {
        return null;
    }
}
