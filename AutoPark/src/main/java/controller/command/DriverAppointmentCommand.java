package controller.command;


import java.sql.SQLException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

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
		try {
		String login = (String) request.getSession().getAttribute("login");
		String password = (String) request.getSession().getAttribute("password");
		AppointmentDTO app = driverAppointmentService.getAppointmentByLogin(login);
		ROLE role = (ROLE) session.getAttribute("role");
		if (login.equals("") || password.equals("")) {
			return "/input_integer";
		}
		try {
		if (role.toString().equals("DRIVER") && driverAppointmentService.isDriverExist(login, password) 
					&& driverAppointmentService.isDriverConfirmed(login, password) && app == null) {
			
			logger.info("This is info : login: " + session.getAttribute("login") + "| role: " 
					+ session.getAttribute("role") + "зашел на страницу: noappointment");
			return "/noappointment.jsp";
		} 
		else if (role.toString().equals("DRIVER") && driverAppointmentService.isDriverExist(login, password)
				&& driverAppointmentService.isDriverConfirmed(login, password)) {
			
			request.setAttribute("app", app);
			logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
					+ session.getAttribute("role") + "зашел на страницу: driverappointment");
			return "/driverappointment.jsp";
		}
		else if (driverAppointmentService.isDriverExist(login, password) 
						&& !driverAppointmentService.isDriverConfirmed(login, password)) {
			logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
					+ session.getAttribute("role") + "зашел на страницу: notconfirmed");
			return "/notconfirmed.jsp";
		}
		else {
			logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
					+ session.getAttribute("role") + " сессия завершена");
			return "/logout";
		}
		}
		catch (SQLException e) {
			logger.error("This is info : login = " + session.getAttribute("login") + "| role = " 
					+ session.getAttribute("role") + " ввел неверные данные и перешел на страницу wrongiput");
			return "/error";
		}
			
		
	}
		catch (NullPointerException e) {
			return "/input_integer";
		}
	}
		
}
