package com.example.project01_allview.pack05recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_allview.R;

import java.util.ArrayList;

//2. RecyclerView.Adatper 상속
public class RecAdapter extends RecyclerView.Adapter<RecAdapter.HolderKYM>{
    LayoutInflater inflater;//<=화면을 붙이기 위한 객체가 필요함. ※
    ArrayList<String> list;

    public RecAdapter(LayoutInflater inflater, ArrayList<String> list) {
        this.inflater = inflater;
        this.list = list;
    }

    public RecAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    //3.ViewHolder를 만드는 행위를함.
    //맨처음에 아직 화면이 세팅이 안되어있을때.
    @NonNull
    @Override
    public HolderKYM onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_recview , parent, false);
        //HolderKYM holderKYM = new HolderKYM(itemView);
        //return holderKYM;
        return new HolderKYM(itemView);
    }

    //데이터를 실제로 처리해주는 부분
    @Override
    public void onBindViewHolder(@NonNull HolderKYM holder, int position) {
        holder.rec_tv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    //1.뷰 홀더 클래스 생성 , RecyclerView.Adapter<VH<======클래스를 의미함>
    // instence Of <= 같은 객체 형태로 만듬 RecyclerView.ViewHolder
    public class HolderKYM extends RecyclerView.ViewHolder{
        //field에는 아이템뷰에서 사용할 모든 위젯들이 옴.
        //ViewHolder == 디자인위젯용DTO
        TextView rec_tv;
        public HolderKYM(@NonNull View itemView) {
            super(itemView);
            rec_tv = itemView.findViewById(R.id.rec_tv);
        }
    }

}
