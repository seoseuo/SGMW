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

public class AdminSearchStudentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		 System.out.println("학생 검색");
		    // 검색어 받기
		    String num = request.getParameter("num");

		    // 객체 설정
		    StudentVO stvo = new StudentVO();
		    stvo.setStudentNum(num); // 학생 번호를 설정

		    HttpSession session = request.getSession();
		    AdminVO advo = (AdminVO) session.getAttribute("admin");  // 관리자 세션 정보 가져오기

	
		    
		    // db 연동
		    StudentDAO stDao = new StudentDAO();  // 학생 DAO 객체 생성
		    List<StudentVO> stList = stDao.searchStudent(stvo, advo);  // 학생 검색

		    // 요청에 저장 후 포워딩
		    request.setAttribute("studentList", stList);  // 검색한 학생 리스트를 요청에 저장
		    request.setAttribute("search", num);
			return "admin/adminGetStudentList"; // 포워딩할 JSP 파일로 이동
	}

}
