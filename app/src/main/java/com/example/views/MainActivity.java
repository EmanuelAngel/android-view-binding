package com.example.views;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.views.databinding.ActivityMainBinding;

import ViewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        setContentView(activityMainBinding.getRoot());

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /* Verboso */
//         mainActivityViewModel.getMutableLogInResultMessage().observe(
//                 this,
//                 new Observer<String>() {
//                     @Override
//                     public void onChanged(String s) {
//                         activityMainBinding.tvResult.setText(s);
//                     }
//         });

        /* Azúcar sintáctico. Por detrás hace lo mismo. */
        mainActivityViewModel.getMutableLogInResultMessage().observe(
                this,
                message -> activityMainBinding.tvResult.setText(message));

//        activityMainBinding.btLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mainActivityViewModel.logIn(
//                        activityMainBinding.etUser.getText().toString(),
//                        activityMainBinding.etPassword.getText().toString()
//                );
//            }
//        });

        activityMainBinding.btLogin.setOnClickListener(view -> mainActivityViewModel.logIn(
                activityMainBinding.etUser.getText().toString(),
                activityMainBinding.etPassword.getText().toString()
        ));

        mainActivityViewModel.getMutableUser().observe(this, user -> {
            var goToHome = new Intent(this, HomeActivity.class);

            goToHome.putExtra("user", user);

            startActivity(goToHome);
        });
    }
}