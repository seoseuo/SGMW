package com.ssk.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssk.biz.course.CourseDAO;
import com.ssk.biz.course.CourseVO;
import com.ssk.web.controller.Controller;

public class AdminSearchCourseController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		System.out.println("강의 검색");
		
		// 검색어 받기
		String name = request.getParameter("name");

		CourseVO covo = new CourseVO();
		covo.setCourseName(name);
		
		CourseDAO codao = new CourseDAO();
		List<CourseVO> coList = codao.searchCourseList(covo);

		// 요청 객체에 넣고 포워딩
		request.setAttribute("courseList", coList);
		request.setAttribute("search", name);
		return "admin/adminGetCourseList";
	}

}
