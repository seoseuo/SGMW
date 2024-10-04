package com.ssk.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.admin.AdminVO;
import com.ssk.biz.board.BoardDAO;
import com.ssk.biz.board.BoardVO;
import com.ssk.web.controller.Controller;

public class AdminInfoController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		System.out.println("관리자 정보");

		// 문의 내역 가져오기
		BoardDAO bdao = new BoardDAO();

		HttpSession session = request.getSession();

		AdminVO advo = (AdminVO) session.getAttribute("admin");
		
		
		List<BoardVO> bdlist = bdao.getBoardList(advo);

		request.setAttribute("boardList", bdlist);
		return "admin/adminInfo";
	}

}
