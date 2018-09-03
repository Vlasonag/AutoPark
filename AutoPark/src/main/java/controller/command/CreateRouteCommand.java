package controller.command;

 
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import model.ENUM.ROLE;
import model.entity.Route;
import model.service.CreateRouteService;

public class CreateRouteCommand implements Command{
	
	CreateRouteService createRouteService = new CreateRouteService();
	
	public CreateRouteCommand(CreateRouteService createRouteService) {
		this.createRouteService = createRouteService;
	}
	
	@Override
	public String execute(HttpServletRequest request) {
		
		final HttpSession session = request.getSession();
		ROLE role = (ROLE) session.getAttribute("role");
		try{
		if (role.toString().equals("ADMIN")) {
			
			int distance = Integer.parseInt(new String(request.getParameter("distance").getBytes("ISO-8859-1"), "UTF-8"));			
			String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
			
			if(name.equals("")) {
				logger.error("This is info : login = " + session.getAttribute("login") + "| role = " 
						+ session.getAttribute("role") + " ввел неверные данные и перешел на страницу wrongiput");
				return "/input_integer";
			}
			try {
					createRouteService.createRoute(distance, name);
					logger.info("This is warn : login =  " + session.getAttribute("login") + "| role = " 
							+ session.getAttribute("role") + " создал маршрут: distance = " + distance+  ", name = " + name);
			}
			catch (Exception e) {
				logger.error("This is info : login = " + session.getAttribute("login") + "| role = " 
						+ session.getAttribute("role") + " ввел неверные данные и перешел на страницу wrongiput");
				return "/error";
			}
			
			List<Route> routelist = createRouteService.getAll();		
			request.setAttribute("routelist", routelist);
			
			return "routes.jsp";
			}
		}
		catch (Exception e) {
			logger.error("This is info : login = " + session.getAttribute("login") + "| role = " 
					+ session.getAttribute("role") + " ввел неверные данные и перешел на страницу wrongiput");
			return "/input_integer";
		}
		logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
				+ session.getAttribute("role") + " сессия завершена");
			return "/logout";		
	}
}
