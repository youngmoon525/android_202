package com.example.project01_allview.ex01listview;

public class ListDTO {
    private int resId ;
    private String chat_name , chat_msg , chat_date;
    // alt + insert


    public ListDTO(int resId, String chat_name, String chat_msg, String chat_date) {
        this.resId = resId;
        this.chat_name = chat_name;
        this.chat_msg = chat_msg;
        this.chat_date = chat_date;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getChat_name() {
        return chat_name;
    }

    public void setChat_name(String chat_name) {
        this.chat_name = chat_name;
    }

    public String getChat_msg() {
        return chat_msg;
    }

    public void setChat_msg(String chat_msg) {
        this.chat_msg = chat_msg;
    }

    public String getChat_date() {
        return chat_date;
    }

    public void setChat_date(String chat_date) {
        this.chat_date = chat_date;
    }
}
