<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="WEB-INF/errors/error.jsp"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>학생 성적 관리 웹 - 로그인</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
</head>

<body>
	<header class="header-container"></header>

	<main>
		<div id="wrap">
			<div class="center-container">
				<div id="index">
					<h1>
						👩🏻‍💻관리자 로그인🧑🏻‍💻
						<hr>
					</h1>
					<form class="login-form" id="loginAdminForm" method="post"
						action="/login.do">

						<input class="input-login" type="text" id="num" name="num"
							placeholder="관리자 번호를 입력하세요." value="${num}"> <input
							class="input-login" type="password" id="password" name="password"
							placeholder="비밀번호를 입력하세요." value="${password}"> <input
							type="text" style="display: none;" id="position" name="position"
							value="admin"> <input type="submit"
							style="display: none;"> <span class="input_warn">${login_warn}</span>

					</form>
				</div>
			</div>
		</div>
	</main>

	<footer>
		<p>
			학생 성적 관리 웹 사이트<br /> 제작: 서승권<br /> 문의: <a
				href="mailto:seoseuo@naver.com">seoseuo@naver.com</a><br /> GitHub:
			<a href="https://github.com/seoseuo/SGMW" target="_blank">https://github.com/seoseuo/SGMW</a>
		</p>
	</footer>

</body>

</html>
