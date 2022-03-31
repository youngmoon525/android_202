package com.example.ex14_practice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 나중에 위젯을 찾아서 사용할때는 return타입인 view를 내가 원하는 변수에 담아서 사용.

        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}