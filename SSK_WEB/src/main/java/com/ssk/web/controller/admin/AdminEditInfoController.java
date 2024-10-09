package com.ssk.web.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.admin.AdminDAO;
import com.ssk.biz.admin.AdminVO;
import com.ssk.web.controller.Controller;

public class AdminEditInfoController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("관리자 정보 수정");
		// 1. 입력된 값 가져오기
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		// 2. 객체 설정
		HttpSession session = request.getSession();
		AdminVO vo = (AdminVO) session.getAttribute("admin");
		
		// 3, 변경 값으로 재 설정
		vo.setAdminName(name);
		vo.setAdminPhone(phone);
		
		// 3. db연동
		AdminDAO dao = new AdminDAO();
		dao.adminEditInfo(vo);
		
		// 4. 변경 정보 세선에 저장
		session.setAttribute("admin", vo);
		
		
		return "/adminInfo.do";
		
		
	}

}
