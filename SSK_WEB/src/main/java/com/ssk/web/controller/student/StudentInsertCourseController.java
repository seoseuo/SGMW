package com.ssk.web.controller.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.course.CourseVO;
import com.ssk.biz.enrollment.EnrollmentDAO;
import com.ssk.biz.enrollment.EnrollmentVO;
import com.ssk.biz.student.StudentVO;
import com.ssk.web.controller.Controller;

public class StudentInsertCourseController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("학생 수강 신청");
		
		// 수강 신청 할 과목 정보 얻기
		String num = request.getParameter("num");
		
		
		HttpSession session = request.getSession();
		StudentVO stvo = (StudentVO) session.getAttribute("student");
		
		EnrollmentVO envo = new EnrollmentVO();
		envo.setEnrollmentCourseNum(Integer.parseInt(num));
		envo.setEnrollmentStudentNum(stvo.getStudentNum());


		//DB 연동 
		EnrollmentDAO endao = new EnrollmentDAO();
		endao.insertStudent(envo);
		
		
		return "/studentGetCourseList.do";
	}

}
