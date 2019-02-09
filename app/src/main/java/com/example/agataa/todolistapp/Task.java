package com.example.agataa.todolistapp;

import java.text.DateFormat;
import java.util.Date;

public class Task {
    String name;
    String deadline;
    String description;


    public Task(String name, String desc, String deadline){
        this.name=name;
        this.description=desc;
        this.deadline=deadline;
    }

    public String getName(){
        return name;
    }

    public String detDescription(){
        return description;
    }

    public String getDeadline() {
        return deadline;
    }
}
