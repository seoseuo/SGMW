<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="errors/error.jsp" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>학생 성적 관리 웹 - 정보 수정</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
</head>

<body>

    <%@ include file="/WEB-INF/layout/studentHeader.jsp" %>
    <main>
        <div id="wrap">
            <div id="page-center-container">
                <div id="admin-info-container">
                    <div class="grid-item">

                        <!-- 내 정보 컴포넌트 -->
                        <div class="page-title">내 정보</div>

                        <form id="UserEditUser" method="post" action="/studentEditInfo.do">
                            <table>
                                <tr>
                                    <td rowspan="5" style="font-size: 130px;">👩🏻‍🎓</td>
                                    <td>
                                        <b>학생 이름: </b>
                                        <input class="input-edit-info" type="text" id="name" name="name" value="${student.studentName}"> <br>
                                        <span class="input_warn" id="name_warn"></span>
                                    </td>
                                </tr>
                                <tr>
                                    <td><b>학생 학번: </b>${student.studentNum}</td>
                                </tr>
                                <tr>
                                    <td>
                                        <b>학생 전화번호: </b>
                                        <input class="input-edit-info" type="text" id="phone" name="phone" value="${student.studentPhone}"><br>
                                        <span class="input_warn" id="phone_warn"></span>
                                    </td>
                                </tr>
                                <tr>
                                    <td><b>학생 관리자: </b>${student.studentAdminNum}</td>
                                </tr>
                                <tr>
                                    <td><input type="submit" value="✅수정 완료"></td>
                                </tr>
                            </table>
                        </form>

                    </div>

                    <div class="grid-item"></div>
                </div>
            </div>
        </div>
    </main>
    <%@ include file="/WEB-INF/layout/footer.jsp" %>

</body>

</html>
