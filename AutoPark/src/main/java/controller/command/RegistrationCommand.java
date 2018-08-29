package controller.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import model.service.RegistrationService;



public class RegistrationCommand implements Command{
	Pattern pattern;
	Matcher matcher;

	
	RegistrationService registrationService = new RegistrationService();
	
	public RegistrationCommand(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}
	@Override
	public String execute(HttpServletRequest request) {
		String login = request.getParameter("login");
		pattern = Pattern.compile("A-Za-z");
		matcher = pattern.matcher(login);
        
		String password = request.getParameter("password");
		if(!(registrationService.isDriverExist(login, password) && !(registrationService.isAdminExist(login, password)))) {
			return "/loginorpasswordexists.jsp";
		}
		else if (matcher.matches()) {
			pattern = Pattern.compile("A-Za-z");
			matcher = pattern.matcher(login);
			return "/wrongdriverlogin.jsp";
		}
		else {
			try {
				registrationService.regDriver(login, password);
			}
			catch (Exception e) {
				return "/error";
			}
			return "/index.jsp";
		}
	}
}

