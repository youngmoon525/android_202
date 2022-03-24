package com.example.project01_allview.ex02selflistview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.project01_allview.R;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    ArrayList<ListDTO> list ; //<= null <= Adapter를 사용하는 쪽에서 데이터를 넘겨 받음.
    LayoutInflater inflater;

    //해당하는 어댑터를 사용하기 위해서는 ArrayList x 1 , LayoutFlater x 1


    public ListAdapter(ArrayList<ListDTO> list, LayoutInflater inflater) {
        this.list = list;
        this.inflater = inflater;
    }

    //ListView,GridView,Recycle..index=0 <=> ArrayList.index=0
    //1.목록에 보여질 데이터 갯수를 의미함.
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override   //5 , pos=0 ....4
    public View getView(int i, View convertView, ViewGroup parent) {
        //화면을 붙여주는 처리 ( LayoutInflater ) <= Context(액티비티나 화면에 떠있는 객체에서만 생성가능)
        //어댑터를 사용하는 곳에서 받아오자. ↑
        convertView = inflater.inflate(R.layout.item_selflistview , parent , false );
        TextView tv_rank  = convertView.findViewById(R.id.tv_rank);
        TextView tv_title = convertView.findViewById(R.id.tv_title);
        TextView tv_singer = convertView.findViewById(R.id.tv_singer);
        tv_rank.setText(list.get(i).getRank());
         tv_title.setText(list.get(i).getTitle());
        tv_singer.setText(list.get(i).getSinger());
        return convertView; // return null이면 에러 발생
    }
}
