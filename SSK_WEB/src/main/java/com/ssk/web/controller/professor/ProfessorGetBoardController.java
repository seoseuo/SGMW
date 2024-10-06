package com.ssk.web.controller.professor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.board.BoardDAO;
import com.ssk.biz.board.BoardVO;
import com.ssk.biz.course.CourseDAO;
import com.ssk.biz.course.CourseVO;
import com.ssk.biz.enrollment.EnrollmentDAO;
import com.ssk.biz.enrollment.EnrollmentVO;
import com.ssk.biz.professor.ProfessorVO;
import com.ssk.web.controller.Controller;

public class ProfessorGetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		System.out.println("교수자 문의 조회");

		// 문의 번호 가져오기
		String num = request.getParameter("num");

		// 객체 설정
		BoardVO bdvo = new BoardVO();
		bdvo.setBoardNum(Integer.parseInt(num));

		// DB 연동
		BoardDAO bdao = new BoardDAO();
		BoardVO getBavo = bdao.getBoard(bdvo);

		// 객체 설정 후 포워딩
		request.setAttribute("board", getBavo);
		return "professor/professorGetBoard";
	}

}
