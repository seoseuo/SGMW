<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage="errors/error.jsp"%>


<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>학생 성적 관리 웹 - 관리자 메인</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
</head>

<body>

	<%@ include file="/WEB-INF/layout/adminHeader.jsp"%>

	<main>
		<div id="wrap">
			<div class="center-container">
				<div id="index">
					<h1>
						${admin.adminName} <span style="color: rgb(152, 152, 152);">관리자
							님,</span><br> 📝학생 성적 관리 웹 <span style="color: rgb(152, 152, 152);">에
							오신 것을 환영합니다.</span>
					</h1>
				</div>
			</div>
		</div>
	</main>

	<%@ include file="/WEB-INF/layout/footer.jsp"%>

</body>

</html>
