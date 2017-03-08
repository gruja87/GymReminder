package com.example.android.gymreminder.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import com.example.android.gymreminder.R;

public class StartActivity extends AppCompatActivity {

    private ProgressDialog loading;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        addHandler();

    }

    private void addHandler(){
        loading = ProgressDialog.show(this,"","Loading...",true);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (loading!=null){
                    loading.dismiss();
                }
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        }, 2000);
    }
}
