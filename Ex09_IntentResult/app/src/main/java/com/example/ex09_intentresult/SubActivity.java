package com.example.ex09_intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {
    String intData = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        //Intent를 만듬. new로 만드는거 x => MainActivity에서 보내준것을 받오게끔 처리를 해야함.
        Intent intent = getIntent();//MainActivity에서 물려놓은 Intent를 받아올수있음 ( Controller => jsp )
        String value = intent.getStringExtra("value1");
        int value2 = intent.getIntExtra("value2" , 0);//null을 담을수없는 int형 데이터는
                                                                        //key로 데이터를 찾았을때 없다면 담을 숫자]
        ArrayList<UserDTO> dtoList = (ArrayList<UserDTO>) intent.getSerializableExtra("list");


        UserDTO dto = (UserDTO) intent.getSerializableExtra("dto");
        Toast.makeText(this, dto.getId() + dto.getAge(), Toast.LENGTH_SHORT).show();
        for(int i = 1 ; i<=100 ; i++) {
            intData += intent.getIntExtra("num"+i, 0) + "";
        }
        Toast.makeText(this, intData, Toast.LENGTH_SHORT).show();
    }
}