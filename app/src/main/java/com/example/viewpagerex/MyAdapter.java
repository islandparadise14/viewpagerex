package com.example.viewpagerex;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            description = itemView.findViewById(R.id.description);
        }
    }
    private ArrayList<MyItem> items;
    MyAdapter(ArrayList<MyItem> items){
        this.items = items;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;

        myViewHolder.imageView.setImageResource(items.get(position).getImageRes());
        myViewHolder.description.setText(items.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
