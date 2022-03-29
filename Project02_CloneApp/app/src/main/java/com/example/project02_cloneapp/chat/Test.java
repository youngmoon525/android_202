package com.example.project02_cloneapp.chat;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Test extends RecyclerView.Adapter<Test.ViewHolderKYM>{


    @NonNull
    @Override
    public ViewHolderKYM onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderKYM holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderKYM extends RecyclerView.ViewHolder{ //<= <VH>

        public ViewHolderKYM(@NonNull View itemView) {
            super(itemView);
        }
    }
}
