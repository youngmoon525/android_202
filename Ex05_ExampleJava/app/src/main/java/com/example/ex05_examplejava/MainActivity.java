package com.example.ex05_examplejava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
//어떤 위젯이든 변수형태로 담아서 사용한다. ( Android 규칙 )
// find를 통해서 xml에 미리 디자인 해놓은 위젯을 찾아서 연결시킴. ※
    //클래스 '사이에' 변수를 만들면 전역변수가 됨 (멤버)
EditText edt_text1 , edt_text2 ;
Button btn_plus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_text1 = findViewById(R.id.edt_text1);
        edt_text2 = findViewById(R.id.edt_text2);
        btn_plus = findViewById(R.id.btn_plus);
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Test test = new Test();
                test.method1();
                //메소드 호출 규칙
                //메소드의 정의 부분 즉 이름까지를 써줌
                //메소드 정의부에 파라메터가 있다면 파라메터에 담을
                //데이터를 넘겨줌. 정의와 호출부를 합치게 되면
                //변수 초기화 식이 된다.
                //String inputData = "1";
                //String inputData = null;
                int edtNumber1 = rtnInt(edt_text1.getText()+"");
                int edtNumber2 = rtnInt(edt_text2.getText()+"");
                Log.d("plusSum", " " + (edtNumber1+edtNumber2));
                //int edtNumber1 = Integer.parseInt(edt_text1.getText()+"");
                //int edtNumber2 = Integer.parseInt(edt_text2.getText()+"");

            }
        });
    }

//Method정의 <= 1.메소드는 메소드 블럭킹 밖에서 만듬.(클래스 안에 있어야함)
//2.void냐 void아니냐 (return이 필요한경우 , return이 필요없는 경우)
//3.public(전체) default(생략)-같은패키지 , private-클래스까지
    int rtnInt(String inputData){
        try {
          return Integer.parseInt(inputData);//사용자가 숫자를 입력한경우.
        }catch (Exception e){
            return 0;
        }
    }




}