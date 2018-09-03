package controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import model.ENUM.ROLE;
import model.entity.Driver;
import model.service.ConfirmDriverByIdService;

public class ConfirmDriverByIdCommand implements Command{
	ConfirmDriverByIdService confirmDriverByIdService = new ConfirmDriverByIdService();
	public ConfirmDriverByIdCommand (ConfirmDriverByIdService confirmDriverByIdService) {
		this.confirmDriverByIdService = confirmDriverByIdService;
	}
	@Override
	public String execute(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		ROLE role = (ROLE) session.getAttribute("role");
		if (role.toString().equals("ADMIN")) {
			
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				confirmDriverByIdService.confirmDriverById(id);
				logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
						+ session.getAttribute("role") + " подтвердил водителя по: id = " + id);
			}
			catch (Exception e){
				logger.error("This is info : login = " + session.getAttribute("login") + "| role = " 
						+ session.getAttribute("role") + " ввел неверные данные и перешел на страницу wrongiput");
				return "/input_integer";
			}
			List<Driver> driverlist = confirmDriverByIdService.getUnconfirmedDriver();
			request.setAttribute("driverlist", driverlist);
			return "driverconfirmation.jsp";
		}
		else {
			logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
					+ session.getAttribute("role") + " сессия завершена");
			return "/logout";
		}

	}
}
