package com.example.ex00_practice_methodclass2;

import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Test {
    int[] intArr ;
    static ArrayList<Integer> intList;
    //return타입이 필요한경우 (= 메소드를 실행하고나서 어떠한 결과를 받아야하는경우
    //무조건 리턴타입이 필요함 )
    //로그를 찍어봄 ( 리턴 필요없음 )
    Button method(){ // 리턴타입 있음 = 메소드에는 반드시 return <=
                     // 리턴타입 없음 = 메소드는 반환(return)없음

        return null;
    }
    static EditText method2(){
        return null;
    }

}
