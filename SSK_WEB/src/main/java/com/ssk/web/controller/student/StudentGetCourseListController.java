package com.ssk.web.controller.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.course.CourseDAO;
import com.ssk.biz.course.CourseVO;
import com.ssk.biz.student.StudentVO;
import com.ssk.web.controller.Controller;

public class StudentGetCourseListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("교수자 강의 목록");

		// 강의 목록 받아오기
		System.out.println("학생 강의 목록");
		CourseDAO codao = new CourseDAO();
		
		HttpSession session = request.getSession();
		
		
		// 듣고있지 않는 강의 목록 보기
		StudentVO stvo = (StudentVO) session.getAttribute("student");
		List<CourseVO> coList = codao.studentGetCourseList(stvo);

		// 요청 객체에 넣고 포워딩
		request.setAttribute("courseList", coList);
//			System.out.println("포워딩");

		return "student/studentGetCourseList";
	}

}
