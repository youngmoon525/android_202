package com.example.last_project.common;

import com.example.last_project.member.MemberVO;

public class CommonVal {
    /*
    * Date : 2022 / 04 / 11
    * Create : KYM
    * Content : 공통으로 사용할 변수를 만듬.
    * */
    public static String HTTP_IP = "http://192.168.0.38";
    public static String SVRPATH = "/mid/";
    public static MemberVO loginInfo = null; // 해당하는 static멤버가 null이라면 로그인이 안된상태.
    //Spring의 세션과 똑같음 ( == 안드 프로그램 종료시 static메모리에 날아감 )
    //Spring (톰캣 리스타트 시 session 날아감 )

    //Collection 구조를 가져서 메모리 공간을 많이 차지하는 데이터가 아닌경우엔 공통으로
    //사용할 변수들을 static으로 놓고 , 같이 사용하는것이 효율적임.
    //룰을 정해서 이름 규칙이나 여러가지 형태들을 회의한 후에 결정해서 사용.
}
