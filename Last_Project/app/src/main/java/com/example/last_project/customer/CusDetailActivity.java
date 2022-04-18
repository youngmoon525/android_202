package com.example.last_project.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.last_project.R;
import com.example.last_project.common.AskTask;
import com.example.last_project.common.CommonMethod;
import com.google.gson.Gson;

/*AppCompat <= 전체화면으로 켜져야함.*/
public class CusDetailActivity extends Activity {
EditText edt_id , edt_name , edt_tel ;
RadioButton rdo_man , rdo_woman;
Button btn_edit , btn_del ;
    CusDTO dto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ==?

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_cus_detail);

        Intent intent = getIntent();
        dto = (CusDTO) intent.getSerializableExtra("dto");
        Log.d("G", "onCreate: " + dto.getName());

        edt_id = findViewById(R.id.edt_id);
        edt_name= findViewById(R.id.edt_name);
        edt_tel= findViewById(R.id.edt_tel);
        rdo_man= findViewById(R.id.rdo_man);
        rdo_woman= findViewById(R.id.rdo_woman);
        btn_edit= findViewById(R.id.btn_edit);
        btn_del= findViewById(R.id.btn_del);

        edt_id.setText( dto.getId()+"" );
        edt_name.setText( dto.getName() );
        edt_tel.setText( dto.getPhone() );





        //edt_id.setEnabled(false);
        if(dto.getGender().equals("남")){
            rdo_man.setChecked(true);
        }else {
            rdo_woman.setChecked(true);
        }

        rdo_man.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    dto.setGender("남");
                    rdo_woman.setChecked(false);
                }
            }
        });

        rdo_woman.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    dto.setGender("여");
                    rdo_man.setChecked(false);
                }
            }
        });

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_name.getText().toString().length() < 1){
                    Toast.makeText(CusDetailActivity.this, "이름은 반드시 입력해야합니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Gson gson = new Gson();
                dto.setName(edt_name.getText()+"");
                //dto.setGender(rdo_man.isChecked() == true ? "남" : "여");
                dto.setPhone(edt_tel.getText()+"");
                AskTask task = new AskTask("update.cu");
                task.addParam("dto" , gson.toJson(dto));
                CommonMethod.executeAskGet(task); // true false / int 1,0 / String ...
                finish(); //<= 테스트가 올바르게 끝나고 나서
            }
        });
        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Gson gson = new Gson();
                AskTask task = new AskTask("delete.cu");
                task.addParam("dto" , gson.toJson(dto));
                CommonMethod.executeAskGet(task);
                finish();
            }
        });
    }
}