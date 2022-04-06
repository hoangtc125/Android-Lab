package com.example.toasthomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ToastHomework extends AppCompatActivity {

    private TextView mShowCount;
    private Button btnCount, btnZero;
    private int colorOdd = -999999999,
                colorEven = -99999,
                colorZero = 999,
                colorNonZero = -99999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_homework);
        mShowCount = this.findViewById(R.id.show_count);
        btnCount = this.findViewById(R.id.button_count);
        btnZero = this.findViewById(R.id.button_set_zero);
        btnCount.setBackgroundColor(colorEven);
        btnZero.setBackgroundColor(colorZero);
    }

    public void showToast(View view) {
        Toast.makeText(this, R.string.toast_content, Toast.LENGTH_SHORT).show();
    }

    public void countUp(View view) {
        btnZero.setBackgroundColor(colorNonZero);
        mShowCount.setText((Integer.parseInt(mShowCount.getText().toString()) + 1) + "");
        int value = Integer.parseInt(mShowCount.getText().toString());
        if(value > 10) {
            mShowCount.setTextSize(60);
        } else {
            mShowCount.setTextSize(160);
        }
        btnCount.setBackgroundColor(Integer.parseInt(mShowCount.getText().toString()) % 2 == 0 ? colorEven : colorOdd);
    }

    public void handleZero(View view) {
        btnCount.setBackgroundColor(colorEven);
        btnZero.setBackgroundColor(colorZero);
        mShowCount.setText("0");
    }
}