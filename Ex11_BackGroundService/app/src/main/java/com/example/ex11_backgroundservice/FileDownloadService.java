package com.example.ex11_backgroundservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class FileDownloadService extends Service {
    //Service <= Thread를 새로 만들어서 비동기 작업이 필요한 상태 (만들어서 사용)
    //반복적으로 파일을 다운로해야하는 상황 ↑
    private static final String TAG = "filedown";
    //final 키워드가 붙으면 초기화 할때 준 값 외에는 변경 불가
    // 서버 IP , TAG(필터 사용) , WAS(IP) , DBPATH...
    //MainActivity <= new 새로운 클래스를 만듬.
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Service Oncreate");
    }

    public FileDownloadService() {
    }
    //※ 서비스로 비동기 x => AsynkTask => Spring(Was) => DB => Spring(WAS) = > Android(Asynck)
    //서비스에서 실제 작업이 일어나는 부분.
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: 실제 작업부 시작.");
        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    for(int i = 0 ; i <= 100 ; i ++){
                                        MainActivity.pg_bar.setProgress(i);//<=어떻게 하면 액티비티에있는
                                        //프로그레스바가 증가가 될까?
                                        Thread.sleep(100);
                                    }


                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                        thread.start();
        
        //재정의 된 메소드여도 반드시 부모클래스가 필요한 경우에는 수정 x
        //개발자가 임의로 커스터마이징을 하게 되면 서비스의 로직중 중간단계가 꼬이게 됨.
        return super.onStartCommand(intent, flags, startId); //reutrn => method => method => int return
    }

    // 화면 (1.사용자가 보이는 부분 Front , ForeGround 정면 에서 보이는 부분 디자이너 ↑) res
    //      (2.사용자가 보이지는 않지만 BackGround , back 실제로 데이터 처리가 되는 부분 개발자 영역) pack

    @Override  // <= 이용해서 화면이 바뀌거나 하는처리 오류 발생률이 높아서 많이 사용 x
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}