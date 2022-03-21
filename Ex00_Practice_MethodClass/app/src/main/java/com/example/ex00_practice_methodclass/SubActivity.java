package com.example.ex00_practice_methodclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Button btn = findViewById(R.id.btn1);
        int[] arr = new int[4];
        int arr2[] = { 1 , 2 , 3 , 4};//1차원 배열은 요소로 데이터만 가짐

        int[][] arr22 = new int[2][4];//행 ,열//2차원 배열은 요소로 1차원배열을 가짐(비정방형)
        int arrr22[][] = { { 1 , 2 , 3 , 4}};  //

 //       ArrayList<String> list = new ArrayList<>();
//        HashMap<String,String> mapList = new HashMap<>();
//        int[][][] arrr33; //3차원 배열은 2차원 배열을 요소로 가짐.
//        int arrr3[][][];
        //btn. (전체 멤버 . im 인스턴스 멤버들)
        //Button. static
        //Button.setOn
        //btn.setOnClickListener();

    }
}