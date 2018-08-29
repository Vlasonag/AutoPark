package controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.ENUM.ROLE;
import model.service.LoginAsAdminService;

public class LoginAsAdminCommand implements Command {
	
	LoginAsAdminService loginAsAdminService = new LoginAsAdminService();
	
	public LoginAsAdminCommand(LoginAsAdminService loginAsAdminService) {
		this.loginAsAdminService = loginAsAdminService;
	}

	@Override
	public String execute(HttpServletRequest request) {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		if(loginAsAdminService.isAdminExist(login, password)) {
			return "/admin_menu.jsp";
		}
		else {
			return "/index.jsp";
		}
	}

}