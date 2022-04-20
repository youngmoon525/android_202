package com.and.mid;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

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
	
	@ResponseBody
	@RequestMapping(value ="/file.f", produces = "application/json;charset=UTF-8")
	public String fileTest(HttpServletRequest req , HttpSession ss) {
		common.checkIp(req);
		
		MultipartRequest mreq = (MultipartRequest) req;
		MultipartFile file = mreq.getFile("file");
		if(file != null) {
			// resources/upload/notice/2022/04/13 
			//어디서든 열수있는 절대경로.
			System.out.println("파일이 들어왔습니다.");
			System.out.println(file.getOriginalFilename());
			String server_path 
			= "http://" + req.getLocalAddr() + ":" + req.getLocalPort() 
			+ req.getContextPath() + "/resources/" + common.fileUpload("and", file, ss); ;
			System.out.println(server_path);
			
		}
		
		return "adfad";
		
	}
	
	
}
