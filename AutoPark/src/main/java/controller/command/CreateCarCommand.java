package controller.command;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
					try {
						createCarService.createRoute(number, model);
					}
					catch (Exception e) {
						return "/error";
					}
					List<Car> carlist = createCarService.getAll();		
					request.setAttribute("carlist", carlist);
					return "/cars";
				}
				
			} catch (Exception e) {
				return "/input_integer";
			}
			return "/logout";
		}
		
	}

