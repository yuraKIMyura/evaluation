package mvc.handler.member;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import mvjsp.board.dao.MemberDao;
import mvjsp.board.model.Member;
import mvjsp.jdbc.connection.ConnectionProvider;

public class JoinHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		String question = req.getParameter("question");
		String answer = req.getParameter("answer");

		//아래 두 줄은 무조건
		Connection conn = ConnectionProvider.getConnection();
		MemberDao dao = MemberDao.getInstance();

		Member member = new Member(id, email, name, question, answer);
		dao.insert(conn, member);
		
		return "/WEB-INF/member/loginForm.jsp";
	}

}
