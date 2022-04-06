package com.example.toasthomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToastLinearLayout(View view) {
        Intent intent = new Intent(MainActivity.this, ToastLinearLayout.class);
        MainActivity.this.startActivity(intent);
    }

    public void showToastRelativeLayout(View view) {
        Intent intent = new Intent(MainActivity.this, ToastRelativeLayout.class);
        MainActivity.this.startActivity(intent);
    }

    public void showToastHomework(View view) {
        Intent intent = new Intent(MainActivity.this, ToastHomework.class);
        MainActivity.this.startActivity(intent);
    }
}