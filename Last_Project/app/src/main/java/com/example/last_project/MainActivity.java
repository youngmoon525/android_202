package com.example.last_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.last_project.common.AskTask;
import com.example.last_project.common.CommonMethod;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        AskTask askTask = new AskTask("test0411");
//        askTask.addParam("testKey" , "testValue");
//        if( CommonMethod.executeAskGet(askTask) != null){
//            Log.d("ttt", "onCreate: ");
//        }else{
//            Log.d("ttt", "onCreate:xxx ");
//        }

    }
}