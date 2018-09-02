package controller.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import controller.RegexInterface.LoginAndPasswordRegex;
import model.service.RegistrationService;



public class RegistrationCommand implements Command, LoginAndPasswordRegex{
	Pattern pattern;
	Matcher matcher;
	final static Logger logger = Logger.getLogger(AdminLoginPageCommand.class);
	
	
	RegistrationService registrationService = new RegistrationService();
	
	public RegistrationCommand(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}
	@Override
	public String execute(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		String login = request.getParameter("login");        
		String password = request.getParameter("password");
		pattern = Pattern.compile(LoginAndPasswordRegex.loginregex);
		matcher = pattern.matcher(login);
		
		if((registrationService.isDriverLoginExist(login)) || (registrationService.isAdminLoginExist(login))) {
			logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
					+ session.getAttribute("role") + " ввел неверные данные и перешел на страницу loginexist");
			return "/login_exist_error";
		}
		else if ((registrationService.isDriverPasswordExist(password)) || (registrationService.isAdminPasswordExist(password))) {
			logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
					+ session.getAttribute("role") + " ввел неверные данные и перешел на страницу passwordexist");
			return "/password_exist_error";
		}
		else {
			if (matcher.matches()){
				pattern = Pattern.compile(LoginAndPasswordRegex.passwordregex);
				matcher = pattern.matcher(password);
				if(matcher.matches()) {
					try {
						registrationService.regDriver(login, password);
						logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
								+ session.getAttribute("role") + " зарегистрировался: login = " + login + ", password = " + password);
					}
					catch (Exception e) {
						logger.error("This is info : login = " + session.getAttribute("login") + "| role = " 
								+ session.getAttribute("role") + " ввел неверные данные и перешел на страницу wrongiput");
						return "/error";
					}
					logger.info("This is info : login = " + session.getAttribute("login") + "| role = " 
							+ session.getAttribute("role") + " перешел на login_page");	
					return "/login_page";
				}
				
			}
			
		}
		logger.error("This is info : login = " + session.getAttribute("login") + "| role = " 
				+ session.getAttribute("role") + " ввел неверные данные и перешел на страницу wrongiput");
		return "/input_integer";
	}
}

