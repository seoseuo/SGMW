package com.ssk.web.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssk.biz.professor.ProfessorDAO;
import com.ssk.biz.professor.ProfessorVO;
import com.ssk.web.controller.Controller;

public class ToAdminEditProfessorController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String professorNum = request.getParameter("professorNum");

		// 교수자 정보를 가져오기 위해 DAO 호출
		ProfessorDAO profDao = new ProfessorDAO();
		ProfessorVO profVo = new ProfessorVO();
		profVo.setProfessorNum(professorNum); // 교수자 교번 설정

		// 교수자 정보를 가져와서 request에 속성으로 설정
		ProfessorVO getProfVo = profDao.getProfessor(profVo);
		
		request.setAttribute("professor", getProfVo);
		System.out.println("교수자 정보 수정 이동, " + professorNum);

		return "admin/adminEditProfessor";
	}

}
