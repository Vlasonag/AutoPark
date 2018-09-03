package controller.command;

 
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

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
			logger.info("This is warn : login = " + session.getAttribute("login") + "| role = " 
					+ session.getAttribute("role") + " удалил машину по: number = " + number);
			
			List<Car> carlist = deleteCarService.getAll();		
			request.setAttribute("carlist", carlist);
			
			return "/cars";
		}
		logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
				+ session.getAttribute("role") + " сессия завершена");
		return "/logout";
	}
}
