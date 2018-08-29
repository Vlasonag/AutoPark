package controller.command;

import javax.servlet.http.HttpServletRequest;

import model.service.RegistrationService;



public class RegistrationCommand implements Command{
	
	RegistrationService registrationService = new RegistrationService();
	
	public RegistrationCommand(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}
	@Override
	public String execute(HttpServletRequest request) {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		if(!(registrationService.isExist(login, password))) {
			registrationService.regDriver(login, password);
			return "/index.jsp";
		}
		else {
			return "/registration.jsp";
		}
	}

}
