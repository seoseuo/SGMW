<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage="errors/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>학생 성적 관리 웹 - 강의 성적 입력</title>
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
								<td rowspan="4" style="font-size: 130px;">📚</td>
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
						</table>

					</div>

					<div class="grid-item">
						<div class="page-title">수강 인원</div>

						<form id="professorEditCourseGrade" method="post"
							action="/professorEditCourseGrade.do">
							<c:if
								test="${professor.professorNum == course.courseProfessorNum}">
								<table id="w-table">
									<tr>
										<th>학생 번호</th>
										<th>학생 이름</th>
										<th>학생 전화번호</th>
										<th>학생 소속 (전공)</th>
										<th>중간고사</th>
										<th>기말고사</th>
										<th>합계</th>
										<th>학점</th>
									</tr>
									<c:forEach var="enrollment" items="${enrollmentList}">
										<tr>
											<td>${enrollment.enrollmentStudentNum}</td>
											<td>${enrollment.enrollmentStudentName}</td>
											<td>${enrollment.enrollmentStudentPhone}</td>
											<td>${enrollment.enrollmentStudentMajor}</td>

											<c:choose>
												<c:when
													test="${enrollment.enrollmentStudentNum == studentNum}">
													<td><input class="input-edit-grade" type="text"
														id="middleGrade"
														name="middleGrade_${enrollment.enrollmentStudentNum}"
														value="${enrollment.enrollmentMiddle}"><br> <span
														class="input_warn"
														id="middleGrade_warn_${enrollment.enrollmentStudentNum}"></span></td>

													<td><input class="input-edit-grade" type="text"
														id="finalGrade"
														name="finalGrade_${enrollment.enrollmentStudentNum}"
														value="${enrollment.enrollmentFinal}"><br> <span
														class="input_warn"
														id="finalGrade_warn_${enrollment.enrollmentStudentNum}"></span></td>

													<td>${enrollment.enrollmentStudentSum}</td>
													<td><b>${enrollment.enrollmentStudentGrade}</b></td>
													<td><input type="submit" value="✅입력 완료"></td>
													<td><input type="hidden" id="studentNum"
														name="studentNum"
														value="${enrollment.enrollmentStudentNum}"></td>
													<td><input type="hidden" id="courseNum"
														name="courseNum" value="${course.courseNum}"></td>
												</c:when>
												<c:otherwise>
													<td>${enrollment.enrollmentMiddle}</td>
													<td>${enrollment.enrollmentFinal}</td>
													<td>${enrollment.enrollmentStudentSum}</td>
													<td><b>${enrollment.enrollmentStudentGrade}</b></td>
													<td></td>
													<td></td>
												</c:otherwise>
											</c:choose>
										</tr>
									</c:forEach>
								</table>
							</c:if>

							<c:if
								test="${professor.professorNum != course.courseProfessorNum}">
								<p>해당 교수자 외에는 열람할 수 없는 페이지입니다.</p>
							</c:if>



						</form>
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
