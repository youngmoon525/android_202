package com.example.project02_cloneapp.chat;

public class ChatDTO {
    // DTO<= 화면에 데이터를 보여줄때 바뀌어야 하는 부분
    // + ( DataBase 와 매칭 시킨 후 + 필요한 변수를 만듬 )
    // employees <= columns갯수만큼 필드 변수가 필요함.
    // + avg(salary) <= 필드 + 1
    // + join departments 부서명 가지고옴 <= 필드 + 1

    private String img_url , name , msg , date;

    public ChatDTO(String img_url, String name, String msg, String date) {
        this.img_url = img_url;
        this.name = name;
        this.msg = msg;
        this.date = date;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
