<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage="errors/error.jsp"%>

<%
System.out.println("adminGetCourse.jsp");
%>
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

	<%@ include file="/WEB-INF/layout/adminHeader.jsp"%>

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
									<td><a class="a-btn"
										href="/adminGetStudent.do?studentNum=${enrollment.enrollmentStudentNum}">${enrollment.enrollmentStudentName}</a></td>
									<td>${enrollment.enrollmentStudentPhone}</td>
									<td>${enrollment.enrollmentStudentMajor}</td>
									<td>${enrollment.enrollmentMiddle}</td>
									<td>${enrollment.enrollmentFinal}</td>
									<td>${enrollment.enrollmentStudentSum}</td>
									<td><b>${enrollment.enrollmentStudentGrade}</b></td>
								</tr>
							</c:forEach>
						</table>

					</div>

				</div>

			</div>
		</div>
	</main>

	<%@ include file="/WEB-INF/layout/footer.jsp"%>

</body>

</html>
