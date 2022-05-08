package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public TextView expression, enterNumber;
    public Button[] btn = new Button[10];
    public int mode = 0, calculate = 0;
    public String sign ="+-x/";
    public long num = 0, input = 0;
    public ArrayList<String> history = new ArrayList<String>();
    private final String TAG = "TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expression = findViewById(R.id.expression_text);
        enterNumber = findViewById(R.id.enter_num);
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
    }

    public void clearNum(View view) {
        expression.setText("");
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
        expression.setText("");
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
    }

    public void calculator(View view) {
        String tmp = ((Button) this.findViewById(view.getId())).getText().toString();
        String top = history.get(history.size() - 1);
        if(tmp.equals("=")) {
            if(sign.contains(top)) {
                return;
            } else {
                if(history.size() >= 3) {
                    switch (history.get(history.size() - 2)) {
                        case "+":
                            num = Long.parseLong(history.get(history.size() - 3)) + Long.parseLong((history.get(history.size() - 1)));
                            break;
                        case "-":
                            num = Long.parseLong(history.get(history.size() - 3)) - Long.parseLong((history.get(history.size() - 1)));
                            break;
                        case "x":
                            num = Long.parseLong(history.get(history.size() - 3)) * Long.parseLong((history.get(history.size() - 1)));
                            break;
                        case "/":
                            num = Long.parseLong(history.get(history.size() - 3)) / Long.parseLong((history.get(history.size() - 1)));
                            break;
                        default:
                            break;
                    }
                    history.add("=");
                    history.add(num + "");
                    expression.setText(history.get(history.size() - 5) + " " + history.get(history.size() - 4) + " "  + history.get(history.size() - 3) + " " + history.get(history.size() - 2));
                    enterNumber.setText(history.get(history.size() - 1));
                }
            }
            return;
        }
        if(sign.contains(top)) {
            switch (tmp) {
                case "+":
                    expression.setText(history.get(history.size() - 2) + " +");
                    history.set(history.size() - 1, "+");
                    break;
                case "-":
                    expression.setText(history.get(history.size() - 2) + " -");
                    history.set(history.size() - 1, "-");
                    break;
                case "x":
                    expression.setText(history.get(history.size() - 2) + " x");
                    history.set(history.size() - 1, "x");
                    break;
                case "/":
                    expression.setText(history.get(history.size() - 2) + " /");
                    history.set(history.size() - 1, "/");
                    break;
                default:
                    break;
            }
        } else {
            switch (tmp) {
                case "+":
                    if(history.size() >= 3 && sign.contains(history.get(history.size() - 2))) {
                        num = Long.parseLong(history.get(history.size() - 3)) + Long.parseLong((history.get(history.size() - 1)));
                        history.add("=");
                        history.add(num + "");
                    }
                    expression.setText(history.get(history.size() - 1) + " +");
                    history.add("+");
                    break;
                case "-":
                    if(history.size() >= 3 && sign.contains(history.get(history.size() - 2))) {
                        num = Long.parseLong(history.get(history.size() - 3)) - Long.parseLong((history.get(history.size() - 1)));
                        history.add("=");
                        history.add(num + "");
                    }
                    expression.setText(history.get(history.size() - 1) + " -");
                    history.add("-");
                    break;
                case "x":
                    if(history.size() >= 3 && sign.contains(history.get(history.size() - 2))) {
                        num = Long.parseLong(history.get(history.size() - 3)) * Long.parseLong((history.get(history.size() - 1)));
                        history.add("=");
                        history.add(num + "");
                    }
                    expression.setText(history.get(history.size() - 1) + " x");
                    history.add("x");
                    break;
                case "/":
                    if(history.size() >= 3 && sign.contains(history.get(history.size() - 2))) {
                        num = Long.parseLong(history.get(history.size() - 3)) / Long.parseLong((history.get(history.size() - 1)));
                        history.add("=");
                        history.add(num + "");
                    }
                    expression.setText(history.get(history.size() - 1) + " /");
                    history.add("/");
                    break;
                default:
                    break;
            }
            enterNumber.setText(history.get(history.size() - 2));
        }
        Log.i(TAG, "calculator: " + history.toString());
    }

    public void changeSign(View view) {
        String tmp = ((Button) this.findViewById(view.getId())).getText().toString();
        String top = history.get(history.size() - 1);
        if(sign.contains(top)) {
            history.add((-num) + "");
        } else {
            if(top.equals("0")) {
                return;
            } else {
                num = -num;
            }
        }
        history.set(history.size() - 1, num + "");
        enterNumber.setText(history.get(history.size() - 1));
    }
}