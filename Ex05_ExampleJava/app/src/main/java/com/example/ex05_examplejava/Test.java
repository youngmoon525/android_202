package com.example.ex05_examplejava;

import android.util.Log;
import android.widget.EditText;

public class Test {
    //멤버 ( 클래스 내부에 있는 변수 , 메소드 , 클래스 등등 전부 )
    //멤버 1.i<- 2.s<-
    //static 이냐 static이 아니냐만 구분하면 됨.
    void method1(){
        Log.d("로그" , "method1: 호출됨.");//상품 추가 기능.
    }
    private void method2(){
        Log.d("로그" , "method2: 호출됨.");
    }
    static void method3(){
        Log.d("로그" , "method3: 호출됨.");
    }
    //static 있나 없나 확인 ( 없음 == new 통해서 객체를 인스턴스화함 )
    // 있음 클래스.메소드 이름

     int rtnInt(String inputData){ //  = "값"
        try{
            return Integer.parseInt(inputData);
        }catch (Exception e){
            return 0 ;
        }
        //void가 아니면 무조건 return 해줘야함 ( 해당하는 데이터 타입 )
    }
    static int parseEdt(EditText editText){
        try{
            return Integer.parseInt( editText.getText() + "" );
        }catch (Exception e){
            return 0;
        }
    }


}
