package controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.ENUM.ROLE;
import model.entity.Route;
import model.service.DeleteRouteService;

public class DeleteRouteCommand implements Command{
	DeleteRouteService deleteRouteService = new DeleteRouteService();
	public DeleteRouteCommand(DeleteRouteService deleteRouteService) {
		this.deleteRouteService = deleteRouteService;
	}
	@Override
	public String execute(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		ROLE role = (ROLE) session.getAttribute("role");
		if (role.toString().equals("ADMIN")) {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				System.out.println(id);
				deleteRouteService.deleteRoute(id);
			}
			catch (Exception e){
				return "/input_integer";
			}
			List<Route> routelist = deleteRouteService.getAll();		
			request.setAttribute("routelist", routelist);
			return "routes.jsp";
		}
		else {
			return "/logout";
	}
	}
}
