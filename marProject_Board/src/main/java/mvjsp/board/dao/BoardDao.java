package mvjsp.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import mvjsp.board.model.Board;
import mvjsp.board.model.Member;
import mvjsp.jdbc.JdbcUtil;

public class BoardDao {
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}

	private BoardDao() {
	}
	
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from board");
			rs.next();
			return rs.getInt(1);
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	public ArrayList<Board> selectPopular(Connection conn) {
		ArrayList<Board> popularList = new ArrayList<>();
		String sql = "SELECT * FROM (SELECT * FROM board ORDER BY hits DESC ) WHERE ROWNUM <= 10";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board(rs.getInt("boardno"), rs.getString("type"), rs.getString("title"), rs.getInt("hits"), rs.getInt("recommends"));				
				popularList.add(board);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return popularList;

	}//method
	
	
	public ArrayList<Board> selectBest(Connection conn) {
		ArrayList<Board> bestList = new ArrayList<>();
		String sql = "SELECT * FROM (SELECT * FROM board ORDER BY recommends DESC ) WHERE ROWNUM <= 10";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board(rs.getInt("boardno"), rs.getString("type"), rs.getString("title"), rs.getInt("hits"), rs.getInt("recommends"));				
				bestList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return bestList;

	}//method

	public ArrayList<Board> selectAnonymous(Connection conn) {
		ArrayList<Board> anonymousList = new ArrayList<>();
		String sql = "SELECT * FROM (SELECT * FROM board WHERE type = ? ORDER BY boardno DESC ) WHERE ROWNUM <= 10";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "익명");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board(rs.getInt("boardno"), rs.getString("type"), rs.getString("title"), rs.getInt("hits"), rs.getInt("recommends"));				
				anonymousList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return anonymousList;
	}//method
	
	public ArrayList<Board> selectFree(Connection conn) {
		ArrayList<Board> freeList = new ArrayList<>();
		String sql = "SELECT * FROM (SELECT * FROM board WHERE type = ? ORDER BY boardno DESC ) WHERE ROWNUM <= 10";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "자유");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board(rs.getInt("boardno"), rs.getInt("memberno"), rs.getString("title"), rs.getInt("hits"), rs.getInt("recommends"));				
				freeList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return freeList;
	}//method

	public ArrayList<Board> selectAll(Connection conn) {
		ArrayList<Board> allList = new ArrayList<>();
		String sql = "SELECT * FROM (SELECT * FROM board ORDER BY boardno DESC ) WHERE ROWNUM <= 10";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board(rs.getInt("boardno"), rs.getString("type"), rs.getString("title"), rs.getInt("hits"), rs.getInt("recommends"));				
				allList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return allList;
	}//method
	
	public ArrayList<Board> selectMy(Connection conn, int memberno) {
		ArrayList<Board> myList = new ArrayList<>();
		String sql = "SELECT * FROM board WHERE memberno = ? ORDER BY boardno DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board(rs.getInt("boardno"), rs.getString("type"), rs.getString("title"), rs.getInt("hits"), rs.getInt("recommends"), rs.getString("regtime"));				
				myList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return myList;
	}//method

	
	public Board selectOneArticle(Connection conn, int boardno) {
		Board article = null;
		String sql = "SELECT * FROM board WHERE boardno = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				article = new Board(rs.getInt("boardno"), rs.getInt("memberno"), rs.getString("type"), rs.getString("regtime"), rs.getInt("hits"), rs.getInt("recommends"), rs.getString("title"),  rs.getString("content"));				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return article;
	}
	
	public ArrayList<Board> selectEntirety(Connection conn) {
		ArrayList<Board> entireList = new ArrayList<>();
		String sql = "SELECT * FROM board ORDER BY boardno DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board(rs.getInt("boardno"), rs.getInt("memberno"), rs.getString("type"), rs.getString("regtime"), rs.getInt("hits"), rs.getInt("recommends"), rs.getString("title"), rs.getString("content"));				
				entireList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return entireList;
	}//method
	
	
	public int insert(Connection conn, Board article) {
		String sql = "INSERT INTO board VALUES (board_seq.NEXTVAL, ?, ?, ?, 0, 0, ?, ?)";
		LocalDateTime currentTime = LocalDateTime.now();
		Timestamp regtime = Timestamp.valueOf(currentTime);
		try ( 
		        PreparedStatement pstmt = conn.prepareStatement(sql);            
		    ) {
		    	pstmt.setInt(1, article.getMemberno());
		    	pstmt.setString(2, article.getType());
		    	pstmt.setTimestamp(3, regtime);
		    	pstmt.setString(4, article.getTitle());
		    	pstmt.setString(5, article.getContent());
		        return pstmt.executeUpdate();
		    
		    } catch(Exception e) {
		        e.printStackTrace();
		    } 
			return 0;
	}
	
	public int update(Connection conn, Board board) {
		String sql = "UPDATE board SET type = ?, title = ?, content = ? WHERE boardno = ?";
	    try ( 
	        PreparedStatement pstmt = conn.prepareStatement(sql);            
	    ) {
	        
	    	pstmt.setInt(4, board.getBoardno());
	    	pstmt.setString(1, board.getType());
	    	pstmt.setString(2, board.getTitle());
	    	pstmt.setString(3, board.getContent());
	        return pstmt.executeUpdate();
	    
	    } catch(Exception e) {
	        e.printStackTrace();
	    } 
		return 0;
	}

	public int delete(Connection conn, int boardno) {
		String sql = "DELETE FROM board WHERE boardno = ?";
	    try ( 
	        PreparedStatement pstmt = conn.prepareStatement(sql);            
	    ) {
	        
	        // 쿼리 실행
	    	pstmt.setInt(1, boardno);
	        return pstmt.executeUpdate();
	    
	    } catch(Exception e) {
	        e.printStackTrace();
	    } 
		return 0;
	}

	public int incrementHits(Connection conn, int boardno) {
		String updateSql = "UPDATE board SET hits = hits + 1 WHERE boardno = ?";

	    try (PreparedStatement updatePstmt = conn.prepareStatement(updateSql)) {
	        updatePstmt.setInt(1, boardno);
	        int rowsUpdated = updatePstmt.executeUpdate();
	        return rowsUpdated;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return 0;
	}

	public int getHits(Connection conn, int boardno) {
	    String sql = "SELECT hits FROM board WHERE boardno = ?";
	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setInt(1, boardno);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            return rs.getInt("hits");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return 0; 
	}
	
	
}//class
