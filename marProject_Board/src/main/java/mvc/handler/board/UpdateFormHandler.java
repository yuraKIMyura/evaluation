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

public class UpdateFormHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int boardno = Integer.parseInt(req.getParameter("boardno"));
		
		//아래 connection, DAO instance는 무조건
		Connection conn = ConnectionProvider.getConnection();
		BoardDao boardDao = BoardDao.getInstance();
		
		Board board = boardDao.selectOneArticle(conn, boardno);
		req.setAttribute("board", board);
				
		return "/WEB-INF/board/updateForm.jsp";
		
	}

}
