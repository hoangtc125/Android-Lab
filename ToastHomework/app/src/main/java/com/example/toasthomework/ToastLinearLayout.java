package com.example.toasthomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ToastLinearLayout extends AppCompatActivity {

    TextView mShowToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_linear_layout);
        mShowToast = this.findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        Toast.makeText(this, R.string.toast_content, Toast.LENGTH_SHORT).show();
    }

    public void countUp(View view) {
        mShowToast.setText((Integer.parseInt(mShowToast.getText().toString()) + 1) + "");
    }
}