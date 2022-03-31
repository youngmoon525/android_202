package com.example.ex14_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();// <= Main에서 보내준 Intent를 받아옴. ( str )
        String str = intent.getStringExtra("str");
        Log.d("받아옴", str);

        ImageView imgv1 = findViewById(R.id.imgv1);
        //Tag <= 어떠한 속성을 넣어놓고나서 해당하는 속성을 이용하는 기법( Object 형태를 넣기때문에 대부분의 것은 넣어짐)
        imgv1.setTag(1); //초기에 1을 넣어둠.
        imgv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("태그에 있는값", imgv1.getTag() + "");
                //이미지를 클릭할때마다 1과 2가 반복적으로 번갈아서 찍히게끔 코딩
                // setTag , getTag이용.   // 처음클릭 . ????
                if(imgv1.getTag().toString().equals("1")){
                    imgv1.setTag(2);
                    imgv1.setImageResource(R.drawable.ic_launcher_background);
                }else{
                    imgv1.setTag(1);
                    imgv1.setImageResource(R.drawable.ic_launcher_foreground);
                }
                // setTag , getTag 이용해서 이미지를 클릭할때마다 다른이미지로 변하게 처리.
                //1== imgv1 == 안드로이드 이미지 초록색
                //2== imgv1 == 안드로이드 이미지 흰색
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SubActivity.this , FragAct.class);
                startActivity(intent1);
            }
        });


    }
}