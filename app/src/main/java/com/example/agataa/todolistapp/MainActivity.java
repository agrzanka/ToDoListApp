package com.example.agataa.todolistapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public ArrayList<Task> tasks=new ArrayList<>();
    public RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.todolist);

        tasks.add(new Task("task1", "task1","10.06.2018"));
        tasks.add(new Task("task2", "rdfgjhjk","17.06.2018"));
        tasks.add(new Task("task3", "adf65432shfdjfdshgradfsg","19.06.2018"));
        tasks.add(new Task("task4", "adf65432shfdjfdshgradfsg","19.06.2018"));
        tasks.add(new Task("task5", "adf65432shfdjfdshgradfsg","19.06.2018"));


        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(new MyAdapter(tasks, recyclerView));

    }

    public void addTask(View view) {
        Intent intent = new Intent(this, AddNewTaskActivity.class);
        startActivityForResult(intent,3);


    }

    public void editTask(View view){
        Intent intent = new Intent(this, AddNewTaskActivity.class);
        startActivityForResult(intent,3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent    data) {
        if (requestCode == 3) {
            if (resultCode == RESULT_OK) {
                addNewItem(data.getExtras().getString("tname"),data.getExtras().getString("tdesc"), data.getExtras().getString("tdeadline"));
            }
        }
    }

    private void addNewItem(String tname, String tDesc, String tDeadline) {
        tasks.add(new Task(tname, tDesc, tDeadline));
        recyclerView=(RecyclerView)findViewById(R.id.todolist);
        recyclerView.setAdapter(new MyAdapter(tasks,recyclerView));

    }

}
