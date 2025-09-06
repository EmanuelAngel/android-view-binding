package ViewModel;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.views.HomeActivity;

import Model.User;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<String> mutableLogInResultMessage;
    private MutableLiveData<User> mutableUser;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getMutableLogInResultMessage() {
        if (mutableLogInResultMessage == null) {
            mutableLogInResultMessage = new MutableLiveData<>();
        }

        return mutableLogInResultMessage;
    }

    public LiveData<User> getMutableUser() {
        if (mutableUser == null) {
            mutableUser = new MutableLiveData<>();
        }

        return mutableUser;
    }

    public void logIn(String user, String password) {
        if (user.equals("elpepe") && password.equals("golshi")) {
            var elpepe = new User(44600506, "elpepe", "Vortex", "golshi");

            mutableLogInResultMessage.setValue("Se ha iniciado sesión correctamente");

            mutableUser.setValue(elpepe);

//            var goToHomeIntent = new Intent(getApplication(), HomeActivity.class);
//
//            goToHomeIntent.putExtra("user", elpepe);
//            goToHomeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//            getApplication().startActivity(goToHomeIntent);
        } else {
            mutableLogInResultMessage.setValue("Credenciales inválidas");
        }
    }
}
