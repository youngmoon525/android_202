package com.example.project02_cloneapp.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_cloneapp.R;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder>{
//2.리사이클러뷰 어댑터 상속 ( 1에서 만든 ViewHolder 클래스 넘겨줌 )

    LayoutInflater inflater; //레이아웃 붙이려면 꼭 필요함 ( Adapter , Fragment ..)

    public FriendAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_friend,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 40;
    }

    //1.ViewHolder라는 중첩(내부)클래스 만들기.
    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
