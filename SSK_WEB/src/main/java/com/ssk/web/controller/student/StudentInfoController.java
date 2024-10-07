package com.ssk.web.controller.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.course.CourseDAO;
import com.ssk.biz.course.CourseVO;
import com.ssk.biz.student.StudentVO;
import com.ssk.web.controller.Controller;

public class StudentInfoController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("학생 정보 이동");

		// 듣고있는 강의 목록 보기
		CourseDAO codao = new CourseDAO();
		HttpSession session = request.getSession();
		
		StudentVO stvo = (StudentVO) session.getAttribute("student");
		List<CourseVO> coList = codao.studentGetMyCourseList(stvo);

		// 객체 저장 후 포워딩
		request.setAttribute("courseList", coList);
		return "student/studentInfo";
	}

}
