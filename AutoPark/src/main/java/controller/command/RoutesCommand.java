package controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpSession;

import model.ENUM.ROLE;
import model.entity.Route;
import model.service.ShowRoutesService;

public class RoutesCommand implements Command{
	ShowRoutesService showRoutesService = new ShowRoutesService();
	public RoutesCommand(ShowRoutesService showRoutesService) {
		this.showRoutesService = showRoutesService;
	}
	@Override
	public String execute(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		ROLE role = (ROLE) session.getAttribute("role");
		if (role.toString().equals("ADMIN")) {
			List<Route> routelist = showRoutesService.getAll();
			request.setAttribute("routelist", routelist);
			return "routes.jsp";
		}
		else {
			return "/logout";
	}

}
}