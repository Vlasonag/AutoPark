package controller.command;

import java.sql.SQLException;
import java.util.List; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

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
			
			int page = 1;
	        int recordsPerPage = 1;
	        List<AppointmentDTO> applist;
	        
	        if(request.getParameter("page") != null) {
	        	page = Integer.parseInt(request.getParameter("page"));
	        }
	        
	        try {
				applist = showAllAppointmentsService.getAllForPage((page-1)*recordsPerPage,
				        recordsPerPage);
			} 
	        catch (SQLException e) {
				return "/noappointments";
			}
	        
			int noOfRecords  = showAllAppointmentsService.getNumberOfAppointments();
			int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			
			request.setAttribute("applist", applist);
			request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
            
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