package com.example.project02_cloneapp.chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project02_cloneapp.R;

import java.util.ArrayList;

public class ChatFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //ViewGroup(자식 , Layout종류) extend View (부모 Layout + 위젯)
        View v = inflater.inflate(R.layout.fragment_chat, container, false);
        RecyclerView rec_chat = v.findViewById(R.id.rec_chat);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                getContext() , RecyclerView.VERTICAL , false
        );

        ArrayList<ChatDTO> list = new ArrayList<>();
        list.add(new ChatDTO("" , "홍길동1" , "마지막 메세지1" , "오후 16:40"));
        list.add(new ChatDTO("" , "홍길동2" , "마지막 메세지2" , "오후 16:41"));
        list.add(new ChatDTO("" , "홍길동3" , "마지막 메세지3" , "오후 16:42"));
        list.add(new ChatDTO("" , "홍길동4" , "마지막 메세지4" , "오후 16:43"));
        list.add(new ChatDTO("" , "홍길동5" , "마지막 메세지5" , "오후 16:44"));


        ChatAdapter adapter = new ChatAdapter(inflater , list);
        rec_chat.setAdapter(adapter);
        rec_chat.setLayoutManager(manager);

        return v;
    }
}