<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="errors/error.jsp"%>



<!-- 모든 프론트 단 입력 유효성 검사 JS -->

<script src="<%=request.getContextPath()%>/js/adminEditInfo.js"></script>
<script src="<%=request.getContextPath()%>/js/adminEditUser.js"></script>
<script src="<%=request.getContextPath()%>/js/adminInsertProfessor.js"></script>
<script src="<%=request.getContextPath()%>/js/adminInsertStudent.js"></script>
<script src="<%=request.getContextPath()%>/js/professorEditMyClassGrade.js"></script>
<script src="<%=request.getContextPath()%>/js/editUser.js"></script>
<script src="<%=request.getContextPath()%>/js/addCourse.js"></script>

<!-- 각 클래스 import  -->

<%@ page import="com.ssk.biz.admin.AdminVO"%>
<%@ page import="com.ssk.biz.professor.ProfessorVO"%>
<%@ page import="com.ssk.biz.student.StudentVO"%>
<%@ page import="com.ssk.biz.board.BoardVO"%>
<%@ page import="com.ssk.biz.enrollment.EnrollmentVO"%>


<footer>
	<p>
		학생 성적 관리 웹 사이트<br /> 제작: 서승권<br /> 문의: <a
			href="mailto:seoseuo@naver.com"
			style="color: white; text-decoration: none;">seoseuo@naver.com</a><br />
		GitHub: <a href="https://github.com/seoseuo/SGMW" target="_blank"
			style="color: white; text-decoration: none;">https://github.com/seoseuo/SGMW</a>
	</p>
</footer>
