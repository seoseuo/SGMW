package com.ssk.web.controller.student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssk.biz.board.BoardDAO;
import com.ssk.biz.board.BoardVO;
import com.ssk.biz.course.CourseDAO;
import com.ssk.biz.course.CourseVO;
import com.ssk.biz.professor.ProfessorVO;
import com.ssk.biz.student.StudentDAO;
import com.ssk.biz.student.StudentVO;
import com.ssk.web.controller.Controller;

public class StudentInsertBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("학생 문의 등록");

		// 입력 값 받아오기

		// 입력 내용 가져오기

		String title = request.getParameter("title"); // 제목
		String content = request.getParameter("content"); // 내용
		String courseNum = request.getParameter("courseNum"); // 강의 번호
		
		System.out.println("Course Num : "+courseNum);

		// 객체 설정하기
		HttpSession session = request.getSession();
		StudentVO stvo = (StudentVO) session.getAttribute("student");
		BoardVO bdvo = new BoardVO();

		bdvo.setBoardTitle(title);
		bdvo.setBoardContents(content);
		bdvo.setBoardFromNum(stvo.getStudentNum());

		// courseNum 이 있다면 교수자로, 없다면 admin으로 boardToNum을 설정한다.
		if (courseNum!=null) { // 강의 선택 안함
			
			CourseDAO codao = new CourseDAO();
			CourseVO covo = new CourseVO();

			covo.setCourseNum(Integer.parseInt(courseNum));
			CourseVO getCovo = codao.getCourse(covo);

			bdvo.setBoardToNum(getCovo.getCourseProfessorNum());
		} 
		
		else {
			bdvo.setBoardToNum(stvo.getStudentAdminNum());
		}

		// 날짜 기입하기

		// 현재 날짜 가져오기
		LocalDate currentDate = LocalDate.now();

		// 날짜를 "YYYY-MM-DD" 형식으로 포맷하기
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date = currentDate.format(formatter);

		bdvo.setBoardDate(date);

		//System.out.println(bdvo.toString());

		// DB 연동

		BoardDAO bdao = new BoardDAO();
		bdao.insertBoard(bdvo);

		if (courseNum != null) {
			return "/studentGetProfessorBoardList.do";
		} else {
			return "/studentGetAdminBoardList.do";
		}
		// 2가지로

	}

}
