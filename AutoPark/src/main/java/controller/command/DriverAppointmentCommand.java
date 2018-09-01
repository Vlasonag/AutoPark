package controller.command;


import java.sql.SQLException;

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
		String password = (String) session.getAttribute("password");
		AppointmentDTO app = driverAppointmentService.getAppointmentByLogin(login);
		ROLE role = (ROLE) session.getAttribute("role");
		try {
		if (role.toString().equals("DRIVER") && driverAppointmentService.isDriverExist(login, password) && driverAppointmentService.isDriverConfirmed(login, password) && app == null) {
			return "/noappointment.jsp";
		} 
		else if (role.toString().equals("DRIVER") && driverAppointmentService.isDriverExist(login, password) && driverAppointmentService.isDriverConfirmed(login, password)) {
			request.setAttribute("app", app);
			return "/driverappointment.jsp";
		}
		else if (driverAppointmentService.isDriverExist(login, password) && !driverAppointmentService.isDriverConfirmed(login, password)) {
			return "/notconfirmed.jsp";
		}
		else {
			return "/logout";
		}
		}
		catch (SQLException e) {
			return "/error";
		}
			
		
	}
}
