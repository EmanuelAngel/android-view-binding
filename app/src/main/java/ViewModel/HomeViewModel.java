package ViewModel;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import Model.User;

public class HomeViewModel extends AndroidViewModel {
    private MutableLiveData<User> mutableUser;

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<User> getMutableUser() {
        if (mutableUser == null) {
            mutableUser = new MutableLiveData<>();
        }

        return mutableUser;
    }

    public void extractIntentData(@NonNull Intent intent) {
        var user = intent.getSerializableExtra("user", User.class);

        if (user != null) {
            mutableUser.setValue(user);
        }
    }
}
