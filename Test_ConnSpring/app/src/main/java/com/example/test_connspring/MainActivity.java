package com.example.test_connspring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (CommonVal.dto != null) {
            Log.d("액티비티", "onCreate: " + CommonVal.dto.getId());
        } else {
            Log.d("액티비티", " 널 오류 finish로직 넣어주면 화면 꺼짐");
        }
    }
}