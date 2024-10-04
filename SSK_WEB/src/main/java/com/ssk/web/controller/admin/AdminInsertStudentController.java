package com.ssk.web.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.admin.AdminVO;
import com.ssk.biz.student.StudentDAO;
import com.ssk.biz.student.StudentVO;
import com.ssk.web.controller.Controller;

public class AdminInsertStudentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("학생 정보 등록");
		
		String num = request.getParameter("num");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String major = request.getParameter("major");

		System.out.println("학생 정보 등록 \n학번 : " + num);
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phone);
		System.out.println("소속 (전공) : " + major);

		// 객체 수정
		StudentVO stvo = new StudentVO();
		stvo.setStudentNum(num);
		stvo.setStudentName(name);
		stvo.setStudentPhone(phone);
		stvo.setStudentMajor(major);
		stvo.setStudentPassword(num); // 비밀번호를 학번으로 설정

		HttpSession session = request.getSession();

		AdminVO advo = (AdminVO) session.getAttribute("admin");
		System.out.println("관리자 번호 : " + advo.getAdminNum());

		// 정보 수정
		StudentDAO stDao = new StudentDAO();

		// db 연동 시작
		stDao.adminInsertStudent(stvo, advo); // StudentDAO의 메서드 호출

		// 요청에 담기
		request.setAttribute("student", stvo); // attribute 이름도 student로 변경

		return "admin/adminGetStudent"; // 반환 경로도 학생 페이지로 변경
	}

}
