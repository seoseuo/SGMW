package com.ssk.web.controller.professor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.course.CourseDAO;
import com.ssk.biz.course.CourseVO;
import com.ssk.biz.professor.ProfessorVO;
import com.ssk.web.controller.Controller;

public class ProfessorAddCourseController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		System.out.println("관리자 강의 추가");

		// 입력 정보 받아오기

		String name = request.getParameter("name");
		String point = request.getParameter("point");

		HttpSession session = request.getSession();

		ProfessorVO profvo = (ProfessorVO) session.getAttribute("professor");

		// 입력할 데이터 값에 대한 객체 저장
		CourseVO covo = new CourseVO();
		covo.setCourseName(name);
		covo.setCoursePoint(Integer.parseInt(point));
		covo.setCourseProfessorNum(profvo.getProfessorNum());

		// 다음 화면에서 명시해줄 데이터 입력
//		covo.setCourseName(profvo.getProfessorName());
//		covo.setCourseProfessorMajor(profvo.getProfessorMajor());
	
		// DB연동
		CourseDAO codao = new CourseDAO();
		codao.addCourse(covo);
		
		
		return "professorInfo.do";
	
	}

}
