package controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		if (role.toString().equals("ADMIN")) {
			String distance = request.getParameter("distance");
			String name = request.getParameter("name");
			createRouteService.createRoute(distance, name);
			List<Route> routelist = createRouteService.getAll();		
			request.setAttribute("routelist", routelist);
			return "routes.jsp";
		}
		else {
			return "/logout";
		}
	}

}
