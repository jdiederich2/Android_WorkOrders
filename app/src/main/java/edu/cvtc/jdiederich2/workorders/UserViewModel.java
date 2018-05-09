package edu.cvtc.jdiederich2.workorders;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;


import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository mUserRepository;
    private MutableLiveData<List<User>> mUser;

    // Constructor. References teh repository and gets the user from the repository.
    public UserViewModel(@NonNull Application application) {
        super(application);
        mUserRepository = new UserRepository( application );
        mUser = mUserRepository.getUser();
    }

    MutableLiveData<List<User>> getUser() {
        return mUser;
    }

    public void insertUser(User user) {
        mUserRepository.insertUser( user );
    }
}
