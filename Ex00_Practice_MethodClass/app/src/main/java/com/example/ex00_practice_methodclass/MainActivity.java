package com.example.ex00_practice_methodclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1 , btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PracticeCls cls = new PracticeCls();//인스턴스화 시킴
        cls.value1="A"; //iv ↑
        PracticeCls.value2 = "B"; //static멤버 (sv)는 항상 클래스에만 접근해도 사용가능
        cls.method1();
        PracticeCls.method2();
        //좌변에 있는 변수에 우변에 있는 값을 할당
        //기본 변수는 한가지 값만 가지고있을수있음.
        cls.value3 =  cls.value3 + 1; //++
        cls.value3 ++ ;
        cls.value3 +=1;
        cls.value4 ++;
        int value5 = cls.getValue5() +1 ;
        //cls.value5 <= private으로 내부에서만 사용(멤버끼리만)
        //public , default형태의 getter & setter

        //value3~5까지 각각의 값에 +1해보기.
        //변수를 사용할수없다면 왜 안될까?


        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //글씨 바꾸기 .setText<=
                //btn1.setText("버튼 글씨를 바꿈");
                //String str = "내가 붙인 글씨";
                //changeText(str);
                changeText("내가 붙인 글씨");
                //Button btn = null;
                //변수를 초기화 아무것도없는상태 null == Button x
                //Button.setText("String"); //메모리에 어떤 객체가 올라와서 참조
                //null.setText("String");   //메모리에 아무것도 x null인상태
                changeText(btn1);
            }
        });
        btn2 = findViewById(R.id.btn2);
        changeText(btn2);

    }//onCreate Method

    //1.메소드 안에는 클래스를 중첩하지 않은 경우에는 메소드를
    //넣을수가없다. ※ 클래스의 중괄호사이에 만든다. ※

    //2.메소드를 정의(만들어놓은 부분) + "=" + 메소드를 호출(값을 주는부분) =변수초기화식
    // String str = "내가 붙인 글씨";

    //3.내가 알고있는 모든 것들은 파라메터부에 쓸수있음 ※

    //4.메소드는 파라메터의 갯수나 타입이 다르면 같은 이름으로 중첩 시킬수가있다.
    // 메소드 오버로딩 <= 면접에 가끔 물어봄( java , Spring )
    void changeText(String str){
        btn1.setText( str + "메소드로 바꿔봄");
    }
    void changeText(Button btn){//<= 호출해보기
        btn.setText("버튼을 파라메터로 입력받아서 사용해봄.");
    }


}