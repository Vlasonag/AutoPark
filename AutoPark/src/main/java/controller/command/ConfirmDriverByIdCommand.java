package controller.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
			}
			catch (Exception e){
				return "/input_integer";
			}
			List<Driver> driverlist = confirmDriverByIdService.getUnconfirmedDriver();
			request.setAttribute("driverlist", driverlist);
			return "driverconfirmation.jsp";
		}
		else {
			return "/logout";
		}

	}
}
