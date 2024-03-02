package mvc.handler.board;

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

public class AllBoardViewHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Connection conn = ConnectionProvider.getConnection();
		BoardDao boardDao = BoardDao.getInstance();
		MemberDao memberDao = MemberDao.getInstance();
		
		ArrayList<Board> entireList = boardDao.selectEntirety(conn);
		
		
		String id = (String) req.getSession().getAttribute("authenticatedUser");
		
		
		for (Board board : entireList) {
			
			int memberno = board.getMemberno();
			String writerId = memberDao.selectOne(conn, memberno).getId();
			
			if(writerId.equals(id)) {
				board.setWriter("😎나");
			} else if(board.getType().equals("익명")) {
				board.setWriter("익명의 작성자");
			} else {
				board.setWriter(writerId);
			}
		}
		
		req.setAttribute("entireList", entireList);
				
		return "/WEB-INF/board/allBoardView.jsp";
	}

}
