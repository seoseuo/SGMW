package com.ssk.web.controller.professor;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.board.BoardDAO;
import com.ssk.biz.board.BoardVO;
import com.ssk.biz.professor.ProfessorVO;
import com.ssk.web.controller.Controller;

public class ProfessorGetAdminBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("교수자 관리자 문의 리스트 이동");

		HttpSession session = request.getSession();
		ProfessorVO profvo = (ProfessorVO) session.getAttribute("professor");

		BoardDAO bdao = new BoardDAO();
		List<BoardVO> bdlist = bdao.professorWriteGetBoardList(profvo);
		
		System.out.println("list.size() : "+bdlist.size());
		
		request.setAttribute("boardList", bdlist);

		return "professor/professorGetAdminBoardList";

	}

}
