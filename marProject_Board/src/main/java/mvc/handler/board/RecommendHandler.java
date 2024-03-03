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
import mvjsp.board.model.Recommend;
import mvjsp.jdbc.connection.ConnectionProvider;

public class RecommendHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		String id = (String) req.getSession().getAttribute("authenticatedUser");
		int boardno = Integer.parseInt(req.getParameter("boardno"));
		
		System.out.println("RECOMMEND: "+id);
		
		//아래 connection, DAO instance는 무조건
		Connection conn = ConnectionProvider.getConnection();
		RecommendDao recommendDao = RecommendDao.getInstance();
		MemberDao memberDao = MemberDao.getInstance();
		BoardDao boardDao = BoardDao.getInstance();
		
		//현재 로그인한 회원의 정보를 이용, memberno 및 role 조회
		Member loggedinMember = memberDao.searchById(conn, id);
		int memberno = loggedinMember.getMemberno();
		int role = loggedinMember.getRole();
		
		//특정 boardno/memberno 조합이 존재하는지 조회
		boolean exists = recommendDao.checkRecommend(conn, boardno, memberno);
		System.out.println(exists);
		
		Boolean isRecommended = null;
		//만일 특정 boardno/memberno 조합이 존재하지 않고, 현재 로그인한 회원이 [관리자]가 아니면 추천
		if(exists==false && role!=1) {
			int setResult = recommendDao.setRecommend(conn, boardno, memberno);
			if(setResult>=1) isRecommended = true;
		//만일 특정 boardno/memberno 조합이 존재하고, 현재 로그인한 회원이 [관리자]가 아니면 추천 해제
		}else if(exists==true && role!=1) {
			int unsetResult = recommendDao.unsetRecommend(conn, boardno, memberno);
			if(unsetResult>=1) isRecommended = false;
		}

		Board article = boardDao.selectOneArticle(conn, boardno);
		System.out.println("Article instance: " + article);

		article.setRecommends(recommendDao.countRecommends(conn, boardno));
        
		String hits = "false";		
		//isRecommended가 "true"이면 '추천해제', "false"이면 '추천'
		req.setAttribute("isRecommended", isRecommended);
		req.setAttribute("hits", hits);
		req.setAttribute("article", article);
		
		System.out.println("isRecommended: "+ isRecommended);

		return "/WEB-INF/board/redirectRecommendView.jsp";
		
	}

}