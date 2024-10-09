package com.ssk.web.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssk.biz.student.StudentDAO;
import com.ssk.biz.student.StudentVO;
import com.ssk.web.controller.Controller;

public class AdminDeletStudentContoller implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		// 삭제할 학번 받아오기
				String num = request.getParameter("num");

				System.out.println("학생 정보 삭제, " + num);
				// 객체 설정
				StudentVO stvo = new StudentVO();
				stvo.setStudentNum(num); 

				// db연동
				StudentDAO stdao = new StudentDAO();
				stdao.adminDeleteStudent(stvo); 
		
		return "/adminGetStudentList.do";
	}

}
