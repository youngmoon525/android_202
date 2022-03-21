package com.example.ex00_practice_methodclass;

public class PracticeCls {
    //0.멤버 : 클래스 블럭킹 안에 있는 모든것

    //다른 클래스에 있는 메소드를 호출하거나
    //변수를 사용할때 지켜야할 규칙들.
    //1.Method , Variable ..등등 static 의 유무 .
    String value1 ;//iv     //MainActivity안에서 각각 두개의 변수에
                           //값 A와 B를 할당해보기.
    //1-1.인스턴스 멤버 인스턴스화 해야만 접근이 가능함.
    // Object obj = new Object();<=

    static String value2;//sv
    //1-2.스태틱 멤버 -메모리에 먼저 항상 올라가 있기때문에
    //클래스의 이름만 접근해도 바로 사용이 가능
    //(메모리 낭비가 심하기때문에 많이 사용 안함 )


    //2.IV <=> SV 관계
    // IV에서는 SV를 접근해서 맘대로 사용가능 .(메모리에 SV는 이미있음)
    // SV에서는 IV를 접근해서 사용 불가 . (IV는 new를 통해서만 메모리에 올라가기때문)
    void method1(){//<= 인스턴스 멤버
        value1 = "A";
        value2 = "B"; //둘다 가능함.//?????
    }
    static void method2(){
        //method2에서 value1에 A를 담으려면 어떻게 해야할까?
        //static멤버는 항상 메모리에 먼저 올라가야하는데
        //인스턴스 멤버를 안에서 사용하게 되면 new를 통해서 인스턴스화 과정을
        //거쳐야만 메모리에 올라갈수있다. 따라서 sv=>iv접근은 일반적으로는 불가능.
        value2 = "B";
        PracticeCls cls = new PracticeCls();
        cls.value1 = "A";
    }

    //3.접근 제한자 <= public , default , private
    //public(공개됨) , default(같은 패키지 내부에서만) , private(클래스내부,멤버끼리만)
    public int value3 = 3;
           int value4 = 4;
    private int value5 = 5;
    //접근을 제한을 둠으로써 변수의 정합성을 높인다
    //(아무 클래스에서나 일반적으로 변수나 메소드에 접근을 막기 위해서)

    int getValue5(){
        return this.value5;
    }


}
