package com.example.test_connspring;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.IOException;
import java.io.InputStream;

public class AskTask extends AsyncTask<String , String , InputStream> {

    final String HTTPIP = "http://192.168.0.38" ;//cmd -> ipconfig로 ip를 확인하고 넣어주기.
                                                 //  80외에 포트는 :포트번호 넣어주기.
    final String SVRPATH = "/mid/";             //<-server.xml에 기재된 path

    HttpClient httpClient ; //접속을 위한 객체
    HttpPost httpPost ;     //접속방식을 POST
    MultipartEntityBuilder builder ; //파라메터,파일 등등 (여러부분으로 나누어진)보내기위한 객체
    private String postUrl ; //HTTPIP+SVRPATH+Mapping 접속할 매핑주소(스프링)
    private String mapping ; //mapping부분은 매번 달라질수있기때문에 객체생성시
                             //입력받아서 처리할수있게끔 필드로 만든다.

    private String data;
    public AskTask(String mapping, String data) {
        this.mapping = mapping;
        this.data = data;
    }

    public AskTask(String mapping) {
        this.mapping = mapping;
    }

    @Override
    protected InputStream doInBackground(String... strings) {
        postUrl = HTTPIP + SVRPATH + mapping ; //http://192.168.0.38/mid/???
        builder = MultipartEntityBuilder.create();//new MultiPart...();API28미만은 안됨.
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);//웹형태로 요청(Legacy)
        //===============파라메터를 추가할 부분 ===================
        builder.addTextBody("testdata" , data,
                ContentType.create("Multipart/related" , "UTF-8"));
        //========================================================= json <= Gson<=
        httpClient = AndroidHttpClient.newInstance("Android");//new ..();
        httpPost = new HttpPost(postUrl);//url을 이용해서 post연결 객체 초기화
        httpPost.setEntity(builder.build());//http요청 모드를 builder이용해서 입력
        InputStream in = null;
        try {
            in = httpClient.execute(httpPost).getEntity().getContent();//실제 =>Spring으로 통신시작
        } catch (IOException e) {
            e.printStackTrace();
        }
        return in;
    }



}
