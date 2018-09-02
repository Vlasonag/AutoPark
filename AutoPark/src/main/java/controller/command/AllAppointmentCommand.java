package controller.command;

import java.util.List; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import model.ENUM.ROLE;
import model.entity.AppointmentDTO;
import model.service.ShowAllAppointmentsService;

public class AllAppointmentCommand implements Command{
	final static Logger logger = Logger.getLogger(AdminLoginPageCommand.class);
	ShowAllAppointmentsService showAllAppointmentsService = new ShowAllAppointmentsService();
	public AllAppointmentCommand(ShowAllAppointmentsService showAllAppointmentsService) {
		this.showAllAppointmentsService = showAllAppointmentsService;
	}
	@Override
	public String execute(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		ROLE role = (ROLE) session.getAttribute("role");
		if (role.toString().equals("ADMIN")) {
			List<AppointmentDTO> applist = showAllAppointmentsService.getAll();
			request.setAttribute("applist", applist);
			logger.info("This is info : login = " + session.getAttribute("login") +
					"| role = " + session.getAttribute("role") + " зашел на страницу: appointments");
			return "cappointment.jsp";
		}
		else {
			logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
					+ session.getAttribute("role") + " сессия завершена");
			return "/logout";
		}
	}
}