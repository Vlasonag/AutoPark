package controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.ENUM.ROLE;

public class LogoutCommand implements Command{

	@Override
	public String execute(HttpServletRequest request) {
		
		final HttpSession session = request.getSession();
		
        session.removeAttribute("login");
        session.removeAttribute("role");
        
        logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
				+ session.getAttribute("role") + " сессия завершена");
		return "login_page";
	}

}
