package com.example.project02_cloneapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.project02_cloneapp.chat.ChatFragment;
import com.example.project02_cloneapp.friend.FriendFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;//전역변수로 ActionBar를 선언만 해둔다. //현)null
    BottomNavigationView bottom_nav;
    final String TAG = "메인";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //actionbar는 안드로이드 os가 제공을 해줌. 따라서 os를 이용해서 값할당(초기화)
        actionBar = getSupportActionBar();//os가 현재 Actionbar를 return
        actionBar.setTitle("친구");
        //actionBar.hide(); <= 전체 화면으로 컨텐트 부분을 더 넓게 보여주고싶다면
        //해당하는 페이지에서 숨김 처리도 가능함.
        bottom_nav = findViewById(R.id.bottom_nav);
        bottom_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // 바텀 네비게이션 메뉴가 바뀔때마다 토스트창 띄우기 .
                //item.getItemId()?//<==============
                //프래그먼트가 각각의 화면에 맞게 전환 됨.
                if(item.getItemId() == R.id.tab1){
                    Log.d(TAG, " 네비게이션 : 친구 ");
                    actionBar.setTitle("친구");
                    // 메소드 정의부(변수입력(파라메터 입력받는부분 )) + 메소드 호출부 (파라메터 넘겨주는부분)
                    // Fragment fragment = new FriendFragment();
                    changeFragment(new FriendFragment());
                }else if(item.getItemId() == R.id.tab2){
                    Log.d(TAG, " 네비게이션 : 채팅 ");
                    actionBar.setTitle("채팅");
                    changeFragment(new ChatFragment());
                }else if(item.getItemId() == R.id.tab3){
                    Log.d(TAG, " 네비게이션 : 뷰 ");
                }else if(item.getItemId() == R.id.tab4){
                    Log.d(TAG, " 네비게이션 : 쇼핑 ");
                }else if(item.getItemId() == R.id.tab5){
                    Log.d(TAG, " 네비게이션 : 기타 ");
                }else{
                    return  false;
                }


                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu , menu);//제발 외우지 마세요. 가져다가 쓰는부분
                                                             //LayoutInflater<=레이아웃 붙이기 요거만 외우세요.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //어떤 아이템이 선택 되었는지 또 구분할수가있음.
        //각각의 메뉴가 눌리면 logd를 이용해서 찍어보기 진행.
        //+토스트창도 띄우기(뮤직<=)
        if(item.getItemId() == R.id.menu_music){
            Log.d(TAG, " 옵션 메뉴 이용 음악 클릭");
            Toast.makeText(this, "음악 클릭 됨", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    //프래그먼트 전환을 위한 메소드 ( 메소드를 활용해서 바텀네비게이션 메뉴가 바뀔때마다
    //각각 다른 프래그먼트를 보여주는 처리 )
    public void  changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }

}