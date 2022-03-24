package com.example.ex13_listview.listvcus;

public class CustomDTO {
    String name ; //친구의 이름
    String msg ; //상태 메세지
    int resId ; //R.id <= int로되어있는거 찾아서 쓸꺼임.

    public CustomDTO(String name, String msg, int resId) {
        this.name = name;
        this.msg = msg;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
