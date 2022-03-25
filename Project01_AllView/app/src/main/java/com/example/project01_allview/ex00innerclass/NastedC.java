package com.example.project01_allview.ex00innerclass;

public class NastedC {
    // 멤버 : 인스턴스 멤버 (instence) , 스태틱 멤버 (static)
    //인스턴스 멤버 : 해당하는 클래스의 내부에 있으며 반드시 인스턴스화 과정(new 클래스이름)
    //거쳐야만 접근을 할수있는 멤버 , 인스턴스화 된 변수에 .(점)를 찍으면 나오는 멤버

    //스태틱 멤버 : 해당하는 클래스의 내부에 있으며 해당하는 클래스가 인스턴스화 과정을
    //거치지 않아도 해당하는 클래스에 .(점)을 찍으면 나오는 멤버(메모리에 이미 있음)

    //{ <= 메모리에 올림 } <= 메모리에서 내림
    //자바는 기본적으로 생성자를 만들지 않으면 빈생성자 클래스이름(){} <- 제공해줌.
    //하지만 사용자가 생성자 메소드를 별도로 만드는 순간 제공 x
    int field; // NastedC라는 클래스의 필드(멤버) static 여부에 따라서 멤버를 구분할수가있다.
    void method(){}
    //생성자 '메소드 오버로딩' = 메소드의 이름이 '같고' 입력받는 파라메터의 타입 또는 갯수가 다를때
    //중첩해서 같은이름으로 만든 후 , 내가 필요한 메소드를 선택해서 사용하게 만드는 것
    public NastedC() {
    }
    public NastedC(int field) {
        this.field = field;
    }

    static String field2;
    static void method2(){ }

    //=========================================================//

    public class A{ // 인스턴스 멤버 , NastedC의 인스턴스 클래스
        String field; // <= 최상위 NastedC => A클래스 => A라는 클래스의 인스턴스 멤버임
        //static String field2; 프로그램 시작하자마 메모리에 있어야함.
        //NastedC라는 클래스가 메모리에 올라가야함(new)
        //NastedC통해서 A라는 클래스를 또 메모리에 올려야함(new)
        void method1(){

        }
    }

    public static class B{
        String bField;
        static String bFieldStatic;
        void method1(){

        }
        static void method2(){

        }
        //1.NastedMain에서 멤버클래스인 B를 생성하기
        //2.B의 모든 멤버에 접근하기
        //3.멤버클래스 A에서는 static 키워드를 사용할수가없었음
        //멤버클래스 B에서는 왜 사용이 가능할까?
    }









}
