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

public class ReadHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		String id = (String) req.getSession().getAttribute("authenticatedUser");
		int boardno = Integer.parseInt(req.getParameter("boardno"));
		String hits = req.getParameter("hits");
		
		//아래 connection, DAO instance는 무조건
		Connection conn = ConnectionProvider.getConnection();
		BoardDao boardDao = BoardDao.getInstance();
		
		Board article = boardDao.selectOneArticle(conn, boardno);
		if(hits!=null && hits.equals("true")) {
			boardDao.incrementHits(conn, boardno);
		}
		int memberno = article.getMemberno();
		
		MemberDao memberDao = MemberDao.getInstance();
		Member member = memberDao.selectOne(conn, memberno);
		
		boolean isWriter = false;
		if(member.getId().equals(id)) {
			article.setWriter("😎나");
			isWriter=true;
			
		}else if(article.getType().equals("익명")) {
			article.setWriter("익명의 작성자");
		}else {
			article.setWriter(member.getId());
		} 
		
		req.setAttribute("article", article);
		req.setAttribute("isWriter", isWriter);

		return "/WEB-INF/board/readView.jsp";
		
	}

}
