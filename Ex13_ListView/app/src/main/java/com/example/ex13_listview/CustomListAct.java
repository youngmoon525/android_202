package com.example.ex13_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.ex13_listview.listvcus.CustomAdapter;
import com.example.ex13_listview.listvcus.CustomDTO;

import java.util.ArrayList;

public class CustomListAct extends AppCompatActivity {
    //데이터 ArrayList<E> Elements <= 자체도 커스텀.(내가 원하는 형태)
    //뷰 layout (칸마다 붙는 데이터<= 자체도 커스텀.(내가 원하는 형태)
    //1.DTO 여러가지 변수(내가 화면을 보여줄때 필요한 데이터들을 묶어놓은 객체)
    //2.Layout 칸마다 붙어서 보여질 화면을 만듬
    //3.↑두개를 이용을해서 Adapter를 만듬.
    //4.listview <= adapter를 세팅함
    Button btn_search;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        ArrayList<CustomDTO> list = new ArrayList<>();
        list.add(new CustomDTO("홍길동" , "상메" , R.drawable.ic_launcher_background));
        list.add(new CustomDTO("임꺽정" , "심심쓰" , android.R.drawable.checkbox_on_background));
        list.add(new CustomDTO("성춘향" , "" , android.R.drawable.ic_dialog_alert));
        list.add(new CustomDTO("에디슨" , "전기" , android.R.drawable.ic_dialog_info));
        list.add(new CustomDTO("빌게이츠" , "" , android.R.drawable.ic_menu_compass));

        btn_search = findViewById(R.id.btn_search);
        listview = findViewById(R.id.listview);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                CustomAdapter adapter = new CustomAdapter(inflater , list);
                listview.setAdapter(adapter);
            }
        });

    }
}