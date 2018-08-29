package controller.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.ENUM.ROLE;
import model.entity.AppointmentDTO;
import model.service.DriverAppointmentService;

public class DriverAppointmentCommand implements Command{
	
	DriverAppointmentService driverAppointmentService = new DriverAppointmentService();
	
	public DriverAppointmentCommand(DriverAppointmentService driverAppointmentService) {
		this.driverAppointmentService = driverAppointmentService;
	}

	@Override
	public String execute(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		String login = (String) session.getAttribute("login");
		AppointmentDTO app = driverAppointmentService.getAppointmentByLogin(login);
		ROLE role = (ROLE) session.getAttribute("role");
		if (role.toString().equals("DRIVER") && app != null) {
			
			request.setAttribute("app", app);
			return "/driverappointment.jsp";
		}
		else if (role.toString().equals("DRIVER") && app == null) {
			return "/noappointment.jsp";
		}
		else {
			return "/logout";
		}
	}
}
