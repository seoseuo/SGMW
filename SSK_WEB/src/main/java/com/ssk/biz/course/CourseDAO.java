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

	private final String STUDENT_GET_COURSE_LIST = "SELECT c.courseNum, c.courseName, c.courseProfessorNum, c.coursePoint, "
			+ "p.professorName AS courseProfessorName, p.professorMajor AS courseProfessorMajor " + "FROM course c "
			+ "JOIN professor p ON c.courseProfessorNum = p.professorNum "
			+ "LEFT JOIN enrollment e ON c.courseNum = e.enrollmentCourseNum AND e.enrollmentStudentNum = ? "
			+ "WHERE e.enrollmentStudentNum IS NULL"; // studentNum이 ?이 아닌 course들만 선택
	
	private final String STUDENT_GET_MY_COURSE_LIST = "SELECT c.courseNum, c.courseName, c.courseProfessorNum, c.coursePoint, "
	        + "p.professorName AS courseProfessorName, p.professorMajor AS courseProfessorMajor "
	        + "FROM course c "
	        + "JOIN professor p ON c.courseProfessorNum = p.professorNum "
	        + "JOIN enrollment e ON c.courseNum = e.enrollmentCourseNum "
	        + "WHERE e.enrollmentStudentNum = ?";


	private final String GET_MY_COURSE = "SELECT c.courseNum, c.courseName, c.courseProfessorNum, c.coursePoint, "
			+ "p.professorName AS courseProfessorName, p.professorMajor AS courseProfessorMajor " + "FROM course c "
			+ "JOIN professor p ON c.courseProfessorNum = p.professorNum WHERE c.courseProfessorNum = ?";

	private final String GET_COURSE = "SELECT c.courseNum, c.courseName, c.courseProfessorNum, c.coursePoint, "
			+ "p.professorName AS courseProfessorName, p.professorMajor AS courseProfessorMajor " + "FROM course c "
			+ "JOIN professor p ON c.courseProfessorNum = p.professorNum WHERE courseNum = ?";
	private final String SEARCH_COURSE = "SELECT c.courseNum, c.courseName, c.courseProfessorNum, c.coursePoint, p.professorName AS courseProfessorName, p.professorMajor AS courseProfessorMajor FROM course c JOIN professor p ON c.courseProfessorNum = p.professorNum WHERE courseName LIKE ?";

	private final String ADD_COURSE = "INSERT INTO course (courseNum, courseName, courseProfessorNum, coursePoint) "
			+ "VALUES ((SELECT IFNULL(MAX(courseNum), 0) + 1 FROM course), ?, ?, ?)";

	private final String DELETE_COURSE = "DELETE FROM course WHERE courseNum = ?";

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

	public List<CourseVO> studentGetCourseList(StudentVO stvo) {
//		System.out.println("getCourseList()");

		List<CourseVO> courseList = new ArrayList<CourseVO>();
		try {

			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(STUDENT_GET_COURSE_LIST); // 쿼리 변경 필요
			stmt.setString(1, stvo.getStudentNum());
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
	
	public List<CourseVO> studentGetMyCourseList(StudentVO stvo) {
//		System.out.println("getCourseList()");

		List<CourseVO> courseList = new ArrayList<CourseVO>();
		try {

			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(STUDENT_GET_MY_COURSE_LIST); // 쿼리 변경 필요
			stmt.setString(1, stvo.getStudentNum());
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

	public List<CourseVO> getCourseList(ProfessorVO profvo) {
		List<CourseVO> courseList = new ArrayList<CourseVO>();
		try {

			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(GET_MY_COURSE);
			stmt.setString(1, profvo.getProfessorNum());
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

				courseList.add(covo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return courseList;
	}

	public void addCourse(CourseVO covo) {
		try {
			conn = JDBCUtil.getConnection();

			stmt = conn.prepareStatement(ADD_COURSE);

			// 바인딩
			stmt.setString(1, covo.getCourseName()); // 강의 이름
			stmt.setString(2, covo.getCourseProfessorNum()); // 교수자 번호
			stmt.setInt(3, covo.getCoursePoint()); // 강의 학점

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 해제
			JDBCUtil.close(stmt, conn);
		}
	}

	public void deleteCourse(CourseVO covo) {
		// TODO Auto-generated method stub
		try {
			conn = JDBCUtil.getConnection();

			stmt = conn.prepareStatement(DELETE_COURSE);

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

}
