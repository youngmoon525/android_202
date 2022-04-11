package com.example.last_project.common;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AskTask extends AsyncTask<String , String , InputStream> {



    HttpClient httpClient ; //접속을 위한 객체
    HttpPost httpPost ;     //접속방식을 POST
    MultipartEntityBuilder builder ; //파라메터,파일 등등 (여러부분으로 나누어진)보내기위한 객체
    private String postUrl ; //HTTPIP+SVRPATH+Mapping 접속할 매핑주소(스프링)
    private String mapping ; //mapping부분은 매번 달라질수있기때문에 객체생성시
                             //입력받아서 처리할수있게끔 필드로 만든다.
    ArrayList<AskDTO> paramList;


    public AskTask(String mapping) {
        this.mapping = mapping;
        paramList = new ArrayList<>();
    }
    //paramList <Collection>자료구조를 이용해서 동적으로 파라메터를 추가하기위한 메소드.
    public void addParam(String key , String value){
        paramList.add(new AskDTO(key , value));
    }

    @Override
    protected InputStream doInBackground(String... strings) {
        postUrl = CommonVal.HTTP_IP + CommonVal.SVRPATH + mapping ; //http://192.168.0.38/mid/???
        builder = MultipartEntityBuilder.create();//new MultiPart...();API28미만은 안됨.
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);//웹형태로 요청(Legacy)
        //===============파라메터를 추가할 부분 ===================
        for(int i = 0 ; i < paramList.size() ; i++){
            builder.addTextBody(paramList.get(i).getKey() , paramList.get(i).getValue(),
                    ContentType.create("Multipart/related" , "UTF-8"));
        }

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

    //Gson을 사용하는게 편하다는것을 알기위한 테스트 단계.
    //InputStream자체를 이용하게되면 Stream을 편하게 읽기위한 리더객체 필요함.
    //StringBuilder <= 소스가 복잡해짐
//    public String rtnString(InputStream in)  {
//        BufferedReader reader = null;//in=>isr=>br
//        try {
//            reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        String line = null;
//        try{
//            while ( (line = reader.readLine()) != null){
//
//                Log.d("TAG", "rtnString: " + line);
//                //responsBody<= 응답을 받기때문에
//            }
//        }catch (IOException e){
//           // e.printStackTrace();
//        }
//        return null;
//    }

}
