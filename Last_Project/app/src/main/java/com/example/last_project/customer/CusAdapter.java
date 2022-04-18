package com.example.last_project.customer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;

import java.util.ArrayList;

public class CusAdapter extends RecyclerView.Adapter<CusAdapter.ViewHolder>{

    LayoutInflater inflater;
    ArrayList<CusDTO> list ;
    Context context;

    public ArrayList<CusDTO> getList() {
        return list;
    }

    public void setList(ArrayList<CusDTO> list) {
        this.list = list;
    }

    public CusAdapter(LayoutInflater inflater, ArrayList<CusDTO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    public CusAdapter(LayoutInflater inflater, ArrayList<CusDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    public CusAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @NonNull
    @Override // ViewHolder를 만들어 내는 구간
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View v = inflater.inflate(R.layout.item_recv_cus , parent , false);
        //ViewHolder vh = new ViewHolder(v);
        //return vh;
        return new ViewHolder( inflater.inflate(R.layout.item_recv_cus , parent , false));
    }

    @Override // ViewHolder가 만들어지고나서 데이터를 바인딩(연결)시키는 구간
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tv_no.setText(list.get(position).getId()+"");
        holder.tv_name.setText(list.get(position).getName()+"");
        holder.tv_tel.setText(list.get(position).getPhone()+"");
        holder.card_cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 새로운 액티비티로 이동하기. ( ? )
                // Activity => Activity
                // Fragment => Activity ?
                Intent intent = new Intent( context , CusDetailActivity.class );
                intent.putExtra("dto" , list.get(position));
                context.startActivity(intent);
                //Intent intent = new Intent(v.getContext() ,CusDetailActivity.class );
                //v.getContext().startActivity(intent);
            }
        });
    }

    @Override //ViewHolder를 몇개 만들어 낼지를 정하는 구간 => list.size()
    public int getItemCount() {
        return list.size();
    }

    //DTO <= 바뀌어야 할 데이터를 가지고있는 객체
    //ViewHolder <= 바뀌어야 할 위젯을 가지고있는 객체
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_no , tv_name , tv_tel ;
        ImageView imgv ;
        CardView card_cus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_no = itemView.findViewById(R.id.tv_no);
            this.tv_name = itemView.findViewById(R.id.tv_name);
            this.tv_tel = itemView.findViewById(R.id.tv_tel);
            this.imgv = itemView.findViewById(R.id.imgv);
            this.card_cus = itemView.findViewById(R.id.card_cus);
        }
    }// viewholder - end

}
