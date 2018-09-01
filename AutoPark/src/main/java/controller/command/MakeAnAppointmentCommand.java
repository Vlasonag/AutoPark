package controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
				int id = Integer.parseInt(request.getParameter("driver"));
				String[] route = request.getParameter("route").split(" ");
				String number = request.getParameter("car");
				String login = makeAnAppointmentService.getLoginById(id);
				String model = makeAnAppointmentService.getModelByNumber(number);
				int intRoute = Integer.parseInt(route[1]);
				makeAnAppointmentService.setCarBusy(number);
				makeAnAppointmentService.setDriverBusy(id);
				makeAnAppointmentService.createAnAppointment(route[0], intRoute, number, model, id, login);
			}
			catch (Exception e) {
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
			return "/logout";
	}
	}

}
