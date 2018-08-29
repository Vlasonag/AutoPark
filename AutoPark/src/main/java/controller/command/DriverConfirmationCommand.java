package controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		final HttpSession session = request.getSession();
		ROLE role = (ROLE) session.getAttribute("role");
		if (role.toString().equals("ADMIN")) {
			List<Driver> driverlist = driverConfirmationService.getUnconfirmedDriver();
	    	request.setAttribute("driverlist", driverlist);
			return "driverconfirmation.jsp";
		}
		else {
			return "/logout";
	}

}
}