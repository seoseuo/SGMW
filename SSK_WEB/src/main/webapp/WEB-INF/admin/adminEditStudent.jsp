<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage="errors/error.jsp"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>학생 성적 관리 웹 - 학생 정보 수정</title>
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

						<div class="page-title">학생 정보 수정</div>
						<table>
							<form id="adminEditUser"
								action="/adminEditStudent.do?num=${student.studentNum}"
								method="post">
								<tr>
									<td rowspan="6" style="font-size: 130px;">🧑🏻‍🎓</td>
									<td><b>학생 이름: </b> <input class="input-edit-info"
										type="text" id="name" name="name"
										value="${student.studentName}"> <br> <span
										class="input_warn" id="name_warn"></span></td>
								</tr>
								<tr>
									<td><b>학생 학번: </b>${student.studentNum}</td>
								</tr>
							<tr>
								<td><b>학생 전화번호: </b> <input class="input-edit-info"
									type="text" id="phone" name="phone"
									value="${student.studentPhone}"> <br> <span
									class="input_warn" id="phone_warn"></span></td>
							</tr>
							<tr>
								<td><b>학생 소속 (전공): </b> <input class="input-edit-info"
									type="text" id="major" name="major"
									value="${student.studentMajor}"> <br> <span
									class="input_warn" id="major_warn"></span></td>
							</tr>
							<tr>
								<td><input type="submit" value="✅수정 완료"></td>
							</tr>
							<tr>
								<td><a href="/adminDeleteStudent.do?num=${student.studentNum}" id="deleteButton"> <input type="button"
										value="❌삭제">
								</a></td>
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
