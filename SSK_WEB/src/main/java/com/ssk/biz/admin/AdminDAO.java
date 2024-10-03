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
			+ "FROM Admin " + "WHERE adminNum = ? ";

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

}
