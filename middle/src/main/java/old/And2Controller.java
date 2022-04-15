package old;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class And2Controller {
	@Autowired Common common;
	
	@Autowired @Qualifier("hanul") private SqlSession sql;
	
	Gson gson = new Gson();
	
	
	@ResponseBody
	@RequestMapping(value ="/Test2", produces = "application/json;charset=UTF-8")
	public String test2(HttpServletRequest req) {
		common.checkIp(req);
		Gson gson = new Gson();
		//json으로 만들기 toJson , json을 다시 오브젝트(Class) fromJson
		//현재 Android에서 TestDTO라는 클래스타입을 json으로 만들어서 보내줌.
		//json을 다시 TestDTO라는 클래스타입으로 만드려면 해당하는 클래스타입을
		//사용할수있는 상태여야한다. ( 여기에 해당하는 타입의 DTO가 있어야함)
		String data = req.getParameter("dto");
		TestDTO dto = gson.fromJson(data, TestDTO.class);
		System.out.println(dto.getId());
		System.out.println(dto.getPw());
		
		TestDTO rtnDto = new TestDTO("스프링ID", "스프링PW");
		return gson.toJson(rtnDto);
	}
	@ResponseBody
	@RequestMapping(value ="/testlist", produces = "application/json;charset=UTF-8")
	public String testList(HttpServletRequest req) {
		System.out.println(req.getParameter("dto"));
		Gson gson = new Gson();//TypeToken<T> <=자동완성 안될때는 파라메터부밖에서
							    //타이핑해서 복붙하기. 
		ArrayList<TestDTO> list = gson.fromJson(req.getParameter("dto"),
				new TypeToken<List<TestDTO>>() {}.getType());
		for (TestDTO testDTO : list) {
			System.out.println(testDTO.getId());
			testDTO.setId(testDTO.getId() + "SPR");
		}
		
		return gson.toJson(list);
	}
	
	@ResponseBody
	@RequestMapping(value ="/test0407", produces = "application/json;charset=UTF-8")
	public String testList2(HttpServletRequest req) {
		//? UserDTO 타입의 클래스가 필요함 // 안드=>UserDTO Spring=>UserDTO가 있어야함.
		UserDTO dto = gson.fromJson(req.getParameter("testdata"), UserDTO.class);
		System.out.println(dto.getId());
		// 왼쪽부터 비교 시작 && 하나라도 false가 나오면 그다음 조건을 비교안하고 false
		if(dto != null && dto.getId().equals("admin") && dto.getPw().equals("1234")) {
			return gson.toJson(dto);
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value ="/test0408", produces = "application/json;charset=UTF-8")
	public String testList3(HttpServletRequest req) {
		String data =  sql.selectOne("test.mapper.test");
		int data2 =  sql.selectOne("test.mapper.test2");
		String data3 =  sql.selectOne("test.mapper.test3" , "data");
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("param1", "data1");
		param.put("param2", "data2");
		String data4 =  sql.selectOne("test.mapper.test4" , param);
		WMemberDTO dto = sql.selectOne("test.mapper.test5");
		HashMap<String, String> login = new HashMap<String, String>();
		
		WMemberDTO revDto = gson.fromJson( req.getParameter("testdata") , WMemberDTO.class);
		login.put("id", revDto.getId());
		login.put("pw", revDto.getPw());
		dto = sql.selectOne("test.mapper.test6",login);
		
		System.out.println(data);
		System.out.println(data2);
		System.out.println(data3);
		System.out.println(data4);
		System.out.println(dto == null ? "널임" : dto.getId());
		System.out.println( gson.toJson(dto) ) ;
		return gson.toJson(dto);
	}
	@ResponseBody
	@RequestMapping(value ="/test0409", produces = "application/json;charset=UTF-8")
	public String aaaaa() {
		return "abcd";
	}
	@ResponseBody
	@RequestMapping(value ="/test0411", produces = "application/json;charset=UTF-8")
	public String aaaaa(HttpServletRequest req ) {
		common.checkIp(req);
		System.out.println(req.getParameter("testKey"));
		return "abcd";
	}

	
}
