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

	<%
	// 세션에서 관리자 정보 가져오기.
	AdminVO vo = (AdminVO) session.getAttribute("admin");
	%>

	<main>
		<div id="wrap">
			<div id="page-center-container">
				<div id="admin-info-container">
					<div class="grid-item">

						<!-- 내 정보 컴포넌트 -->
						<table>
							<form id="adminEditInfo" method="post" action="/adminEditInfo.do">


								<div class="page-title">내 정보 수정</div>
								<tr>
									<td rowspan="5" style="font-size: 130px;">🧑🏻‍💻</td>
									<td><b>관리자 이름: </b><input class="input-edit-info"
										type="text" id="name" name="name" value="${admin.adminName}">
										<br> <span class="input_warn" id="name_warn"></span></td>
								</tr>
								<tr>
									<td><b>관리자 번호: </b>${admin.adminNum}</td>
								</tr>
								<tr>
									<td><b>관리자 전화번호: </b><input class="input-edit-info"
										type="text" id="phone" name="phone" value="${admin.adminPhone}">
										<br> <span class="input_warn" id="phone_warn"></span></td>
								</tr>
								<tr>
									<td><b>관리자 업무: </b>${admin.adminMajor}</td>
								</tr>
								<tr>
									<td><input type="submit" value="✅수정 완료"></td>
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
