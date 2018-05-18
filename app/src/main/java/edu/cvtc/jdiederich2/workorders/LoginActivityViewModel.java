package edu.cvtc.jdiederich2.workorders;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import static java.lang.String.valueOf;

public class LoginActivityViewModel extends AndroidViewModel implements LoginDao {
    private UserRepository mUserRepository;
    private LiveData<List<User>> mUser;


    private String dbUserName;
    private String dbPassword;

    // Constructor. References the repository and gets the user from the repository.
    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        mUserRepository = new UserRepository(application);
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
