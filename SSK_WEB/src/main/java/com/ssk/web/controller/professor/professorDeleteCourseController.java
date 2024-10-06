package com.ssk.web.controller.professor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssk.biz.course.CourseDAO;
import com.ssk.biz.course.CourseVO;
import com.ssk.biz.enrollment.EnrollmentDAO;
import com.ssk.web.controller.Controller;

public class professorDeleteCourseController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("교수자 강의 삭제");

		// 강의 번호 받아오기.
		String num = request.getParameter("num");
		System.out.println(num);
		CourseVO covo = new CourseVO();
		covo.setCourseNum(Integer.parseInt(num));

		// DB 연동
		CourseDAO codao = new CourseDAO();
		codao.deleteCourse(covo);

		EnrollmentDAO endao = new EnrollmentDAO();
		endao.deleteEnrollment(covo);

		return "/professorInfo.do";
	}

}
