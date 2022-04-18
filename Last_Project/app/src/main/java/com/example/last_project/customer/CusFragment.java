package com.example.last_project.customer;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.StrictMode;
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
    ArrayList<CusDTO> list ;
    CusAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        // ↑ 네트워크 오류를 풀어준다.
        // excute(); <- 어싱크 실행 시 비동기로 작업함
        // excute().get() <- 어싱크 실행 시 동기로 작업함(완료 될때까지 프로그램이 대기상태)

        View v = inflater.inflate(R.layout.fragment_cus, container, false);
        recv_cus  = v.findViewById(R.id.recv_cus);
        swipe  = v.findViewById(R.id.swipe);
        scv_cus  = v.findViewById(R.id.scv_cus);
        list = selectList();//getContext<= 프래그먼트가 띄워져있는 부모가되는 엑티비티
        adapter = new CusAdapter(inflater , list , getContext());
        recv_cus.setAdapter(adapter);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                getContext() , RecyclerView.VERTICAL , false
        );
        scv_cus.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override // 돋보기 확인 버튼을 눌렀을떄 처리.
            public boolean onQueryTextSubmit(String query) {
                Log.d("태그", " : " + query);
                // query라는 String 변수를 이용해서
                //해당하는 내용으로 Customer테이블에서 email 또는 이름 또는 전화번호가
                //해당하는 값과 일치하는 검색 정보를 조회하기.
                //SelectList<=메소드를 이용해서 처리하기 ( 전체 조회 )
                //전체조회 + where 조건 <= 선택 조회

                //메소드 <= 전체 조회(selectList)
                //어떤 값을 메소드에서 이용할수있게 해아한다.??
                //파라메터로 보내준다.
                adapter.setList(selectList(query));
                adapter.notifyDataSetChanged();
                return false;
            }

            @Override // 글자가 바뀔때 마다 처리.
            public boolean onQueryTextChange(String newText) {
                if(newText == null || newText.length() < 1){
                    refreshSelect();
                }
                Log.d("태그", " : " + newText);
                return false;
            }
        });


        recv_cus.setLayoutManager(manager);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshSelect();
                // 여기 부분 실행전에 Spring에서 데이터 얻어오는 처리 넣어주면 됨.
                swipe.setRefreshing(false);
            }
        });

        return v ;
    }

    // 메소드 오버로딩 ( 같은 이름으로 파라메터의 타입이나 갯수를 달리해서
    // 개발자가 선택해서 사용할수있게함.)
    public ArrayList<CusDTO> selectList(){
        Intent intent = new Intent();
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

    public ArrayList<CusDTO> selectList(String query){
        Gson gson = new Gson();
        AskTask task = new AskTask("list.cu");
        task.addParam("data" , query); //<= param(req요청시 데이터를 같이 주고 요청)
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

    @Override // 프래그먼트가 다시 작동할때마다 실행되는 부분.
    public void onResume() {
        super.onResume();
        refreshSelect();
        Log.d("태그" , "onResume: " + "작동함.");
    }
    //String query = null;
    public void refreshSelect(){

        adapter.setList(selectList());
        adapter.notifyDataSetChanged();
    }
}