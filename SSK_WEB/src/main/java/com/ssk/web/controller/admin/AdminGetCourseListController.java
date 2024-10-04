package com.ssk.web.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssk.biz.course.CourseDAO;
import com.ssk.biz.course.CourseVO;
import com.ssk.web.controller.Controller;

public class AdminGetCourseListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		System.out.println("강의 목록");
		
		
		// 강의 목록 받아오기
		List<CourseVO> coList = new ArrayList<CourseVO>();
		CourseDAO codao = new CourseDAO();
		coList = codao.getCourseList();
		
		// 요청 객체에 넣고 포워딩
		request.setAttribute("courseList", coList);
//		System.out.println("포워딩");
		
		return "admin/adminGetCourseList";	
	}

}
