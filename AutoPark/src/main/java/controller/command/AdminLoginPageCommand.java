package controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class AdminLoginPageCommand implements Command{
	
	@Override
	public String execute(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
		+ session.getAttribute("role") + " зашел на страницу: admin_login");
		return "admin_login.jsp";
	}

}
