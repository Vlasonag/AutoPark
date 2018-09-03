package controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginPageCommand implements Command{

	@Override
	public String execute(HttpServletRequest request) {
		
		final HttpSession session = request.getSession();
		
		logger.info("This is info : login = " + session.getAttribute("login") +
				"| role = " + session.getAttribute("role") + " перешел на страницу: login_page");
		return "index.jsp";
		}
}
