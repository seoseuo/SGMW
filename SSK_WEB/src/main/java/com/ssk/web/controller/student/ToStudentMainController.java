package com.ssk.web.controller.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssk.web.controller.Controller;

public class ToStudentMainController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("학생 메인");
		return "student/studentMain";
	}

}
