package com.ssk.biz.enrollment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssk.biz.common.JDBCUtil;
import com.ssk.biz.course.CourseVO;

public class EnrollmentDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	// 강의 번호를 기준으로 조인문을 사용하여 해당 학생의 정보들을 가져오는 쿼리문
	private final String GET_ENROLLMENT_LIST = "SELECT e.enrollmentStudentNum, s.studentName AS enrollmentStudentName, "
			+ "s.studentPhone AS enrollmentStudentPhone, s.studentMajor AS enrollmentStudentMajor, "
			+ "e.enrollmentMiddle, e.enrollmentFinal " + "FROM enrollment e "
			+ "JOIN student s ON e.enrollmentStudentNum = s.studentNum " + "WHERE e.enrollmentCourseNum = ? "
			+ "ORDER BY (e.enrollmentMiddle + e.enrollmentFinal) DESC";

	public List<EnrollmentVO> getEnrollmentList(CourseVO covo) {
		// TODO Auto-generated method stub

		List<EnrollmentVO> enlist = new ArrayList<EnrollmentVO>();
		try {

			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(GET_ENROLLMENT_LIST); // 쿼리 변경 필요
			stmt.setInt(1, covo.getCourseNum());
			rs = stmt.executeQuery();

			while (rs.next()) {
				EnrollmentVO envo = new EnrollmentVO(); // EnrollmentVO 객체 생성

				envo.setEnrollmentStudentNum(rs.getString("enrollmentStudentNum")); // 학생 학번 설정
				envo.setEnrollmentStudentName(rs.getString("enrollmentStudentName")); // 학생 이름 설정
				envo.setEnrollmentStudentPhone(rs.getString("enrollmentStudentPhone")); // 학생 전화번호 설정
				envo.setEnrollmentStudentMajor(rs.getString("enrollmentStudentMajor")); // 학생 전공 설정
				envo.setEnrollmentMiddle(rs.getInt("enrollmentMiddle")); // 중간고사 성적 설정
				envo.setEnrollmentFinal(rs.getInt("enrollmentFinal")); // 기말고사 성적 설정
				envo.setEnrollmentStudentSum(envo.getEnrollmentMiddle(), envo.getEnrollmentFinal()); // 합계 설정
				// 리스트에 객체 추가
				enlist.add(envo); // enrollmentList는 EnrollmentVO 객체의 리스트

			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return enlist;

	}

}
