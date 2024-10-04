package com.ssk.web.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssk.biz.professor.ProfessorDAO;
import com.ssk.biz.professor.ProfessorVO;
import com.ssk.biz.student.StudentDAO;
import com.ssk.biz.student.StudentVO;
import com.ssk.web.controller.Controller;

public class AdminEditStudentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		// 입력 정보 추출
		String num = request.getParameter("num");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String major = request.getParameter("major");
	
		System.out.println("학생 정보 수정, " + num);

		// 객체 수정
		StudentVO stvo = new StudentVO();
		stvo.setStudentNum(num);
		stvo.setStudentName(name);
		stvo.setStudentPhone(phone);
		stvo.setStudentMajor(major);

		System.out.println("학생 정보 수정, " + stvo.getStudentNum());
		System.out.println("학생 정보 수정, " + stvo.getStudentName());
		System.out.println("학생 정보 수정, " + stvo.getStudentPhone());
		System.out.println("학생 정보 수정, " + stvo.getStudentMajor());

		// 정보 수정
		StudentDAO stdao = new StudentDAO();

		stdao.adminEditStudent(stvo);

		// 요청에 담기
		request.setAttribute("student", stvo);

		return "admin/adminGetStudent";

	}

}
