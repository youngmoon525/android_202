package com.example.ex11_backgroundservice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //ProgreeDialog <= 화면 위에 띄워져서 어떤 처리를 하는동안 사용자에게
        //어떤 처리가 이루어지고있음을 알려주는 위젯
        //DB에 접속해서 어떤처리를 오랫동안함. 언제까지할지는 모름
        //그동안 앱은 정지상태에 있음 조작 x
        //사용자 입장에서는 앱이 멈춘건지 작업중인지를 인지를 못함
        //작업중이라는것을 알려주기 위한것.
        ProgressDialog dialog = new ProgressDialog(SplashActivity.this);
        dialog.setTitle("지금 프로젝트를 로딩 중입니다. 소요시간 3초");
        dialog.show(); // <= 실제 보여줌. 인스턴스
        //ProgressDialog.show(SplashActivity.this,"타이틀","메세지"); 스태틱
        //↓ 필요하다면 한쪽에 정리해두고 나중에 복붙해서 쓸것
        //외우지말것 , 단 ※ 인터페이스를 파라메터로 입력받는 메소드 호출
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this , MainActivity.class);
                startActivity(intent);//<= 새로운 액티비티로 연결(MainActivity 시작함)
                finish();//현재 화면을 완전히 종료 시킴.
            }
        }  , 3000);


//        userPostDelaed(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        } , 3000);
        //1000 == 1초 , 3초를 지연시키고 코드를 실행함.
        //delay를 줌 몇초동안 보여줄지. 추후추가
    }

 //   void userPostDelaed(Runnable runnable , int delayMillis){

 //   }






}