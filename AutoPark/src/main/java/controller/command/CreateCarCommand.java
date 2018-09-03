package controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

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
		
			try {
				if (role.toString().equals("ADMIN")) {
					String number = new String(request.getParameter("number").getBytes("ISO-8859-1"), "UTF-8");				
					String model = new String(request.getParameter("model").getBytes("ISO-8859-1"), "UTF-8");
					if(number.equals("") || model.equals("")) {
						logger.error("This is info : login = " + session.getAttribute("login") + "| role = " 
								+ session.getAttribute("role") + " ввел неверные данные и перешел на страницу wrongiput");
						return "/input_integer";
					}
					try {
						createCarService.createCar(number, model);
						logger.info("This is warn : login: " + session.getAttribute("login") + "| role: " 
								+ session.getAttribute("role") + " создал машину: number = " + number+  ", model = " + model);
					}
					catch (Exception e) {
						logger.error("This is info : login = " + session.getAttribute("login") + "| role = " 
								+ session.getAttribute("role") + " ввел неверные данные и перешел на страницу wrongiput");
						return "/error";
					}
					List<Car> carlist = createCarService.getAll();		
					request.setAttribute("carlist", carlist);
					return "/cars";
				}
				
			} catch (Exception e) {
				logger.error("This is info : login = " + session.getAttribute("login") + "| role = " 
						+ session.getAttribute("role") + " ввел неверные данные и перешел на страницу wrongiput");
				return "/input_integer";
			}
			logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
					+ session.getAttribute("role") + " сессия завершена");
			return "/logout";
		}
		
	}

