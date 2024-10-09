package com.ssk.web.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssk.biz.professor.ProfessorDAO;
import com.ssk.biz.professor.ProfessorVO;
import com.ssk.biz.student.StudentDAO;
import com.ssk.biz.student.StudentVO;
import com.ssk.web.controller.Controller;

public class AdminDeleteProfessorController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		// 삭제할 학번 받아오기
		String num = request.getParameter("num");

		System.out.println("학생 정보 삭제, " + num);
		// 객체 설정
		ProfessorVO stvo = new ProfessorVO();
		stvo.setProfessorNum(num); 

		// db연동
		ProfessorDAO profdao = new ProfessorDAO();
		profdao.adminDeleteProfessor(stvo); 

		return "/adminGetProfessorList.do";

	}

}
