package com.example.ex00_practice_methodclass2;

public class NewSumClass  extends SumClassA{
    //기존에 SumClass<=객체가 잘 작동을 하는상태에서 추가적인 기능을 넣고 싶음.
    //또는 기능을 변경을 하고 싶음 (일부분)
    //자식이 부모를 선택하는것 ( 자식(더 많은 기능을 구현할거 + 부모) )
    void sum4(){

    }

    @Override //<= Override 재정의 ( 부모가 이미 해놓은 기능을 그대로 가지고와서 구현을 다시함.)
    int sum3(int num1, int num2) {
        //; super.sum3(num1, num2); //super<=부모클래스.메소드
        return num1 + num2;
    }
}
