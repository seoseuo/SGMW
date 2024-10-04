package com.ssk.web.controller.professor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssk.web.controller.Controller;

public class ToProfessorLoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	
		System.out.println("교수자 로그인 이동");
		
		return "professor/professorLogin";
	
	}
	

}
