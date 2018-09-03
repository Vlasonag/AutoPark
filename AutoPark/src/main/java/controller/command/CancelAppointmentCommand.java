package controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

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
			int page = 1;
	        int recordsPerPage = 1;
	        if(request.getParameter("page") != null) {
	        	page = Integer.parseInt(request.getParameter("page"));
	        }
			String number = request.getParameter("number");
			int id = Integer.parseInt(request.getParameter("id"));
			cancelAppointmentService.cancelAppointment(id, number);
			logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
			+ session.getAttribute("role") + " отменил назначение по: driver_id = " + id + ", car_number = " + number);
			List<AppointmentDTO> applist = cancelAppointmentService.getAllForPage((page-1)*recordsPerPage,
                    recordsPerPage);
			int noOfRecords  = cancelAppointmentService.getNumberOfAppointments();
			int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			System.out.println();
			request.setAttribute("applist", applist);	
			request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
			return "cappointment.jsp";
		}
		else {
			logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
					+ session.getAttribute("role") + " сессия завершена");
			return "/logout";
		}
	}

}
