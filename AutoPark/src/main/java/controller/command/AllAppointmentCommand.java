package controller.command;

import java.util.List; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.ENUM.ROLE;
import model.entity.AppointmentDTO;
import model.service.ShowAllAppointmentsService;

public class AllAppointmentCommand implements Command{
	
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
			return "cappointment.jsp";
		}
		else {
			return "/logout";
		}
	}
}