package com.example.last_project.employees;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;

import java.util.ArrayList;

public class EmpAdapter extends RecyclerView.Adapter<EmpAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<EmpDTO> list;
    //필요한 내용들을 전부다 받아온다. ( Fragment , Activity )
    public EmpAdapter(LayoutInflater inflater, ArrayList<EmpDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override // 화면 붙이는 부분 LayoutInflater 일반 클래스에서는 사용할수없음.(받아오면됨)
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recv_emp , parent , false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder,position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    //===========================================================//

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_empid , tv_name , tv_dept_name ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_empid = itemView.findViewById(R.id.tv_empid);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_dept_name = itemView.findViewById(R.id.tv_dept_name);
        }
        //googld doc <= 권장하는 방법.
        public void bind(@NonNull ViewHolder holder, int i){
            holder.tv_empid.setText(list.get(i).getEmployee_id());
            holder.tv_name.setText(list.get(i).getName());
            holder.tv_dept_name.setText(list.get(i).getDepartment_name());
        }
    }
}
