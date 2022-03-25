package com.example.project01_allview.ex00innerclass;

public class NastedMain {

    public void main(){
        //NastedC의 멤버에 접근하기 (＊) 추후에 ViewHolder라는 위젯을 묶어놓은 중첩클래스를 만듬
        //중첩클래스( 클래스의 멤버가 클래스인것)
        NastedC c = new NastedC(); // 메모리에 올라감
        c.field = 10;
        c.method();
        c = new NastedC(10);
        NastedC.field2 = "A";
        NastedC.method2();
        //==============================여기까지는 이미 해본 내용================//
        NastedC.A a = c.new A();
        a.field = "aa";
        a.method1();

    }
}
