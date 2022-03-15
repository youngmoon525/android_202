package com.example.ex05_examplejava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {
    EditText edt_text1 , edt_text2 ;
    Button btn_plus;
    //필드 , 멤버 변수
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        edt_text1 = findViewById(R.id.edt_text1);
        edt_text2 = findViewById(R.id.edt_text2);
        btn_plus = findViewById(R.id.btn_plus);
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //instence <= new를 통해서 메모리에 올려야만 호출할수있는영역
                //static <= new가 필요없이 클래스에 접근만해도 됨.
                //멤버 == 클래스 뒤에다가 .찍으면 나오는 변수,메소드 등.
                //인스턴스 멤버 = 인스턴스화 된 (변수화) 객체 뒤에 .
                //스태틱 멤버 = 클래스 뒤에 .찍으면 나오는 것들
                //Test test = new Test();
                //test.method1();
                //test.method2();//private 접근제한자로 외부에서는 접근 x
                //Test.method3();
                //test.method3();//<= 프로그램은 이방식을 추천x
                Test b = new Test();
                int result = b.rtnInt(edt_text1.getText()+"")
                           + b.rtnInt(edt_text2.getText()+"");
                Log.d("합계", "합계는: " + result);
                //Test클래스에 String을 입력받아서 int를 return 메소드를
                //자유롭게(이름) 만들고 edt1 + edt2 합을 구할수있게 프로그램.
                //ex)int result = test.메소드이름(문자값) +test.메소드이름(문자값);
                // 로그출력(result)

                //응용문제 ( 못풀어도됨 좀 어려움)
                int result2 =Test.parseEdt(edt_text1) + Test.parseEdt(edt_text2);
                Log.d("합계", "edt메소드 합계는: " + result);




            }
        });

    }

}