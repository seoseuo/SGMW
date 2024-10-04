package com.ssk.web.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssk.biz.professor.ProfessorDAO;
import com.ssk.biz.professor.ProfessorVO;
import com.ssk.biz.student.StudentDAO;
import com.ssk.biz.student.StudentVO;
import com.ssk.web.controller.Controller;

public class ToAdminEditStudentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// studentNum을 request에서 가져오기
		String num = request.getParameter("studentNum");

		// 학생 정보를 가져오기 위해 DAO 호출
		StudentDAO stDao = new StudentDAO();
		StudentVO stvo = new StudentVO();
		stvo.setStudentNum(num); // 학생 번호 설정

		System.out.println("학생 정보 수정 이동, " + num);

		// 학생 정보를 가져와서 request에 속성으로 설정
		StudentVO getStvo = stDao.getStudent(stvo);

		request.setAttribute("student", getStvo);

		return "admin/adminEditStudent";

	}

}
