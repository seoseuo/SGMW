package com.ssk.web.controller.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssk.biz.course.CourseDAO;
import com.ssk.biz.course.CourseVO;
import com.ssk.biz.enrollment.EnrollmentDAO;
import com.ssk.biz.enrollment.EnrollmentVO;
import com.ssk.web.controller.Controller;

public class StudentGetCourseController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("학생 강의 조회");

		String num = request.getParameter("num");

		// 객체 설정
		CourseVO covo = new CourseVO();
		covo.setCourseNum(Integer.parseInt(num));

		// DB 연동
		CourseDAO codao = new CourseDAO();
		CourseVO getCovo = codao.getCourse(covo);
		

		// 수강 학생 X 점수 정보 가져오기
		EnrollmentDAO endao = new EnrollmentDAO();
		List<EnrollmentVO> enList = endao.getEnrollmentList(covo);

		
		// 학점 배정
		EnrollmentVO envo = new EnrollmentVO();
		envo.assignGrade(enList);

		// 객체 설정 후 포워딩
		request.setAttribute("course", getCovo);
		request.setAttribute("enrollmentList", enList);
		
		return "student/studnetGetCourse";
	}

}
