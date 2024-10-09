<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage="errors/error.jsp"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>학생 성적 관리 웹 - 학생 목록</title>
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

						<div class="page-title">👩🏻‍🎓학생 검색</div>
						<br>
						<form method="post" action="/adminSearchStudent.do">
							<input class="input-login" type="text" id="num" name="num"
								value="${search}" placeholder="학생의 학번을 입력하세요.">
						</form>

					</div>

					<div class="grid-item">

						<div class="page-title">🧑🏻‍🎓학생 목록</div>

						<table id="w-table">
							<tr>
								<th>학생 번호</th>
								<th>학생 이름</th>
								<th>학생 전화번호</th>
								<th>학생 소속 (전공)</th>

							</tr>
							<!-- JSTL을 사용하여 학생 목록 반복 출력 -->
							<c:forEach var="student" items="${studentList}">
								<tr>
									<td>${student.studentNum}</td>
									<td><a class="a-btn"
										href="/adminGetStudent.do?studentNum=${student.studentNum}">${student.studentName}</a></td>
									<td>${student.studentPhone}</td>
									<td>${student.studentMajor}</td>

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
