package com.ssk.web.controller.professor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.board.BoardVO;
import com.ssk.biz.course.CourseDAO;
import com.ssk.biz.course.CourseVO;
import com.ssk.biz.professor.ProfessorDAO;
import com.ssk.biz.professor.ProfessorVO;
import com.ssk.biz.student.StudentDAO;
import com.ssk.biz.student.StudentVO;
import com.ssk.web.controller.Controller;

public class ProfessorGetStudentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		ProfessorVO profvo = (ProfessorVO) session.getAttribute("professor");
		CourseDAO codao = new CourseDAO();

		System.out.println("교수자 학생 정보, "+profvo.getProfessorNum());
		
		// 학생 학번 가져오기
				String StudentNum = request.getParameter("studentNum");

				StudentVO stvo = new StudentVO();
				stvo.setStudentNum(StudentNum);

				StudentDAO stdao = new StudentDAO();
				StudentVO getstvo = stdao.getStudent(stvo);

				request.setAttribute("student", getstvo);

		return "professor/professorGetStudent";
	}

}
