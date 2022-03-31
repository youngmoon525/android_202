package com.example.ex14_practice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class SubFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 나중에 위젯을 찾아서 사용할때는 return타입인 view를 내가 원하는 변수에 담아서 사용.
        View rootView =  inflater.inflate(R.layout.fragment_sub, container, false);
        Button btn_back = rootView.findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FragAct act = new FragAct(); //<=x하면 안됨.
                FragAct act = (FragAct) getActivity(); // <=나를 담고있는 액티비티를 받아와서 변수에 담아서 사용.
                act.chageFragment();
                // Activity 1.↓
                // Fragment 2 <=> Fragemnt 2
            }
        });
        return rootView;
    }

}