package controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.ENUM.ROLE;
import model.entity.Car;
import model.service.CreateCarService;

public class CreateCarCommand implements Command {
	CreateCarService createCarService = new CreateCarService();
	public CreateCarCommand(CreateCarService createCarService) {
		this.createCarService = createCarService;
	}
	@Override
	public String execute(HttpServletRequest request) {
		
		final HttpSession session = request.getSession();
		ROLE role = (ROLE) session.getAttribute("role");
		if (role.toString().equals("ADMIN")) {
			String number = request.getParameter("number");
			String model = request.getParameter("model");
			createCarService.createRoute(number, model);
			List<Car> carlist = createCarService.getAll();		
			request.setAttribute("carlist", carlist);
			return "cars.jsp";
		}
		else {
			return "/logout";
		}
	}
}
