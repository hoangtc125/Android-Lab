package com.example.dataimport;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "TAG";
    private TextView name, mssv, cccd, sdt, email, wname, wmssv, wcccd, wsdt, wemail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = this.findViewById(R.id.ipName);
        mssv = this.findViewById(R.id.ipMssv);
        cccd = this.findViewById(R.id.ipCCCD);
        sdt = this.findViewById(R.id.ipSdt);
        email = this.findViewById(R.id.ipEmail);
        wname = this.findViewById(R.id.wname);
        wmssv = this.findViewById(R.id.wmssv);
        wcccd = this.findViewById(R.id.wcccd);
        wsdt = this.findViewById(R.id.wsdt);
        wemail = this.findViewById(R.id.wemail);
        CheckBox cf = this.findViewById((R.id.ipCf));
        this.findViewById(R.id.btnOk).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if(cf.isChecked() == false) {
                    Toast.makeText(MainActivity.this, "Hãy đồng ý điều khoản", Toast.LENGTH_SHORT).show();
                    return;
                }
                // Do something in response to button click
                boolean checked = true;
                Log.i(TAG, "onClick: " + name.getText().toString());

                if(name.getText().toString().trim().equals("")) {
                    wname.setVisibility(View.VISIBLE);
                    checked = false;
                } else {
                    wname.setVisibility(View.GONE);
                }

                if(mssv.getText().toString().trim().equals("")) {
                    wmssv.setVisibility(View.VISIBLE);
                    checked = false;
                } else {
                    wmssv.setVisibility(View.GONE);
                }

                if(cccd.getText().toString().trim().equals("")) {
                    wcccd.setVisibility(View.VISIBLE);
                    checked = false;
                } else {
                    wcccd.setVisibility(View.GONE);
                }

                if(sdt.getText().toString().trim().equals("")) {
                    wsdt.setVisibility(View.VISIBLE);
                    checked = false;
                } else {
                    wsdt.setVisibility(View.GONE);
                }

                if(email.getText().toString().trim().equals("")) {
                    wemail.setVisibility(View.VISIBLE);
                    checked = false;
                } else {
                    wemail.setVisibility(View.GONE);
                }

                if(checked) {
                    Toast.makeText(MainActivity.this, "Nhập thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Không được bỏ trống các trường bắt buộc", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}