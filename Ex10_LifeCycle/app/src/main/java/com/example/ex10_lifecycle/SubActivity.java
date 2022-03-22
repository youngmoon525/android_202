package com.example.ex10_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Log.d("lifecycleB", "onCreate:  1단계 ");
    }
    //2.단계
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycleB", "onStart:  2단계 ");
    }
    //1.Loader(코딩)=>2.Parsing(변환)=>3.랜더링트리
    //4.Css로딩 => 5.레이아웃 6.그리기(Painting)
    //Html/Jsp

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycleB", "onResume: 3단계 ");
    }
}