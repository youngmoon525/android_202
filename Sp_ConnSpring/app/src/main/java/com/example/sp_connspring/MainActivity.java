package com.example.sp_connspring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //Service <= 비동기작업을 새로운 쓰레드 작업을 만들어서 했다면.
    //↑→ AsyncTask <= 안드로이드는 기본적으로 http(web,was)를 요청할때는
    //메인 쓰레드에서 작업을 못하게 막아둠 ( 비동기 처리를 하게끔 만들어둠 , 어플의 안정성의 이유)
    //API <= Retrofit , okhttp

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AskTask task = new AskTask("and");
                task.execute();//비동기로 스프링에 연결하는 처리 시작(doInBackground 작업 시작)
            }
        });
    }
}