package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	public int insert(BoardDTO board) {		// 글 작성
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rs = null;
		try {
			conn = DBUtil.makeConnection();
			String sql = "insert into board_tb(title, writer, content, write_date) "
					+ " VALUES (?, ?, ?, now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("insert Error");
		}finally {
			DBUtil.close(rs, pstmt, conn);
			
		}
		return result;
	}
	public List<BoardDTO> selectList(int startRow, int count){		// 글 목록
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<BoardDTO> result = new ArrayList<>();
		ResultSet rs = null;
		try {
			conn = DBUtil.makeConnection();
			String sql = "select bno, title, writer, write_date, read_count from board_tb order by bno limit ?, ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, count);
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO b = new BoardDTO();
				b.setBno(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setWriter(rs.getString(3));
				b.setWrite_date(rs.getString(4));
				b.setRead_count(rs.getInt(5));
				
				result.add(b);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Select List Error");
		}finally {
			DBUtil.close(rs, pstmt, conn);
		}
		
		return result;
	}
	public int selectTotalCount() {	//
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rs = null;
		try {
			conn = DBUtil.makeConnection();
			String sql = "select count(*) from board_tb";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			rs.next();	// 이 쿼리는 무조건 숫자하나가 들어있을거임
			result = rs.getInt(1);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Select Total Error");
		}finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return result;
	}
	public BoardDTO selectOne(int bno) {		// 글 읽기
		Connection conn = null;
		PreparedStatement pstmt = null;
		BoardDTO result = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.makeConnection();
			String sql = "select bno, title, writer, content, write_date, read_count from board_tb where bno = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new BoardDTO();
				result.setBno(rs.getInt(1));
				result.setTitle(rs.getString(2));
				result.setWriter(rs.getString(3));
				result.setContent(rs.getString(4));
				result.setWrite_date(rs.getString(5));
				result.setRead_count(rs.getInt(6));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Select One Error");
		}finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return result;
	}
	public int updateReadCount(int bno) {		// 글 수정
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rs = null;
		try {
			conn = DBUtil.makeConnection();
			String sql = "update board_tb set read_count = read_count + 1 where bno = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Update Error");
		}finally {
			DBUtil.close(rs, pstmt, conn);
		}
		
		return result;
	}
}
