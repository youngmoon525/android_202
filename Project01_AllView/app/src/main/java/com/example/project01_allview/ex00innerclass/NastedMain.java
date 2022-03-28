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
        //==============static 클래스(멤버) 사용하기 =========================//
        NastedC.B b = new NastedC.B(); //스태틱 멤버이기때문에 클래스에만 접근해도 접근가능.
        NastedC.B.bFieldStatic = "여기는 스태틱 클래스의 스태틱멤버";
        NastedC.B.method2();//여기는 스태틱 클래스의 스태틱멤버
        b.bField = "B클래스의 인스턴스 멤버";

    }
}
