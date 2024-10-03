package com.ssk.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	//추상 메소드
	String handleRequest(HttpServletRequest request, HttpServletResponse response);

}
