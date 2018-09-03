package controller.command;

import javax.servlet.http.HttpServletRequest;

public class LoginExistPageCommand implements Command{

	@Override
	public String execute(HttpServletRequest request) {
		
		return "loginexist.jsp";
	}

}
