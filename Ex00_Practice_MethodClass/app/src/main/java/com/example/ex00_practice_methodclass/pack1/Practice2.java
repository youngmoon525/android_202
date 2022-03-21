package com.example.ex00_practice_methodclass.pack1;

import com.example.ex00_practice_methodclass.PracticeCls;

public class Practice2 {

    void method(){
        PracticeCls cls = new PracticeCls();
        cls.value3 ++ ; //
        //접근제한자를 생략한 나머지 메소드나
        //value4같은경우는 같은패키지까지만 접근을
        //허용해놓음.
    }

}
