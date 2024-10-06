package com.ssk.web.controller.professor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.enrollment.EnrollmentDAO;
import com.ssk.biz.enrollment.EnrollmentVO;
import com.ssk.biz.professor.ProfessorDAO;
import com.ssk.biz.professor.ProfessorVO;
import com.ssk.web.controller.Controller;

public class ProfessorEditCourseGradeController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("강의 정보 성적 입력");

		// 수정 값 받아오기
		String courseNum = request.getParameter("courseNum");
		String studentNum = request.getParameter("studentNum");
		String middleGrade = request.getParameter("middleGrade");
		String finalGrade = request.getParameter("finalGrade");
		

//		System.out.println(courseNum);
//		System.out.println(studentNum);
//		System.out.println(middleGrade);
//		System.out.println(finalGrade);

		
		// 객체 설정하기
		EnrollmentVO envo = new EnrollmentVO();
		envo.setEnrollmentCourseNum(Integer.parseInt(courseNum));
		envo.setEnrollmentStudentNum(studentNum);
		envo.setEnrollmentMiddle(Integer.parseInt(middleGrade));
		envo.setEnrollmentFinal(Integer.parseInt(finalGrade));
		
		System.out.println(envo.toString());
		
		// 점수 정보 수정하기
		EnrollmentDAO endao = new EnrollmentDAO();
		
		
		// DB 연동
		endao.editEnrollment(envo);
		
		// 객체 정보 설정 후 포워딩
		request.setAttribute("num", courseNum);
		return "/professorGetCourse.do?num=" + courseNum;
	}

}
