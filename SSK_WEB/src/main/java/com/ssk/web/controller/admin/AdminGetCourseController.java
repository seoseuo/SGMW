package com.ssk.web.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssk.biz.course.CourseDAO;
import com.ssk.biz.course.CourseVO;
import com.ssk.web.controller.Controller;

public class AdminGetCourseController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		System.out.println("강의 정보");
		
		// 강의 번호 가져오기
		String coureNumStr = request.getParameter("courseNum");
		int courseNum = Integer.parseInt(coureNumStr);
		
		// 강의 정보 받아오기
		CourseVO covo = new CourseVO();
		covo.setCourseNum(courseNum);

		// db연동
		CourseDAO codao = new CourseDAO();
		CourseVO getCovo = codao.getCourse(covo);
		
		// 요청 객체에 넣고 포워딩
		request.setAttribute("course", getCovo);
		
		
		return "admin/adminGetCourse";	
	}

}
