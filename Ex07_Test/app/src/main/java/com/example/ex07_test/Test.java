package com.example.ex07_test;

import android.view.View;
import android.widget.ImageView;

public class Test {

    public static void changeVis(ImageView imagv1, ImageView imagv2) {
        if(imagv1.getVisibility() == View.VISIBLE){
            imagv1.setVisibility(View.GONE);
            imagv2.setVisibility(View.VISIBLE);
        }else if(imagv2.getVisibility() == View.VISIBLE){
            imagv2.setVisibility(View.GONE);
            imagv1.setVisibility(View.VISIBLE);
        }
    }
}
