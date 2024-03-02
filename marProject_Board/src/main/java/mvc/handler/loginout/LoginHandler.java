package mvc.handler.loginout;

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

public class LoginHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		

		//아래 connection, DAO instance는 무조건
		Connection conn = ConnectionProvider.getConnection();
		MemberDao memberDao = MemberDao.getInstance();
		BoardDao boardDao = BoardDao.getInstance();
		
		ArrayList<Board> allList = boardDao.selectAll(conn);
		req.setAttribute("allList", allList);
		
//		ArrayList<Board> popularList = boardDao.selectPopular(conn);
//		req.setAttribute("popularList", popularList);
//		
//		ArrayList<Board> bestList = boardDao.selectBest(conn);
//		req.setAttribute("bestList", bestList);
		
//		ArrayList<Board> anonymousList = boardDao.selectAnonymous(conn);
//		req.setAttribute("anonymousList", anonymousList);
//		
//		ArrayList<Board> freeList = boardDao.selectFree(conn);
//		req.setAttribute("freeList", freeList);
//	
		
		boolean isValidUser = memberDao.authenticateUser(conn, id, email);
		
		
		
		if(isValidUser) {
			HttpSession session = req.getSession();
			session.setAttribute("authenticatedUser", id);
			req.setAttribute("id",id);
			return "/WEB-INF/board/postLoginView.jsp";
		}else {
			return "/WEB-INF/member/loginForm.jsp";
		}
		
	}

}
