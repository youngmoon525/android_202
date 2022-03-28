package com.example.project02_cloneapp.friend;

public class FriendDTO {
    private int imgid;
    private String name , msg;

    public FriendDTO(int imgid, String name, String msg) {
        this.imgid = imgid;
        this.name = name;
        this.msg = msg;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
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
}
