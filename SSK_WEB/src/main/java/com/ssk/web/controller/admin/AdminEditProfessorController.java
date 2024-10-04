package com.ssk.web.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssk.biz.professor.ProfessorDAO;
import com.ssk.biz.professor.ProfessorVO;
import com.ssk.web.controller.Controller;

public class AdminEditProfessorController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		// 입력 정보 추출
		String num = request.getParameter("num");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String major = request.getParameter("major");
	
		System.out.println("교수자 정보 수정, "+num);
	
		// 객체 수정
		ProfessorVO profVo = new ProfessorVO();
		profVo.setProfessorNum(num);
		profVo.setProfessorName(name);
		profVo.setProfessorPhone(phone);
		profVo.setProfessorMajor(major);
		
		System.out.println("교수자 정보 수정, "+profVo.getProfessorNum());
		System.out.println("교수자 정보 수정, "+profVo.getProfessorName());
		System.out.println("교수자 정보 수정, "+profVo.getProfessorPhone());
		System.out.println("교수자 정보 수정, "+profVo.getProfessorMajor());
		
		// 정보 수정 
		ProfessorDAO profDao = new ProfessorDAO();
		
		profDao.adminEditProfessor(profVo);
		
		//요청에 담기
		request.setAttribute("professor", profVo);
		
		return "admin/adminGetProfessor";
	}

}
