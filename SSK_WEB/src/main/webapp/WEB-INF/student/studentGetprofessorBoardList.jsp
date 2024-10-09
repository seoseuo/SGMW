<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="WEB-INF/errors/error.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>학생 성적 관리 웹 - 강의 문의</title>
<link rel="stylesheet" href="../../../css/style.css" />
</head>

<body>
	<%@ include file="/WEB-INF/layout/studentHeader.jsp"%>

	<main>
		<div id="wrap">
			<div id="page-center-container">
				<div id="admin-info-container">
					<div class="grid-item">

						<!-- 내 정보 컴포넌트 -->
						<div class="page-title">강의 문의</div>
						<form id="insertBoard" action="/studentInsertBoard.do"
							method="POST">
							<br> <label for="title"><b>제목</b></label><br> <input
								class="input-login" type="text" id="title" name="title"
								placeholder="제목을 입력하세요."> <br> <br> <b>강의</b>
								
							<select id="menu" name="courseNum">
								<!-- name 속성 설정 -->
								<c:forEach var="course" items="${courseList}">
									<option value="${course.courseNum}">${course.courseName}</option>
									<!-- 선택된 강의 번호가 전송됨 -->
								</c:forEach>
								
							</select> <br> <br> <label for="content"><b>내용</b></label><br>
							<textarea class="input-login" id="content" name="content"
								rows="5" placeholder="내용을 입력하세요."></textarea>

							<br> <input type="submit" value="✅작성 완료">
						</form>


					</div>

					<div class="grid-item">
						<div class="page-title">내 문의 내역</div>

						<table id="w-table">
							<tr>
								<th>문의 번호</th>
								<th>문의 대상 이름</th>
								<th>문의 제목</th>
								<th>문의 날짜</th>
							</tr>
							<c:forEach var="board" items="${boardList}">
								<tr>
									<td>${board.boardNum}</td>
									<td>${board.boardToName}</td>
									<td><a class="a-btn"
										href="/studentGetBoard.do?num=${board.boardNum}">${board.boardTitle}</a></td>
									<td>${board.boardDate}</td>
								</tr>
							</c:forEach>
						</table>

					</div>

				</div>
			</div>
		</div>
	</main>

	<jsp:include page="/WEB-INF/layout/footer.jsp" />

</body>
</html>
