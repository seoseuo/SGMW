<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage="errors/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>학생 성적 관리 웹 - 문의 조회</title>
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


						<div class="page-title">문의 내용</div>

						<h1>${board.boardTitle}</h1>
						<b>작성자</b> : ${board.boardName}<br> <b>교번/학번</b> :
						${board.boardFromNum}<br> <b>직책</b> : ${board.boardPosition}<br>
						<b>문의 일자</b> : ${board.boardDate}<br> <br> <br> <br>
						${board.boardContents}




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
