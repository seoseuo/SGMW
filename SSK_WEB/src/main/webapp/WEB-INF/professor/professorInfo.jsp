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
									href="/toProfessorEditInfo.do?professorNum=${professor.professorNum}">📝수정
										하기</a></td>
							</tr>
						</table>

						<!-- 나의 강의 내역 컴포넌트 -->
						<div class="page-title">나의 강의</div>
						<a class="a-btn" href="">⏏️강의 추가</a>

						<table id="w-table">
							<tr>
								<th>강의 번호</th>
								<th>강의 이름</th>
								<th>강의 교수자 소속 (전공)</th>
								<th>강의 학점</th>
							</tr>

							<c:choose>
								<c:when test="${empty courseList}">
									<tr>
										<td colspan="4" style="text-align: center;">등록된 강의가 없습니다.</td>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach var="course" items="${courseList}">
										<tr>
											<td>${course.courseNum}</td>
											<td><a class="a-btn" href="#">${course.courseName}</a></td>
											<td>${course.courseProfessorMajor}</td>
											<td>${course.coursePoint}</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>


						</table>

					</div>

					<div class="grid-item">
						<!-- 강의 문의 내역 컴포넌트 -->
						<div class="page-title">강의 문의 내역</div>
						<table id="w-table">
							<tr>
								<th>문의 번호</th>
								<th>문의자 이름</th>
								<th>문의 제목</th>
								<th>문의 날짜</th>
							</tr>
							<tr>
								<td>1</td>
								<td>이름이름</td>
								<td><a class="a-btn" href="#">수업 질문</a></td>
								<td>2024-10-02</td>
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
