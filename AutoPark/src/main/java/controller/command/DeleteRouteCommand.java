package controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import model.ENUM.ROLE;
import model.entity.Route;
import model.service.DeleteRouteService;

public class DeleteRouteCommand implements Command{
	final static Logger logger = Logger.getLogger(AdminLoginPageCommand.class);
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
				deleteRouteService.deleteRoute(id);
				logger.info("This is warn : login = " + session.getAttribute("login") + "| role = " 
						+ session.getAttribute("role") + " удалил маршрут по: id = " + id);
			}
			catch (Exception e){
				logger.error("This is info : login = " + session.getAttribute("login") + "| role = " 
						+ session.getAttribute("role") + " ввел неверные данные и перешел на страницу wrongiput");
				return "/input_integer";
			}
			List<Route> routelist = deleteRouteService.getAll();		
			request.setAttribute("routelist", routelist);
			return "routes.jsp";
		}
		else {
			logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
					+ session.getAttribute("role") + " сессия завершена");
			return "/logout";
	}
	}
}
