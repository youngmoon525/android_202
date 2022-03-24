package com.example.project01_allview.ex01listview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.project01_allview.R;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    ListView listView;
    Button btn_insert , btn_delete;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);
        //layout을 viewGroup에 담아서 (findViewById하기 위해서) 사용
        listView = rootView.findViewById(R.id.listview);
        ArrayList<ListDTO> list = new ArrayList<>(); // Spring , Eclipse DB에서 받아옴.
        list.add(new ListDTO(R.drawable.ic_launcher_background,"채팅방"
                ,"메세지 입니다1" , "오후 16:08"
        ));
        list.add(new ListDTO(R.drawable.ic_launcher_background,"채팅방"
                ,"메세지 입니다2" , "오후 16:09"
        ));
        list.add(new ListDTO(R.drawable.ic_launcher_background,"채팅방"
                ,"메세지 입니다3" , "오후 16:10"
        ));
        ListAdapter adapter = new ListAdapter(list , inflater);
        listView.setAdapter(adapter);

        btn_insert = rootView.findViewById(R.id.btn_insert);
        btn_delete = rootView.findViewById(R.id.btn_delete);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.list.add(new ListDTO(R.drawable.ic_launcher_background,"채팅방"
                        ,"메세지 입니다3" , "오후 16:10"
                ));
                adapter.notifyDataSetChanged();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 삭제 ??????????
                // 1.전체 비우기
                // ArrayList , List == 규칙 index ( index == 0~ size()-1 )
                //adapter.list.clear();
                adapter.list.remove(0);
                adapter.notifyDataSetChanged();
                //4개짜리 0~3 , 0 ~ n - 1
                // 2.0번 인덱스를 사용중인 데이터만 지우기.
            }
        });
        return rootView;
    }
}