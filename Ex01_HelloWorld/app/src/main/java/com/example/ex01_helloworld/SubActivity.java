package com.example.ex01_helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    Button button;
    static Button button2;
    // 클래스의 멤버 <= 클래스에 접근해야지만 사용할수있는 영역
    // 인스턴스 멤버 <= 클래스를 인스턴스화시켜야만 쓸수있음 == new SubActivity();<=
    // 스태틱 멤버 <= 클래스를 인스턴스화 안하고 접근만해서 . 사용가능 == SubActivity.button2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        //Button button ; //지역 변수 : 메소드 안에서만 사용가능
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goSub2();
            }
        });
    }

    //↓ 메소드 이름이 회색이면 만들어 놓고 호출안함(안씀)
    public void goSub2(){
        Intent intent = new Intent(SubActivity.this , Sub2Activity.class);
        startActivity(intent);
    }

}