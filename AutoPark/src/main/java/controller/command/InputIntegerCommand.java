package controller.command;

import javax.servlet.http.HttpServletRequest;

public class InputIntegerCommand  implements Command{

	@Override
	public String execute(HttpServletRequest request) {
		
		return "wronginput.jsp";
	}

}
