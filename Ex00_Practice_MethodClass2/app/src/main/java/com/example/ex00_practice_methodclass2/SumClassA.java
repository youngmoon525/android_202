package com.example.ex00_practice_methodclass2;

import android.util.Log;
import android.widget.EditText;

public class SumClassA {
    // 클래스 규칙 : 대문자로 시작 <=
    // 변수 규칙 : 소문자로 시작 의미있는 단어가 되게끔 만들기
    // 메소드 규칙 : 소문자로 시작 의미있는 단어들을 연결해서 대문자로 구분(카멜)
    // ex) 어떤 수를 합산한 결과값 : return x <= x => return result , hap , intSum...
    //twoIntSum();
    void sum(int num1 , int num2){
        //메소드 만들었음.  default접근제한자 : 같은 패키지 내부에서만 사용이 가능
    }
    void sum2(int num1 , int num2){
        for(int i = num1 ; i<num2; i++){
            Log.d("SumClass", "" + i);
        }
    }

    int sum3(int num1 , int num2){
        int result = 0 ;
        for(int i = num1 ; i<num2; i++){
            result += i;
            Log.d("SumClass", "" + i);
        }
        return result;
    }
    String test(){
        return "아무값";
    }
}
