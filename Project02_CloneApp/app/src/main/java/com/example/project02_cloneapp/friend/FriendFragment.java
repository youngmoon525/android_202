package com.example.project02_cloneapp.friend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project02_cloneapp.R;


public class FriendFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_friend, container, false);
        RecyclerView rec_frdlist = rootView.findViewById(R.id.rec_frdlist);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                getContext() , RecyclerView.VERTICAL , false
        );
        FriendAdapter adapter = new FriendAdapter(inflater);
        rec_frdlist.setLayoutManager(manager);
        rec_frdlist.setAdapter(adapter);

        return rootView;
    }
}