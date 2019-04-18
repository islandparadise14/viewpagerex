package com.example.viewpagerex;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class TabFragment2 extends Fragment {

    TextView sec1;
    TextView min1;
    TextView hour1;
    TextView sec2;
    TextView min2;
    TextView hour2;
    Button reset1;
    Button start1;
    Button reset2;
    Button start2;
    public static Handler mHandler;
    public static Handler mHandler2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.multi,container,false);
        sec1 = (TextView) view.findViewById(R.id.sec1);
        min1 = (TextView) view.findViewById(R.id.min1);
        hour1 = (TextView) view.findViewById(R.id.hour1);
        sec2 = (TextView) view.findViewById(R.id.sec2);
        min2 = (TextView) view.findViewById(R.id.min2);
        hour2 = (TextView) view.findViewById(R.id.hour2);
        reset1 = (Button) view.findViewById(R.id.reset1);
        start1 = (Button) view.findViewById(R.id.start1);
        reset2 = (Button) view.findViewById(R.id.reset2);
        start2 = (Button) view.findViewById(R.id.start2);

        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg)  {
                super.handleMessage(msg);
                int time = msg.arg1;
                if(time%60<10){ sec1.setText("0"+Integer.toString(time%60)); }
                else{ sec1.setText(Integer.toString(time%60)); }
                if(time%3600/60<10){min1.setText("0"+Integer.toString(time%3600/60));}
                else{ min1.setText(Integer.toString(time%3600/60));}
                if(time/3600<10){ hour1.setText("0"+Integer.toString(time/3600));}
                else{hour1.setText(Integer.toString(time/3600));}
            }
        };

        mHandler2 = new Handler(){
            @Override
            public void handleMessage(Message msg)  {
                super.handleMessage(msg);
                int time = msg.arg1;
                if(time%60<10){ sec2.setText("0"+Integer.toString(time%60)); }
                else{ sec2.setText(Integer.toString(time%60)); }
                if(time%3600/60<10){min2.setText("0"+Integer.toString(time%3600/60));}
                else{ min2.setText(Integer.toString(time%3600/60));}
                if(time/3600<10){ hour2.setText("0"+Integer.toString(time/3600));}
                else{hour2.setText(Integer.toString(time/3600));}
            }
        };

        class TimerThread implements Runnable {
            int count = 0;

            @Override
            public void run() {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        Thread.sleep(1000);
                        count++;
                        Message msg = mHandler.obtainMessage();
                        msg.arg1=count;
                        mHandler.sendMessage(msg);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        class TimerThread2 implements Runnable {
            int count = 0;

            @Override
            public void run() {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        Thread.sleep(1000);
                        count++;
                        Message msg = mHandler2.obtainMessage();
                        msg.arg1=count;
                        mHandler2.sendMessage(msg);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        start1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimerThread timer1 = new TimerThread();
                final Thread thread1 = new Thread(timer1);
                thread1.start();
                start1.setEnabled(false);
                reset1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        thread1.interrupt();
                        sec1.setText("00");
                        min1.setText("00");
                        hour1.setText("00");
                        start1.setEnabled(true);
                    }
                });
            }
        });

        start2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimerThread2 timer2 = new TimerThread2();
                final Thread thread2 = new Thread(timer2);
                thread2.start();
                start2.setEnabled(false);
                reset2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        thread2.interrupt();
                        sec2.setText("00");
                        min2.setText("00");
                        hour2.setText("00");
                        start2.setEnabled(true);
                    }
                });
            }
        });
        return view;
    }

}
