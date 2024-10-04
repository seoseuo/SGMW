package com.ssk.web.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssk.biz.professor.ProfessorDAO;
import com.ssk.biz.professor.ProfessorVO;
import com.ssk.web.controller.Controller;

public class AdminGetProfessorController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("교수자 정보");
	
		// 교수자 교번 가져오기
		String professorNum = request.getParameter("professorNum");

		ProfessorVO profVo = new ProfessorVO();
		profVo.setProfessorNum(professorNum);
		
		ProfessorDAO profDao = new ProfessorDAO();
		ProfessorVO getProfVo = profDao.getProfessor(profVo);
		
		request.setAttribute("professor", getProfVo);
		
		return "admin/adminGetProfessor";
	}

}
