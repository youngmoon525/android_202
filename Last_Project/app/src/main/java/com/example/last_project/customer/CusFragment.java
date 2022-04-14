package com.example.last_project.customer;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.last_project.R;
import com.example.last_project.common.AskTask;
import com.example.last_project.common.CommonMethod;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
        ArrayList<CusDTO> list = selectList();//getContext<= 프래그먼트가 띄워져있는 부모가되는 엑티비티
        CusAdapter adapter = new CusAdapter(inflater , list , getContext());
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

        selectList();
        return v ;
    }


    public ArrayList<CusDTO> selectList(){
        Gson gson = new Gson();
        AskTask task = new AskTask("list.cu");
        InputStreamReader ir =  CommonMethod.executeAskGet(task);
        ArrayList<CusDTO> list = null ;
        if(ir!=null){
            list = gson.fromJson(ir ,
                    new TypeToken< List<CusDTO> > (){}.getType());
        }else{
            Log.d("TAG", "selectList: " + "널임");
        }
        return list;
    }
}