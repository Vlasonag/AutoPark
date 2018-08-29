package controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.ENUM.ROLE;
import model.entity.AppointmentDTO;
import model.service.CancelAppointmentService;

public class CancelAppointmentCommand implements Command{

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
			String id = request.getParameter("id");
			System.out.println(id);
			System.out.println(number);
			cancelAppointmentService.cancelAppointment(id, number);
			List<AppointmentDTO> applist = cancelAppointmentService.getAll();
			request.setAttribute("applist", applist);
			return "cappointment.jsp";
		}
		else {
			return "/logout";
		}
	}

}
