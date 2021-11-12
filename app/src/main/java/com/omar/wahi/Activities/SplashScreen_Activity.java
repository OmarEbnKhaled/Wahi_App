package com.omar.wahi.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.widget.TextView;

import com.omar.wahi.R;

public class SplashScreen_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TextView logo = findViewById(R.id.logo);

        Handler h = new Handler();
        h.postDelayed(() -> {

            Intent intent = new Intent(SplashScreen_Activity.this,Log_In_Activity.class);

            //getWindow().setSharedElementEnterTransition(new ChangeBounds().setDuration(2000));

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreen_Activity.this,
                    Pair.create(logo,"logoTransition"));

            startActivity(intent,options.toBundle());

            finish();

        }, 2000);

    }
}