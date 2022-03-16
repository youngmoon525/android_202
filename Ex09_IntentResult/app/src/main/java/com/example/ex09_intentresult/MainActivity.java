package com.example.ex09_intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView main_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        main_tv = findViewById(R.id.main_tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserDTO dtoa ;

                dtoa = new UserDTO("kym" , "kaaaa" ,"이름" , 99);

                //※인텐트 ( Intent ) : 인텐트는 크게 두가지 종류로 구분이 된다.
                //암시적(묵시) , 명시적
                //명시적 인텐트 , 정확한 위치를 알고 있을때 ( 내가 소스를 가지고 있음) 사용
                //ex) 액티비티 메인(회원 가입) =>(intent)=> 액티비티 서브(로그인 화면으로 보내줄때) ,새 액티비티 띄우기
                //암시적(묵시) , 정확한 위치는 모르지만 어떠한 서비스를 실행할때 사용
                // ex) 액티비티 메인=> 전화걸기(os) or , 문자보내기(os) , 카메라로 사진찍기(os), naver.com(Internet)
                Intent intent = new Intent(MainActivity.this , SubActivity.class);
                //intent에 데이터를 담아서 넘긴다.
                //key,value
                //HashMap<String,String> map = new HashMap<>();
                //map.put("key","value");
                intent.putExtra("value1","이 데이터는 Main에서 보내준거다.");
                intent.putExtra("value2",1000);
                UserDTO dto = new UserDTO("kym" , "kaaaa" ,"이름" , 99);
                // new 를 통한 생성자 메소드는 객체 타입을 리턴한다.
                //ArrayList<Element==UserDTO>에 Element를 UserDTO로 한다.
                //데이터를 10건정도 넣어서 리스트 만들어 보기.
                //배열Array ====> List ( => ArrayList<- , LinkedList-느림)
                UserDTO[] arrUserDTOs = new UserDTO[4];//<=정해진 데이터 건수를 넘어서면 불편
                //[dto@12345]     [dto] [new UserDTO] [null]
                //인스턴스화
                arrUserDTOs[0] = new UserDTO("a" , "b","c",111);

                ArrayList<UserDTO> list = new ArrayList<>();
                for(int i = 0 ; i<10; i++) {
                    list.add(new UserDTO("kym"+i, "kaaaa", "이름", 99));
                }
                intent.putExtra("list" , list);
                //직렬화 된 객체가 아니면 Intent를 통해서 넘길수가없음.
                for(int i = 1 ; i<=100 ; i++){
                    intent.putExtra("num" + i,i); // num1 ..num2
                }


                startActivity(intent);
            }
        });

    }
}