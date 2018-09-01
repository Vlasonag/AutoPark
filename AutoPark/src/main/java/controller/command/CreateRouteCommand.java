package controller.command;

import java.io.UnsupportedEncodingException;
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
		try{
		if (role.toString().equals("ADMIN")) {
			int distance = Integer.parseInt(new String(request.getParameter("distance").getBytes("ISO-8859-1"), "UTF-8"));			
			String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
			if(name.equals("")) {
				return "/input_integer";
			}
			try {
				
					createRouteService.createRoute(distance, name);
				
			}
			catch (Exception e) {
				return "/error";
			}
			List<Route> routelist = createRouteService.getAll();		
			request.setAttribute("routelist", routelist);
			return "routes.jsp";
			}
		}
		catch (Exception e) {
			return "/input_integer";
		}
			return "/logout";
		
	}

}
