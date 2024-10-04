package com.ssk.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.admin.AdminVO;
import com.ssk.biz.professor.ProfessorDAO;
import com.ssk.biz.professor.ProfessorVO;
import com.ssk.web.controller.Controller;

public class AdminSearchProfessorController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		System.out.println("교수자 검색");
		// 검색어 받기
		String num = request.getParameter("num");

		// 객체 설정
		ProfessorVO profvo = new ProfessorVO();
		profvo.setProfessorNum(num);		
	
		HttpSession session = request.getSession();
		AdminVO advo = (AdminVO) session.getAttribute("admin");
		// db 연동
		ProfessorDAO profdao = new ProfessorDAO();
		List<ProfessorVO> profList = profdao.searchProfessor(profvo,advo);

		// 요청에 저장 후 포워딩
		request.setAttribute("professorList", profList);
		request.setAttribute("search", num);
		return "admin/adminGetProfessorList";
	}

}
