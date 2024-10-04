package com.ssk.web.controller.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.admin.AdminDAO;
import com.ssk.biz.admin.AdminVO;
import com.ssk.web.controller.Controller;

public class LoginController implements Controller {

	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	    

	    // 1. 입력 정보 추출
	    String num = request.getParameter("num");
	    String password = request.getParameter("password");
	    
	    System.out.println("입력 번호 : "+num);
	    System.out.println("입력 비밀번호 : "+password);

	    // 2. num 길이에 따라 어느 사용자로 로그인 할 것인지 결정
	    // 관리자 6자리 , 교수자 7자리, 학생 8자리

	    if (num.length() < 7) {
	        System.out.println("관리자 로그인");
	        AdminVO vo = new AdminVO();
	        
	        vo.setAdminNum(num);
	        vo.setAdminPassword(password);

	        // 3. 데이터베이스 연동
	        AdminDAO dao = new AdminDAO();
	        AdminVO loginVo = dao.adminLogin(vo);

	        HttpSession session = request.getSession();

	        if (loginVo != null && loginVo.getAdminPassword().equals(password)) {
	            System.out.println("로그인 성공!");

	            // 사용자 정보를 세션에 저장
	            session.setAttribute("admin", loginVo);

	            return "admin/adminMain";

	        } else {
	            System.out.println("로그인 실패, 아이디 혹은 비밀번호 오류.");

	            // 로그인 실패 시 alert 띄우고 다시 로그인 페이지로 돌아가도록 처리
	            try {
	                response.setContentType("text/html;charset=UTF-8");
	                PrintWriter out = response.getWriter();
	                out.println("<script>alert('로그인 실패, 아이디 혹은 비밀번호 오류입니다.'); history.back();</script>");
	                out.flush();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }

	            return "index";  // 로그인 실패 시에는 다른 페이지로 리다이렉트하지 않고, 현재 상태로 유지
	        }

	    } else if (num.length() == 7) {
	        System.out.println("교수자 로그인");
	        // 교수자 로그인 처리 로직 추가

	    } else {
	        System.out.println("학생 로그인");
	        // 학생 로그인 처리 로직 추가
	    }

	    return "index";  // 기본적으로 null 반환, 상황에 맞는 페이지로 리턴할 수 있음
	}
}