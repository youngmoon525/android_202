package com.example.ex07_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
                          implements View.OnClickListener {
    ImageView imagv1 , imagv2 ,imagv3 ,imagv4 ;
    Button btn1 , btn2 ;
    ArrayList<ImageView> imgList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagv1 = findViewById(R.id.imgv1);
        imagv2 = findViewById(R.id.imgv2);
        imagv3 = findViewById(R.id.imgv3);
        imagv4 = findViewById(R.id.imgv4);

        imgList.add(imagv1);
        imgList.add(imagv2);
        imgList.add(imagv3);
        imgList.add(imagv4);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        // new View.Onclick == Interface ( 상속받아서 사용가능 )
        // extends <= 상속이 하나만 됨
        // implements <= 다중 상속이 가능함(강제로 만들어야할 메소드가 있음)
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn1){
            Test.changeVis(imagv1 , imagv2);
        }else if(v.getId() == R.id.btn2){
            Test.changeVis(imagv3 , imagv4);
        }
    }//OnClick ( Interface를 상속받아서 구현부를 직접 클래스에 만듬)

    //이미지뷰 갯수가 일정하지 않은 순간이 무조건있음 100
//    private void changeVis(ImageView imagv1, ImageView imagv2) {
//        if(imagv1.getVisibility() == View.VISIBLE){
//            imagv1.setVisibility(View.GONE);
//            imagv2.setVisibility(View.VISIBLE);
//        }else if(imagv2.getVisibility() == View.VISIBLE){
//            imagv2.setVisibility(View.GONE);
//            imagv1.setVisibility(View.VISIBLE);
//        }
//    }
//    int visible = 0;
//    private void changeVis(ArrayList<ImageView> list) {
//        for(int i= 0 ; i<list.size(); i++){
//            list.get(i).setVisibility(View.GONE);
//        }
//        list.get(visible).setVisibility(View.VISIBLE);
//        visible ++ ;
//    }


}