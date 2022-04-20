package com.and.mid;

import java.util.ArrayList;
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
import employee.EmpDTO;

@Controller
public class EmpController {
	Gson gson = new Gson();
	@Autowired Common common; 
	@Autowired @Qualifier("hr") SqlSession sql;
	@ResponseBody
	@RequestMapping(value ="/list.hr", produces = "application/json;charset=UTF-8")
	public String list(HttpServletRequest req ) {
		common.checkIp(req); 
		System.out.println(sql.selectOne("hr.mapper.test")+"");
		List<EmpDTO> list = sql.selectList("hr.mapper.list");
		for (EmpDTO empDTO : list) {
			System.out.println(empDTO.getDepartment_name());
		}
		return gson.toJson(list);
	}
}
