package com.example.sp_connspring2;

public class TestDTO {
    private String id , pw ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public TestDTO(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
}
