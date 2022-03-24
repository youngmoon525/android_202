package com.example.ex13_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FragAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);
        //1. 여기 액티비티가 맨 먼저 (처음) 나오게끔 수정 hint Manifest
        //2. Fragment하나를 만들고 fragActivity에 붙이기. hint getSupport ???
        // (Fragment에 버튼 하나 ListView 넣어서 만들기 )
        getSupportFragmentManager().beginTransaction().replace(R.id.container , new ListFrag()).commit();
    }
}