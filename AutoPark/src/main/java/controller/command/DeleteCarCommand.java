package controller.command;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.ENUM.ROLE;
import model.entity.Car;
import model.service.DeleteCarService;

public class DeleteCarCommand implements Command{
	DeleteCarService deleteCarService = new DeleteCarService();
	public DeleteCarCommand(DeleteCarService deleteCarService) {
		this.deleteCarService = deleteCarService;
	}
	@Override
	public String execute(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		ROLE role = (ROLE) session.getAttribute("role");
		try {
		if (role.toString().equals("ADMIN")) {
			String number = new String(request.getParameter("number").getBytes("ISO-8859-1"), "UTF-8");	
			System.out.println(number);
			deleteCarService.deleteCar(number);
			List<Car> carlist = deleteCarService.getAll();		
			request.setAttribute("carlist", carlist);
			return "cars.jsp";
			}
		}
		catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/logout";
	
	}

}
