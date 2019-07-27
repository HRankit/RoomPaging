package com.hrankit.roompaging;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hrankit.roompaging.roomWithPaging.RoomWithPagingActivity;
import com.hrankit.roompaging.roomWithoutPaging.RoomWithoutPagingActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        findViewById(R.id.withoutpaging).setOnClickListener(v -> {
            Intent i = new Intent(StartActivity.this, RoomWithoutPagingActivity.class);
            startActivity(i);
        });


        findViewById(R.id.withpaging).setOnClickListener(v -> {
            Intent i = new Intent(StartActivity.this, RoomWithPagingActivity.class);
            startActivity(i);
        });
    }
}
