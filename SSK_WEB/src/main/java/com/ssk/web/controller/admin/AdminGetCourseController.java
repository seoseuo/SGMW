package com.ssk.web.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ssk.biz.course.CourseDAO;
import com.ssk.biz.course.CourseVO;
import com.ssk.biz.enrollment.EnrollmentDAO;
import com.ssk.biz.enrollment.EnrollmentVO;
import com.ssk.web.controller.Controller;

public class AdminGetCourseController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		System.out.println("강의 정보");

		// 강의 번호 가져오기
		String coureNumStr = request.getParameter("courseNum");
		System.out.println(coureNumStr);
		int courseNum = Integer.parseInt(coureNumStr);
		System.out.println(courseNum);

		// 강의 정보 받아오기
		CourseVO covo = new CourseVO();
		covo.setCourseNum(courseNum);

		// db연동
		CourseDAO codao = new CourseDAO();
		CourseVO getCovo = codao.getCourse(covo);

		// 수강 학생 X 점수 정보 가져오기

		EnrollmentDAO endao = new EnrollmentDAO();
		List<EnrollmentVO> enList = endao.getEnrollmentList(covo);
		
		
		
		 //학점 배정
		EnrollmentVO envo = new EnrollmentVO();
		envo.assignGrade(enList);
		
		// 요청 객체에 넣고 포워딩
		request.setAttribute("course", getCovo);
		request.setAttribute("enrollmentList", enList);

		return "admin/adminGetCourse";
	}

}
