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

public class ReadHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		String id = (String) req.getSession().getAttribute("authenticatedUser");
		int boardno = Integer.parseInt(req.getParameter("boardno"));
		String hits = req.getParameter("hits");
		
		System.out.println("READ: "+id);
		System.out.println("hits: " + hits);
		
		//아래 connection, DAO instance는 무조건
		Connection conn = ConnectionProvider.getConnection();
		BoardDao boardDao = BoardDao.getInstance();
		MemberDao memberDao = MemberDao.getInstance();
		RecommendDao recommendDao = RecommendDao.getInstance();

		
		//boardno를 사용해서 article을 특정, article을 작성한 회원 memberno를 획득
		Board article = boardDao.selectOneArticle(conn, boardno);
		int articleMemberno = article.getMemberno();
		
		//추천수 조회 후 설정
		int recommends = recommendDao.countRecommends(conn, boardno);
		article.setRecommends(recommends);
		
		//위에서 얻은 작성자 memberno로 작성자의 정보를 조회
		Member articleMember = memberDao.selectOne(conn, articleMemberno);
		
		//[admin]작성자 회원정보 외에, 현재 로그인한 회원의 정보를 조회
		Member loggedinMember = memberDao.searchById(conn, id);
	
		
		
		//[admin]현재 로그인한 회원이 admin role인지 확인
		int role = loggedinMember.getRole();


		if(role==1) hits="false";
		//만일 hits가 false이거나(수정 후 조회) role이 1이면 조회수 증가시키지 않음
		if(hits!=null && hits.equals("true") ) {
			boardDao.incrementHits(conn, boardno);
		    int updatedHits = boardDao.getHits(conn, boardno); // Replace 'getHits' with your method to fetch hits
		    article.setHits(updatedHits);
		}
		
		
		
		boolean isWriter = false;
		//1.로그인한 회원과 작성 회원이 같으면 작성자를 '나'로 보여줌, 수정과 삭제 가능
		if(articleMember.getId().equals(id)) {
			article.setWriter("😎나");
			isWriter=true;
		//2.로그인한 회원의 role이 1이면, 수정과 삭제 가능
		}else if(loggedinMember.getRole()==1) {
			isWriter = true;
		}
		//3.만일 article이 작성된 게시판이 '익명게시판'이면 작성자 이름 가리기
		else if(article.getType().equals("익명")) {
			article.setWriter("익명의 작성자");
		}else {
		//4.위의 어떤 조건에도 해당하지 않으면 article 작성자 아이디 보여줌
			article.setWriter(articleMember.getId());
		} 
		
		
		
		
		//현재 로그인한 회원의 정보를 이용, memberno 및 role 조회
		int memberno = loggedinMember.getMemberno();
		
		//특정 boardno/memberno 조합이 존재하는지 조회
		boolean exists = recommendDao.checkRecommend(conn, boardno, memberno);

		Boolean isRecommended = null;
		if(exists==false) {
			isRecommended = false;
		}
		//만일 특정 boardno/memberno 조합이 존재하고, 현재 로그인한 회원이 [관리자]가 아니면 추천 해제
		else {
			isRecommended = true;
		}
		
		article.setRecommends(recommendDao.countRecommends(conn, boardno));
		

		//article 관련 정보 포함한 Board 객체
		req.setAttribute("article", article);
		//isWriter=true면 수정/삭제 가능
		req.setAttribute("isWriter", isWriter);
		req.setAttribute("isRecommended", isRecommended);

		return "/WEB-INF/board/readView.jsp";
		
	}

}