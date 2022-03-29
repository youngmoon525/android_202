package com.example.project02_cloneapp.friend;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_cloneapp.R;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder>{
//2.리사이클러뷰 어댑터 상속 ( 1에서 만든 ViewHolder 클래스 넘겨줌 )

    LayoutInflater inflater; //레이아웃 붙이려면 꼭 필요함 ( Adapter , Fragment ..)
    ArrayList<FriendDTO> list;//해당하는 클래스(Adapter)내부에서 어디서든 사용가능하게 필드로 만듬
    Context context; // <= null인 상태에서 어댑터가 생성이 되면 무조건 꺼짐(NullPointerException )

    public FriendAdapter(LayoutInflater inflater, ArrayList<FriendDTO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

//    public FriendAdapter(LayoutInflater inflater, ArrayList<FriendDTO> list) {
//        this.inflater = inflater;
//        this.list = list;
//    }
//
//    public FriendAdapter(LayoutInflater inflater) {
//        this.inflater = inflater;
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_friend,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        //onCreateViewHolder 에서 생성해놓은 ViewHolder를 그대로 다시 파라메터로 넘겨줌.+position0~
        holder.imgv_profile.setImageResource(list.get(i).getImgid());
        holder.tv_name.setText(list.get(i).getName());
        holder.tv_msg.setText(list.get(i).getMsg());

        holder.imgv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ※ Context <= 현재 화면이 띄워져있는 객체로
                // 레이아웃 붙이기 == LayoutInflater
                // 프래그먼트 붙이기 == getSupportFragmentManager
                // startActivity
                // 기타등등의 기능을 가지고있는 객체 ※
                // 일반 클래스에서는 화면을 붙이고 또는 새로운 액티비티를 띄우는 등의 기능을
                // 사용할수가없으니 해당하는 기능을 사용할수있는 Activity또는 Context를 받아온다. ※
                Intent intent = new Intent( context , DetailActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override //디자인 확인시 return  내가 숫자 ==> 리스트가 생기면(DB) list.size변경
    public int getItemCount() {
        return list.size();
    }

    //1.ViewHolder라는 중첩(내부)클래스 만들기.
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgv_profile ; // null<=
        TextView tv_name , tv_msg; // null <=

        public ViewHolder(@NonNull View itemView) {
            super(itemView);//생성자에서 find를 통해서 위젯들이 null이 아닌 상태로 만듬
            imgv_profile = itemView.findViewById(R.id.imgv_profile);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_msg = itemView.findViewById(R.id.tv_msg);
        }
    }
}
