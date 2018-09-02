package controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import model.ENUM.ROLE;
import model.entity.AppointmentDTO;
import model.service.CancelAppointmentService;

public class CancelAppointmentCommand implements Command{
	final static Logger logger = Logger.getLogger(AdminLoginPageCommand.class);
	CancelAppointmentService cancelAppointmentService = new CancelAppointmentService();
	
	public CancelAppointmentCommand(CancelAppointmentService cancelAppointmentService) {
		this.cancelAppointmentService = cancelAppointmentService;
	}
	@Override
	public String execute(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		ROLE role = (ROLE) session.getAttribute("role");
		if (role.toString().equals("ADMIN")) {
			String number = request.getParameter("number");
			int id = Integer.parseInt(request.getParameter("id"));
			cancelAppointmentService.cancelAppointment(id, number);
			logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
			+ session.getAttribute("role") + " отменил назначение по: driver_id = " + id + ", car_number = " + number);
			List<AppointmentDTO> applist = cancelAppointmentService.getAll();
			request.setAttribute("applist", applist);	
			return "cappointment.jsp";
		}
		else {
			logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
					+ session.getAttribute("role") + " сессия завершена");
			return "/logout";
		}
	}

}
