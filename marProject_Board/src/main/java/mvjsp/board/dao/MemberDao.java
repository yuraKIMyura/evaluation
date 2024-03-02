package mvjsp.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mvjsp.board.model.Member;
import mvjsp.jdbc.JdbcUtil;

public class MemberDao {
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}

	private MemberDao() {
	}
	
	//DBCP에서 connection을 주고 있어!
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from member");
			rs.next();
			return rs.getInt(1);
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}//method
	
	public ArrayList<Member> selectAll(Connection conn) {
		ArrayList<Member> list = new ArrayList<>();
		String sql = "select * from member";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//util이 있으니까 try-catch하지 않아도 된다구
		//finally로 가자구
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member member = new Member(rs.getInt("memberno"), rs.getString("id"), rs.getString("email"), rs.getString("name"), rs.getString("question"), rs.getString("answer"));				
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return list;
	} 
		
	public boolean authenticateUser(Connection conn, String id, String email) {
		String sql = "SELECT * FROM member WHERE id = ? AND email = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return false;
	}
	
	
	public Member selectOne(Connection conn, int memberno) {
		Member member = null;
		String sql = "SELECT * FROM member WHERE memberno = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//util이 있으니까 try-catch하지 않아도 된다구
		//finally로 가자구
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member(rs.getInt("memberno"), rs.getString("id"), rs.getString("email"), rs.getString("name"), rs.getString("question"), rs.getString("answer"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return member;
	}
	
	public int insert(Connection conn, Member member) {
		String sql = "INSERT INTO member(memberno, id, email, name, question, answer) VALUES (member_seq.NEXTVAL, ?, ?, ?, ?, ?)";
	    try ( 
	        PreparedStatement pstmt = conn.prepareStatement(sql);            
	    ) {
	        
	        // 쿼리 실행
	    	pstmt.setString(1, member.getId());
	    	pstmt.setString(2, member.getEmail());
	    	pstmt.setString(3, member.getName());
	    	pstmt.setString(4,  member.getQuestion());
	    	pstmt.setString(5, member.getAnswer());
	        return pstmt.executeUpdate();
	    
	    } catch(Exception e) {
	        e.printStackTrace();
	    } 
		return 0;
	}
	
	public int update(Connection conn, Member member) {
		String sql = "UPDATE member SET email = ?, name = ?, question = ?, answer = ? WHERE id = ?";
	    try ( 
	        PreparedStatement pstmt = conn.prepareStatement(sql);            
	    ) {
	        
	        // 쿼리 실행
	    	pstmt.setString(5, member.getId());
	    	pstmt.setString(1, member.getEmail());
	    	pstmt.setString(2, member.getName());
	    	pstmt.setString(3, member.getQuestion());
	    	pstmt.setString(4, member.getAnswer());
	        return pstmt.executeUpdate();
	    
	    } catch(Exception e) {
	        e.printStackTrace();
	    } 
		return 0;
	}


	public Member searchById(Connection conn, String id) {
		Member member = null;
		String sql = "SELECT * FROM member WHERE id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member(rs.getInt("memberno"), rs.getString("id"), rs.getString("email"), rs.getString("name"), rs.getString("question"), rs.getString("answer"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return member;
	}

	
	public int delete(Connection conn, String id) {
		String sql = "DELETE FROM member WHERE id = ?";
	    try ( 
	        PreparedStatement pstmt = conn.prepareStatement(sql);            
	    ) {
	        
	        // 쿼리 실행
	    	pstmt.setString(1, id);
	        return pstmt.executeUpdate();
	    
	    } catch(Exception e) {
	        e.printStackTrace();
	    } 
		return 0;
	}
	
}//class
