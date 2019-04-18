package com.example.viewpagerex;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TabFragment1 extends Fragment {

    TextView textview;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttona;
    Button buttonb;
    Button buttonc;
    Button buttond;
    Button buttone;
    Button buttonf;

    int state=0;
    int number1=0;
    int operator=4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.calculate,container,false);
        textview = (TextView)view.findViewById(R.id.textView);
        button0 = (Button)view.findViewById(R.id.btn0);
        button1 = (Button)view.findViewById(R.id.btn1);
        button2 = (Button)view.findViewById(R.id.btn2);
        button3 = (Button)view.findViewById(R.id.btn3);
        button4 = (Button)view.findViewById(R.id.btn4);
        button5 = (Button)view.findViewById(R.id.btn5);
        button6 = (Button)view.findViewById(R.id.btn6);
        button7 = (Button)view.findViewById(R.id.btn7);
        button8 = (Button)view.findViewById(R.id.btn8);
        button9 = (Button)view.findViewById(R.id.btn9);
        buttona = (Button)view.findViewById(R.id.btn_plus);
        buttonb = (Button)view.findViewById(R.id.btn_minus);
        buttonc = (Button)view.findViewById(R.id.btn_multi);
        buttond = (Button)view.findViewById(R.id.btn_sap);
        buttone = (Button)view.findViewById(R.id.btn_clear);
        buttonf = (Button)view.findViewById(R.id.btn_equal);

        if(savedInstanceState != null){
            state = savedInstanceState.getInt("state");
            number1 = savedInstanceState.getInt("number");
            operator = savedInstanceState.getInt("operator");
            textview.setText(savedInstanceState.getString("now"));
        }

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(v);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(v);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(v);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(v);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(v);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(v);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(v);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(v);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(v);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(v);
            }
        });
        buttona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clkoper(v);
            }
        });
        buttonb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clkoper(v);
            }
        });
        buttonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clkoper(v);
            }
        });
        buttond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clkoper(v);
            }
        });
        buttone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear(v);
            }
        });
        buttonf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equa(v);
            }
        });
        return view;
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("state",state);
        savedInstanceState.putInt("number",number1);
        savedInstanceState.putInt("operator",operator);
        savedInstanceState.putString("now",textview.getText().toString());
    }

    public void click(View view) {
        int id = view.getId();
        switch (state){
            case 0: switch (id) {
                case R.id.btn0:
                    textview.setText("0");
                    break;
                case R.id.btn1:
                    textview.setText("1");
                    state = 1;
                    break;
                case R.id.btn2:
                    textview.setText("2");
                    state = 1;
                    break;
                case R.id.btn3:
                    textview.setText("3");
                    state = 1;
                    break;
                case R.id.btn4:
                    textview.setText("4");
                    state = 1;
                    break;
                case R.id.btn5:
                    textview.setText("5");
                    state = 1;
                    break;
                case R.id.btn6:
                    textview.setText("6");
                    state = 1;
                    break;
                case R.id.btn7:
                    textview.setText("7");
                    state = 1;
                    break;
                case R.id.btn8:
                    textview.setText("8");
                    state = 1;
                    break;
                case R.id.btn9:
                    textview.setText("9");
                    state = 1;
                    break;
            }
                break;
            case 1: switch (id) {
                case R.id.btn0:
                    textview.setText(textview.getText().toString() + "0");
                    break;
                case R.id.btn1:
                    textview.setText(textview.getText().toString() + "1");
                    break;
                case R.id.btn2:
                    textview.setText(textview.getText().toString() + "2");
                    break;
                case R.id.btn3:
                    textview.setText(textview.getText().toString() + "3");
                    break;
                case R.id.btn4:
                    textview.setText(textview.getText().toString() + "4");
                    break;
                case R.id.btn5:
                    textview.setText(textview.getText().toString() + "5");
                    break;
                case R.id.btn6:
                    textview.setText(textview.getText().toString() + "6");
                    break;
                case R.id.btn7:
                    textview.setText(textview.getText().toString() + "7");
                    break;
                case R.id.btn8:
                    textview.setText(textview.getText().toString() + "8");
                    break;
                case R.id.btn9:
                    textview.setText(textview.getText().toString() + "9");
                    break;
            }
                break;
            case 2: switch (id){
                case R.id.btn0:textview.setText("0"); state = 3;
                    break;
                case R.id.btn1:textview.setText("1"); state = 3;
                    break;
                case R.id.btn2:textview.setText("2"); state = 3;
                    break;
                case R.id.btn3:textview.setText("3"); state = 3;
                    break;
                case R.id.btn4:textview.setText("4"); state = 3;
                    break;
                case R.id.btn5:textview.setText("5"); state = 3;
                    break;
                case R.id.btn6:textview.setText("6"); state = 3;
                    break;
                case R.id.btn7:textview.setText("7"); state = 3;
                    break;
                case R.id.btn8:textview.setText("8"); state = 3;
                    break;
                case R.id.btn9:textview.setText("9"); state = 3;
                    break;
            }
                break;
            case 3:
                if(textview.getText().toString()=="0"){
                    textview.setText("");
                }
                switch (id) {
                    case R.id.btn0:
                        textview.setText(textview.getText().toString() + "0");
                        break;
                    case R.id.btn1:
                        textview.setText(textview.getText().toString() + "1");
                        break;
                    case R.id.btn2:
                        textview.setText(textview.getText().toString() + "2");
                        break;
                    case R.id.btn3:
                        textview.setText(textview.getText().toString() + "3");
                        break;
                    case R.id.btn4:
                        textview.setText(textview.getText().toString() + "4");
                        break;
                    case R.id.btn5:
                        textview.setText(textview.getText().toString() + "5");
                        break;
                    case R.id.btn6:
                        textview.setText(textview.getText().toString() + "6");
                        break;
                    case R.id.btn7:
                        textview.setText(textview.getText().toString() + "7");
                        break;
                    case R.id.btn8:
                        textview.setText(textview.getText().toString() + "8");
                        break;
                    case R.id.btn9:
                        textview.setText(textview.getText().toString() + "9");
                        break;
                }
                break;
        }
    }

    public void clkoper(View view) {
        int id = view.getId();
        switch (state) {
            case 0:
                switch (id) {
                    case R.id.btn_plus:
                        number1=0;
                        operator=0;
                        state=2;
                        break;
                    case R.id.btn_minus:
                        number1=0;
                        operator=1;
                        state=2;
                        break;
                    case R.id.btn_multi:
                        number1=0;
                        operator=2;
                        state=2;
                        break;
                    case R.id.btn_sap:
                        number1=0;
                        operator=3;
                        state=2;
                        break;
                }
                break;
            case 1:
                switch (id) {
                    case R.id.btn_plus:
                        number1= Integer.parseInt(textview.getText().toString());
                        operator=0;
                        state=2;
                        break;
                    case R.id.btn_minus:
                        number1=Integer.parseInt(textview.getText().toString());
                        operator=1;
                        state=2;
                        break;
                    case R.id.btn_multi:
                        number1=Integer.parseInt(textview.getText().toString());
                        operator=2;
                        state=2;
                        break;
                    case R.id.btn_sap:
                        number1=Integer.parseInt(textview.getText().toString());
                        operator=3;
                        state=2;
                        break;
                }
                break;
            case 2:
                switch (id) {
                    case R.id.btn_plus:
                        operator=0;
                        break;
                    case R.id.btn_minus:
                        operator=1;
                        break;
                    case R.id.btn_multi:
                        operator=2;
                        break;
                    case R.id.btn_sap:
                        operator=3;
                        break;
                }
                break;
            case 3:
                break;
        }
    }

    public void equa(View view) {
        switch (state) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                switch (operator) {
                    case 0:
                        textview.setText(Integer.toString(number1+Integer.parseInt(textview.getText().toString())));
                        if(Integer.parseInt(textview.getText().toString())==0){
                            state=0;
                        }
                        else{
                            state=1;
                        }
                        break;
                    case 1:
                        textview.setText(Integer.toString(number1-Integer.parseInt(textview.getText().toString())));
                        if(Integer.parseInt(textview.getText().toString())==0){
                            state=0;
                        }
                        else{
                            state=1;
                        }
                        break;
                    case 2:
                        textview.setText(Integer.toString(number1*Integer.parseInt(textview.getText().toString())));
                        if(Integer.parseInt(textview.getText().toString())==0){
                            state=0;
                        }
                        else{
                            state=1;
                        }
                        break;
                    case 3:
                        if(textview.getText().toString()=="0"){
                            textview.setText("0");
                            state=0;
                            break;
                        }
                        if(number1%Integer.parseInt(textview.getText().toString())!=0){
                            textview.setText(Integer.toString(number1/Integer.parseInt(textview.getText().toString())));
                            if(Integer.parseInt(textview.getText().toString())==0){
                                state=0;
                            }
                            else{
                                state=1;
                            }
                        }
                        else{
                            textview.setText(Integer.toString(number1/Integer.parseInt(textview.getText().toString())));
                            if(Integer.parseInt(textview.getText().toString())==0){
                                state=0;
                            }
                            else{
                                state=1;
                            }
                        }
                        break;
                }
                break;
        }
    }

    public void clear(View view) {
        textview.setText("0");
        state=0;
    }
}
