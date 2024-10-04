<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage="errors/error.jsp"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>학생 성적 관리 웹 - 교수자 정보</title>
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

						<!-- 내 정보 컴포넌트 -->
						<div class="page-title">교수자 정보</div>
						<table>
							<tr>
								<td rowspan="5" style="font-size: 130px;">👨🏻‍🏫</td>
								<td><b>${professor.professorName}</b></td>
							</tr>
							<tr>
								<td><b>교수자 교번: </b>${professor.professorNum}</td>
							</tr>
							<tr>
								<td><b>교수자 전화번호: </b>${professor.professorPhone}</td>
							</tr>
							<tr>
								<td><b>교수자 소속 (전공): </b>${professor.professorMajor}</td>
							</tr>
							<tr>
								<td><a
									href="/toAdminEditProfessor.do?professorNum=${professor.professorNum}">📝수정
										하기</a></td>
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
