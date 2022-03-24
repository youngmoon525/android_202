package com.example.ex11_backgroundservice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    //0.※컴포넌트들은 반드시 AndroidManifest.xml에 등록이 되어야한다.

    //1.초기에 프로젝트를 만들게 되면 기본적으로 MainActivity 자바를 제공해줌.
    //맨먼저 이 액티비티가 화면에 나오는 이유는 Manifest의 설정 때문임.
    //AndroidManifest.xml
    //SplashActivity <= 로고를 사용자에게 각인시켜서 브랜드의 이미지를 기억하게 하거나
    //또는 로고를 보여주는 시간동안 디비에 있는 데이터를 불러옴으로써 사용자에게 편리함을 주는 화면.
    Button btn_alert;
    ProgressBar pg_bar;
    String a = "KYM"; //<=String a에 담겨있는값은 FileDown에서 사용해보기

    //boolean isDown = false; 문제를 해결하는 방법중 전역변수를 이용하는 방법.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_alert = findViewById(R.id.btn_alert);
        pg_bar = findViewById(R.id.pg_bar);
        pg_bar.setProgress(50);
        // <= 다이어로그에서 예 버튼을 클릭했을때 반복문을 이용해서 1부터 100까지 progress가 바뀌게 처리.
        //바뀌는 과정이 눈으로 보여야함.
        // ※ 모든 프로그램은 기본적으로 static Thread가 무조건있음 (process)
        btn_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //AlertDialog <= AlertDialog.Builder 만들수있는 설정들을 미리 지정을 해놓고 세팅함.
                //MainActivity.Builder builder2 = new MainActivity.Builder(MainActivity.this);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("다운로드 안내");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setMessage("Service를 이용해서 다운로드 하시겠습니까?");

                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //서비스를 실행하는 방법 Intent (컴포넌트임)
                        Intent intent = new Intent(MainActivity.this,FileDownloadService.class);
                        startService(intent);


                        //if(pg_bar.getProgress() == 0 && pg_bar.getProgress() == 100){
                        //
                        //}
                        //btn_alert.setEnabled(false);
                        //예를 눌렀을때처리 => 현재는 파일다운로드 시작
                        //Thread.sleep <= 메인 (현재 돌아가고있는 안드로이드 os에 휴지 시간 )
                        //예 버튼을 클릭하면 Thread는 new를 통해 인스턴스화를 계속하고 메모리에 각각올라가서
                        //작업을 비동기로 여러개가 실행이 됨.
                        //progress가 진행중인 상태이면 다시 버튼을 눌러도 Thread를 new로 생성못하게 막기
                        //=======================================================여가
//
                        //====================여기까지 작업중일때는 다시 실행안되게 막기
//                        try {
//                            Thread.sleep(100); // 현재 프로세스에 휴지시간을 줌. 1000 = 1초 , 0.1초
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    }
                });

                builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });



                AlertDialog dialog = builder.create();//<= create()라는 메소드는 AlertDialog를 return
                dialog.show();
                //int aaa = return int
            }
        });

    }

//    static class Builder{
//        Context context;
//
//        public Builder(Context context) {
//            this.context = context;
//        }
//    }
}