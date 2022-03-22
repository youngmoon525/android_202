package com.example.ex00_practice_methodclass2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    // 메소드 규칙
    // void , void아닌것
    // method(메소드 실행시 필요한 모든 변수 )
    //void method(int x){
    //
    //}
    //method(x에 담을수있는 값) , method(5);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Class SumClass
        //1. 숫자 두개를 입력받는 메소드를 만드세요. sum
        SumClassA sumClass = new SumClassA();
        sumClass.sum(1 , 2);

        //2. 숫자 두개를 입력받는 메소드
        // +기능 두수 사이의 합을 logd에 찍는 메소드. sum2
        sumClass.sum2(1 , 10);
        //3. 숫자 두개를 입력받아서 두수 사이의 합을 logd에 찍고
        //결과를 다시 MainActivity로 받을수있게끔 해주는 메소드. sum3
        int resultb = sumClass.sum3(1 , 10) + 30;
        String aaa = sumClass.test();
        if(aaa.length() > 0){

        }
        if(sumClass.test().length() > 0){}

        NewSumClass2 nsc = new NewSumClass2();
        nsc.sum3(5 , 5);

//        NewSumClass nsc = new NewSumClass();
//        nsc.sum(1 , 2);
//        nsc.sum2(1 , 2);
//        nsc.sum3(1 , 2);
//        nsc.sum4();






    }





//
//
//
//        Test.method2(); // 프로그램이 시작만해도 메모리에 있는 static 클래스에 .찍어도 나옴
//    Test.intList = new ArrayList<>();
//    //method1과 intArr는 아직 메모리에 없음.
//    Test test = new Test(); //<= 메모리에 생김.
//    test.intArr = new int[5];
//        test.method();


}