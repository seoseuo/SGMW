<%@ page contentType="text/html; charset=UTF-8" %>
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
                  <a href="#">🧑🏻‍🎓학생</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <a href="#">👨🏻‍🏫교수자</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <a href="#">🧑🏻‍💻관리자</a>
                </div>
              </div>
        </div>
      </div>
    </main>

    <footer>
      <p>
        학생 성적 관리 웹 사이트<br />
        제작: 서승권<br />
        문의: <a href="mailto:seoseuo@naver.com">seoseuo@naver.com</a><br />
        GitHub:
        <a href="https://github.com/seoseuo/SGMW" target="_blank"
          >https://github.com/seoseuo/SGMW</a
        >
      </p>
    </footer>

  </body>
</html>
