<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="WEB-INF/errors/error.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>강의 목록</title>
<link rel="stylesheet" href="../../../css/style.css" />
</head>

<body>
	<%@ include file="/WEB-INF/layout/studentHeader.jsp"%>

	<main>
		<div id="wrap">
			<div id="page-center-container">
				<div id="admin-info-container">
					<div class="grid-item">

						<div class="page-title">강의 정보</div>
						<table>
							<tr>
								<td rowspan="5" style="font-size: 130px;">📚</td>
								<td><b>${course.courseName}</b></td>
							</tr>
							<tr>
								<td><b>강의 교수자 : </b><a class="a-btn"
									href="/adminGetProfessor.do?professorNum=${course.courseProfessorNum}">${course.courseProfessorName}</a></td>
							</tr>
							<tr>
								<td><b>강의 전공 : </b>${course.courseProfessorMajor}</td>
							</tr>
							<tr>
								<td><b>강의 학점: </b>${course.coursePoint}</td>
							</tr>
						</table>

					</div>

					<div class="grid-item">
						<div class="page-title">수강 인원</div>

						<table id="w-table">
							<tr>
								<th>학생 번호</th>
								<th>학생 이름</th>
								<th>학생 소속 (전공)</th>
	
							</tr>

							<c:forEach var="enrollment" items="${enrollmentList}">
								<tr>
									<td>${enrollment.enrollmentStudentNum}</td>
									<td>${enrollment.enrollmentStudentName}</td>
									<td>${enrollment.enrollmentStudentMajor}</td>
								</tr>
							</c:forEach>
						</table>

					</div>

				</div>

			</div>
		</div>
	</main>

	<jsp:include page="/WEB-INF/layout/footer.jsp" />

</body>
</html>
