package com.example.brian.fyp115494258;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

//Utilised the following youtube video:https://www.youtube.com/watch?v=9ZCK5BOU6wk&index=29&list=PLshdtb5UWjSrOJfpFOE-u55s3SnY2EO9v
//This allowed me to follow the steps for creating a list of items using the recycler view


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{


    private List<String> list;

    public RecyclerAdapter(List <String> list){

        this.list = list;
    }




    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        TextView textView = (TextView)  LayoutInflater.from(parent.getContext()).inflate(R.layout.text_view_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(textView);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.MenuItem.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {


        TextView MenuItem;

        public MyViewHolder(TextView itemView) {
            super(itemView);
            MenuItem = itemView;
        }
    }
}
