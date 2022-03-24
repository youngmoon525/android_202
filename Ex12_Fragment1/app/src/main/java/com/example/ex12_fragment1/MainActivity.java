package com.example.ex12_fragment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //1.액티비티 2.서비스 <= Manifest
    int flag = 0 ;
    boolean isFlag = false;
    String sFlag = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //View타입을 상속받은 위젯들은 전부다 OnClickListener가 있기때문에
        //파인드 뒤에 바로 써도 무방함.
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!isFlag){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container , new Fragment1()).commit();
                }else{
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container , new Fragment2()).commit();
                }
                isFlag = !isFlag;//true , false
                //프래그먼트를 붙이는 방법
                //Activity(getSuppoertFragmentManager<= 이용)
                //파라메터중 @--res로 끝나는것들은 res폴더에 있는
                //Transaction  <= UPDATE , DELETE , INSERT <= DB ROLLBACK; , COMMIT;

            }
        });


    }
}