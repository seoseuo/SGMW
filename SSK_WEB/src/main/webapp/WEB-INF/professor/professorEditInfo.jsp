<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage="errors/error.jsp"%>


<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>학생 성적 관리 웹 - 교수자 정보 수정</title>
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

						<div class="page-title">교수자 정보 수정</div>
						<table>
							<form id="editUser" action="/professorEditinfo.do" method="post">
								<tr>
									<td rowspan="6" style="font-size: 130px;">👨🏻‍🏫</td>
									<td><b>교수자 이름: </b> <input class="input-edit-info"
										type="text" id="name" name="name"
										value="${professor.professorName}"> <br> <span
										class="input_warn" id="name_warn"></span></td>
								</tr>
								<tr>
									<td><b>교수자 교번: </b>${professor.professorNum}</td>
								</tr>
								<tr>
									<td><b>교수자 전화번호: </b> <input class="input-edit-info"
										type="text" id="phone" name="phone"
										value="${professor.professorPhone}"> <br> <span
										class="input_warn" id="phone_warn"></span></td>
								</tr>
								<tr>
									<td><b>교수자 소속 (전공): </b>${professor.professorMajor} <br>
									</td>
								</tr>
								<tr>
									<td><input type="submit" value="✅수정 완료"></td>
								</tr>
								<tr>

									</td>
								</tr>
							</form>
						</table>



					</div>

				</div>
			</div>
		</div>
	</main>

	<%@ include file="/WEB-INF/layout/footer.jsp"%>

</body>

</html>
