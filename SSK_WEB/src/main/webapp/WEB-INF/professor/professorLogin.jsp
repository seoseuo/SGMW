<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="WEB-INF/errors/error.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>학생 성적 관리 웹 - 로그인</title>
  <link rel="stylesheet" href="../../../css/style.css" />
</head>

<body>
  <header class="header-container"></header>

  <main>
    <div id="wrap">
      <div class="center-container">
        <div id="index">
          <h1>
            👨🏻‍🏫교수자 로그인👩🏻‍🏫
            <hr>
          </h1>
          <form class="login-form" id="loginAdminForm" method="post" action="/login.do">
            <input class="input-login" type="text" id="num" name="num" placeholder="교수자 교번를 입력하세요." value="${num}">
            <input class="input-login" type="password" id="password" name="password" placeholder="비밀번호를 입력하세요." value="${password}">
            <span class="input_warn">${login_warn}</span>
            <input type="text" style="display: none;" id="position" name="position" value="professor">
            
            <input type="submit" style="display: none;">
            
          </form>
        </div>
      </div>
    </div>
  </main>

<jsp:include page="/WEB-INF/layout/footer.jsp" />

</body>
</html>
