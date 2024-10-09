package com.ssk.biz.professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssk.biz.admin.AdminVO;
import com.ssk.biz.common.JDBCUtil;

public class ProfessorDAO {

	// JDBC 관련 변수
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	private final String GET_PROFESSOR_LIST = "SELECT * FROM PROFESSOR WHERE professorAdminNum = ?";
	private final String GET_PROFESSOR = "SELECT * FROM PROFESSOR WHERE professorNum = ?";
	private final String ADMIN_EDIT_PROFESSOR = "UPDATE PROFESSOR SET professorName = ?, professorPhone = ?, professorMajor = ? WHERE professorNum = ?";
	private final String EDIT_PROFESSOR = "UPDATE PROFESSOR SET professorName = ?, professorPhone = ? WHERE professorNum = ?";
	private final String ADMIN_INSERT_PROFESSOR = "INSERT INTO PROFESSOR (professorNum, professorName, professorPhone, professorMajor, professorAdminNum, professorPassword) VALUES (?, ?, ?, ?, ?, ?)";
	private final String SEARCH_PROFESSOR_LIST = "SELECT * FROM PROFESSOR WHERE professorNum LIKE ? AND professorAdminNum = ?";
	private final String ADMIN_DELETE_PROFESSOR = "DELETE FROM BOARD WHERE boardFromNum = ? OR boardToNum = ?; "
			+ "DELETE FROM COURSE WHERE courseProfessorNum = ?; " + "DELETE FROM PROFESSOR WHERE professorNum = ?;";

	// 교수자 목록 가져오기
	public List<ProfessorVO> getProfessorList(AdminVO adminVo) {
		// TODO Auto-generated method stub
		List<ProfessorVO> profList = new ArrayList<ProfessorVO>();

		try {

			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(GET_PROFESSOR_LIST);

			stmt.setString(1, adminVo.getAdminNum());

			rs = stmt.executeQuery();

			while (rs.next()) {
				ProfessorVO profVo = new ProfessorVO();

				// ResultSet에서 값을 가져와 ProfessorVO에 설정
				profVo.setProfessorNum(rs.getString("professorNum"));
				profVo.setProfessorName(rs.getString("professorName"));
				profVo.setProfessorPassword(rs.getString("professorPassword"));
				profVo.setProfessorPhone(rs.getString("professorPhone"));
				profVo.setProfessorMajor(rs.getString("professorMajor"));
				profVo.setProfessorAdminNum(rs.getString("professorAdminNum"));

				// 리스트에 객체 추가
				profList.add(profVo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return profList;
	}

	public ProfessorVO getProfessor(ProfessorVO profVo) {
		// TODO Auto-generated method stub
		ProfessorVO getProfVo = null;
		try {

			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(GET_PROFESSOR);

			stmt.setString(1, profVo.getProfessorNum());

			rs = stmt.executeQuery();

			while (rs.next()) {
				getProfVo = new ProfessorVO();

				// ResultSet에서 값을 가져와 ProfessorVO에 설정
				getProfVo.setProfessorNum(rs.getString("professorNum"));
				getProfVo.setProfessorName(rs.getString("professorName"));
				getProfVo.setProfessorPassword(rs.getString("professorPassword"));
				getProfVo.setProfessorPhone(rs.getString("professorPhone"));
				getProfVo.setProfessorMajor(rs.getString("professorMajor"));
				getProfVo.setProfessorAdminNum(rs.getString("professorAdminNum"));

				System.out.println(getProfVo.getProfessorNum() + ", " + getProfVo.getProfessorName());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return getProfVo;

	}

	public void adminEditProfessor(ProfessorVO profVo) {

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(ADMIN_EDIT_PROFESSOR);

			stmt.setString(1, profVo.getProfessorName());
			stmt.setString(2, profVo.getProfessorPhone());
			stmt.setString(3, profVo.getProfessorMajor());
			stmt.setString(4, profVo.getProfessorNum());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}

	}

	public List<ProfessorVO> searchProfessor(ProfessorVO profvo, AdminVO advo) {
		List<ProfessorVO> profList = new ArrayList<ProfessorVO>();

		try {

			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SEARCH_PROFESSOR_LIST);

			// 검색어가 없거나, 0 또는 1만 입력된 경우에도 모두 검색되도록 처리
			if (profvo.getProfessorNum() == null || profvo.getProfessorNum().isEmpty()) {
				stmt.setString(1, "%"); // 입력 없을 때 전체 검색
			} else {
				stmt.setString(1, "%" + profvo.getProfessorNum() + "%"); // 입력 값 포함 검색
			}
			stmt.setString(2, advo.getAdminNum());

			rs = stmt.executeQuery();

			while (rs.next()) {
				ProfessorVO profVo = new ProfessorVO();

				// ResultSet에서 값을 가져와 ProfessorVO에 설정
				profVo.setProfessorNum(rs.getString("professorNum"));
				profVo.setProfessorName(rs.getString("professorName"));
				profVo.setProfessorPassword(rs.getString("professorPassword"));
				profVo.setProfessorPhone(rs.getString("professorPhone"));
				profVo.setProfessorMajor(rs.getString("professorMajor"));
				profVo.setProfessorAdminNum(rs.getString("professorAdminNum"));

				// 리스트에 객체 추가
				profList.add(profVo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return profList;
	}

	public void adminInsertProfessor(ProfessorVO profVo, AdminVO advo) throws SQLException {
		// TODO Auto-generated method stub

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(ADMIN_INSERT_PROFESSOR);

			stmt.setString(1, profVo.getProfessorNum());
			stmt.setString(2, profVo.getProfessorName());
			stmt.setString(3, profVo.getProfessorPhone());
			stmt.setString(4, profVo.getProfessorMajor());
			stmt.setString(5, advo.getAdminNum());
			stmt.setString(6, profVo.getProfessorNum()); // 비밀번호를 교수 번호로 설정

			System.out.println(stmt.executeUpdate() + "명의 교수자 등록 완료");

		} catch (SQLException e) {

			// 교번 중복일 때
			e.printStackTrace();
			throw e;

		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public void adminDeleteProfessor(ProfessorVO profvo) {
		try {

			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(ADMIN_DELETE_PROFESSOR);
			stmt.setString(1, profvo.getProfessorNum());
			stmt.setString(2, profvo.getProfessorNum());
			stmt.setString(3, profvo.getProfessorNum());
			stmt.setString(4, profvo.getProfessorNum());

			System.out.println("삭제할 교수 번호: " + profvo.getProfessorNum());

			System.out.println(stmt.executeUpdate() + "명의 교수자 삭제 완료");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}

	}

	public void editProfessor(ProfessorVO profvo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(EDIT_PROFESSOR);

			stmt.setString(1, profvo.getProfessorName());
			stmt.setString(2, profvo.getProfessorPhone());
			stmt.setString(3, profvo.getProfessorNum());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}

	}
}
