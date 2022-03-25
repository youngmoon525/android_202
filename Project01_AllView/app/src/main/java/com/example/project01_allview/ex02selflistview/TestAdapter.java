package com.example.project01_allview.ex02selflistview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.project01_allview.R;

import java.util.ArrayList;

public class TestAdapter extends BaseAdapter {
    ArrayList<TestDTO> list;
    LayoutInflater inflater;

    public TestAdapter(ArrayList<TestDTO> list, LayoutInflater inflater) {
        this.list = list;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override // int i<= 칸마다의 인덱스(주소) 우리한테 넘겨줌.
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //칸마다 보여질 화면을 붙이고 return
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        convertView = inflater.inflate(R.layout.item_selflistview ,parent , false);
        ImageView imageView = convertView.findViewById(R.id.imgv_title);
        Glide.with(convertView)
                .load("https://cdn.notefolio.net/img/d6/3f/d63fc54819cd3fb0c319021e2e7cd6bfee951e8ce2db9e948bd828f538272da6_v1.jpg")
                .into(imageView);
        return convertView;
    }
}
