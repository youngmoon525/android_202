package old;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Repository
public class Common {
	public void checkIp(HttpServletRequest req) {
	String test = "";
		
		req = (( ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		test = req.getRemoteAddr();
		System.out.println("test" + test);
	}
}
