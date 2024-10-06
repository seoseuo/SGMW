<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage="errors/error.jsp"%>


<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>학생 성적 관리 웹 - 학생 정보</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
</head>

<body>

	<%@ include file="/WEB-INF/layout/professorHeader.jsp"%>

	<main>
		<div id="wrap">
			<div id="page-center-container">
				<div id="admin-info-container">
					<div class="grid-item">

						<!-- 내 정보 컴포넌트 -->
						<div class="page-title">학생 정보</div>
						<table>
							<tr>
								<td rowspan="4" style="font-size: 130px;">🧑🏻‍🎓</td>
								<td><b>${student.studentName}</b></td>
							</tr>
							<tr>
								<td><b>학생 학번: </b>${student.studentNum}</td>
							</tr>
							<tr>
								<td><b>학생 전화번호: </b>${student.studentPhone}</td>
							</tr>
							<tr>
								<td><b>학생 소속 (전공): </b>${student.studentMajor}</td>
							</tr>

						</table>

					</div>

				</div>
			</div>
		</div>
	</main>

	<%@ include file="/WEB-INF/layout/footer.jsp"%>

</body>

</html>
