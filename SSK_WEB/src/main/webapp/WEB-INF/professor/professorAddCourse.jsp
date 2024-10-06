<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage="errors/error.jsp"%>


<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>학생 성적 관리 웹 - 강의 추가</title>
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

						<div class="page-title">강의 추가</div>
						<!-- 내 정보 컴포넌트 -->
						<form id="addCourse" action="/professorAddCourse.do" method="POST">
							<table>
								<tr>
									<td rowspan="5" style="font-size: 130px;">📚</td>
									<td><b>강의 이름: </b><input class="input-edit-info"
										type="text" id="name" name="name"
										placeholder="강의 이름을 입력하세요"><br>
									<span class="input_warn" id="name_warn"></span></td>

								</tr>

								<tr>
									<td><b>강의 학점: </b><input class="input-edit-info"
										type="text" id="point" name="point"
										placeholder="학점을 입력하세요"><br>
									<span class="input_warn" id="point_warn"></span></td>
								</tr>
								<tr>
									<td><input type="submit" value="✅ 강의 추가"></td>
								</tr>
							</table>
						</form>

					</div>



				</div>



			</div>

		</div>
		</div>
		</div>
	</main>

	<%@ include file="/WEB-INF/layout/footer.jsp"%>

</body>

</html>
