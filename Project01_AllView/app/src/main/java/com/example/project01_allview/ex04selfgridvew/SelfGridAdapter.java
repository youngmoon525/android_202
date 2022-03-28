package com.example.project01_allview.ex04selfgridvew;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.project01_allview.R;

import java.util.ArrayList;

public class SelfGridAdapter extends BaseAdapter {
    // 화면 붙일 LayoutInflater 1 , getCount와 내용을 동적으로 보여줄 ArrayList
    ArrayList<SelfGridDTO> list;
    LayoutInflater inflater ;


    public SelfGridAdapter(ArrayList<SelfGridDTO> list, LayoutInflater inflater) {
        this.list = list;
        this.inflater = inflater;
    }

    public SelfGridAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Object getItem(int i) {
        return list.get(i);
    }
    @Override
    public long getItemId(int itemid) {
        return itemid;
    }
    @Override //0~99
    public View getView(int i, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_selfgrid , parent , false);
        ImageView imgv_grid = convertView.findViewById(R.id.imgv_grid);
        TextView tv_filename = convertView.findViewById(R.id.tv_filename);
        Glide.with(convertView).load(list.get(i).getUrl()).into(imgv_grid);
        tv_filename.setText(list.get(i).getText());
        return convertView;
    }

}
