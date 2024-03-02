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

public class UpdateHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String id = (String) req.getSession().getAttribute("authenticatedUser");
		

		int thisBoardno = Integer.parseInt(req.getParameter("boardno"));
		String type = req.getParameter("type");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
				
		//아래 connection, DAO instance는 무조건
		Connection conn = ConnectionProvider.getConnection();
		BoardDao boardDao = BoardDao.getInstance();
		
		Board newInfoBoard = new Board(type, title, content, thisBoardno);
		int updateResult = boardDao.update(conn, newInfoBoard);
		
		Board board = boardDao.selectOneArticle(conn, thisBoardno);
		int boardno = board.getBoardno();
		req.setAttribute("boardno", boardno);
		req.setAttribute("hits", 2);
				
		return "/WEB-INF/board/redirectReadView.jsp";
		
	}

}
