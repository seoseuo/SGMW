package com.ssk.web.controller.professor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.board.BoardDAO;
import com.ssk.biz.board.BoardVO;
import com.ssk.biz.course.CourseDAO;
import com.ssk.biz.course.CourseVO;
import com.ssk.biz.professor.ProfessorDAO;
import com.ssk.biz.professor.ProfessorVO;
import com.ssk.web.controller.Controller;

public class ProfessorInfoController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		ProfessorVO profvo = (ProfessorVO) session.getAttribute("professor");
		CourseDAO codao = new CourseDAO();

		System.out.println("교수자 정보, "+profvo.getProfessorNum());
		
		// 강의 목록 가져오기

		
		List<CourseVO> colist = codao.getCourseList(profvo);
		request.setAttribute("courseList", colist);
		
		//  내가 받은 강의 문의 내역 가져오기
		
		BoardDAO bdao = new BoardDAO();
		List<BoardVO> bdlist = bdao.getBoardList(profvo);
		request.setAttribute("boardList", bdlist);

		return "professor/professorInfo";
	}

}
