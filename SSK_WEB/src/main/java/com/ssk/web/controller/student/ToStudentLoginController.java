package com.ssk.web.controller.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssk.web.controller.Controller;

public class ToStudentLoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	
		System.out.println("학생 로그인 이동");
		
		return "student/studentLogin";
	
	}
	

}
