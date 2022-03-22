package com.example.ex10_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;

    //onCreate 1.액티비티가 렌더링(화면에 보이는 단계 중 가장 먼저 실행 됨)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycleA", "onCreate: 1단계");
        button = findViewById(R.id.button);
        //위젯 <-> 자바코드만 연결
    }
    //2.단계
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycleA", "onStart: 2단계");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("lifecycleA", "onClick: 클릭됨");
                Intent intent = new Intent(MainActivity.this,SubActivity.class);
                startActivity(intent);//?
                //버튼을 클릭을하면 SubActivity가 나오게 처리 ※
                //Intent 객체이용. (Activity , Service , Provider , BrodCast)
            }
        });

        //자바코드로 어떤 메소드를 만들고나서 처리.
    }

    //1.Loader(코딩)=>2.Parsing(변환)=>3.랜더링트리
    //4.Css로딩 => 5.레이아웃 6.그리기(Painting)
    //Html/Jsp

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycleA", "onResume: 3단계 ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycleA", "onRestart: 액티비티가 다시 시작됨 ");
        button.setText("액티비티 다시 실행 ");
        // 새로운 화면을 띄우고 나서 새화면이 종료 되고 어떤 처리가 필요한경우
        // 데이터를 다시 조회함.
    }

    //액티비티가 종료 되기전 일시정지를 함. (종료 1단계:)
    //액티비티가 새로운 화면을 띄우기전에 일시정지를 함 ( 정지 1단계:)
    @Override
    protected void onPause() {
        super.onPause();
    }
    //액티비티가 종료 되기전 정지를 시킴. (종료 2단계)
    //액티비티가 새로운 화면을 띄우기전에 정지를 함 ( 정지 2단계 ) -끝- => 새화면 띄움
    @Override
    protected void onStop() {
        super.onStop();
    }
    //액티비티가 종료 되기전 마지막 단계. ( 종료 3단계 ) -> 종료
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}