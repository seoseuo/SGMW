package com.ssk.biz.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssk.biz.common.JDBCUtil;

public class AdminDAO {

	// JDBC 관련 변수
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	// 관리자 로그인
	private final String ADMIN_LOGIN = "SELECT adminNum, adminName, adminPassword, adminPhone, adminMajor "
			+ "FROM ADMIN " + "WHERE adminNum = ? ";

	// 관리자 정보 수정
	private final String ADMIN_EDIT_INFO = "UPDATE ADMIN SET adminName = ?, adminPhone = ? WHERE adminNum = ?";

	// 관리자 로그인 메소드.
	public AdminVO adminLogin(AdminVO vo) {

		System.out.println("adminLogin()");
		AdminVO resultVo = null;

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(ADMIN_LOGIN);

			stmt.setString(1, vo.getAdminNum());
			rs = stmt.executeQuery();

			while (rs.next()) { // rs에 담긴 결과 값을 담아준다.
				resultVo = new AdminVO();
				resultVo.setAdminNum(rs.getString("adminNum"));
				resultVo.setAdminName(rs.getString("adminName"));
				resultVo.setAdminPassword(rs.getString("adminPassword"));
				resultVo.setAdminPhone(rs.getString("adminPhone"));
				resultVo.setAdminMajor(rs.getString("adminMajor"));
			}

		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return resultVo;
	}

	public void adminEditInfo(AdminVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(ADMIN_EDIT_INFO);
			stmt.setString(1, vo.getAdminNum());
			stmt.setString(2, vo.getAdminName());
			stmt.setString(3, vo.getAdminPhone());
			
			stmt.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}

	}

}
