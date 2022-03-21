package com.example.a00vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent(); // 넘겨준 인텐트를 받아온다.
        ArrayList<VendingDTO> resultList = (ArrayList<VendingDTO>)
                                             intent.getSerializableExtra("resultlist");
        int money = intent.getIntExtra("money" , 0);


    }
}