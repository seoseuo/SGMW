<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage="errors/error.jsp"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>학생 성적 관리 웹 - 강의 목록</title>
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

						<div class="page-title">강의 검색</div><br>

						<form method="post" action="/adminSearchCourse.do">
							<input class="input-login" type="text" id="name" name="name"
								placeholder="강의의 이름을 입력하세요." value = "${search}">
						</form>

					</div>

					<div class="grid-item">

						<div class="page-title">개설 강의</div>

						<table id="w-table">
							<tr>
								<th>강의 번호</th>
								<th>강의 이름</th>
								<th>강의 교수자 번호</th>
								<th>강의 교수자 이름</th>
								<th>강의 교수자 소속 (전공)</th>
								<th>강의 학점</th>
							</tr>
							<!-- EL을 사용해 courseList를 반복 출력 -->
							<c:forEach var="course" items="${courseList}">
								<tr>
									<td>${course.courseNum}</td>
									<td><a class="a-btn"
										href="/adminGetCourse.do?courseNum=${course.courseNum}">${course.courseName}</a></td>


									<td>${course.courseProfessorNum}</td>
									<td>${course.courseProfessorName}</td>
									<!-- 교수자 이름 -->
									<td>${course.courseProfessorMajor}</td>
									<!-- 교수자 전공 -->
									<td>${course.coursePoint}</td>
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
