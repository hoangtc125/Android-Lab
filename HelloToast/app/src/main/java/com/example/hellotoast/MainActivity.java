package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = this.findViewById(R.id.show_count1);
    }

    public void showToast(View view) {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show();
    }

    public void countUp(View view) {
        mShowCount.setText((Integer.parseInt(mShowCount.getText().toString()) + 1) + "");
    }

    public void linearLayout(View view) {
//        Intent intent = new Intent(MainActivity.this, LinearLayoutToast.class);
//        MainActivity.this.startActivity(intent);
    }

    public void RelativeLayout(View view) {
//        Intent intent = new Intent(MainActivity.this, RelativeLayoutToast.class);
//        MainActivity.this.startActivity(intent);
    }
}