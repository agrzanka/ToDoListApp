package com.example.agataa.todolistapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class AddNewTaskActivity extends Activity{

    public String newName, newDesc, newDeadline;

    Intent intent =new Intent();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_layout);
    }

    public void ok_task(View view) {

        //Intent intent =new Intent();

        EditText editText=(EditText)findViewById(R.id.editText);
        newName=editText.getText().toString();
        intent.putExtra("tname",newName);

        EditText editText1=(EditText)findViewById(R.id.editText2);
        newDesc=editText1.getText().toString();
        intent.putExtra("tdesc",newDesc);

        EditText editText2=(EditText)findViewById(R.id.editText2);
        newDeadline=editText2.getText().toString();
        intent.putExtra("tdeadline", newDeadline);

        setResult(RESULT_OK, intent);
        finish();

    }

    public void editTask(View view){
       /* EditText editText=(EditText)findViewById(R.id.editText);
        editText.setText(intent.getStringExtra("tname"));

        EditText editText1=(EditText)findViewById(R.id.editText2);
        editText1.setText(intent.getStringExtra("tdesc"));

        EditText editText2=(EditText)findViewById(R.id.editText2);
        editText2.setText(intent.getStringExtra("tdeadline"));*/

    }
}
