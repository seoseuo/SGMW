<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage="errors/error.jsp"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>정보 수정</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
</head>

<body>

	<%@ include file="/WEB-INF/layout/studentHeader.jsp"%>
	<main>
		<div id="wrap">
			<div id="page-center-container">
				<div id="admin-info-container">
					<div class="grid-item">


						<div class="page-title">문의 내용</div>

						<h1>${board.boardTitle}</h1>

						<b>문의 일자</b> : ${board.boardDate}<br> <br> <br> <br>
						${board.boardContents}




					</div>
				</div>
			</div>
	</main>
	<%@ include file="/WEB-INF/layout/footer.jsp"%>

</body>

</html>
