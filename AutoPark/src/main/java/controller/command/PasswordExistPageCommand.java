package controller.command;

import javax.servlet.http.HttpServletRequest;

public class PasswordExistPageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		return "passwordexist.jsp";
	}

}
