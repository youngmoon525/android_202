package com.and.mid;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import member.MemberDAO;
import member.MemberVO;


@Controller

public class MemberController {
	
	@Autowired Common common;
	@Autowired MemberDAO dao;
	Gson gson = new Gson();
	
	
	@ResponseBody
	@RequestMapping(value ="/login", produces = "application/json;charset=UTF-8")
	public String login(HttpServletRequest req ) {
		common.checkIp(req); // F6 STEP OVER , F8 RESUME PROGRAM
							 // 내가 모르는 class로 디버깅포인트가이동이되어있다면
							 // F8로 넘기기.
		MemberVO vo = new MemberVO();
		vo.setId(req.getParameter("id"));
		vo.setPw(req.getParameter("pw"));
	 	vo =  dao.login(vo);
		return gson.toJson(vo); // 보내줄때 Object => String(json) toJson메소드
	}
}
