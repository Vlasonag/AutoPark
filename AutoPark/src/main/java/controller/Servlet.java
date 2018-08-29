package controller;

import java.io.IOException;   
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.CancelAppointmentService;
import model.service.ConfirmDriverByIdService;
import model.service.CreateCarService;
import model.service.CreateRouteService;
import model.service.DeleteCarService;
import model.service.DeleteRouteService;
import model.service.DriverConfirmationService;
import model.service.LoginAsAdminService;
import model.service.LoginService;
import model.service.MakeAnAppointmentService;
import model.service.RegistrationService;
import model.service.ShowAllAppointmentsService;
import model.service.ShowAppointmentsService;
import model.service.ShowCarsService;
import model.service.ShowRoutesService;
import controller.command.AllAppointmentCommand;
import controller.command.AppointmentCommand;
import controller.command.CancelAppointmentCommand;
import controller.command.CarCommand;
import controller.command.Command;
import controller.command.ConfirmDriverByIdCommand;
import controller.command.CreateCarCommand;
import controller.command.CreateRouteCommand;
import controller.command.DeleteCarCommand;
import controller.command.DeleteRouteCommand;
import controller.command.DriverConfirmationCommand;
import controller.command.LoginAsAdminCommand;
import controller.command.LoginCommand;
import controller.command.LogoutCommand;
import controller.command.MakeAnAppointmentCommand;
import controller.command.RegistrationCommand;
import controller.command.RoutesCommand;

/**
 * Servlet implementation class Servlet
 */
public class Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Map<String, Command> commands = new HashMap<>();
	LoginService ls = new LoginService();
	
	public void init(){
		commands.put("loginasadmin", new LoginAsAdminCommand(new LoginAsAdminService()));
        commands.put("login", new LoginCommand(new LoginService()));
        commands.put("registration", new RegistrationCommand(new RegistrationService()));
        commands.put("logout", new LogoutCommand());
        commands.put("driverconfirmation", new DriverConfirmationCommand(new DriverConfirmationService()));
        commands.put("confirmdriverbyid", new ConfirmDriverByIdCommand(new ConfirmDriverByIdService()));
        commands.put("routes", new RoutesCommand(new ShowRoutesService()));
        commands.put("createroute", new CreateRouteCommand(new CreateRouteService()));
        commands.put("deleteroute", new DeleteRouteCommand(new DeleteRouteService()));
        commands.put("cars", new CarCommand(new ShowCarsService()));
        commands.put("createcar", new CreateCarCommand(new CreateCarService()));
        commands.put("deletecar", new DeleteCarCommand(new DeleteCarService()));
        commands.put("appointment", new AppointmentCommand(new ShowAppointmentsService()));
        commands.put("makeanappointment", new MakeAnAppointmentCommand(new MakeAnAppointmentService()));
        commands.put("appointments", new AllAppointmentCommand(new ShowAllAppointmentsService()));
        commands.put("cancelappointment", new CancelAppointmentCommand(new CancelAppointmentService()));
    }
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = request.getRequestURI();
        path = path.replaceAll(".*/AutoPark/", "");
        Command command = commands.get(path);
        String page = command.execute(request);
        System.out.println(page);
        request.getRequestDispatcher(page).forward(request,response);
	}
	/*public static void main(String[] args) throws UnsupportedEncodingException {
		ResourceBundle res1 = ResourceBundle.getBundle("resources_en");
		System.out.println(new String(res1.getString("name").getBytes("ISO-8859-1"), "UTF-8"));
	}*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = request.getRequestURI();
        path = path.replaceAll(".*/AutoPark/", "");
        Command command = commands.get(path);
        String page = command.execute(request);
        System.out.println(page);
        request.getRequestDispatcher(page).forward(request,response);
	}

}
