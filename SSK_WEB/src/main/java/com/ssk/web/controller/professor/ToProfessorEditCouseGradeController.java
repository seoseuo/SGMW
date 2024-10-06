package com.ssk.web.controller.professor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssk.biz.course.CourseDAO;
import com.ssk.biz.course.CourseVO;
import com.ssk.biz.enrollment.EnrollmentDAO;
import com.ssk.biz.enrollment.EnrollmentVO;
import com.ssk.web.controller.Controller;

public class ToProfessorEditCouseGradeController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		System.out.println("강의 성적 입력 이동");

		// 성적 입력할 강의 가져오기
		CourseVO covo = new CourseVO();
		covo.setCourseNum(Integer.parseInt(request.getParameter("courseNum")));
		CourseDAO codao = new CourseDAO();
		CourseVO getCovo = codao.getCourse(covo);
		// 수정할 학생 학번 가져오기
		String studentNum = request.getParameter("studentNum");
		
		
		// 수강 학생 X 점수 정보 가져오기
		EnrollmentDAO endao = new EnrollmentDAO();
		List<EnrollmentVO> enList = endao.getEnrollmentList(covo);
		
		
		// 학점 배정
		EnrollmentVO envo = new EnrollmentVO();
		envo.assignGrade(enList);

		// 객체저장 후 포워딩
		request.setAttribute("course", getCovo);
		request.setAttribute("enrollmentList", enList);
		request.setAttribute("studentNum", studentNum);
		return "professor/professorEditCourseGrade";
	}

}
