package controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.ENUM.ROLE;
import model.entity.Car;
import model.service.ShowCarsService;

public class CarCommand implements Command{

	ShowCarsService showCarsService = new ShowCarsService();
	public CarCommand(ShowCarsService showCarsService) {
		this.showCarsService = showCarsService;
	}
	@Override
	public String execute(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		ROLE role = (ROLE) session.getAttribute("role");
		if (role.toString().equals("ADMIN")) {
			List<Car> carlist = showCarsService.getAll();
			request.setAttribute("carlist", carlist);
			return "cars.jsp";
		}
		else {
			return "/logout";
	}

}

}
