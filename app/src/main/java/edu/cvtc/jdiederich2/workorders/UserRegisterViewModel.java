package edu.cvtc.jdiederich2.workorders;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;


import java.util.List;

public class UserRegisterViewModel extends AndroidViewModel {

    private UserRepository mUserRepository;
    private LiveData<List<User>> mUser;

    // Constructor. References teh repository and gets the user from the repository.
    public UserRegisterViewModel(@NonNull Application application) {
        super(application);
        mUserRepository = new UserRepository( application );
        mUser = mUserRepository.getUser();
    }

    LiveData<List<User>> getUser() {
        return mUser;
    }

    public void insertUser(User user) {
        mUserRepository.insertUser( user );
    }
}
