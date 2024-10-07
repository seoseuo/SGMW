<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="errors/error.jsp" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>학생 정보</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <script>
        // 강의 철회 확인 함수
        function confirmWithdrawal(courseNum) {
            // 확인 대화 상자 표시
            var result = confirm("정말 철회하시곘습니까?");
            if (result) {
                // 사용자가 확인한 경우, 해당 강의 철회 요청으로 이동
                window.location.href = "/studentDeleteCourse.do?num=" + courseNum;
            }
            // 사용자가 취소를 클릭하면 아무 것도 하지 않음
        }
    </script>
</head>

<body>

    <%@ include file="/WEB-INF/layout/studentHeader.jsp" %>

    <div id="wrap">
        <div id="page-center-container">
            <div id="admin-info-container">
                <div class="grid-item">

                    <!-- 내 정보 컴포넌트 -->
                    <div class="page-title">내 정보</div>

                    <table>
                        <tr>
                            <td rowspan="5" style="font-size: 130px;">👩🏻‍🎓</td>
                            <td><b>${student.studentName}</b></td>
                        </tr>
                        <tr>
                            <td><b>학생 학번: </b>${student.studentNum}</td>
                        </tr>
                        <tr>
                            <td><b>학생 전화번호: </b>${student.studentPhone}</td>
                        </tr>
                        <tr>
                            <td><b>학생 관리자: </b>${student.studentAdminNum}</td>
                        </tr>
                        <tr>
                            <td><a href="/toStudentEditInfo.do?num=${student.studentNum}">📝수정하기</a></td>
                        </tr>
                    </table>

                </div>

                <div class="grid-item">

                    <!-- 나의 강의 내역 컴포넌트 -->
                    <div class="page-title">수강 내역</div>

                    <table id="w-table">
                        <tr>
                            <th>강의 번호</th>
                            <th>강의 이름</th>
                            <th>강의 교수자 소속 (전공)</th>
                            <th>강의 학점</th>
                            <th>철회</th>
                        </tr>
                        <c:forEach var="course" items="${courseList}">
                            <tr>
                                <td>${course.courseNum}</td>
                                <td><a class="a-btn" href="courseDetail.jsp?courseNum=${course.courseNum}">${course.courseName}</a></td>
                                <td>${course.courseProfessorMajor}</td>
                                <td>${course.coursePoint}</td>
                                <td>
                                    <a class="a-btn" href="javascript:void(0);" onclick="confirmWithdrawal('${course.courseNum}')">❌</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>

                </div>
            </div>
        </div>
    </div>
    </div>
    <footer>
        <%@ include file="/WEB-INF/layout/footer.jsp" %>
    </footer>

</body>

</html>
