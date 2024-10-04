package com.ssk.web.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssk.web.controller.Controller;

public class ToAdminLoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	
		System.out.println("관리자 로그인 이동");
		
		return "admin/adminLogin";
	
	}
	

}
