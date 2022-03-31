package com.example.ex14_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class FragAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);
        //Fragment를 하나 생성후 Activitiy_frag에 붙이기
        // -> hint , 어디에 붙일껀지 ( Layout ) container
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container , new MainFragment()).commit();

        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container , new SubFragment()).commit();

                // 프래그먼트를 하나 추가 ( 이름은 자유롭게 배경색은 어두운 색 )
                // 다음 프래그먼트 버튼 클릭시 만든 프래그먼트로 전환되게끔 처리.replace()
            }
        });
    }

    void chageFragment(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container , new MainFragment()).commit();
    }
}