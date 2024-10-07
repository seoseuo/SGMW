package com.ssk.web.controller.professor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.board.BoardDAO;
import com.ssk.biz.board.BoardVO;
import com.ssk.biz.professor.ProfessorDAO;
import com.ssk.biz.professor.ProfessorVO;
import com.ssk.web.controller.Controller;

public class ProfessorInsertProfessorBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method
		System.out.println("교수자 문의 등록");
		
		// 입력 내용 가져오기
		
		String title = request.getParameter("title"); // 제목
		String content = request.getParameter("content"); // 내용
		
		
		// 객체 설정하기
		HttpSession session = request.getSession();
		ProfessorVO profvo = (ProfessorVO) session.getAttribute("professor");
		BoardVO bdvo = new BoardVO();
		
		bdvo.setBoardTitle(title);
		bdvo.setBoardContents(content);
		bdvo.setBoardFromNum(profvo.getProfessorNum());
		bdvo.setBoardToNum(profvo.getProfessorAdminNum());

		// 날짜 기입하기
		
		// 현재 날짜 가져오기
        LocalDate currentDate = LocalDate.now();
        
        // 날짜를 "YYYY-MM-DD" 형식으로 포맷하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = currentDate.format(formatter);
        
        bdvo.setBoardDate(date);
		
        // DB 연동
        
        BoardDAO bdao = new BoardDAO();
        bdao.insertBoard(bdvo);
		
		return "/professorGetAdminBoardList.do";
	}

}
