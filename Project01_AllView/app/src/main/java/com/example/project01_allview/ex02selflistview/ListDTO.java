package com.example.project01_allview.ex02selflistview;

public class ListDTO {
    private int resId ;
    private String rank , title , singer ;

    public ListDTO(int resId, String rank, String title, String singer) {
        this.resId = resId;
        this.rank = rank;
        this.title = title;
        this.singer = singer;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
