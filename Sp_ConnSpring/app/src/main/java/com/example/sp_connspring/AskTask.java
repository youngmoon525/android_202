package com.example.sp_connspring;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class AskTask extends AsyncTask<String , String , Integer> {

    //1.파라메터..( doInBackground = 어떤 비동기 작업을 실제로 처리하는 부분 )
    // 여기에 필요한 변수를 뜻한다.
    //<= 실사용에는 불편한점이 있어서 생성자를 이용해서 파라메터를 입력받을수가있음.
    //doInBackground(*String... strings*)

    //2.프로그레스 ( 작업이 어느정도 진행되었는지를 다른 태스크(액티비티)에서 확인할수있는
    //변수를 뜻하는데 정확도가 낮아서 신빙성이 없는데이터이기 때문에 사용 x)
    // Android => Spring에서의 작업 진행률을 확인할수가없음 => 정확 x

    //3.Result ※
    //작업을 완료하고나서 어떤 데이터를 리턴받기위한 타입.
    // protected *Integer*
    final String HTTPIP = "http://192.168.0.38" ;//cmd -> ipconfig로 ip를 확인하고 넣어주기.
                                                 //  80외에 포트는 :포트번호 넣어주기.
    final String SVRPATH = "/mid/";             //<-server.xml에 기재된 path

    HttpClient httpClient ; //접속을 위한 객체
    HttpPost httpPost ;     //접속방식을 POST
    MultipartEntityBuilder builder ; //파라메터,파일 등등 (여러부분으로 나누어진)보내기위한 객체
    private String postUrl ; //HTTPIP+SVRPATH+Mapping 접속할 매핑주소(스프링)
    private String mapping ; //mapping부분은 매번 달라질수있기때문에 객체생성시
                             //입력받아서 처리할수있게끔 필드로 만든다.


    public AskTask(String mapping) {
        this.mapping = mapping;
    }

    @Override
    protected Integer doInBackground(String... strings) {
        postUrl = HTTPIP + SVRPATH + mapping ; //http://192.168.0.38/mid/???
        builder = MultipartEntityBuilder.create();//new MultiPart...();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);//웹형태로 요청(Legacy)
        //===============파라메터를 추가할 부분 ===================

        builder.addTextBody("param" , "StringsParam",
                ContentType.create("Multipart/related" , "UTF-8"));

        //========================================================= json <= Gson<=


        httpClient = AndroidHttpClient.newInstance("Android");//new ..();
        httpPost = new HttpPost(postUrl);//url을 이용해서 post연결 객체 초기화
        httpPost.setEntity(builder.build());//http요청 모드를 builder이용해서 입력

        try {
            //stream 흐름 프로그램 내부에서 밖으로 내보낼것인지 , 외부에서 내부로 들여올것인지.
            //system.out.println <= out <= outputstream
            //scanner . System.in <= in <= inputstream
            InputStream in = httpClient.execute(httpPost).getEntity().getContent();//실제 =>Spring으로 통신시작
            rtnString(in);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    //Gson을 사용하는게 편하다는것을 알기위한 테스트 단계.
    //InputStream자체를 이용하게되면 Stream을 편하게 읽기위한 리더객체 필요함.
    //StringBuilder <= 소스가 복잡해짐
    public String rtnString(InputStream in)  {
        BufferedReader reader = null;//in=>isr=>br
        try {
            reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String line = null;
        try{
            while ( (line = reader.readLine()) != null){
                Log.d("TAG", "rtnString: " + line);
                //responsBody<= 응답을 받기때문에
            }
        }catch (IOException e){
           // e.printStackTrace();
        }
        return null;
    }



    //AskTask 는 extends를 해줘야만 인식을 한다. (해당하는 Class로)
    //AskTask 는 클래스타입<> 에 3개의 클래스타입을 넘겨 줘야하는 형태.
}
