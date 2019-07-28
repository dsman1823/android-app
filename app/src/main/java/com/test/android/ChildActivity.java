package com.test.android;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.test.android.util.HttpUtils;

public class ChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
    }

    @Override
    protected void onStart() {
        super.onStart();
        HttpUtils.sendLog(this, "message from child page");
    }
}
