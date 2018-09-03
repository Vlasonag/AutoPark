package controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import model.ENUM.ROLE;
import model.entity.Driver;
import model.service.DriverConfirmationService;


public class DriverConfirmationCommand implements Command{
	
	DriverConfirmationService driverConfirmationService = new DriverConfirmationService();
	
	public DriverConfirmationCommand(DriverConfirmationService driverConfirmationService) {
		this.driverConfirmationService = driverConfirmationService;
	}
	
	@Override
	public String execute(HttpServletRequest request) {
		try{
			final HttpSession session = request.getSession();
		
			String login = (String) request.getSession().getAttribute("login");
			String password = (String) request.getSession().getAttribute("password");
		
			ROLE role = (ROLE) session.getAttribute("role");
			if(login.equals("") || password.equals("")) {
				return "/input_integer";
			}
			if (role.toString().equals("ADMIN")) {
				
				login = (String) request.getSession().getAttribute("login");
				password = (String) request.getSession().getAttribute("password");
				
				List<Driver> driverlist = driverConfirmationService.getUnconfirmedDriver();
				request.setAttribute("driverlist", driverlist);
				
				logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
						+ session.getAttribute("role") + " зашел на страницу: driverconfirmation");
				return "driverconfirmation.jsp";
			}
			else if(!driverConfirmationService.isAdminExist(login, password)){
				
				logger.error("This is info : login = " + session.getAttribute("login") + "| role = " 
						+ session.getAttribute("role") + " ввел неверные данные и перешел на страницу wrongiput");
				return "/error";
			}
			else {
				
				logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
						+ session.getAttribute("role") + " сессия завершена");
				return "/logout";
			}
		}
		catch (NullPointerException e) {
			
			return "/input_integer";
		}
	}		
}