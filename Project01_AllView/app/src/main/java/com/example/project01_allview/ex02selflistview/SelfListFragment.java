package com.example.project01_allview.ex02selflistview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.project01_allview.R;

import java.util.ArrayList;

public class SelfListFragment extends Fragment {
    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_selflist, container, false);
        //layout을 viewGroup에 담아서 (findViewById하기 위해서) 사용
        listView = rootView.findViewById(R.id.listview);
        ArrayList<TestDTO> list = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i ++){
            list.add(new TestDTO(i+1+"" , "title" , "가수"));
        }
        TestAdapter adapter = new TestAdapter(list , inflater);
        listView.setAdapter(adapter);
        return rootView;
    }
}