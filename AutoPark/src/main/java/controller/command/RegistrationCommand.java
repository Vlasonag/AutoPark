package controller.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import controller.RegexInterface.LoginAndPasswordRegex;
import model.service.RegistrationService;



public class RegistrationCommand implements Command, LoginAndPasswordRegex{
	Pattern pattern;
	Matcher matcher;

	
	RegistrationService registrationService = new RegistrationService();
	
	public RegistrationCommand(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}
	@Override
	public String execute(HttpServletRequest request) {
		String login = request.getParameter("login");        
		String password = request.getParameter("password");
		pattern = Pattern.compile(LoginAndPasswordRegex.loginregex);
		matcher = pattern.matcher(login);
		
		if((registrationService.isDriverLoginExist(login)) || (registrationService.isAdminLoginExist(login))) {
			return "/login_exist_error";
		}
		else if ((registrationService.isDriverPasswordExist(password)) || (registrationService.isAdminPasswordExist(password))) {
			return "/password_exist_error";
		}
		else {
			if (matcher.matches()){
				pattern = Pattern.compile(LoginAndPasswordRegex.passwordregex);
				matcher = pattern.matcher(password);
				if(matcher.matches()) {
					try {
						registrationService.regDriver(login, password);
					}
					catch (Exception e) {
						return "/error";
					}	
					return "/login_page";
				}
				
			}
			
		}
		return "/input_integer";
	}
}

