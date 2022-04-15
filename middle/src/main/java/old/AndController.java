package old;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class AndController {
@Autowired Common common;
	// res <= encoding produces ( 페이지를 찾을수없습니다 == jsp,html파일없음 )
	// RequestMapping을 치게되고 return String을 하면
	// org.springframework.web.servlet.view.InternalResourceViewResolver
	// default로 해당하는 jsp파일을 view/에서 찾음.
	//RequestMapping을 받는 메소드의 규칙
	//req.getParamter("name"); <= "name"을 바로 파라메터부의 변수 이름으로 지정을하면
	//알아서 request가 변수에 담아준다
	@ResponseBody //<= 해당하는 jsp파일을 찾는게 아니라 메소드 바디에서 응답하겠다.
	@RequestMapping(value = "/and" , produces = "application/json;charset=UTF-8" )
	public String test(HttpServletRequest req  ,String param1 , String param2) {
		common.checkIp(req);
		//System.out.println("안드에서 보내준값" + req.getParameter("param"));
		System.out.println("안드에서 String" + param1);
		System.out.println("안드에서 String" + param2);

		return "한글 데이터";
	}
	
	@ResponseBody
	@RequestMapping(value ="/toFromAnd", produces = "application/json;charset=UTF-8")
	public String test2(HttpServletRequest req) {
		// 여기 부분 포문으로 바꿔보기 ↓ ??
		//System.out.println("안드에서 보내준값" + req.getParameter("param1"));
		//System.out.println("안드에서 보내준값" + req.getParameter("param2"));
		//System.out.println("안드에서 보내준값" + req.getParameter("param3"));
		//System.out.println("안드에서 보내준값" + req.getParameter("param4"));
		//System.out.println("안드에서 보내준값" + req.getParameter("param5"));
		// i가 시작하는 지점 (변수) , i가 false되서 반복문을 종료해야되는 지점(변수)
		System.out.println(req.getParameter("paramA"));
		System.out.println(req.getParameter("paramB"));
		for (int i =Integer.parseInt(req.getParameter("paramA")); i <= Integer.parseInt(req.getParameter("paramB")); i++) {
			System.out.println("안드에서 보내준값" + req.getParameter("param"+i));
		}
		
		return "여까지옴" ;
	}
	
	
	
}
