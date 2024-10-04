<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage="errors/error.jsp"%>

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
						<!-- 내 정보 컴포넌트 -->
						<table>

							<tr>
								<td rowspan="5" style="font-size: 130px;">📚</td>
								<td><b>[강의 이름]</b></td>
							</tr>
							<tr>
								<td><b>강의 교수자 : </b><a class="a-btn" href="#">[강의 교수자]</a></td>
							</tr>
							<tr>
								<td><b>강의 전공 : </b>[강의 전공]</td>
							</tr>
							<tr>
								<td><b>강의 학점: </b>[강의 학점]</td>
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
								<th>학생 관리자</th>
								<th>중간고사</th>
								<th>기말고사</th>
								<th>합계</th>
								<th>학점</th>
							</tr>
							<tr>
								<td>1</td>
								<td><a class="a-btn" href="#">홍길동</a></td>
								<td>010-1234-5678</td>
								<td>컴퓨터 공학과</td>
								<td>김철수</td>
								<td>85</td>
								<td>90</td>
								<td>175</td>
								<td>A</td>
							</tr>
						</table>

					</div>



				</div>

			</div>
		</div>
		</div>
	</main>


	<%@ include file="/WEB-INF/layout/footer.jsp"%>

</body>

</html>
