package com.ssk.web.controller.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssk.biz.board.BoardDAO;
import com.ssk.biz.board.BoardVO;
import com.ssk.web.controller.Controller;

public class StudentGetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("학생 문의 상세 조회");

		String num = request.getParameter("num");

		// 객체 설정
		BoardVO bdvo = new BoardVO();
		bdvo.setBoardNum(Integer.parseInt(num));

		// DB 연동
		BoardDAO bdao = new BoardDAO();
		BoardVO getBavo = bdao.getBoard(bdvo);

		// 객체 설정 후 포워딩
		request.setAttribute("board", getBavo);

		return "student/studentGetBoard";
	}

}
