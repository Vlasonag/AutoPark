package controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import model.ENUM.ROLE;
import model.entity.Car;
import model.entity.Driver;
import model.entity.Route;
import model.service.MakeAnAppointmentService;

public class MakeAnAppointmentCommand implements Command {
	MakeAnAppointmentService makeAnAppointmentService = new MakeAnAppointmentService();
	
	public MakeAnAppointmentCommand(MakeAnAppointmentService makeAnAppointmentService) {
		this.makeAnAppointmentService = makeAnAppointmentService;
	}
	@Override
	public String execute(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		ROLE role = (ROLE) session.getAttribute("role");
		if (role.toString().equals("ADMIN")) {
			
			
			try {
				Integer id = Integer.parseInt(request.getParameter("driver"));
				String[] route = request.getParameter("route").split(" ");
				Integer r_id = Integer.parseInt(route[2]);
				String number = request.getParameter("car");
				String login = makeAnAppointmentService.getLoginById(id);
				String model = makeAnAppointmentService.getModelByNumber(number);
				Integer intRoute = Integer.parseInt(route[1]);
				if (route[0].equals("") || intRoute.toString().equals("") || number.toString().equals("")
						|| model.toString().equals("") || id.toString().equals("") 
						|| login.toString().equals("") || r_id.toString().equals("")) {
					return "/error";
				}
				makeAnAppointmentService.setCarBusy(number);
				logger.info("This is info : login: " + session.getAttribute("login") + "| role: " 
						+ session.getAttribute("role") + " сделал водителя занятым по: number = " + number);
				makeAnAppointmentService.setDriverBusy(id);
				logger.info("This is info : login: " + session.getAttribute("login") + "| role: " 
						+ session.getAttribute("role") + " сделал машину занятой по: id = " + id);
				makeAnAppointmentService.createAnAppointment(route[0], intRoute, number, model, id, login, r_id);
				logger.info("This is info : login: " + session.getAttribute("login") + "| role: " 
						+ session.getAttribute("role") + " создал назначение по: route_name = " + route[0] + 
						", route_distance = " + intRoute + ", car_number = " + number + ", car_model = " + model
						 + ", driver_id = " + id + ", driver_login = " + login);
			}
			catch (Exception e) {
				logger.error("This is info : login = " + session.getAttribute("login") + "| role = " 
						+ session.getAttribute("role") + " ввел неверные данные и перешел на страницу error");
				return "/error";
			}
			List<Route> routelist = makeAnAppointmentService.getAllRoutes();
			request.setAttribute("routelist", routelist);
			List<Car> carlist = makeAnAppointmentService.getAllFreeCars();
			request.setAttribute("carlist", carlist);
			List<Driver> driverlist = makeAnAppointmentService.getAllFreeDrivers();
			request.setAttribute("driverlist", driverlist);			
			
			
			return "appointment.jsp";
		}
		else {
			logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
					+ session.getAttribute("role") + " сессия завершена");
			return "/logout";
	}
	}

}
