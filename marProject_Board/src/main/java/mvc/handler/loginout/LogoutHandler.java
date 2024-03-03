package mvc.handler.loginout;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;
import mvjsp.board.dao.BoardDao;
import mvjsp.board.dao.MemberDao;
import mvjsp.board.model.Board;
import mvjsp.board.model.Member;
import mvjsp.jdbc.connection.ConnectionProvider;

public class LogoutHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		HttpSession session = req.getSession(false);
		session.invalidate();
		
		String email = "";
		String id = "";

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
		    for (Cookie cookie : cookies) {
		        if (cookie.getName().equals("userEmail")) {
		            email = cookie.getValue();
		        } else if (cookie.getName().equals("userId")) {
		            id = cookie.getValue();
		        }
		    }
		}
		
		req.setAttribute("email", email);
		req.setAttribute("id", id);
		
		return "/WEB-INF/member/loginForm.jsp";
		
	}
}
