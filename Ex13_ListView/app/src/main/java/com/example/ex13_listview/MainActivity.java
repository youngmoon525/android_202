package com.example.ex13_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    Button btn_search;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_search = findViewById(R.id.btn_search);
        listview = findViewById(R.id.listview);
        //ListView,RecyclerView,GridView <= 연속 된 목록을 가진 List형태의 뷰들에 한칸마다 보여줄 정보들은
        //개발자마다 다른형태를 띄고 있음.
        //Adapter <= 데이터형태,데이터내용등등 여러가지가 다르기 때문에
        //Data => LisView에 걸어서 사용하는게아니라 내가 원하는 모양으로 만들수있게 제공을 함
        //기본적으로 제공해주는 모양 ArrayAdapter <= 외울 필요가 전혀 없음.
        //Adapter의 종류가 생각보다 많은데 사용빈도가 높은것들은 전부 커스터마이징 해야함.

        ArrayList<String> list = new ArrayList<>();//어댑터에 바인딩시킬 데이터
        for(int i = 0 ; i < 20 ; i++){
            list.add(UUID.randomUUID() + "");//고유 식별자 (WEB)
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                MainActivity.this , android.R.layout.simple_list_item_1,list
        );
        //android.R.layout.simple => 유저 커스터마이징 ( 내가 필요한 모양으로 만듬 )
        //ArrayList<E_DTO> list =>   유저 커스터마이징 ( 내가 필요한 데이터의 묶음 형태로 만듬)
        listview.setAdapter(adapter);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}