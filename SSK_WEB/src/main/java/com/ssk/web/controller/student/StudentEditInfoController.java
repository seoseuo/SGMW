package com.ssk.web.controller.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.student.StudentDAO;
import com.ssk.biz.student.StudentVO;
import com.ssk.web.controller.Controller;

public class StudentEditInfoController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("학생 정보 수정");

		// 수정된 정보 받기
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");

		// 객체 설정
		HttpSession session = request.getSession();
		StudentVO studentvo = (StudentVO) session.getAttribute("student");
		studentvo.setStudentName(name);
		studentvo.setStudentPhone(phone);

		// DB 연동
		StudentDAO studentdao = new StudentDAO();
		studentdao.editStudent(studentvo);

		// 다시 세션에 저장
		session.setAttribute("student", studentvo);
		return "student/studentInfo";

	}

}
