package controller.command;

import javax.servlet.http.HttpServletRequest;

public class AdminLoginPageCommand implements Command{

	@Override
	public String execute(HttpServletRequest request) {
		return "admin_login.jsp";
	}

}
