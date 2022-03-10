package com.example.ex04_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int flag = 0; //0이면 아직 아무도 클릭하지 않은 상태. ?
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imgv1 = findViewById(R.id.imgv1); // java <=> xml
        ImageView imgv2 = findViewById(R.id.imgv2); // java <=> xml
        ImageView imgv3 = findViewById(R.id.imgv3); // java <=> xml
        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag ++ ;//버튼을 클릭 한번 flag=1 , flag=2 , flag=3...?
                //만약에 flag가 1이면 이미지 2를 보여주게 처리.
                //만약에 ....   2이면 이미지 1을
                //              3이면 이미지 3을.........
                //       4면?<- flag는 4가 되면 안됨.

                //imgv3.setVisibility(View.GONE);
                /* 자바코드를 이용한 문제 . (수단 방법 가리지 말기)
                * 버튼을 클릭할때마다 이미지가 바뀌게 처리.
                * ex)버튼한번클릭 이미지3(안보임) 이미지2(보임)
                * 두번 클릭 이미지2(안보임) 이미지1(보임)---------
                * 세번 클릭 이미지1(안보임) 이미지3(보임)
                * */

            }
        });


    }
}