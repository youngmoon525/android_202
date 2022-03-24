package com.example.ex13_listview.listvcus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.ex13_listview.R;

import java.util.ArrayList;

//Adapter 의 기능을 상속 받아야만 Adapter이다.
//BaseAdapter 가장 기본적인 커스터마이징 어댑터의 종류 중 하나.
//1.Adapter 타입의 클래스를 상속 받기.
public class CustomAdapter extends BaseAdapter {
    //2.리스트 목록에 몇칸의 데이터가 있는지를 지정.
    //-초기에는 숫자를 대충 넣고 테스트 => ArrayList<E>.size();

    //5-1.필요한 데이터를 필드부에 놓고 생성자 메소드를 만들기.
    LayoutInflater inflater;
    ArrayList<CustomDTO> list;
    //LayoutInflater가 필요함 근데 만들어서 가지고옴 . 있어야만 생성가능.
    //annotation <= @override , @NonNull
    //주석 - 일반적인 우리가 만드는 주석 //<= 컴퓨터가 안읽음.의미가 없음 사람만 보는것
    //어노테이션 - @의미있는 기능을 뜻함 (주석)<=컴퓨터가 읽어서 어떤 기능을 나타내고있는지를 읽음.


    public CustomAdapter(@NonNull LayoutInflater inflater, ArrayList<CustomDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    public CustomAdapter(@NonNull LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    //3.-- 몇번째 칸의 데이터(DTO)를 리턴 .
    @Override
    public Object getItem(int position) {
        return list.get(position); // CustomDTO return (Object)
    }

    //4. position
    @Override
    public long getItemId(int position) {
        return position;
    }
    //5. ※ 실제 어떤 아이템이 보여질지 정해지는 부분! 중요함. ※
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //일반 클래스에는 Inflater자체를 만들 방법도없음.
        //Context<= 화면단에 어떤 처리를 위한 기능들이 들어있는 클래스(Activity)
        //Fragment<= OnCreateView라는 메소드는 ↑ LayoutInflater 기능을 가지고옴.
        convertView = inflater.inflate(R.layout.custom_item , parent , false);
        TextView tv_name =  convertView.findViewById(R.id.tv_name);
        TextView tv_msg =  convertView.findViewById(R.id.tv_msg);
        ImageView imgv_profile =  convertView.findViewById(R.id.imgv_profile);
        tv_name.setText(list.get(position).getName());
        tv_msg.setText(list.get(position).getMsg());
        imgv_profile.setImageResource(list.get(position).getResId());
        return convertView;
    }
}
