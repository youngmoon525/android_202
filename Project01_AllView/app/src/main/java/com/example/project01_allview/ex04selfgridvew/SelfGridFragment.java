package com.example.project01_allview.ex04selfgridvew;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.project01_allview.R;

import java.util.ArrayList;

public class SelfGridFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_self_grid, container, false);
        GridView gridView = rootView.findViewById(R.id.gridview);
        //DTO , XML
        // fragment_self_grid <= 여기 안에 listview가 없음 find를 통해서 찾아도 null gridview.!
        ArrayList<SelfGridDTO> list = new ArrayList<>();
        for(int i = 1 ;  i< 100 ; i++){
            list.add(new SelfGridDTO("https://cdn.icon-icons.com/icons2/1128/PNG/512/1486164755-125_79693.png" , "text" + i));
        }

        SelfGridAdapter adapter = new SelfGridAdapter(list ,inflater);
        gridView.setAdapter(adapter);
        return rootView;
    }
}