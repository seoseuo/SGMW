//package com.ssk.web.controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.ssamz.biz.board.BoardDAO;
//import com.ssamz.biz.board.BoardVO;
//import com.ssamz.biz.user.UserDAO;
//import com.ssamz.biz.user.UserVO;
//
///**
// * Servlet implementation class DispatcherServlet
// */
////@WebServlet("*.do")
//public class DispatcherServletBackup extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//
//	/**
//	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		// 1. 사용자 요청 path를 추출합니다.
//		String uri = request.getRequestURI();
//		String path = uri.substring(uri.lastIndexOf("/"));
//		
//		//2. 추출된 path 정보에 따라 요청을 분기 처리합니다.
//		if (path.equals("/login.do")) {
//			System.out.println("로그인 처리");
//			
//			// 1. 사용자 입력 정보 추출
//			String id = request.getParameter("id");
//			String password = request.getParameter("password");
//			
//			// 2. DB 연동 처리
//			UserVO vo =  new UserVO();
//			vo.setId(id);
//			
//			UserDAO dao = new UserDAO();
//			UserVO user = dao.getUser(vo);
//			
//			
//			// 3. 화면 이동
//			HttpSession session = request.getSession();
//			
//			if (user != null && user.getPassword().equals(password)) {
//				
//				// 상태 정보를 세션에 저장합니다.
//				session.setAttribute("user", user);
//				
//				// 글 목록 화면으로 이동합니다.
//				RequestDispatcher dispatcher = request.getRequestDispatcher("/getBoardList.do");
//				dispatcher.forward(request, response);
//			} else {
//				RequestDispatcher dispatcher = request.getRequestDispatcher("/loginView.do");
//				dispatcher.forward(request, response);
//				
//			}
//			
//		} else if (path.equals("/insertUser.do")) {
//			System.out.println("회원가입 처리");
//			
//			// 1. 사용자 입력 정보 추출
//			String id = request.getParameter("id");
//			String password = request.getParameter("password");
//			String name = request.getParameter("name");
//			String role = request.getParameter("role");
//			
//			// 2. DB 연동 처리
//			UserVO vo = new UserVO();
//			vo.setId(id);
//			vo.setPassword(password);
//			vo.setName(name);
//			vo.setRole(role);
//			
//			UserDAO dao = new UserDAO();
//			dao.insertUser(vo);
//			
//			// 3. 화면 이동
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/");
//			dispatcher.forward(request, response);
//			
//		} else if (path.equals("/logout.do")) {
//			System.out.println("로그아웃 처리");
//			
//			HttpSession session = request.getSession();
//			session.invalidate();
//			
//			response.sendRedirect("/");
//		
//		} else if (path.equals("/insertBoard.do")) {
//			System.out.println("글 등록 처리");
//			
//			// 1. 사용자 입력 정보 추출
//			String title = request.getParameter("title");
//			String writer = request.getParameter("writer");
//			String content = request.getParameter("content");
//			
//			// 2. DB 연동 처리
//			BoardVO vo = new BoardVO();
//			vo.setTitle(title);
//			vo.setWriter(writer);
//			vo.setContent(content);
//			
//			BoardDAO boardDAO = new BoardDAO();
//			boardDAO.insertBoard(vo);
//			
//			// 3. 화면 이동
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/getBoardList.do");
//			dispatcher.forward(request, response);
//			
//		} else if (path.equals("/getBoard.do")) {
//			System.out.println("글 상세 조회 처리");
//			
//			// 1. 사용자 입력 정보 추출
//			String seq = request.getParameter("seq");
//			
//			// 2. DB 연동 처리
//			BoardVO vo = new BoardVO();
//			vo.setSeq(Integer.parseInt(seq));
//			
//			BoardDAO boardDAO = new BoardDAO();
//			BoardVO board = boardDAO.getBoard(vo);
//			
//			// 3. 화면 이동
//			request.setAttribute("board", board);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/getBoard.jsp");
//			dispatcher.forward(request, response);
//		
//			
//		} else if (path.equals("/updateBoard.do")) {
//			System.out.println("글 수정 처리");
//			
//			// 1. 사용자 입력 정보 추출
//			String seq = request.getParameter("seq");
//			String title = request.getParameter("title");
//			String content = request.getParameter("content");
//			
//			// 2. DB 연동 처리
//			BoardVO vo = new BoardVO();
//			vo.setSeq(Integer.parseInt(seq));
//			vo.setTitle(title);
//			vo.setContent(content);
//			
//			BoardDAO boardDAO = new BoardDAO();
//			boardDAO.updateBoard(vo);
//			
//			// 3. 화면 이동
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/getBoardList.do");
//			dispatcher.forward(request, response);
//			
//		} else if (path.equals("/deleteBoard.do")) {
//			System.out.println("글 삭제 처리");
//			
//			// 1. 사용자 입력 정보 추출
//			String seq = request.getParameter("seq");
//			
//			// 2. DB 연동 처리
//			BoardVO vo = new BoardVO();
//			vo.setSeq(Integer.parseInt(seq));
//			
//			BoardDAO boardDAO = new BoardDAO();
//			boardDAO.deleteBoard(vo);
//			
//			// 3. 화면 이동
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/getBoardList.do");
//			dispatcher.forward(request, response);
//			
//		} else if (path.equals("/getBoardList.do")) {
//			System.out.println("글 목록 검색 처리");
//			
//			// 1. 사용자 입력 정보 추출
//			String searchCondition = request.getParameter("searchCondition");
//			String searchKeyword = request.getParameter("searchKeyword");
//			
//			// Null Check
//			if (searchCondition == null) {
//				searchCondition = "TITLE";
//			}
//			
//			if (searchKeyword == null) {
//				searchKeyword = "";
//			}
//			
//			// 세션에 검색 관련 정보를 저장합니다.
//			HttpSession session = request.getSession();
//			session.setAttribute("condition", searchCondition);
//			session.setAttribute("keyword", searchKeyword);
//			
//			//System.out.println("condition: " + searchCondition);
//			//System.out.println("keyword: " + searchKeyword);
//
//			// 2. DB 연동 처리
//			BoardVO vo = new BoardVO();
//			vo.setSearchCondition(searchCondition);
//			vo.setSearchKeyword(searchKeyword);
//			
//			BoardDAO dao = new BoardDAO();
//			List<BoardVO> boardList = dao.getBoardList(vo);
//			
//			// 3. 화면 이동
//			request.setAttribute("boardList", boardList);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/getBoardList.jsp");
//			dispatcher.forward(request, response);
//			
//		} else if (path.equals("/insertUserView.do")) {
//			System.out.println("회원가입 화면으로 이동");
//			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/insertUser.jsp");
//			dispatcher.forward(request, response);
//			
//		} else if (path.equals("/loginView.do")) {
//			System.out.println("로그인 화면으로 이동");
//			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/login.jsp");
//			dispatcher.forward(request, response);
//			
//		} else if (path.equals("/insertBoardView.do")) {
//			System.out.println("글 등록 화면으로 이동");
//			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/insertBoard.jsp");
//			dispatcher.forward(request, response);
//			
//		}
//		
//		
//		
//		
//		
//	}
//
//}
