package controller.command;

import javax.servlet.http.HttpServletRequest;

public class RepeatErrorCommand implements Command{

	@Override
	public String execute(HttpServletRequest request) {
		
		return "repeat_error.jsp";
	}

}
