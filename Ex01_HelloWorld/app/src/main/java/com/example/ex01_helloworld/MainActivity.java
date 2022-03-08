package com.example.ex01_helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
// AppCompatActivity라는 클래스를 상속을 받음. ( 화면 하나의 단위를 Activity라고 한다)
// 재정의를 통해서 작업을 시작을 한다. onCreate <=
// 위젯을 찾거나 액티비티가 초기화되는 시점에서 반드시 필요한 코딩들은 onCreate메소드 안에서 한다.
//setContentView(R.layout.activity_main) <= 해당하는 메소드는 매우 중요함
// xml <=> java를 연결시키는 메소드
// ex) xml(디자인) 버튼을 추가함 그리고 ID를 줌. => java파일에서 xml<=>java를 연결 시킴.
// 그리고 나서 id를 통해서 해당하는 버튼을 찾고 기능을 구현함.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//※
        //return type <=> 리턴을 받는 객체 타입은 같을수밖에없음.
        //btn1이라는 Button타입의 변수를 선언과 동시에 값을 할당.
        //res=> R이라는 클래스로 나중에 만들어짐. ( 위젯에 아이디를 주게 되면 Android Sdk가 알아서 R클래스로 만듬)
        //res == R == Resourcese
        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //syso ==> logd ( "String필터값" , "String값") 1.로그캣을 필터할수있는 값 2.실제 로그에 찍을 값
                Log.d("구분할수있는값", "내가 실제 출력하고 싶은 값");
            }
        });
        Button btn2 = findViewById(R.id.btn2);
        Toast.makeText(this, "원하는 메세지" , Toast.LENGTH_SHORT).show();
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast 대문자로시작 소문자로 끝까지
                //두번째메소드를 선택 ( create a new ....)
                Toast.makeText(MainActivity.this, "토스트 메세지 KYM", Toast.LENGTH_SHORT).show();
                //for문을 이용해서 토스트를 10번찍는데 원하는 메세지 + 숫자가 나오게끔 처리해보시오.
                //for( 반복에 사용할변수 초기화 ; 반복시킬동안 true나올수있게 값 ; 증감 )
                for(int i = 0 ; i < 10 ; i++){
                    Toast.makeText(MainActivity.this, "원하는 메세지" + i, Toast.LENGTH_SHORT).show();
                    //Context <=== ※※※※※※※ 현재 화면에 띄워져있는 객체
                }
            }
        });

        Button btn_new = findViewById(R.id.btn_new);
        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent <= 새로운 화면을 띄우거나 안드로이드에서 제공하는 액션(전화걸기,갤러리,카메라 등등)을 사용할수있게
                //해주는 중간다리 역. 현재화면(Main).this => 새로운 화면(Sub).class
                Intent intent = new Intent(MainActivity.this , SubActivity.class);
                startActivity(intent);//startActivity라는 메소드는 Intent에 미리 정의해놓은 화면으로 이동하는 처리를 한다.
            }
        });


    }//onCreate



}//ActivityClass