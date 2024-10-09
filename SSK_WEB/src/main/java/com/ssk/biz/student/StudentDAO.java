package com.ssk.biz.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssk.biz.admin.AdminVO;
import com.ssk.biz.common.JDBCUtil;

public class StudentDAO {
	// JDBC 관련 변수
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	private final String GET_STUDENT_LIST = "SELECT * FROM STUDENT WHERE studentAdminNum = ?";
	private final String GET_STUDENT = "SELECT * FROM STUDENT WHERE studentNum = ?";
	private final String ADMIN_EDIT_STUDENT = "UPDATE STUDENT SET studentName = ?, studentPhone = ?, studentMajor = ? WHERE studentNum = ?";
	private final String SEARCH_STUDENT_LIST = "SELECT * FROM STUDENT WHERE studentNum LIKE ? AND studentAdminNum = ?";
	private final String ADMIN_INSERT_STUDENT = "INSERT INTO STUDENT (studentNum, studentName, studentPhone, studentMajor, studentAdminNum, studentPassword) VALUES (?, ?, ?, ?, ?, ?)";
	private final String ADMIN_DELETE_STUDENT = "DELETE FROM BOARD WHERE boardFromNum = ?; "
			+ "DELETE FROM ENROLLMENT WHERE enrollmentStudentNum = ?; " + "DELETE FROM STUDENT WHERE studentNum = ?";

	private final String EDIT_STUDENT = "UPDATE student SET studentName = ?, studentPhone = ? WHERE studentNum = ?";

	public List<StudentVO> getStudentList(AdminVO adminVo) {

		System.out.println("getStudentList()");
		// 학생 목록 가져오기

		List<StudentVO> stList = new ArrayList<StudentVO>();

		try {

			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(GET_STUDENT_LIST); // 쿼리 변경 필요

			stmt.setString(1, adminVo.getAdminNum());

			rs = stmt.executeQuery();

			while (rs.next()) {
				StudentVO stVo = new StudentVO();

				// ResultSet에서 값을 가져와 StudentVO에 설정
				stVo.setStudentNum(rs.getString("studentNum"));
				stVo.setStudentName(rs.getString("studentName"));
				stVo.setStudentPassword(rs.getString("studentPassword"));
				stVo.setStudentPhone(rs.getString("studentPhone"));
				stVo.setStudentMajor(rs.getString("studentMajor"));
				stVo.setStudentAdminNum(rs.getString("studentAdminNum"));

//				System.out.println(stVo.getStudentNum());
				// 리스트에 객체 추가
				stList.add(stVo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return stList;
	}

	public StudentVO getStudent(StudentVO stvo) {
		// TODO Auto-generated method stub
		StudentVO getStvo = null;
		try {
			//
			conn = JDBCUtil.getConnection();

			stmt = conn.prepareStatement(GET_STUDENT);

			stmt.setString(1, stvo.getStudentNum());

			//
			rs = stmt.executeQuery();

			// ResultSet에서 데이터를 가져와 StudentVO에 설정
			while (rs.next()) {
				getStvo = new StudentVO();

				// ResultSet에서 학생 정보 추출
				getStvo.setStudentNum(rs.getString("studentNum"));
				getStvo.setStudentName(rs.getString("studentName"));
				getStvo.setStudentPassword(rs.getString("studentPassword"));
				getStvo.setStudentPhone(rs.getString("studentPhone"));
				getStvo.setStudentMajor(rs.getString("studentMajor"));
				getStvo.setStudentAdminNum(rs.getString("studentAdminNum"));

				System.out.println(getStvo.getStudentNum() + ", " + getStvo.getStudentName());
			}

		} catch (SQLException e) {
			// 오류 처리
			e.printStackTrace();
		} finally {
			// 데이터베이스 리소스 해제
			JDBCUtil.close(rs, stmt, conn);
		}

		return getStvo;
	}

	public void adminEditStudent(StudentVO stvo) {
		// TODO Auto-generated method stub
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(ADMIN_EDIT_STUDENT);

			stmt.setString(1, stvo.getStudentName());
			stmt.setString(2, stvo.getStudentPhone());
			stmt.setString(3, stvo.getStudentMajor());
			stmt.setString(4, stvo.getStudentNum());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// 예외 처리
		} finally {
			JDBCUtil.close(stmt, conn);
		}

	}

	public List<StudentVO> searchStudent(StudentVO stvo, AdminVO advo) {
		// TODO Auto-generated method stub
		List<StudentVO> stList = new ArrayList<StudentVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SEARCH_STUDENT_LIST);

			// 검색어가 없거나, 0 또는 1만 입력된 경우에도 모두 검색되도록 처리
			if (stvo.getStudentNum() == null || stvo.getStudentNum().isEmpty()) {
				stmt.setString(1, "%"); // 입력 없을 때 전체 검색
			} else {
				stmt.setString(1, "%" + stvo.getStudentNum() + "%"); // 입력 값 포함 검색
			}
			stmt.setString(2, advo.getAdminNum());

			rs = stmt.executeQuery();

			while (rs.next()) {
				StudentVO stVo = new StudentVO();

				// ResultSet에서 값을 가져와 StudentVO에 설정
				stVo.setStudentNum(rs.getString("studentNum"));
				stVo.setStudentName(rs.getString("studentName"));
				stVo.setStudentPassword(rs.getString("studentPassword"));
				stVo.setStudentPhone(rs.getString("studentPhone"));
				stVo.setStudentMajor(rs.getString("studentMajor"));
				stVo.setStudentAdminNum(rs.getString("studentAdminNum"));

//				System.out.println(stVo.getStudentNum());
				// 리스트에 객체 추가
				stList.add(stVo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return stList;
	}

	public void adminInsertStudent(StudentVO stvo, AdminVO advo) throws SQLException {
		// TODO Auto-generated method stub

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(ADMIN_INSERT_STUDENT);

			stmt.setString(1, stvo.getStudentNum()); // 학생 번호
			stmt.setString(2, stvo.getStudentName()); // 학생 이름
			stmt.setString(3, stvo.getStudentPhone()); // 학생 전화번호
			stmt.setString(4, stvo.getStudentMajor()); // 학생 전공
			stmt.setString(5, advo.getAdminNum()); // 관리자 번호
			stmt.setString(6, stvo.getStudentNum()); // 비밀번호를 학생 번호로 설정

			System.out.println(stmt.executeUpdate() + "명의 학생 등록 완료");

		} catch (SQLException e) {
			// 학번 중복일 때
			e.printStackTrace();
			throw e;
		} finally {
			// 자원 해제
			JDBCUtil.close(stmt, conn);
		}
	}

	public void adminDeleteStudent(StudentVO stvo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(ADMIN_DELETE_STUDENT);
			stmt.setString(1, stvo.getStudentNum());
			stmt.setString(2, stvo.getStudentNum());
			stmt.setString(3, stvo.getStudentNum());

			System.out.println("삭제할 학생 번호: " + stvo.getStudentNum());

			System.out.println(stmt.executeUpdate() + "명의 학생 삭제 완료");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}

	}

	public void editStudent(StudentVO studentvo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(EDIT_STUDENT);

			stmt.setString(1, studentvo.getStudentName()); // 학생 이름
			stmt.setString(2, studentvo.getStudentPhone()); // 학생 전화번호
			stmt.setString(3, studentvo.getStudentNum()); // 학생 학번

			// 쿼리 실행
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 해제
			JDBCUtil.close(stmt, conn);
		}
	}
}
