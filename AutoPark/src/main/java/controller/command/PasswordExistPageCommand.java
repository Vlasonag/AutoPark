package controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PasswordExistPageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		return "passwordexist.jsp";
	}

}
