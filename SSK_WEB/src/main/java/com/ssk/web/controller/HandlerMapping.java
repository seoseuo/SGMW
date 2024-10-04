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
import com.ssk.web.controller.common.LoginController; // 올바른 패키지 경로 사용
import com.ssk.web.controller.common.LogoutController;

public class HandlerMapping {

	// Controller를 구현한 객체들을 저장하는 Map
	private Map<String, Controller> mappings;

	public HandlerMapping() {
		// Key-Value 형태로 수 많은 Controller를 등록합니다.
		mappings = new HashMap<String, Controller>();

		// 경로에 맞는 컨트롤러 등록

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
	}

	public Controller getController(String path) {
		// Map에 등록된 Controller 중 특정 경로(path)에 해당하는 Controller를 리턴합니다.
		return mappings.get(path);
	}
}
