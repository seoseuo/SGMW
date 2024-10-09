<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage="errors/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>학생 성적 관리 웹 - 관리자 문의</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
</head>

<body>

	<header>
		<!-- 공통 헤더 영역 -->
		<%@ include file="/WEB-INF/layout/professorHeader.jsp"%>
	</header>

	<main>
		<div id="wrap">
			<div id="page-center-container">
				<div id="admin-info-container">
					<div class="grid-item">

						<!-- 내 정보 컴포넌트 -->
						<div class="page-title">관리자 문의</div>
						<form action="/professorInsertBoard.do" method="POST">
							<br> <label for="title"><b>제목</b></label><br> <input
								class="input-login" type="text" id="title" name="title"
								placeholder="제목을 입력하세요."> <br> <br> <label
								for="content"><b>내용</b></label><br>
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
								<th>문의 제목</th>
								<th>문의 대상 이름</th>
								<!-- 수정: 올바르게 닫힘 -->
								<th>문의 날짜</th>
							</tr>
							<c:forEach var="board" items="${boardList}">
								<tr>
									<td>${board.boardNum}</td>
									<!-- 문의자 이름 -->
									<td><a class="a-btn"
										href="/professorGetBoard.do?num=${board.boardNum}">${board.boardTitle}</a></td>
									<!-- 문의 제목 -->
									<td>${board.boardToName}</td>
									<td>${board.boardDate}</td>
									<!-- 문의 날짜 -->
								</tr>
							</c:forEach>
						</table>


					</div>
				</div>
			</div>
		</div>
	</main>

	<!-- 공통 푸터 영역 -->
	<footer>
		<%@ include file="/WEB-INF/layout/footer.jsp"%>
	</footer>

</body>

</html>
