package com.example.last_project.member;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.last_project.R;
import com.example.last_project.common.AskTask;
import com.example.last_project.common.CommonMethod;
import com.google.gson.Gson;

import java.io.InputStreamReader;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "로그인";
    EditText edt_id , edt_pw;
    Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//R.layout.activity_login
        setContentView(R.layout.activity_login);

        edt_id = findViewById(R.id.edt_id );
        edt_pw = findViewById(R.id.edt_pw );
        btn_login = findViewById(R.id.btn_login );

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 아이디가 aaa 이고 비밀번호가 0000 일때 Spring에 아이디 비밀번호 보내고.
                // 로그인 처리 되게 하기.(Spring으로부터 어떤 값을 받아서 처리하기)DB연동 x
                // 어싱크사용시 paramList이용하기.<-
                // 그외값이 들어오면 아이디 비밀번호를 확인하세요. Toast.

                // 입력이 되었는지 안되었는지를 먼저 체크
                // break point <= 내가 오류가 날것같은 지점 전 스택에 찍으면 유리함.
                // 내가 만들지 않은 .java파일로 디버깅이 진행중일때는 반드시 F9로 빠져나오기.
                if( edt_id.getText().toString().trim().length() < 1 ||
                        edt_pw.getText().toString().trim().length() < 1){
                    Toast.makeText(LoginActivity.this, "아이디 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    Log.d(TAG, "onClick: ");
                    AskTask task = new AskTask("login");
                    task.addParam("id" ,  edt_id.getText().toString());
                    task.addParam("pw" ,  edt_pw.getText().toString());
                    //어떤 요청을 Spring에다가 하면 ( Request )
                    //어떤 요청에 대한 응답을 하면  ( Response)
                    //파라메터 추가해서 보내보기 ( 스프링 콘솔창에 출력 )
                    InputStreamReader isr =  CommonMethod.executeAskGet(task);//
                    Gson gson = new Gson();
                    Log.d(TAG, "onClick: " + gson.fromJson(isr , String.class));//<=확인 후 DTO작업
                }
            }
        });

    }
}