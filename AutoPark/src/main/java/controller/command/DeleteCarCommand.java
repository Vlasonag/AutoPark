package controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.ENUM.ROLE;
import model.entity.Car;
import model.service.DeleteCarService;

public class DeleteCarCommand implements Command{
	DeleteCarService deleteCarService = new DeleteCarService();
	public DeleteCarCommand(DeleteCarService deleteCarService) {
		this.deleteCarService = deleteCarService;
	}
	@Override
	public String execute(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		ROLE role = (ROLE) session.getAttribute("role");
		if (role.toString().equals("ADMIN")) {
			String number = request.getParameter("number");
			deleteCarService.deleteCar(number);
			List<Car> carlist = deleteCarService.getAll();		
			request.setAttribute("carlist", carlist);
			return "cars.jsp";
		}
		else {
			return "/logout";
	}
	}

}
