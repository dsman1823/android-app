package com.test.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.test.android.util.HttpUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToChild(View view) {
        Intent intent = new Intent(this, ChildActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        HttpUtils.sendLog(this, "message from main page");
    }
}
