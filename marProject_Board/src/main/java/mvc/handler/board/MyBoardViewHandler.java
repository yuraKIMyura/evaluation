package mvc.handler.board;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import mvjsp.board.dao.BoardDao;
import mvjsp.board.dao.MemberDao;
import mvjsp.board.model.Board;
import mvjsp.board.model.Member;
import mvjsp.jdbc.connection.ConnectionProvider;

public class MyBoardViewHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Connection conn = ConnectionProvider.getConnection();
		BoardDao boardDao = BoardDao.getInstance();
		MemberDao memberDao = MemberDao.getInstance();

		String id = (String) req.getSession().getAttribute("authenticatedUser");
		int memberno = memberDao.searchById(conn, id).getMemberno();
		
		ArrayList<Board> myList = boardDao.selectMy(conn,memberno);
				
		for (Board board : myList) {
				board.setWriter("😎나");
		}
		
		req.setAttribute("myList", myList);
		req.setAttribute("id", id);
				
		return "/WEB-INF/board/myBoardView.jsp";
	}

}
