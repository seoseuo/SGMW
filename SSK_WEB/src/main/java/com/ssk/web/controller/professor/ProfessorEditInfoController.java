package com.ssk.web.controller.professor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.professor.ProfessorDAO;
import com.ssk.biz.professor.ProfessorVO;
import com.ssk.web.controller.Controller;

public class ProfessorEditInfoController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("교수 정보 수정");
		
		// 수정된 점수들 받기
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		// 객체 설정
		
		HttpSession session = request.getSession();
		ProfessorVO profvo = (ProfessorVO) session.getAttribute("professor");
		profvo.setProfessorName(name);
		profvo.setProfessorPhone(phone);
		
		
		// db 연동
		ProfessorDAO profdao = new ProfessorDAO();
		profdao.editProfessor(profvo);
		
		// 다시 세션에 저장
		session.setAttribute("session", profvo);
		return "professor/professorInfo";
		
		
	}

}
