package com.example.project01_allview.ex03gridview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.project01_allview.R;
import com.example.project01_allview.ex02selflistview.TestAdapter;
import com.example.project01_allview.ex02selflistview.TestDTO;

import java.util.ArrayList;

public class GridFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_grid, container, false);
        GridView gridView = viewGroup.findViewById(R.id.gridview);
        ArrayList<TestDTO> list = new ArrayList<>();
        for(int i = 0 ; i < 20 ; i ++){
            list.add(new TestDTO(i+1+"" , "title" , "가수"));
        }
        TestAdapter adapter = new TestAdapter(list , inflater);
        gridView.setAdapter(adapter);

        return viewGroup;
    }
}