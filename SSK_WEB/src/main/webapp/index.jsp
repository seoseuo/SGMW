<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>학생 성적 관리 웹</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" />
  </head>
  <body>
    <header class="header-container"></header>

    <main>
      <div id="wrap">
        <div class="center-container">
            <div id="index">
                <h1>
                  학생 성적 관리 웹📝
                  <hr>
                </h1>
                <div class="menu">
                  <a href="/toStudentLogin.do">🧑🏻‍🎓학생</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <a href="/toProfessorLogin.do">👨🏻‍🏫교수자</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <a href="/toAdminLogin.do">🧑🏻‍💻관리자</a>
                </div>
              </div>
        </div>
      </div>
    </main>

  <jsp:include page="/WEB-INF/layout/footer.jsp" />

  </body>
</html>
