package com.example.test_connspring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class LoginActivity extends AppCompatActivity {
    EditText edt_id , edt_pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();
                WMemberDTO dto = new WMemberDTO();
                dto.setId(edt_id.getText().toString());
                dto.setPw(edt_pw.getText().toString());
                Log.d("데이터", " dto를 json으로 바꾸기" + gson.toJson(dto));
                AskTask task = new AskTask("test0408" , gson.toJson(dto));
                try {
                    InputStream in = task.execute().get(5000 , TimeUnit.MILLISECONDS);
                    dto = gson.fromJson(new InputStreamReader(in) , WMemberDTO.class);
                    if(dto != null){
                        CommonVal.dto = dto; // 어느 클래스(액티비티,Fragment)에서 접근을 하든
                                             //중간에 데이터를 비우지 않는 이상은 로그인정보가 유지됨
                        Intent intent = new Intent(LoginActivity.this , MainActivity.class);
                        startActivity(intent);
                        Log.d("TAG", "onClick: " + "널아님");
                    }else{
                        Log.d("TAG", "onClick: " + "널임 로그인 실패.");

                    }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}