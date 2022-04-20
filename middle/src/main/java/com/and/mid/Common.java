package com.and.mid;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class Common {
	public void checkIp(HttpServletRequest req) {
	String test = "";
		
		req = (( ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		test = req.getRemoteAddr();
		System.out.println("test" + test);
	}
	
	
	// 파일 업로드 처리
	public String fileUpload(String category, MultipartFile file, HttpSession session) {
//D:\Study_Spring\Workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\clcd\resources		
		String resources = session.getServletContext().getRealPath("resources");
// resources/upload/notice/2022/04/13		
		String folder = resources + "/upload/" + category + "/" 
						+ new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		String uuid = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		
		File dir = new File( folder );

/* File 클래스 : 입출력에 필요한 파일 및 디렉토리에 관한 정보를 다룰 수 있음. 
		File 클래스는 파일과 디렉토리의 접근 권한, 생성된 시간, 마지막 수정 일자, 크기, 경로 등의
		정보를 얻을 수 있는 메소드를 가지고 있으며, 새로운 파일과 디렉토리 생성 및 삭제,
		이름 변경 등의 조작 메소드를 가지고 있음. */
		
		if ( ! dir.exists() )	dir.mkdirs();
		// exists() : 지정한 경로에 디렉토리/파일 구분없이 존재하는지 확인
			try {
				file.transferTo(new File( folder, uuid  ));
			// transferTo() : 기존 FileInputStream 등을 사용하지 않아도 쉽게 파일을 저장할 수 있는 메소드임 
			} catch (Exception e) {
				e.printStackTrace();
			} 
		
		// 	upload/notice/2022/04/13/akskgkskslksg_abc.txt
		return folder.substring(resources.length() + 1) + "/" + uuid;
	}
	
	
}
