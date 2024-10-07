package com.ssk.web.controller;

import java.util.HashMap;
import java.util.Map;

import com.ssk.web.controller.admin.AdminDeletStudentContoller;
import com.ssk.web.controller.admin.AdminDeleteProfessorController;
import com.ssk.web.controller.admin.AdminEditInfoController;
import com.ssk.web.controller.admin.AdminEditProfessorController;
import com.ssk.web.controller.admin.AdminEditStudentController;
import com.ssk.web.controller.admin.AdminGetBoardController;
import com.ssk.web.controller.admin.AdminGetCourseController;
import com.ssk.web.controller.admin.AdminGetCourseListController;
import com.ssk.web.controller.admin.AdminGetProfessorController;
import com.ssk.web.controller.admin.AdminGetProfessorListController;
import com.ssk.web.controller.admin.AdminGetStudentController;
import com.ssk.web.controller.admin.AdminGetStudentListController;
import com.ssk.web.controller.admin.AdminInfoController;
import com.ssk.web.controller.admin.AdminInsertProfessorController;
import com.ssk.web.controller.admin.AdminInsertStudentController;
import com.ssk.web.controller.admin.AdminMainController;
import com.ssk.web.controller.admin.AdminSearchCourseController;
import com.ssk.web.controller.admin.AdminSearchProfessorController;
import com.ssk.web.controller.admin.AdminSearchStudentController;
import com.ssk.web.controller.admin.ToAdminEditInfoController;
import com.ssk.web.controller.admin.ToAdminEditProfessorController;
import com.ssk.web.controller.admin.ToAdminEditStudentController;
import com.ssk.web.controller.admin.ToAdminInsertProfessorController;
import com.ssk.web.controller.admin.ToAdminInsertStudentController;
import com.ssk.web.controller.admin.ToAdminLoginController;
import com.ssk.web.controller.common.LoginController; // 올바른 패키지 경로 사용
import com.ssk.web.controller.common.LogoutController;
import com.ssk.web.controller.professor.ProfessorAddCourseController;
import com.ssk.web.controller.professor.ProfessorEditCourseGradeController;

import com.ssk.web.controller.professor.ProfessorEditInfoController;
import com.ssk.web.controller.professor.ProfessorGetBoardController;
import com.ssk.web.controller.professor.ProfessorGetCourseController;
import com.ssk.web.controller.professor.ProfessorGetCouseListController;
import com.ssk.web.controller.professor.ProfessorGetStudentController;
import com.ssk.web.controller.professor.ProfessorInfoController;
import com.ssk.web.controller.professor.ProfessorInsertProfessorBoardController;
import com.ssk.web.controller.professor.ProfessorSearchCouseController;
import com.ssk.web.controller.professor.ToProfessorAddCourseController;
import com.ssk.web.controller.professor.ToProfessorEditCouseGradeController;
import com.ssk.web.controller.professor.ToProfessorEditInfoController;
import com.ssk.web.controller.professor.ProfessorGetAdminBoardListController;
import com.ssk.web.controller.professor.ToProfessorLoginController;
import com.ssk.web.controller.professor.ToProfessorMainController;
import com.ssk.web.controller.student.ToStudentEditInfoController;
import com.ssk.web.controller.professor.professorDeleteCourseController;
import com.ssk.web.controller.student.StudentDeleteCourseController;
import com.ssk.web.controller.student.StudentEditInfoController;
import com.ssk.web.controller.student.StudentGetAdminBoardListController;
import com.ssk.web.controller.student.StudentGetBoardController;
import com.ssk.web.controller.student.StudentGetCourseController;
import com.ssk.web.controller.student.StudentGetCourseListController;
import com.ssk.web.controller.student.StudentGetProfessorBoardListController;
import com.ssk.web.controller.student.StudentInfoController;
import com.ssk.web.controller.student.StudentInsertBoardController;
import com.ssk.web.controller.student.StudentInsertCourseController;
import com.ssk.web.controller.student.StudentSearchCourseController;
import com.ssk.web.controller.student.ToStudentLoginController;
import com.ssk.web.controller.student.ToStudentMainController;

public class HandlerMapping {

	// Controller를 구현한 객체들을 저장하는 Map
	private Map<String, Controller> mappings;

	public HandlerMapping() {
		// Key-Value 형태로 수 많은 Controller를 등록합니다.
		mappings = new HashMap<String, Controller>();

		// 경로에 맞는 컨트롤러 등록

		// 관리자 로그인 이동
		// 교수자 로그인 이동
		// 학생 로그인 이동
		mappings.put("/toAdminLogin.do", new ToAdminLoginController());
		mappings.put("/toProfessorLogin.do", new ToProfessorLoginController());
		mappings.put("/toStudentLogin.do", new ToStudentLoginController());

		// 로그인
		mappings.put("/login.do", new LoginController());

		// 로그아
		mappings.put("/logout.do", new LogoutController());
		// 관리자 메인
		mappings.put("/adminMain.do", new AdminMainController());
		// 관리자 정보
		mappings.put("/adminInfo.do", new AdminInfoController());
		// 관리자 정보 수정 이동
		mappings.put("/toAdminEditInfo.do", new ToAdminEditInfoController());
		// 관리자 정보 수정
		mappings.put("/adminEditInfo.do", new AdminEditInfoController());
		// 교수자 조회
		mappings.put("/adminGetProfessorList.do", new AdminGetProfessorListController());
		// 학생 조회
		mappings.put("/adminGetStudentList.do", new AdminGetStudentListController());
		// 교수자 상세 조회
		mappings.put("/adminGetProfessor.do", new AdminGetProfessorController());
		// 학생 상세 조회
		mappings.put("/adminGetStudent.do", new AdminGetStudentController());
		// 교수자 정보 수정 이동
		mappings.put("/toAdminEditProfessor.do", new ToAdminEditProfessorController());
		// 교수자 정보 수정
		mappings.put("/adminEditProfessor.do", new AdminEditProfessorController());
		// 학생 정보 수정 이동
		mappings.put("/toAdminEditStudent.do", new ToAdminEditStudentController());
		// 학생 정보 수정
		mappings.put("/adminEditStudent.do", new AdminEditStudentController());
		// 교수자 검색
		mappings.put("/adminSearchProfessor.do", new AdminSearchProfessorController());
		// 학생 검색
		mappings.put("/adminSearchStudent.do", new AdminSearchStudentController());
		// 교수자 등록 이동
		mappings.put("/toAdminInsertProfessor.do", new ToAdminInsertProfessorController());
		// 교수자 등록
		mappings.put("/adminInsertProfessor.do", new AdminInsertProfessorController());
		// 학생 등록 이동
		mappings.put("/toAdminInsertStudent.do", new ToAdminInsertStudentController());
		// 교수자 등록
		mappings.put("/adminInsertStudent.do", new AdminInsertStudentController());
		// 교수자 정보 삭제
		mappings.put("/adminDeleteProfessor.do", new AdminDeleteProfessorController());
		// 교수자 정보 삭제
		mappings.put("/adminDeleteStudent.do", new AdminDeleteProfessorController());
		// 강의 목록
		mappings.put("/adminGetCourseList.do", new AdminGetCourseListController());
		// 강의 정보
		mappings.put("/adminGetCourse.do", new AdminGetCourseController());
		// 강의 검색
		mappings.put("/adminSearchCourse.do", new AdminSearchCourseController());
		// 관리자 문의 정보
		mappings.put("/adminGetBoard.do", new AdminGetBoardController());

		// 교수자 메인
		mappings.put("/toProfessorMain.do", new ToProfessorMainController());

		// 교수자 정보
		mappings.put("/professorInfo.do", new ProfessorInfoController());
		// 교수자 정보 수정 이동
		mappings.put("/toProfessorEditInfo.do", new ToProfessorEditInfoController());
		// 교수자 정보 수정
		mappings.put("/professorEditinfo.do", new ProfessorEditInfoController());
		// 교수자 강의 추가 이동
		mappings.put("/toProfessorAddCourse.do", new ToProfessorAddCourseController());
		// 교수자 강의 추가
		mappings.put("/professorAddCourse.do", new ProfessorAddCourseController());

		// 교수자 강의 조회
		mappings.put("/professorGetCourse.do", new ProfessorGetCourseController());
		// 교수자 학생 조회
		mappings.put("/professorGetStudent.do", new ProfessorGetStudentController());
		// 교수자 학생 조회
		mappings.put("/professorDeleteCourse.do", new professorDeleteCourseController());
		// 교수자 강의 목록
		mappings.put("/professorGetCourseList.do", new ProfessorGetCouseListController());
		// 교수자 강의 검색
		mappings.put("/professorSearchCourse.do", new ProfessorSearchCouseController());
		// 교수자 강의 수정
		mappings.put("/ToProfessorEditCourseGrade.do", new ToProfessorEditCouseGradeController());
		// 교수자 강의 수정
		mappings.put("/professorEditCourseGrade.do", new ProfessorEditCourseGradeController());
		// 교수자 관리자 문의 이동
		mappings.put("/professorGetAdminBoardList.do", new ProfessorGetAdminBoardListController());
		// 교수자 관리자 문의 상세 이동
		mappings.put("/professorGetBoard.do", new ProfessorGetBoardController());
		// 교수자 관리자 문의 상세 이동
		mappings.put("/professorInsertBoard.do", new ProfessorInsertProfessorBoardController());

		// 학생 메인
		mappings.put("/toStudentMain.do", new ToStudentMainController());
		// 학생 메인
		mappings.put("/studentInfo.do", new StudentInfoController());
		// 학생 정보 수정 이동
		mappings.put("/toStudentEditInfo.do", new ToStudentEditInfoController());
		// 학생 정보 수정
		mappings.put("/studentEditInfo.do", new StudentEditInfoController());
		// 학생 강의 목록
		mappings.put("/studentGetCourseList.do", new StudentGetCourseListController());
		// 학생 강의 상세 목록
		mappings.put("/studentGetCourse.do", new StudentGetCourseController());
		// 학생 강의 검색
		mappings.put("/studentSearchCourse.do", new StudentSearchCourseController());
		// 학생 수강 신청
		mappings.put("/studentInsertCourse.do", new StudentInsertCourseController());
		// 학생 수강 철회
		mappings.put("/studentDeleteCourse.do", new StudentDeleteCourseController());
		// 학생 수강 철회
		mappings.put("/studentGetProfessorBoardList.do", new StudentGetProfessorBoardListController());
		// 학생 문의 상세 조회
		mappings.put("/studentGetBoard.do", new StudentGetBoardController());
		// 학생 관리자 문의 리스트
		mappings.put("/studentGetAdminBoardList.do", new StudentGetAdminBoardListController());
		// 학생 문의 작성
		mappings.put("/studentInsertBoard.do", new StudentInsertBoardController());

	}

	public Controller getController(String path) {
		// Map에 등록된 Controller 중 특정 경로(path)에 해당하는 Controller를 리턴합니다.
		return mappings.get(path);
	}
}
