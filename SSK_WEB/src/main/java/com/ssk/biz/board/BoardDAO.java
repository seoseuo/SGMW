package com.ssk.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssk.biz.admin.AdminVO;
import com.ssk.biz.common.JDBCUtil;
import com.ssk.biz.course.CourseVO;
import com.ssk.biz.professor.ProfessorVO;

public class BoardDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	private final String GET_BOARD_LIST = "SELECT b.boardNum, b.boardFromNum, b.boardTitle, b.boardContents, b.boardDate, p.professorName AS boardName "
			+ "FROM board b " + "JOIN professor p ON b.boardFromNum = p.professorNum " + "WHERE b.boardToNum = ? "
			+ "UNION ALL "
			+ "SELECT b.boardNum, b.boardFromNum, b.boardTitle, b.boardContents, b.boardDate, s.studentName AS boardName "
			+ "FROM board b " + "JOIN student s ON b.boardFromNum = s.studentNum " + "WHERE b.boardToNum = ? "
			+ "ORDER BY boardNum DESC;"; // 문의 번호 기준으로 내림차순 정렬

	private final String GET_BOARD_LIST_BY_ME = "SELECT b.boardNum, b.boardFromNum, b.boardTitle, b.boardContents, b.boardDate, p.professorName AS boardName "
			+ "FROM board b " + "JOIN professor p ON b.boardFromNum = p.professorNum " + "WHERE b.boardFromNum = ? "
			+ "UNION ALL "
			+ "SELECT b.boardNum, b.boardFromNum, b.boardTitle, b.boardContents, b.boardDate, s.studentName AS boardName "
			+ "FROM board b " + "JOIN student s ON b.boardFromNum = s.studentNum " + "WHERE b.boardFromNum = ? "
			+ "ORDER BY boardNum DESC;"; // 문의 번호 기준으로 내림차순 정렬

	private final String GET_BOARD = "SELECT b.boardNum, b.boardFromNum, b.boardTitle, b.boardContents, b.boardDate, p.professorName AS boardName "
			+ "FROM board b " + "JOIN professor p ON b.boardFromNum = p.professorNum " + "WHERE b.boardNum = ? " // boardNum으로
																													// 필터링
			+ "UNION ALL "
			+ "SELECT b.boardNum, b.boardFromNum, b.boardTitle, b.boardContents, b.boardDate, s.studentName AS boardName "
			+ "FROM board b " + "JOIN student s ON b.boardFromNum = s.studentNum " + "WHERE b.boardNum = ?;"; // boardNum으로
																												// 필터링

	private final String INSERT_BOARD = "INSERT INTO board (boardNum, boardFromNum, boardTitle, boardContents, boardToNum, boardDate) "
			+ "VALUES ((SELECT COALESCE(MAX(boardNum), 0) + 1 FROM board), ?, ?, ?, ?, ?)";

	public List<BoardVO> getBoardList(AdminVO advo) {
		List<BoardVO> boardList = new ArrayList<>(); // BoardVO 객체를 담을 리스트 생성

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(GET_BOARD_LIST);
			stmt.setString(1, advo.getAdminNum());
			stmt.setString(2, advo.getAdminNum());

			rs = stmt.executeQuery();

			while (rs.next()) {
				BoardVO boardVO = new BoardVO(); // BoardVO 객체 생성

				boardVO.setBoardNum(rs.getInt("boardNum")); // 문의 번호 설정
				boardVO.setBoardFromNum(rs.getString("boardFromNum")); // 문의한 교번 혹은 학번 설정
				boardVO.setBoardTitle(rs.getString("boardTitle")); // 문의 제목 설정
				boardVO.setBoardContents(rs.getString("boardContents")); // 문의 내용 설정
				boardVO.setBoardDate(rs.getString("boardDate")); // 문의 일자 설정
				boardVO.setBoardName(rs.getString("boardName")); // 문의자 이름 설정
				boardVO.setBoardPosition(boardVO.getBoardFromNum());

				// 리스트에 객체 추가
				boardList.add(boardVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}

		return boardList;

	}

	public BoardVO getBoard(BoardVO bdvo) {
		BoardVO getBdvo = null;

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(GET_BOARD);
			stmt.setInt(1, bdvo.getBoardNum());
			stmt.setInt(2, bdvo.getBoardNum());

			rs = stmt.executeQuery();

			while (rs.next()) {
				getBdvo = new BoardVO(); // BoardVO 객체 생성

				getBdvo.setBoardNum(rs.getInt("boardNum")); // 문의 번호 설정
				getBdvo.setBoardFromNum(rs.getString("boardFromNum")); // 문의한 교번 혹은 학번 설정
				getBdvo.setBoardTitle(rs.getString("boardTitle")); // 문의 제목 설정
				getBdvo.setBoardContents(rs.getString("boardContents")); // 문의 내용 설정
				getBdvo.setBoardDate(rs.getString("boardDate")); // 문의 일자 설정
				getBdvo.setBoardName(rs.getString("boardName")); // 문의자 이름 설정
				getBdvo.setBoardPosition(getBdvo.getBoardFromNum()); // 직책 설정
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}

		return getBdvo;

	}

	public List<BoardVO> getBoardList(ProfessorVO profvo) {
		List<BoardVO> boardList = new ArrayList<>(); // BoardVO 객체를 담을 리스트 생성

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(GET_BOARD_LIST);
			stmt.setString(1, profvo.getProfessorNum());
			stmt.setString(2, profvo.getProfessorNum());

			rs = stmt.executeQuery();

			while (rs.next()) {
				BoardVO boardVO = new BoardVO(); // BoardVO 객체 생성

				boardVO.setBoardNum(rs.getInt("boardNum")); // 문의 번호 설정
				boardVO.setBoardFromNum(rs.getString("boardFromNum")); // 문의한 교번 혹은 학번 설정
				boardVO.setBoardTitle(rs.getString("boardTitle")); // 문의 제목 설정
				boardVO.setBoardContents(rs.getString("boardContents")); // 문의 내용 설정
				boardVO.setBoardDate(rs.getString("boardDate")); // 문의 일자 설정
				boardVO.setBoardName(rs.getString("boardName")); // 문의자 이름 설정
				boardVO.setBoardPosition(boardVO.getBoardFromNum()); // 직책 설정

				// 리스트에 객체 추가
				boardList.add(boardVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}

		return boardList;
	}

	public List<BoardVO> getBoardListByMe(ProfessorVO profvo) {
		List<BoardVO> boardList = new ArrayList<>(); // BoardVO 객체를 담을 리스트 생성

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(GET_BOARD_LIST_BY_ME);
			stmt.setString(1, profvo.getProfessorNum());
			stmt.setString(2, profvo.getProfessorNum());

			rs = stmt.executeQuery();

			while (rs.next()) {
				BoardVO boardVO = new BoardVO(); // BoardVO 객체 생성

				boardVO.setBoardNum(rs.getInt("boardNum")); // 문의 번호 설정
				boardVO.setBoardFromNum(rs.getString("boardFromNum")); // 문의한 교번 혹은 학번 설정
				boardVO.setBoardTitle(rs.getString("boardTitle")); // 문의 제목 설정
				boardVO.setBoardContents(rs.getString("boardContents")); // 문의 내용 설정
				boardVO.setBoardDate(rs.getString("boardDate")); // 문의 일자 설정
				boardVO.setBoardName(rs.getString("boardName")); // 문의자 이름 설정
				boardVO.setBoardPosition(boardVO.getBoardFromNum()); // 직책 설정

				// 리스트에 객체 추가
				boardList.add(boardVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}

		return boardList;
	}

	public void insertBoard(BoardVO bdvo) {
		// TODO Auto-generated method stub
		try {
			conn = JDBCUtil.getConnection();

			stmt = conn.prepareStatement(INSERT_BOARD);

			// PreparedStatement에 값 바인딩

			stmt.setString(1, bdvo.getBoardFromNum()); // 문의한 교번 혹은 학번
			stmt.setString(2, bdvo.getBoardTitle()); // 문의 제목
			stmt.setString(3, bdvo.getBoardContents()); // 문의 내용
			stmt.setString(4, bdvo.getBoardToNum()); // 문의할 관리자 번호 또는 교수 교번
			stmt.setString(5, bdvo.getBoardDate()); // 문의 일자

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

}
