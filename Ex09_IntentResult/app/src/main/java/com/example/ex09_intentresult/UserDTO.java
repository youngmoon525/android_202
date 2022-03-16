package com.example.ex09_intentresult;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private String id , pw , name ;
    private int age ;
    //외부에서 접근해서 바로 수정할수없게 필드를 만듬.
    //getter & setter메소드를 만듬. 생성자도 만듬.
    // alt + insert = constructor 소스 자동 완성
    //통신에서 객체(Object)를 전송할때는 Serializable
    //객체 안에 있는 변수들이 메모리에 여러부분에 흩어져있음
    //흩어져있는 메모리에 있는 변수들을 일자로 세움 ( 직렬화 )1001 , 1009 , 1010
    //1100 => 1101 1102 1103 ,

    public UserDTO(String id, String pw, String name, int age) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.age = age;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
