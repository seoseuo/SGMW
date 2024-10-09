<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage="errors/error.jsp"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>학생 성적 관리 웹 - 학생 정보 등록</title>
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
						<div class="page-title">
							학생 정보 등록 <span class="input_warn">${num_warn}</span>
						</div>

						<form id="adminInsertStudent" action="/adminInsertStudent.do"
							method="post">
							<table>
								<tr>
									<td rowspan="6" style="font-size: 130px;">🧑🏻‍🎓</td>
									<td><b>학생 이름: </b> <input class="input-edit-info"
										type="text" id="name" name="name" placeholder="올바른 한글"
										value="${name}"> <br> <span class="input_warn"
										id="name_warn"></span></td>
								</tr>
								<tr>
									<td><b>학생 교번: </b> <input class="input-edit-info"
										type="text" id="num" name="num" placeholder="20******"
										value="${num}"> <br> <span class="input_warn"
										id="num_warn"></span></td>
								</tr>
								<tr>
									<td><b>학생 전화번호: </b> <input class="input-edit-info"
										type="text" id="phone" name="phone"
										placeholder="010-****-****" value="${phone}"><br>
										<span class="input_warn" id="phone_warn"></span></td>
								</tr>
								<tr>
									<td><b>학생 소속 (전공): </b> <input class="input-edit-info"
										type="text" id="major" name="major" placeholder="**학과"
										value="${major}"><br> <span class="input_warn"
										id="major_warn"></span></td>
								</tr>
								<tr>
									<td><input type="submit" value="✅등록 완료"></td>
								</tr>
							</table>
						</form>


					</div>

				</div>
			</div>
		</div>
	</main>

	<%@ include file="/WEB-INF/layout/footer.jsp"%>

</body>

</html>
