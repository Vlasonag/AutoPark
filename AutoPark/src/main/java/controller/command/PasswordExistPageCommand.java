package controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PasswordExistPageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
				+ session.getAttribute("role") + " ввел неверные данные и перешел на страницу passwordexist");
		
		return "passwordexist.jsp";
	}

}
