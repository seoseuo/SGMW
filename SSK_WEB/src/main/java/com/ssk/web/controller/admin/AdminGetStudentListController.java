package com.ssk.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.admin.AdminVO;
import com.ssk.biz.professor.ProfessorDAO;
import com.ssk.biz.professor.ProfessorVO;
import com.ssk.biz.student.StudentDAO;
import com.ssk.biz.student.StudentVO;
import com.ssk.web.controller.Controller;

public class AdminGetStudentListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("학생 목록");
		// 학생 목록 가져오기
		StudentDAO dao = new StudentDAO();

		// 로그인 한 관리자가 관리하는 교수자 목록 보기
		HttpSession session = request.getSession();
		AdminVO adminVo = (AdminVO) session.getAttribute("admin");

		List<StudentVO> stList = dao.getStudentList(adminVo);

		// request객체에 놓고 쏘기
		request.setAttribute("studentList", stList);
		return "admin/adminGetStudentList";
	}

}
