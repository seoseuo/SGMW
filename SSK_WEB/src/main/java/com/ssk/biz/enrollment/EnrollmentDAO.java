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

	private final String DELETE_ENROLLMENT = "DELETE FROM enrollment WHERE enrollmentCourseNum = ?";

	private final String EDIT_ENROLLMENT = "UPDATE enrollment SET enrollmentMiddle = ?, enrollmentFinal = ? WHERE enrollmentCourseNum = ? AND enrollmentStudentNum = ?";

	private final String INSERT_ENROLLMENT = "INSERT INTO enrollment (enrollmentCourseNum, enrollmentStudentNum, enrollmentMiddle, enrollmentFinal) VALUES (?, ?, 0, 0)";

	private final String DELETE_STUDENT_COURSE = "DELETE FROM ENROLLMENT WHERE enrollmentStudentNum = ? AND enrollmentCourseNum = ?";

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
				enlist.add(envo);

			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return enlist;

	}

	public void deleteEnrollment(CourseVO covo) {
		// TODO Auto-generated method stub
		try {
			conn = JDBCUtil.getConnection();

			stmt = conn.prepareStatement(DELETE_ENROLLMENT);

			// 바인딩
			stmt.setInt(1, covo.getCourseNum());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 해제
			JDBCUtil.close(stmt, conn);
		}

	}

	public void editEnrollment(EnrollmentVO envo) {
		// TODO Auto-generated method stub
		try {
			conn = JDBCUtil.getConnection();

			stmt = conn.prepareStatement(EDIT_ENROLLMENT);

			// 바인딩
			stmt.setInt(1, envo.getEnrollmentMiddle());
			stmt.setInt(2, envo.getEnrollmentFinal());
			stmt.setInt(3, envo.getEnrollmentCourseNum());
			stmt.setString(4, envo.getEnrollmentStudentNum());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 해제
			JDBCUtil.close(stmt, conn);
		}
	}

	public void insertStudent(EnrollmentVO envo) {
		// TODO Auto-generated method stub
		try {
			conn = JDBCUtil.getConnection();

			stmt = conn.prepareStatement(INSERT_ENROLLMENT);

			// 바인딩
			stmt.setInt(1, envo.getEnrollmentCourseNum());
			stmt.setString(2, envo.getEnrollmentStudentNum());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 해제
			JDBCUtil.close(stmt, conn);

		}
	}

	public void deleteStudentCorse(EnrollmentVO envo) {
		// TODO Auto-generated method stub
		try {
			conn = JDBCUtil.getConnection();

			stmt = conn.prepareStatement(DELETE_STUDENT_COURSE);

			// 바인딩
			stmt.setString(1, envo.getEnrollmentStudentNum());
			stmt.setInt(2, envo.getEnrollmentCourseNum());
			
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 해제
			JDBCUtil.close(stmt, conn);

		}
	}

}
