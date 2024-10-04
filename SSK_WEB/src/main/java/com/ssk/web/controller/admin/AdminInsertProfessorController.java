package com.ssk.web.controller.admin;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.admin.AdminVO;
import com.ssk.biz.professor.ProfessorDAO;
import com.ssk.biz.professor.ProfessorVO;
import com.ssk.web.controller.Controller;

public class AdminInsertProfessorController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 입력 정보 추출
		System.out.println("교수자 정보 등록");

		String num = request.getParameter("num");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String major = request.getParameter("major");

		System.out.println("교수자 정보 등록 \n학번 : " + num);
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phone);
		System.out.println("소속 (전공) : " + major);

		// 객체 수정
		ProfessorVO profVo = new ProfessorVO();
		profVo.setProfessorNum(num);
		profVo.setProfessorName(name);
		profVo.setProfessorPhone(phone);
		profVo.setProfessorMajor(major);
		profVo.setProfessorPassword(num);

		HttpSession session = request.getSession();
		AdminVO advo = (AdminVO) session.getAttribute("admin");

		System.out.println("관리자 번호 : " + advo.getAdminNum());
		ProfessorDAO profDao = new ProfessorDAO();

		// DB 연동 시작
		try {

			// 교번이 중복일 때
			profDao.adminInsertProfessor(profVo, advo);

			request.setAttribute("professor", profVo);

			return "admin/adminGetProfessor";
		} catch (SQLException e) {
			// 오류 메세지 던지기
 			request.setAttribute("num_warn", "중복된 교번 입니다.");
 			
 			// 입력 값 유지 시켜주기
 			request.setAttribute("num", num);
 			request.setAttribute("name", name);
 			request.setAttribute("phone", phone);
 			request.setAttribute("major", major);
 			
			return "admin/adminInsertProfessor";
		}

	}
}
