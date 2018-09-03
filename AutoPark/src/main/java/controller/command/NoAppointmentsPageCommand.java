package controller.command;

import javax.servlet.http.HttpServletRequest;

public class NoAppointmentsPageCommand implements Command{

	@Override
	public String execute(HttpServletRequest request) {
		
		return "noappointments.jsp";
	}

}
