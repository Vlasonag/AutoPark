package controller.command;

import javax.servlet.http.HttpServletRequest;

public class WrongRoleErrorCommand implements Command{

	@Override
	public String execute(HttpServletRequest request) {
		
		return "wrongrole.jsp";
	}

}
