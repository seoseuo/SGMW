package com.ssk.web.controller.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.admin.AdminDAO;
import com.ssk.biz.admin.AdminVO;
import com.ssk.biz.professor.ProfessorDAO;
import com.ssk.biz.professor.ProfessorVO;
import com.ssk.web.controller.Controller;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		// 1. 입력 정보 추출
		String num = request.getParameter("num");
		String password = request.getParameter("password");
		String position = request.getParameter("position");

		System.out.println("입력 번호 : " + num);
		System.out.println("입력 비밀번호 : " + password);
		System.out.println("로그인 직책 : " + position);

		// 2. num 길이에 따라 어느 사용자로 로그인 할 것인지 결정
		// 관리자 6자리 , 교수자 7자리, 학생 8자리

		if (position.equals("admin")) {
			System.out.println("관리자 로그인");
			AdminVO vo = new AdminVO();

			vo.setAdminNum(num);
			vo.setAdminPassword(password);

			// 3. 데이터베이스 연동
			AdminDAO dao = new AdminDAO();
			AdminVO loginVo = dao.getAdmin(vo);

			HttpSession session = request.getSession();

			if (loginVo != null && loginVo.getAdminPassword().equals(password)) {
				System.out.println("로그인 성공!");

				// 사용자 정보를 세션에 저장
				session.setAttribute("admin", loginVo);

				return "admin/adminMain";

			} else {
				System.out.println("로그인 실패, 아이디 혹은 비밀번호 오류.");

				// 로그인 실패 시
				request.setAttribute("login_warn", "아이디 혹은 비밀번호 오류입니다.");

				// 입력값 유지
				request.setAttribute("position", "admin");
				request.setAttribute("num", num);
				request.setAttribute("password", password);

				return "admin/adminLogin";
			}

		} else if (position.equals("professor")) {
			System.out.println("교수자 로그인");

			ProfessorVO profvo = new ProfessorVO();

			profvo.setProfessorNum(num);
			profvo.setProfessorPassword(password);

			// 3. 데이터베이스 연동
			ProfessorDAO profdao = new ProfessorDAO();
			ProfessorVO loginVo = profdao.getProfessor(profvo);

			HttpSession session = request.getSession();

			if (loginVo != null && loginVo.getProfessorPassword().equals(password)) {
				System.out.println("로그인 성공!");

				// 사용자 정보를 세션에 저장
				session.setAttribute("professor", loginVo);

				return "professor/professorMain";

			} else {
				System.out.println("로그인 실패, 아이디 혹은 비밀번호 오류.");

				// 로그인 실패 시 alert 띄우고 다시 로그인 페이지로 돌아가도록 처리
				// 로그인 실패 시
				request.setAttribute("login_warn", "아이디 혹은 비밀번호 오류입니다.");

				// 입력값 유지
				request.setAttribute("position", "professor");
				request.setAttribute("num", num);
				request.setAttribute("password", password);

				return "professor/professorLogin";
			}

		} else if (position.equals("student")) {
			System.out.println("학생 로그인");
			// 학생 로그인 처리 로직 추가
			request.setAttribute("position", "student");
			return "student.studentLogin";
		}
		return "index";

	}
}