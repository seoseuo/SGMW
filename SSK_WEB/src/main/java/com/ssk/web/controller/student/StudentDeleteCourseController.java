package com.ssk.web.controller.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.enrollment.EnrollmentDAO;
import com.ssk.biz.enrollment.EnrollmentVO;
import com.ssk.biz.student.StudentVO;
import com.ssk.web.controller.Controller;

public class StudentDeleteCourseController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("강의 철회");
		
		// 철회할 강의
		String num = request.getParameter("num");
		
		HttpSession session = request.getSession();
		StudentVO stvo = (StudentVO) session.getAttribute("student");
		
		EnrollmentVO envo = new EnrollmentVO();
		
		// 객체 설정
		envo.setEnrollmentCourseNum(Integer.parseInt(num));
		envo.setEnrollmentStudentNum(stvo.getStudentNum());
		
		EnrollmentDAO endao = new EnrollmentDAO();
		
		//DB 연동
		
		endao.deleteStudentCorse(envo);
		
		return "/studentInfo.do";
	}

}
