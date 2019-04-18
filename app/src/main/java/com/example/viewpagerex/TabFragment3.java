package com.example.viewpagerex;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class TabFragment3 extends Fragment {

    private MyAdapter myAdapter;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutMavager;
    Button button1;
    Button button2;
    TextView textView;
    ArrayList<MyItem> myData;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler, container, false);

        button1 = view.findViewById(R.id.button);
        button2 = view.findViewById(R.id.button2);
        textView = view.findViewById(R.id.textView);
        mRecyclerView = view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutMavager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutMavager);

        if(savedInstanceState!=null){
            myData = savedInstanceState.getParcelableArrayList("data");
            myAdapter = new MyAdapter(myData);
            mRecyclerView.setAdapter(myAdapter);
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myData=((MainActivity)getActivity()).getData();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAdapter = new MyAdapter(myData);
                mRecyclerView.setAdapter(myAdapter);

            }
        });
        return view;
    }
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putParcelableArrayList("data", myData);
    }
}
