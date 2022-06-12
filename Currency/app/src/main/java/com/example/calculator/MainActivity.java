package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public TextView enterNumber, outputNumber, label;
    public Button[] btn = new Button[10];
    public int mode = 0, calculate = 0;
    public String sign ="+-x/";
    public long num = 0, input = 0;
    public ArrayList<String> history = new ArrayList<String>();
    private final String TAG = "TAG";
    public Spinner spinner1, spinner2;
    private Double res = 0.0, inpW = 1.0, resW = 1.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterNumber = findViewById(R.id.enter_num);
        outputNumber = findViewById(R.id.enter_num2);
        label = findViewById(R.id.textView);
        history.add("0");
        btn[0] = findViewById(R.id.n0);
        btn[1] = findViewById(R.id.n1);
        btn[2] = findViewById(R.id.n2);
        btn[3] = findViewById(R.id.n3);
        btn[4] = findViewById(R.id.n4);
        btn[5] = findViewById(R.id.n5);
        btn[6] = findViewById(R.id.n6);
        btn[7] = findViewById(R.id.n7);
        btn[8] = findViewById(R.id.n8);
        btn[9] = findViewById(R.id.n9);

        this.spinner1 = findViewById(R.id.spinner1);
        this.spinner2 = findViewById(R.id.spinner2);

        List<Currency> currencyList = new ArrayList<Currency>();
        currencyList.add(new Currency("Vietnam", "dong", 1.0, "d"));
        currencyList.add(new Currency("United State", "dollar", 23.3, "u"));
        currencyList.add(new Currency("Campuchia", "cam", 3.20, "c"));
        currencyList.add(new Currency("United Kingdom", "bang", 30.30, "b"));
        currencyList.add(new Currency("Euro", "euro", 25.40, "e"));

        ArrayAdapter<Currency> adapter = new ArrayAdapter<Currency>(this,
                android.R.layout.simple_spinner_item,
                currencyList);

        ArrayAdapter<Currency> adapter2 = new ArrayAdapter<Currency>(this,
                android.R.layout.simple_spinner_item,
                currencyList);

        // Layout for All ROWs of Spinner.  (Optional for ArrayAdapter).
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.spinner1.setAdapter(adapter);

        // When user select a List-Item.
        this.spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onItemSelectedHandler(parent, view, position, id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        this.spinner2.setAdapter(adapter2);

        // When user select a List-Item.
        this.spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onItemSelectedHandler2(parent, view, position, id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void onItemSelectedHandler(AdapterView<?> adapterView, View view, int position, long id) {
        Adapter adapter = adapterView.getAdapter();
        Currency currency = (Currency) adapter.getItem(position);
        this.inpW = currency.getWeight();
        changeRes();
        TextView donvi1 = findViewById(R.id.donvi1);
        donvi1.setText(currency.getMindonvi());
        Toast.makeText(getApplicationContext(), "Selected Currency: " + currency.getCountry() ,Toast.LENGTH_SHORT).show();
    }

    private void onItemSelectedHandler2(AdapterView<?> adapterView, View view, int position, long id) {
        Adapter adapter = adapterView.getAdapter();
        Currency currency = (Currency) adapter.getItem(position);
        this.resW = currency.getWeight();
        changeRes();
        TextView donvi2 = findViewById(R.id.donvi2);
        donvi2.setText(currency.getMindonvi());
        Toast.makeText(getApplicationContext(), "Selected Currency: " + currency.getCountry() ,Toast.LENGTH_SHORT).show();
    }

    private void changeRes() {
        this.label.setText("Weight: " + this.inpW + " : " + this.resW);
        Double inp = Double.parseDouble(this.enterNumber.getText().toString());
        this.outputNumber.setText("" + Math.round(inp * resW / inpW));
    }

    public void clearNum(View view) {
        enterNumber.setText("0");
        String top = history.get(history.size() - 1);
        if(sign.contains(top)) {
            history.remove(top);
        } else {
            history.set(history.size() - 1, "0");
        }
        Log.i(TAG, "clearNum: " + history.toString());
    }

    public void clearAll(View view) {
        enterNumber.setText("0");
        history = new ArrayList<>();
        history.add("0");
    }

    public void clearOne(View view) {
        String top = history.get(history.size() - 1);
        if(sign.contains(top)) {
            return;
        } else {
            if(top.length() == 1) {
                history.set(history.size() - 1, "0");
            } else {
                history.set(history.size() - 1, top.substring(0, top.length() - 1));
            }
            num = Long.parseLong(history.get(history.size() - 1));
            enterNumber.setText(history.get(history.size() - 1));
        }
    }

    public void enterNumber(View view) {
        String tmp = ((Button) this.findViewById(view.getId())).getText().toString();
        String top = history.get(history.size() - 1);
        if(sign.contains(top)) {
            num = Long.parseLong(tmp);
            history.add(num + "");
        } else {
            if(top.equals("0")) {
                num = Long.parseLong(tmp);
            } else {
                num = num*10 + Long.parseLong(tmp);
            }
            history.set(history.size() - 1, num + "");
        }
        enterNumber.setText(history.get(history.size() - 1));
        changeRes();
    }
}