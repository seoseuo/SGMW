<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage="errors/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>학생 성적 관리 웹 - 강의 정보</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
</head>

<body>

	<header>
		<!-- 공통 헤더 영역 -->
		<%@ include file="/WEB-INF/layout/professorHeader.jsp"%>
	</header>

	<main>
		<div id="wrap">
			<div id="page-center-container">
				<div id="admin-info-container">
					<div class="grid-item">

						<div class="page-title">강의 정보</div>

						<!-- 강의 정보 테이블 -->
						<table>
							<tr>
								<td rowspan="5" style="font-size: 130px;">📚</td>
								<td><b>강의 이름:</b> ${course.courseName}</td>
							</tr>
							<tr>
								<td><b>강의 교수자 :</b> ${course.courseProfessorName}</td>
							</tr>
							<tr>
								<td><b>강의 전공 :</b> ${course.courseProfessorMajor}</td>
							</tr>
							<tr>
								<td><b>강의 학점 :</b> ${course.coursePoint}</td>
							</tr>
							<tr>
								<td><c:if
										test="${course.courseProfessorNum == professor.professorNum}">
										<a class="a-btn"
											href="/professorDeleteCourse.do?num=${course.courseNum}">❌
											강의 삭제</a>
									</c:if></td>
							</tr>
						</table>


					</div>

					<div class="grid-item">
						<div class="page-title">수강 인원</div>
						
						<c:if
							test="${course.courseProfessorNum == professor.professorNum}">
						</c:if>

						<table id="w-table">
							<tr>
								<th>학생 번호</th>
								<th>학생 이름</th>
								<th>학생 전화번호</th>
								<th>학생 소속 (전공)</th>
								<c:if
									test="${course.courseProfessorNum == professor.professorNum}">
									<th>중간고사</th>
									<th>기말고사</th>
									<th>합계</th>
									<th>학점</th>
								</c:if>
							</tr>

							<c:forEach var="enrollment" items="${enrollmentList}">
								<tr>
									<td>${enrollment.enrollmentStudentNum}</td>
									<td><a class="a-btn"
										href="/professorGetStudent.do?studentNum=${enrollment.enrollmentStudentNum}">${enrollment.enrollmentStudentName}</a></td>
									<td>${enrollment.enrollmentStudentPhone}</td>
									<td>${enrollment.enrollmentStudentMajor}</td>
									<c:if
										test="${course.courseProfessorNum == professor.professorNum}">
										<td>${enrollment.enrollmentMiddle}</td>
										<td>${enrollment.enrollmentFinal}</td>
										<td>${enrollment.enrollmentStudentSum}</td>
										<td><b>${enrollment.enrollmentStudentGrade}</b></td>
										<td><a class="a-btn" href="/ToProfessorEditCourseGrade.do?courseNum=${course.courseNum}&studentNum=${enrollment.enrollmentStudentNum}">✏️수정</a>
									</c:if>
								</tr>
							</c:forEach>
						</table>


					</div>

				</div>
			</div>
		</div>
	</main>

	<!-- 공통 푸터 영역 -->
	<footer>
		<%@ include file="/WEB-INF/layout/footer.jsp"%>
	</footer>

</body>

</html>
