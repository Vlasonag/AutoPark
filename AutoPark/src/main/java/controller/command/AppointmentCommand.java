package controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import model.ENUM.ROLE;
import model.entity.Car;
import model.entity.Driver;
import model.entity.Route;
import model.service.ShowAppointmentsService;

public class AppointmentCommand implements Command{
	final static Logger logger = Logger.getLogger(AdminLoginPageCommand.class);
	ShowAppointmentsService showAppointmentsService = new ShowAppointmentsService();
	public AppointmentCommand(ShowAppointmentsService showAppointmentsService) {
		this.showAppointmentsService = showAppointmentsService;
	}
	@Override
	public String execute(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		ROLE role = (ROLE) session.getAttribute("role");
		if (role.toString().equals("ADMIN")) {
			List<Route> routelist = showAppointmentsService.getAllRoutes();
			request.setAttribute("routelist", routelist);
			List<Car> carlist = showAppointmentsService.getAllFreeCars();
			request.setAttribute("carlist", carlist);
			List<Driver> driverlist = showAppointmentsService.getAllFreeDrivers();
			request.setAttribute("driverlist", driverlist);
			logger.info("This is info : login = " + session.getAttribute("login") + "| role = " + 
			session.getAttribute("role") + " зашел на страницу: appointment");
			return "appointment.jsp";
		}
		else {
			logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
					+ session.getAttribute("role") + " сессия завершена");
			return "/logout";
	}
	}

}
