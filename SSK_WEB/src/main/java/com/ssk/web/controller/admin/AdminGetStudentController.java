package com.ssk.web.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssk.biz.professor.ProfessorDAO;
import com.ssk.biz.professor.ProfessorVO;
import com.ssk.biz.student.StudentDAO;
import com.ssk.biz.student.StudentVO;
import com.ssk.web.controller.Controller;

public class AdminGetStudentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		// TODO Auto-generated method stub
		System.out.println("학생 정보");

		// 학생 학번 가져오기
		String StudentNum = request.getParameter("studentNum");

		StudentVO stvo = new StudentVO();
		stvo.setStudentNum(StudentNum);

		StudentDAO stdao = new StudentDAO();
		StudentVO getstvo = stdao.getStudent(stvo);

		request.setAttribute("student", getstvo);

		return "admin/adminGetStudent";

	}

}
