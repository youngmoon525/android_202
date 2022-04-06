package com.example.sp_connspring2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestDTO dto = new TestDTO("admin" , "0000");
                Gson gson = new Gson();
                String data = gson.toJson(dto);
                Log.d("jsonData", "onClick: " + data);
                AskTask task = new AskTask("Test2" , data);
                // execute() , execute().get();
                //execute <= 비동기로 작업을 하기때문에 새로운 쓰레드로 동작을함.
                //( 메인액티비티는 액티비티 자체 작업을 따로하고 AsnckTask도 작업따로)
                // excute().get() <= 어싱크 테스크를 실행하고나서 반드시 결과를 받고
                //그다음줄 소스를 진행한다.

                try {
                    InputStream in = task.execute().get(5000 , TimeUnit.MILLISECONDS); // 해당하는 어싱크가 반드시 결과를 return해줄때(스프링에서 응답줬을때)
                                           //다음 스택의 코드를 실행하겠다.
                                           //TimeOut을 주는이유는 서버가 특정한 상황에서 응답을 주지못할때
                                            //무한정 기다리는게 아니라 연결을 끊고나서 서버가 응답을 못주는
                                           //상태라는것을 알고나서 어떤 처리를 넣기 위함.
                    TestDTO revDTO = gson.fromJson(new InputStreamReader(in), TestDTO.class);
                    Log.d("adf", "onClick: " + revDTO.getId() + revDTO.getPw());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException | TimeoutException e) {
                    e.printStackTrace();
                }

                Log.d("adf", "onClick: 여기 실행됨");
            }
        });
    }
}