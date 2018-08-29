package controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.ENUM.ROLE;
import model.entity.AppointmentDTO;
import model.service.ConfirmAppointmentService;

public class ConfirmAppointmentCommand implements Command{
	
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
			AppointmentDTO app = confirmAppointmentService.getAppointmentByLogin(login);
			request.setAttribute("app", app);
			return "driverappointment.jsp";
		}
		else {
			return "/logout";
		}
	}

}
