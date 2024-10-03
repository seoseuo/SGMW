package com.ssk.web.controller;

import java.util.HashMap;
import java.util.Map;

import com.ssamz.web.controller.user.DeleteBoardController;
import com.ssamz.web.controller.user.GetBoardController;
import com.ssamz.web.controller.user.GetBoardListController;
import com.ssamz.web.controller.user.InsertBoardController;
import com.ssamz.web.controller.user.InsertBoardViewController;
import com.ssamz.web.controller.user.InsertUserController;
import com.ssamz.web.controller.user.InsertUserViewController;
import com.ssamz.web.controller.user.LoginController;
import com.ssamz.web.controller.user.LoginViewController;
import com.ssamz.web.controller.user.LogoutController;
import com.ssamz.web.controller.user.UpdateBoardController;

public class HandlerMapping {
	
	// Controller를 구현한 객체들을 저장하는 Map
	private Map<String, Controller> mappings;

	public HandlerMapping() {
		//super();
		// TODO Auto-generated constructor stub
		// Key-Value 형태로 수 많은 Controller를 등록합니다.
		mappings = new HashMap<String, Controller>();
		// 회원 가입
		mappings.put("/insertUserView.do", new InsertUserViewController());
		mappings.put("/insertUser.do", new InsertUserController());
		// 로그인
		mappings.put("/loginView.do", new LoginViewController());
		mappings.put("/login.do", new LoginController());
		// 글 목록
		mappings.put("/getBoardList.do", new GetBoardListController());
		// 글 상세 조회
		mappings.put("/getBoard.do", new GetBoardController());
		// 글 등록
		mappings.put("/insertBoardView.do", new InsertBoardViewController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		// 글 수정
		mappings.put("/updateBoard.do", new UpdateBoardController());
		// 글 삭제
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		// 로그아웃
		mappings.put("/logout.do", new LogoutController());
		
	}
	
	public Controller getController(String path) {
		// Map에 등록된 Controller등 중에서
		// 특정 경로(path)에 해당하는  Controller를 리턴합니다.
		return mappings.get(path);
	}
	

}
