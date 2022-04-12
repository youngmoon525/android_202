package com.example.last_project.member;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.last_project.MainActivity;
import com.example.last_project.common.AskTask;
import com.example.last_project.common.CommonMethod;
import com.example.last_project.common.CommonVal;
import com.google.gson.Gson;

import java.io.InputStreamReader;

public class MemberDAO {
    private static final String TAG = "로그인";


    //일반 클래스 (Fragment , Acitivty를 제외하고 "Context" 화면 위에 어떤 객체를 띄우거나
    //다른 화면으로 이동을 시키는 등의 처리) 는 Context 사용불가.

    //일반 클래스에서 어떻게하면 Context에 있는 기능을 사용할수가있을까?
    //해당하는 일반 클래스를 생성할때 상위에있는(Context) 객체로부터 받아온다.

//    Context context;
//    public MemberDAO(Context context) {
//        this.context = context;
//    }
    LoginActivity activity; // <= 장점 LoginAcitivity에 있는 모든 위젯을 사용할수있다(!private)
                            // <= 단점 모든 위젯을 사용할수있지만 LoginActivity를 제외한 다른 액티비티나 프래그먼트
                            //에서는 사용할수가없다.
    public MemberDAO(LoginActivity activity) {
        this.activity = activity;
    }

    public boolean isMemberLogin(){
        Log.d(TAG, "onClick: ");
        AskTask task = new AskTask("login");
        task.addParam("id" ,  activity.edt_id.getText().toString());
        task.addParam("pw" ,  activity.edt_pw.getText().toString());
        //어떤 요청을 Spring에다가 하면 ( Request )
        //어떤 요청에 대한 응답을 하면  ( Response)
        //파라메터 추가해서 보내보기 ( 스프링 콘솔창에 출력 )
        InputStreamReader isr =  CommonMethod.executeAskGet(task);//
        Gson gson = new Gson();
        //Vo형태의 클래스 타입Object=> String으로 바꿀수없어서 에러
        //Log.d(TAG, "onClick: " + gson.fromJson(isr , String.class));//<=확인 후 DTO작업
        MemberVO vo = gson.fromJson(isr , MemberVO.class);
        if(vo != null){
            CommonVal.loginInfo = vo ; //==기존 그냥 화면 전환 => t , f
            return true;
        }else{
            //Log.d(TAG, "onClick: " + vo.getId());
            Toast.makeText(activity, "아이디 또는 비밀번호가 틀립니다.", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}
