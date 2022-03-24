package com.example.ex13_listview;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ex13_listview.listvcus.CustomAdapter;
import com.example.ex13_listview.listvcus.CustomDTO;

import java.util.ArrayList;


public class ListFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflater.inflate(layout) == setContentView(layout)
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);
        ListView listView = viewGroup.findViewById(R.id.listview);
        Button btn_search = viewGroup.findViewById(R.id.btn_search);
        ArrayList<CustomDTO> list = new ArrayList<>();
        list.add(new CustomDTO("홍_길_동" , "상메" , R.drawable.ic_launcher_background));
        list.add(new CustomDTO("임_꺽정" , "심심쓰" , android.R.drawable.checkbox_on_background));
        list.add(new CustomDTO("성춘_향" , "" , android.R.drawable.ic_dialog_alert));
        list.add(new CustomDTO("에_디슨" , "전기" , android.R.drawable.ic_dialog_info));
        list.add(new CustomDTO("빌게_이츠" , "" , android.R.drawable.ic_menu_compass));

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //LayoutInflater inflater1 = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //Context<= 화면에서 제어될때 많은 기능들을 담고있는 클래스
                //화면 제어권(기능이 제약 된) Fragment 기준 기능이 부족하다면 나의 상위 액티비티에 기능들을
                //가지고오는 메소드가 있다. getActivity, getContext
                CustomAdapter adapter = new CustomAdapter(inflater , list);
                listView.setAdapter(adapter);
            }
        });
        return viewGroup;
    }
}