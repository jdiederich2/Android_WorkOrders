package edu.cvtc.jdiederich2.workorders;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import static java.lang.String.valueOf;

public class LoginActivityViewModel extends AndroidViewModel {

    private UserRepository mUserRepository;
    private MutableLiveData<List<User>> mUser;

    MutableLiveData<String> userName;

    // Constructor. References the repository and gets the user from the repository.
    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        mUserRepository = new UserRepository(application);
        mUser = mUserRepository.getUser();
    }


    public MutableLiveData<List<User>> getUser() {
        return mUser;
    }

    public void insert(User user) {}

}
