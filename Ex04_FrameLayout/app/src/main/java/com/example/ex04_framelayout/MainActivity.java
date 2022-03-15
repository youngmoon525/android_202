package com.example.ex04_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int flag = 0; //0이면 아직 아무도 클릭하지 않은 상태. ?
    String testV = null;
    ImageView imgv1, imgv2,  imgv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgv1 = findViewById(R.id.imgv1); // java <=> xml
        imgv2 = findViewById(R.id.imgv2); // java <=> xml
        imgv3 = findViewById(R.id.imgv3); // java <=> xml
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag ++ ;   // 1 , 2 , 3  if ==> 0
                changeImg();// 0 , 1 , 2 , 0== ,
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag --;// 0 == -1 , 1 == 0 , 2 == 1 , ?
                //   버튼을 클릭하면 값이 무조건 세개안에서 돌아야함 0 , 1 , 2
                changeImg();// 0 ==> 2 , 1 , 0 , 0==?
                ////???

            }
        });


    }//onCreate
    //1.public <= 접근제한(어디서든 접근가능) , private(클래스 내에서만)
    // , default(<=같은 패키지 내에서만 접근 가능)

    //void이냐 void가 아니냐 ※※※※※
    //void이면 실행이 되고나서 return이 없는 메소드
    //void가 아니면 어떤 형태든 지정되어있는 DataType을 return해야 하는 메소드(null)
    //Button , ImageView , Linearlayout , FrameLayout

    //Collection자료구조 , 배열Array 어떤것이든 내가 알고있는 대부분은 자료구조형으로 바꿀수있음
    //
//    ArrayList<LinearLayout> list = null;
//    FrameLayout[] fArr = new FrameLayout[5];
//
//    Button rtnBtn(){
//        return null;
//    }
//    ImageView rtnImageView(){
//        return null;
//    }

    //lv <= 메소드 내에서 선언된 변수로 메소드 블럭킹 {} 사용할수없음
    //Instence variable <= Instence 객체를 new로 초기화해서 메모리에 올리는 방법 (인스턴스화 해야지만 다른클래스에서
    //사용할수있는 변수를 의미한다 )
    //iv , sv = 멤버 ( 클래스 블럭킹 안에서 사용할수있는 두개의 멤버)
    // variable(변수선언) , for(반복문) , if(선택문) , <-
    // Class(오브젝트) , method(함수) , Collection(ArrayList<>) , oop(dao , dto)

    void changeImg(){
        if(flag == -1) flag = 2;
        if(flag == 3) flag = 0 ;
        imgv1.setVisibility(View.GONE);
        imgv2.setVisibility(View.GONE);
        imgv3.setVisibility(View.GONE);
        if(flag == 0){
            imgv2.setVisibility(View.VISIBLE);
        }else if(flag == 1){
            imgv1.setVisibility(View.VISIBLE);
        }else if(flag == 2){
            imgv3.setVisibility(View.VISIBLE);
        }
    }


}//Class End