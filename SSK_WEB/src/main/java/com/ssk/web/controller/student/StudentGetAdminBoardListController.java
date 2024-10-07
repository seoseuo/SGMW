package com.ssk.web.controller.student;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.board.BoardDAO;
import com.ssk.biz.board.BoardVO;
import com.ssk.biz.student.StudentVO;
import com.ssk.web.controller.Controller;

public class StudentGetAdminBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("관리자 문의 리스트 이동");

		HttpSession session = request.getSession();
		StudentVO stvo = (StudentVO) session.getAttribute("student");

		BoardDAO bdao = new BoardDAO();
		List<BoardVO> bdlist = bdao.studentWriteGetBoardList(stvo);
		request.setAttribute("boardList", bdlist);

		System.out.println(bdlist.toString());
		
		
		Iterator<BoardVO> iterator = bdlist.iterator(); // Iterator 생성

		//관리자에게 문의 했기 때문애 교번의 길이가 7인 교수자 문의는 잘라낸다.
		while (iterator.hasNext()) {
			BoardVO bdvo = iterator.next(); // 다음 요소 가져오기
			if (bdvo.getBoardToNum().length() == 7) {
				iterator.remove(); // 길이가 6인 경우 삭제
			}
		}
		

		// 객체 저장 후 포워딩
		request.setAttribute("boardList", bdlist);

		return "student/studentGetAdminBoardList";
	}

}
