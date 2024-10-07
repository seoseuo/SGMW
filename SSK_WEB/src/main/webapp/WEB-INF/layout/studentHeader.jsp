<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 모든 JSP 파일에게 적용하기 위하 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<!-- 학생 헤더 -->
<header class="header-container">
    <div class="admin-header-container">
      <a href="/toStudentMain.do" class="header-item">🎓</a>
      <a href="/studentInfo.do" class="header-item">내 정보</a>
      <a href="/studentGetCourseList.do" class="header-item">개설 강의</a>
      <a href="/studentGetProfessorBoardList.do" class="header-item">강의 문의</a>
      <a href="/studentGetAdminBoardList.do" class="header-item">관리자 문의</a>
      <a href="/logout.do" class="header-item">로그아웃</a>
  </div>    
</header>