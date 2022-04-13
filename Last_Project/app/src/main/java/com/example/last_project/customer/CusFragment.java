package com.example.last_project.customer;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.last_project.R;

public class CusFragment extends Fragment {
    RecyclerView recv_cus;
    SwipeRefreshLayout swipe;
    SearchView scv_cus ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cus, container, false);
        recv_cus  = v.findViewById(R.id.recv_cus);
        swipe  = v.findViewById(R.id.swipe);
        scv_cus  = v.findViewById(R.id.scv_cus);

        CusAdapter adapter = new CusAdapter(inflater);
        recv_cus.setAdapter(adapter);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                getContext() , RecyclerView.VERTICAL , false
        );
        recv_cus.setLayoutManager(manager);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 여기 부분 실행전에 Spring에서 데이터 얻어오는 처리 넣어주면 됨.
                swipe.setRefreshing(false);
            }
        });


        return v ;
    }
}