package com.example.ex08_layoutinflater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    LinearLayout linear; // xml에서 만든 모든 위젯은 별도의 클래스파일이 존재한다.
                         // 대문자로시작(Class) , 소문자로시작(Method,Variable) , 전체 대문자(final variable)
                         // is <=returnType boolean , set<= setter , get<=getter
    RelativeLayout relative;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //String abcd = null; //reference <= 참조 메모리
        //                  //null.length()
        //                  //new <= 객체(Obj) 메모리에 공간을두고 사용할준비를함
        //                  //메모리에 공간을 안두고 사용준비 x
        //if(abcd.length() == 0){
        //    Log.d("글자" , " 글자가 0글자입니다.");
        //}

        //setContentView가 레이아웃을 찾아서 액티비티 화면에 '붙이는' 과정
        //레이아웃을 인플레이션 한다.
        //레이아웃을 인플레이션(붙임)처리를 하기전에 어떤 위젯을 찾고나서 이벤트를 걸면
        //해당하는 위젯을 null임(사용준비가 안됨)
        //＊오류가 났을때는 반드시 파란색글씨로 표시 된 오류코드와 그윗줄을 반드시 볼것※
        //안드로이드가 어려운 이유: 안드로이드 os에서 제공해주는 기능을 사용해서 코딩해야함
        //사용방법을 알고나서 사용하는것은 쉽지만 백퍼센트 모든 원리를 이해하는것이 어려움.
        setContentView(R.layout.activity_main); // setContentView다음에 어떤 위젯을 찾는처리가 있는경우.
        btn1 = findViewById(R.id.btn1);
        //레이아웃을 붙임(붙어질 레이아웃)
        linear = findViewById(R.id.linear);//<=sub1.xml
        relative = findViewById(R.id.relative);//<=sub1.xml
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //※ 레이아웃을 붙일때 사용하는 객체 ( LayoutInflater ) <= os에서 제공해줌
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.sub1, linear , true);
                inflater.inflate(R.layout.sub2, relative , true);
                //attachToRoot<= xml파일이 별도로 .java코드를 가지고 있는지 여부 (true없음)
                // false <= xml파일이 별도로 .java코드를 가지고있는형태 (대부분임 나중엔)

                //findViewById<= '현재 내가 가지고있는' xml에서 위젯을 찾아와 자바코드와 연결해줌.
                Button sub_btn1 = findViewById(R.id.sub_btn1);
                sub_btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "토스트", Toast.LENGTH_SHORT).show();
                    }
                });
                
                
                //attachToRoot <= layout이 별도로 소스코드(.java)파일을 가지고있는지의 여부
                //true = 없음 , false = 있음(※※)
            }
        });




    }


}