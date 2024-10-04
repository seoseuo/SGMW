<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage="errors/error.jsp" %>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>학생 성적 관리 웹 - 관리자 정보</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
</head>

<body>

	<%@ include file="/WEB-INF/layout/adminHeader.jsp"%>
	

<main>
      <div id="wrap">
        <div id="page-center-container">
          <div id="admin-info-container">
            <div class="grid-item">
              
              <!-- 내 정보 컴포넌트 -->
              <div class="page-title">내 정보</div>
              <table>
                <tr>
                  <td rowspan="5" style="font-size: 130px;">
                    🧑🏻‍💻
                  </td>
                  <td><b>${admin.adminName}</b></td>
                </tr>
                <tr>
                  <td><b>관리자 번호: </b>${admin.adminNum}</td>
                </tr>
                <tr>
                  <td><b>관리자 전화번호: </b>${admin.adminPhone}</td>
                </tr>
                <tr>
                  <td><b>관리자 업무: </b>${admin.adminMajor}</td>
                </tr>
                <tr>
                  <td><a href="/toAdminEditInfo.do">📝수정 하기</a></td>
                </tr>
              </table>
              
            </div>

            <div class="grid-item">

              <!-- 관리자 문의 내역 컴포넌트 -->
               <div class="page-title">관리자 문의 내역</div>
              <table id="w-table">
                <tr>
                  <th>문의 번호</th>
                  <th>문의자 직책</th>
                  <th>문의자 이름</th>
                  <th>문의 제목</th>
                  <th>문의 날짜</th>
                </tr>
                <tr>
                  <td>1</td>
                  <td>학생</td>
                  <td>이름이름</td>
                  <td><a class="a-btn" href="#">수업 질문</a></td>
                  <td>2024-10-02</td>
                </tr>
              </table>

            </div>
          </div>
        </div>
      </div>
    </main>

	<%@ include file="/WEB-INF/layout/footer.jsp"%>

</body>

</html>
