package com.example.last_project.employees;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.last_project.R;
import com.example.last_project.common.AskTask;
import com.example.last_project.common.CommonMethod;
import com.example.last_project.customer.CusDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class EmpFragment extends Fragment {
    RecyclerView rec_emp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_emp, container, false);
        rec_emp = v.findViewById(R.id.rec_emp);

        AskTask task = new AskTask("list.hr");
        Gson gson = new Gson();
        ArrayList<EmpDTO> list =
                gson.fromJson(CommonMethod.executeAskGet(task)
                ,new TypeToken<List<EmpDTO>>(){}.getType()
                );


        EmpAdapter adapter = new EmpAdapter(inflater ,list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                getContext() , RecyclerView.VERTICAL , false
        );
        rec_emp.setLayoutManager(manager);
        rec_emp.setAdapter(adapter);
        return v;
    }
}