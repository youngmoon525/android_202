package com.example.project01_allview.pack05recyclerview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_allview.R;

import java.util.ArrayList;

public class RecyclerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_recycler, container, false);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                getContext() , RecyclerView.HORIZONTAL , false
        );//  해당하는 매니저를 사용하고있는 화면(Context)
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<10; i++){
            list.add("문자열"+ i);
        }

        RecAdapter adapter = new RecAdapter(inflater , list);
        // 방향지정 , 반대로 정렬 할건지 대부분 false
        RecyclerView rec_view = rootView.findViewById(R.id.rec_view);
        rec_view.setAdapter(adapter);
        rec_view.setLayoutManager(manager);
        // 리사이클러 뷰는 가로 또는 세로로 선택을 할수가있다.(데이터 뷰 형태를)

        return rootView;
    }
}