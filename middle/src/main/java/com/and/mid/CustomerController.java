package com.and.mid;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import customer.CusDTO;
import member.MemberVO;

@Controller
public class CustomerController {
	
	@Autowired Common common; 
	@Autowired @Qualifier("hanul") SqlSession sql;
	Gson gson = new Gson();
	//1. Spring에서 컨트롤러를 추가하고 해당하는 맵핑까지 정상적으로 오는지 URL테스트.
	// (localhost/mid/list.cu) ↓
	
	//sql.selectone <= 한건 조회 ( 한건이상조회하면 에러남)
	//sql.selectlist<= 한건 이상 조회 ( 오류안남)
	
	@ResponseBody
	@RequestMapping(value ="/list.cu", produces = "application/json;charset=UTF-8")
	public String list(HttpServletRequest req ) {
		common.checkIp(req); // F6 STEP OVER , F8 RESUME PROGRAM
		String data = req.getParameter("data");
		System.out.println(data);
		List<CusDTO> list = sql.selectList("cus.mapper.list",data);
		//내가 가지고있는 어떤 객체를 json(String) gson.toJson
		return gson.toJson(list);
	}
	@ResponseBody
	@RequestMapping(value ="/update.cu", produces = "application/json;charset=UTF-8")
	public String update(HttpServletRequest req ) {
		common.checkIp(req); // F6 STEP OVER , F8 RESUME PROGRAM
		System.out.println(req.getParameter("dto"));
		CusDTO dto = gson.fromJson(req.getParameter("dto"), CusDTO.class);
		//내가 가지고있는 어떤 객체를 json(String) gson.toJson
		//toJson DTO나 여러 형태를 String json로 만들어줌
		//fromJson String json형태를 내가 원하는 DTO나 여러 객체 형태로 바꿔줌.
		//mybatis update <= 그결과를 성공 1
		
		//1.데이터베이스에서 올바른 쿼리를 이용해서 업데이트 해보기.<=
		//2.해당하는 쿼리를 mybatis 맵퍼에 등록하기. o
		//3.Controller에서 실행하기 ↑
		System.out.println(sql.update("cus.mapper.update" , dto));
		//4.그결과가 성공인지 체크.
		return "";
	}
	      
	@ResponseBody
	@RequestMapping(value ="/delete.cu", produces = "application/json;charset=UTF-8")
	public String delete(HttpServletRequest req ) {
		common.checkIp(req); // F6 STEP OVER , F8 RESUME PROGRAM
		System.out.println(req.getParameter("dto"));
		CusDTO dto = gson.fromJson(req.getParameter("dto"), CusDTO.class);

		System.out.println(sql.delete("cus.mapper.delete" , dto));
		return "";
	}  
}
