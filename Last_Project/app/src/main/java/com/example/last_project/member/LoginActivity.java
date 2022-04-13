package com.example.last_project.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.last_project.MainActivity;
import com.example.last_project.R;
import com.example.last_project.common.AskTask;
import com.example.last_project.common.CommonMethod;
import com.example.last_project.common.CommonVal;
import com.google.gson.Gson;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.Account;
import com.navercorp.nid.NaverIdLoginSDK;
import com.navercorp.nid.oauth.NidOAuthLogin;
import com.navercorp.nid.oauth.OAuthLoginCallback;
import com.navercorp.nid.oauth.view.NidOAuthLoginButton;
import com.navercorp.nid.profile.NidProfileCallback;
import com.navercorp.nid.profile.data.NidProfileResponse;

import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "로그인";
    EditText edt_id , edt_pw;
    Button btn_login;
    CheckBox chk_auto ;

    //1.자동로그인 , 네이버 로그인 <= Android ( Kotlinx <= 사용법 java 와 어떤 차이가 있는지 )
    // Flutter <- dots , 리엑트
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//R.layout.activity_login
        setContentView(R.layout.activity_login);
        getHashKey();
        NaverIdLoginSDK.INSTANCE.initialize(
                this,"dPPIq5XGJtg4QU0KlgaZ",
                "8pNSZEnDCa",
                "lastproject");
        KakaoSdk.init(this,"247d6205dcf6631decbb67cdd4b00880");

        ImageView btn_kakao = findViewById(R.id.btn_kakao);
        // 카카오계정으로 로그인 공통 callback 구성
        // 카카오톡으로 로그인 할 수 없어 카카오계정으로 로그인할 경우 사용됨
//        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
//        if (error != null) {
//            Log.e(TAG, "카카오계정으로 로그인 실패", error)
//        } else if (token != null) {
//            Log.i(TAG, "카카오계정으로 로그인 성공 ${token.accessToken}")
//        }
//}
        Function2<OAuthToken, Throwable, Unit> callback =
                new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
               if(oAuthToken != null){
                   Log.d(TAG, " 카카오 토큰이 있음 . 로그인 정보를 빼오면 됨");
                   getKakaoProfile();
               }else{
                   Log.d(TAG, " 카카오 토큰이 없음 . " + throwable.toString());
               }
               return null;
            }
        };
        btn_kakao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(UserApiClient.getInstance().isKakaoTalkLoginAvailable(LoginActivity.this)){
                    Log.d(TAG, " 카톡 설치 되있음");
                    UserApiClient.getInstance().loginWithKakaoTalk(LoginActivity.this,callback);
                }else{
                    Log.d(TAG, " 카톡 설치 X");
                    UserApiClient.getInstance().loginWithKakaoAccount(LoginActivity.this,callback);
                }
            }
        });

        NidOAuthLoginButton btn_naver = findViewById(R.id.btn_naver);
        btn_naver.setOAuthLoginCallback(new OAuthLoginCallback() {
            @Override
            public void onSuccess() {
                Log.d(TAG, "onSuccess: " +  NaverIdLoginSDK.INSTANCE.getAccessToken());
                Log.d(TAG, "onSuccess: " +  NaverIdLoginSDK.INSTANCE.getRefreshToken());
                getNaverProfile();
            }

            @Override
            public void onFailure(int i, String s) {
                Log.d(TAG, "onFailure: " + s);
            }

            @Override
            public void onError(int i, String s) {
                Log.d(TAG, "onError: " + s);
            }
        });

        edt_id = findViewById(R.id.edt_id );
        edt_pw = findViewById(R.id.edt_pw );
        btn_login = findViewById(R.id.btn_login );
        chk_auto = findViewById(R.id.chk_auto);
        SharedPreferences preferences = getPreferences(LoginActivity.MODE_PRIVATE);
        edt_id.setText(preferences.getString("id" , ""));
        edt_pw.setText(preferences.getString("pw" , ""));

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( edt_id.getText().toString().trim().length() < 1 ||
                        edt_pw.getText().toString().trim().length() < 1){
                    Toast.makeText(LoginActivity.this, "아이디 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }else{

                    MemberDAO dao = new MemberDAO(LoginActivity.this);
                    // if ( true , false )
                    //boolean aa = 1 < 3 ;
                    //명명규칙 꼭 알아야지 개발하는데 1이라도 도움이됨.
                    //is <= 불타입을 리턴할 확률 98%
                    if(dao.isMemberLogin()) {

                        checkAutoLogin();
                        goMain(); //Intent를 이용 메인액티비티로 이동.
                    }else{
                        chk_auto.setChecked(false);
                        checkAutoLogin();
                    }
                }
            }
        });
        if(edt_id.getText().toString().length() >= 1){
            chk_auto.setChecked(true);
            btn_login.performClick();
        }

    }

    public void getKakaoProfile(){
        // 사용자 정보 요청 (기본)
        UserApiClient.getInstance().me(  (user, throwable) -> {
           if(throwable != null){
               Log.d(TAG, " 사용자 정보 요청 실패"+ throwable.toString());
               //오류가 났을때는 어떤 오류인지를 Kakao에서 제공해줌 . KOE + 숫자
           }else{
               // [ { } ] json 구조처럼 바로 데이터가 있는게 아니라 Accuount라는 키로 한칸을 들어감(오브젝트)
               //그안에서 profile을 얻어 올수가있음.
               Account account = user.getKakaoAccount();
               if(account != null){

                   Log.d(TAG, " 사용자 정보 요청 성공 : "+account.getProfile().getNickname());
                   Log.d(TAG, " 사용자 정보 요청 성공 : "+account.getEmail());
               }


           }

            return null;
        });
    }


    public void getNaverProfile(){ //<- 억세스 토큰 O일때만 성공함.
        NidOAuthLogin authLogin = new NidOAuthLogin();
        authLogin.callProfileApi(new NidProfileCallback<NidProfileResponse>() {
            @Override
            public void onSuccess(NidProfileResponse nidProfileResponse) {
                Log.d(TAG, "onSuccess: " + nidProfileResponse.getProfile().getEmail());
                Log.d(TAG, "onSuccess: " + nidProfileResponse.getProfile().getMobile());
                Log.d(TAG, "onSuccess: " + nidProfileResponse.getProfile().getName());
            }

            @Override
            public void onFailure(int i, String s) {
                Log.d(TAG, "onFailure: " + s);
            }

            @Override
            public void onError(int i, String s) {
                Log.d(TAG, "onFailure: " + s);
            }
        });

    }

    public void goMain(){ //카카오 , 네이버 , 일반로그인 했을때 메인엑티비티로 이동하게끔처리.
                         //카카오 , 네이버 로그인 시 회원정보가 x
        Intent intent = new Intent(LoginActivity.this , MainActivity.class);
        startActivity(intent);
    }


    public void checkAutoLogin(){
        //해당하는 화면 외에는 공유를 안하는 경우.
        SharedPreferences preferences = getPreferences(LoginActivity.MODE_PRIVATE);
        //공유자원을 사용하는 방법 1.생성 ↑
        //공유자원을 수정할수있는 객체가 별도로 존재함.
        SharedPreferences.Editor editor = preferences.edit();
        if(chk_auto.isChecked()){
            editor.putString("id" , edt_id.getText().toString()); //test라는 key(name)을 구분자로 두고 data라는 값을 넣음.
            editor.putString("pw" , edt_pw.getText().toString()); //test라는 key(name)을 구분자로 두고 data라는 값을 넣음.

        }else{
            //editor.remove("id");
            editor.clear(); //<=전체지우기.
        }
        editor.apply();


    }



    private void getHashKey(){
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            Log.e("KeyHash", "KeyHash:null");

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
    }
}