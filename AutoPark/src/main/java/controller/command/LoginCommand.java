package controller.command;

import java.sql.SQLException; 

import javax.servlet.http.HttpServletRequest;

import model.service.LoginService;

public class LoginCommand implements Command{
	
	LoginService loginService = new LoginService();
	
	public LoginCommand(LoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	public String execute(HttpServletRequest request) {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		try {
			if(loginService.isDriverExist(login, password)) {
				return "/driver_menu.jsp";
			}
			
		} catch (SQLException e) {
			return "/error";
		}
		return "/index.jsp";
	}

}
