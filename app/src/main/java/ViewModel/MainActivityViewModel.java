package ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import Model.User;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<String> mutableLogInResultMessage;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getMutableLogInResultMessage() {
        if (mutableLogInResultMessage == null) {
            mutableLogInResultMessage = new MutableLiveData<>();
        }

        return mutableLogInResultMessage;
    }

    public void logIn(String user, String password) {
        if (user.equals("elpepe") && password.equals("golshi")) {
            // var elpepe = new User(44600506, "elpepe", "Vortex", "golshi");

            mutableLogInResultMessage.setValue("Se ha iniciado sesión correctamente");
        }
    }
}
