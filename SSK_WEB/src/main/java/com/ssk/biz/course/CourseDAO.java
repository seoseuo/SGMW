package com.ssk.biz.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssk.biz.common.JDBCUtil;
import com.ssk.biz.professor.ProfessorVO;
import com.ssk.biz.student.StudentVO;

public class CourseDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	// 강의 와 교수자 를 조인하여 원하는 정보를 가져옴, 강의 테이블의 교수자 교번 외래키를 사용하여 교수자의 이름과 소속(전공) 을 가져온다.
	private final String GET_COURSE_LIST = "SELECT c.courseNum, c.courseName, c.courseProfessorNum, c.coursePoint, "
			+ "p.professorName AS courseProfessorName, p.professorMajor AS courseProfessorMajor " + "FROM course c "
			+ "JOIN professor p ON c.courseProfessorNum = p.professorNum";
	private final String GET_COURSE = "SELECT c.courseNum, c.courseName, c.courseProfessorNum, c.coursePoint, "
			+ "p.professorName AS courseProfessorName, p.professorMajor AS courseProfessorMajor " + "FROM course c "
			+ "JOIN professor p ON c.courseProfessorNum = p.professorNum WHERE courseNum = ?";
	private final String SEARCH_COURSE = "SELECT c.courseNum, c.courseName, c.courseProfessorNum, c.coursePoint, p.professorName AS courseProfessorName, p.professorMajor AS courseProfessorMajor FROM course c JOIN professor p ON c.courseProfessorNum = p.professorNum WHERE courseName LIKE ?";


	public List<CourseVO> getCourseList() {
//		System.out.println("getCourseList()");

		List<CourseVO> courseList = new ArrayList<CourseVO>();
		try {

			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(GET_COURSE_LIST); // 쿼리 변경 필요
			rs = stmt.executeQuery();

			while (rs.next()) {
				CourseVO covo = new CourseVO(); // CourseVO 객체 생성

				covo.setCourseNum(rs.getInt("courseNum")); // 강의 번호 설정
				covo.setCourseName(rs.getString("courseName")); // 강의 이름 설정
				covo.setCourseProfessorNum(rs.getString("courseProfessorNum")); // 교수자 번호 설정
				covo.setCoursePoint(rs.getInt("coursePoint")); // 강의 학점 설정
				covo.setCourseProfessorName(rs.getString("courseProfessorName")); // 교수자 이름 설정
				covo.setCourseProfessorMajor(rs.getString("courseProfessorMajor")); // 교수자 소속(전공) 설정
				// 리스트에 객체 추가
//			    System.out.println(covo.getCourseName());
				courseList.add(covo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return courseList;
	}

	public CourseVO getCourse(CourseVO covo) {
		CourseVO getCovo = null;
		try {

			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(GET_COURSE); // 쿼리 변경 필요
			stmt.setInt(1, covo.getCourseNum());
			rs = stmt.executeQuery();

			while (rs.next()) {
				getCovo = new CourseVO(); // CourseVO 객체 생성

				getCovo.setCourseNum(rs.getInt("courseNum")); // 강의 번호 설정
				getCovo.setCourseName(rs.getString("courseName")); // 강의 이름 설정
				getCovo.setCourseProfessorNum(rs.getString("courseProfessorNum")); // 교수자 번호 설정
				getCovo.setCoursePoint(rs.getInt("coursePoint")); // 강의 학점 설정
				getCovo.setCourseProfessorName(rs.getString("courseProfessorName")); // 교수자 이름 설정
				getCovo.setCourseProfessorMajor(rs.getString("courseProfessorMajor")); // 교수자 소속(전공) 설정
				//
//			    System.out.println(covo.getCourseName());

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return getCovo;

	}

	public List<CourseVO> searchCourseList(CourseVO covo) {
		List<CourseVO> colist = new ArrayList<CourseVO>();

		try {

			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SEARCH_COURSE);

			// 검색어가 없거나, 0 또는 1만 입력된 경우에도 모두 검색되도록 처리
			if (covo.getCourseName() == null || covo.getCourseName().isEmpty()) {
				stmt.setString(1, "%"); // 입력 없을 때 전체 검색
			} else {
				stmt.setString(1, "%" + covo.getCourseName() + "%"); // 입력 값 포함 검색
			}

			rs = stmt.executeQuery();

			while (rs.next()) {

				CourseVO getCovo = new CourseVO(); // CourseVO 객체 생성

				getCovo.setCourseNum(rs.getInt("courseNum")); // 강의 번호 설정
				getCovo.setCourseName(rs.getString("courseName")); // 강의 이름 설정
				getCovo.setCourseProfessorNum(rs.getString("courseProfessorNum")); // 교수자 번호 설정
				getCovo.setCoursePoint(rs.getInt("coursePoint")); // 강의 학점 설정
				getCovo.setCourseProfessorName(rs.getString("courseProfessorName")); // 교수자 이름 설정
				getCovo.setCourseProfessorMajor(rs.getString("courseProfessorMajor")); // 교수자 소속(전공) 설정
				// 리스트에 객체 추가
//			    System.out.println(covo.getCourseName());
				colist.add(getCovo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return colist;
	}

}
