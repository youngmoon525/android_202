package com.example.project01_allview.ex04selfgridvew;

import android.widget.ImageView;

public class SelfGridDTO {
    String url , text;

    public SelfGridDTO(String url, String text) {
        this.url = url;
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
