package edu.cvtc.jdiederich2.workorders;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;

import static java.lang.String.valueOf;

public class LoginActivityViewModel extends AndroidViewModel {

    MutableLiveData<String> userName;

    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
    }

}
