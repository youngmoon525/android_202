package com.example.a00vendingmachine;

public class VendingDAO {
    int money = 0 ; // 사용자가 입력한 금액을 메소드들에서 편하게 사용할수있게                    // DAO에 만들어줌

    //화면에서 금액이 필요한경우
    public int getMoney() {
        return money;
    }
    //화면에 입력 된 금액을 세팅하는 경우
    public void setMoney(int money) {
        this.money = money;
    }
    //메소드를 만들때 리턴타입을 아직 정하지 않은 경우 무조건 void
    //필요한 return타입이 생기면 그때 해당하는 타입으로 바꿈.
    public void setMinus(VendingDTO dto){//index =0 콜라에 대한 모든 정보가 담아져있음
        //음료를 뽑을때 ==> ( 수량 -1 , 사용자 금액 차감 - ,글자가 바뀌어야함 )
        //                  dto.count , dao.money ,    dto.tv.setText(바뀜)
        dto.count -- ;
        money = money - dto.price ;
        dto.tv_name.setText(dto.name + " : " + dto.price + "원");
        dto.tv_count.setText(dto.count + " 개남음");
    }
    public boolean isCheckVending(VendingDTO dto){
        // 사용자의 금액이 내가 선택한 음료보다 같거나 많은지를 체크한다. 1 ,dto<= price
        // 사용자가 선택한 음료가 재고가 남아있는지를 체크한다. 2 dto <= count
        // && <= 논리곱 true=1 , false = 0 = 1 * 0 = 0 (하나라도 false가 나오면 0false)
        // 앞에 조건이 true가 나와도 뒤에조건을 계속 따짐 *0<=나오는 순간 0
        // || <= 논리합 true=1 , false = 0 = 1 + 0 = 1 (하나라도 true가 나오면 true)
        // 앞에 조건이 true가 나오는 순간 뒤에 조건을 무시함 <= 1이 나오는순간 뒤에도 1
        if(dto.price <= money && dto.count > 0){
            return true;
        }
        return false;
    }


}
