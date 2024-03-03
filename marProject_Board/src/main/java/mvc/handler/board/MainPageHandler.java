package mvc.handler.board;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;
import mvjsp.board.dao.BoardDao;
import mvjsp.board.dao.MemberDao;
import mvjsp.board.dao.RecommendDao;
import mvjsp.board.model.Board;
import mvjsp.board.model.Member;
import mvjsp.jdbc.connection.ConnectionProvider;

public class MainPageHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
			
				
		//아래 connection, DAO instance는 무조건
		Connection conn = ConnectionProvider.getConnection();
		BoardDao boardDao = BoardDao.getInstance();
		RecommendDao recommendDao = RecommendDao.getInstance();

				
		ArrayList<Board> allList = boardDao.selectAll(conn);
		for (Board board : allList) {
			int boardno = board.getBoardno();
			int recommends = recommendDao.countRecommends(conn, boardno);
			board.setRecommends(recommends);
	}
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
			
		String id = (String) req.getSession().getAttribute("authenticatedUser");
		req.setAttribute("id", id);
				
		
		return "/WEB-INF/board/postLoginView.jsp";
	}

}
