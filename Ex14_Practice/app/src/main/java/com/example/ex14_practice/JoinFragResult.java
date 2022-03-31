package com.example.ex14_practice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class JoinFragResult extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_join_result, container, false);
        Button btn = v.findViewById(R.id.btn_next);
        btn.setText("회원 가입 완료");

        return v ;
    }
}