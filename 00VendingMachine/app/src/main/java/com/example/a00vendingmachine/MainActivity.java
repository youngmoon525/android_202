package com.example.a00vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edt_usermoney;
    Button btn_inputmoney, btn_result;
    TextView tv_money;
    VendingDAO dao = new VendingDAO();
    ArrayList<VendingDTO> list;
    ArrayList<VendingDTO> resultList = new ArrayList<>(); // <= list.add<=

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_usermoney = findViewById(R.id.edt_usermoney);
        btn_inputmoney = findViewById(R.id.btn_inputmoney);
        btn_result = findViewById(R.id.btn_result);
        tv_money = findViewById(R.id.tv_money);


        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , SubActivity.class);
                intent.putExtra("resultlist", resultList); //사용자가 뽑은 음료 갯수 목록
                intent.putExtra("money",dao.money );       //사용자가 반환 받아야할 금액.
                startActivity(intent);
            }
        });



        btn_inputmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //나중에 고도화(안정화) 예외처리 하면 됨 => 현 상태에서는 숫자만 넣고 테스트
                dao.money = Integer.parseInt(edt_usermoney.getText() + "");
                tv_money.setText("잔액 : " + dao.money + "원");
            }
        });

        //VendingDTO에 위젯묶음하나(콜라,콜라갯수,콜라버튼) 컨트롤 해보기.
        //더 긴 코딩으로 VendingDTO를 사용하는 방법.
        //TextView tv_drinkname = findViewById(R.id.tv_drinkname1);
        //TextView tv_drinkcnt1 = findViewById(R.id.tv_drinkcnt1);
        //Button btn_order1 = findViewById(R.id.btn_order1);
        //DTO로 묶어서 사용할 위젯들을 따로 위젯타입의 변수에 담아서 사용할필요 x =>바로 값을 할당해주면 됨.
        VendingDTO dto = new VendingDTO(
                "콜라", 900, 10
                , findViewById(R.id.tv_drinkname1)
                , findViewById(R.id.tv_drinkcnt1)
                , findViewById(R.id.btn_order1)); // DTO라는 객체에 데이터에 사용할 변수 + 위젯(객체)를 하나로 묶어둠.
        list = new ArrayList<>();
        list.add(dto);
        list.add(new VendingDTO("사이다", 1000, 11, findViewById(R.id.tv_drinkname2)
                , findViewById(R.id.tv_drinkcnt2)
                , findViewById(R.id.btn_order2)));
        list.add(new VendingDTO("환타", 1100, 12, findViewById(R.id.tv_drinkname3)
                , findViewById(R.id.tv_drinkcnt3)
                , findViewById(R.id.btn_order3)));
        list.add(new VendingDTO("데미소다", 1200, 2, findViewById(R.id.tv_drinkname4),
                findViewById(R.id.tv_drinkcnt4)
                , findViewById(R.id.btn_order4)));

        for (int i = 0; i < list.size(); i++) {
            list.get(i).btn_order.setOnClickListener(this);
            //VendingDTO
        }

    }//onCreate <= 메소드 안쪽에서 만든 모든 변수들은 메소드가 끝나는 블럭킹에서
    //메모리에서 사라진다. (== 블럭킹 밖에 사용 불가 x = 지역 변수 )

    //구현부를 내가 가지고있는 클래스 바디(지역)로 가지고옴
    @Override
    public void onClick(View v) {
        for (int i = 0; i < list.size(); i++) {
            if (v.getId() == list.get(i).btn_order.getId()) {
                //내가 원하는 index에 있는 DTO를 빼오는 작업을 할수가있음
                //클릭한 button의 id와 내가 가지고있는 button의 id가 일치한다면.
                if (dao.isCheckVending(list.get(i))) {
                    resultList.add(list.get(i));//사용자가 버튼을 클릭할때마다
                                                //그처리가 정상적으로 되었다면 누적시키기.
                    dao.setMinus(list.get(i));
                    tv_money.setText("잔액 : " + dao.money + " 원 ");
                }
            }
        }
    }

}//class