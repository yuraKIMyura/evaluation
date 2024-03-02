package mvc.handler.member;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;
import mvjsp.board.dao.BoardDao;
import mvjsp.board.dao.MemberDao;
import mvjsp.board.model.Board;
import mvjsp.board.model.Member;
import mvjsp.jdbc.connection.ConnectionProvider;

public class DeleteHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String id = (String) req.getSession().getAttribute("authenticatedUser");
		System.out.println(id);
	
		//아래 connection, DAO instance는 무조건
		Connection conn = ConnectionProvider.getConnection();
		MemberDao memberDao = MemberDao.getInstance();
			
		int deleteResult = memberDao.delete(conn, id);
		System.out.println(deleteResult);
				
		return "/WEB-INF/member/loginForm.jsp";
		
	}

}
