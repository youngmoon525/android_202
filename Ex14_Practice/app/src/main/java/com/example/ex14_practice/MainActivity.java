package com.example.ex14_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 모든 위젯들은 View라는 클래스를 상속받은 객체들이다. ( Object=>View =>위젯(레이아웃,ViewGroup)
        // 공통기능 + 버튼에만 필요기능 , 텍스트뷰에만 필요한기능.. 등등
        // 2G폰->3G폰->4G폰 기존에 있던 기능을 그대로 사용하고 + 기능을 업그레이드함(재정의)(상속)
        Button button = findViewById(R.id.btn1);

        TextView tv1 = findViewById(R.id.tv1);
        EditText edt1 = findViewById(R.id.edt1);
        ImageView imgv = findViewById(R.id.imgv1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "버튼이 클릭 되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "텍스트뷰 클릭 됨.", Toast.LENGTH_SHORT).show();
            }
        });

        edt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "에딧 텍스트가 클릭 됨", Toast.LENGTH_SHORT).show();

            }
        });

        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "이미지뷰가 클릭 됨", Toast.LENGTH_SHORT).show();

            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // edt텍스트에서 제일 많이 사용되는것은 , edt.getText() <=  return type editable +"" 확실하게 스트링으로만들기
                Toast.makeText(MainActivity.this, edt1.getText()+"", Toast.LENGTH_SHORT).show();
                // edt1에 입력된 값이 aaa와 같다면 로그인 되었습니다가 로그에 찍히는 프로그램을 작성하세요.
                // String에서의 값비교는 반드시 equals 를 사용해야함
                // == 참조하고있는 어드레스의 비교이다. ( new를 사용하면 다를수밖에없음 )
                // 대문자로 시작하는 Class타입은 두개의 메모리 번지를 가지고.
                // 일반 변수(소문자시작)은 한개의 메모리 번지를 가지기 때문에 값비교 방식이 다르다.

                if(edt1.getText().toString().equals("aaa")){
                    //새로운 액티비로 이동.
                    //SubActivity1을 추가하고 해당하는 액티비티로 이동하는 코드 작성.

                    // intent가 이동할때 입력 한 id(aaa)를 가지고 SubActivity로 이동하기.
                    // 2. SubActivity에서 받은 id값을 출력해보기(TextView,Logd,Toast)
                    Intent intent = new Intent(MainActivity.this , SubActivity.class);
                    intent.putExtra("str" , edt1.getText().toString());
                    startActivity(intent);

                }
//
//                if(edt1.getText().toString() == "aaa"){
//
//                }
                //==========================================================↑
                //trim()
            }
        });

    }

    public static class TestDTO{
        static String aaa = "asd";
    }
}