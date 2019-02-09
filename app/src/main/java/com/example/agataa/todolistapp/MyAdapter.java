package com.example.agataa.todolistapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter {

    private ArrayList<Task> tasks=new ArrayList<>();

    private RecyclerView recyclerView;

    private class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView deadline;

        public MyViewHolder(View pItem){
            super(pItem);
            name=(TextView)pItem.findViewById(R.id.task_name);
            deadline=(TextView)pItem.findViewById(R.id.task_deadline);
        }

    }

    public MyAdapter(ArrayList<Task> tasksList,RecyclerView taskRecyclerView){
        tasks=tasksList;
        recyclerView=taskRecyclerView;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout, parent, false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int positionToDelete = recyclerView.getChildAdapterPosition(v);
                tasks.remove(positionToDelete);
                notifyItemRemoved(positionToDelete);
            }
        });
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Task task=tasks.get(position);
        ((MyViewHolder) holder).name.setText(task.getName());
        ((MyViewHolder) holder).deadline.setText(task.getDeadline());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
