package controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import model.ENUM.ROLE;
import model.entity.AppointmentDTO;
import model.service.ConfirmAppointmentService;

public class ConfirmAppointmentCommand implements Command{
	final static Logger logger = Logger.getLogger(AdminLoginPageCommand.class);
	ConfirmAppointmentService confirmAppointmentService = new ConfirmAppointmentService();
	
	public ConfirmAppointmentCommand (ConfirmAppointmentService confirmAppointmentService) {
		this.confirmAppointmentService = confirmAppointmentService;
	}
	@Override
	public String execute(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		String login = (String) session.getAttribute("login");
		ROLE role = (ROLE) session.getAttribute("role");
		if (role.toString().equals("DRIVER")) {
			confirmAppointmentService.confirmAppointment(login);
			logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
					+ session.getAttribute("role") + " подтвердил свое назначение");				
			AppointmentDTO app = confirmAppointmentService.getAppointmentByLogin(login);
			request.setAttribute("app", app);
			return "driverappointment.jsp";
		}
		else {
			logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
					+ session.getAttribute("role") + " сессия завершена");
			return "/logout";
		}
	}

}
