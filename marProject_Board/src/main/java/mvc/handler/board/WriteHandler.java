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

public class WriteHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		String id = (String) req.getSession().getAttribute("authenticatedUser");
		String type = req.getParameter("type");
		String title =  req.getParameter("title");
		String content = req.getParameter("content");
		
		System.out.println(type);

		//아래 두 줄은 무조건
		Connection conn = ConnectionProvider.getConnection();
		BoardDao boardDao = BoardDao.getInstance();
		MemberDao memberDao = MemberDao.getInstance();
		int memberno = memberDao.searchById(conn, id).getMemberno();

		Board article = new Board(memberno, type, title, content);
		System.out.println(article.toString());
		int insertResult = boardDao.insert(conn, article);
		System.out.println("insertResult: " + insertResult);
		
		return "/WEB-INF/board/redirectAllBoardView.jsp";
	}

}
