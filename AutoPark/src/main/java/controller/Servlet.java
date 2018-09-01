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
import model.service.ConfirmAppointmentService;
import model.service.ConfirmDriverByIdService;
import model.service.CreateCarService;
import model.service.CreateRouteService;
import model.service.DeleteCarService;
import model.service.DeleteRouteService;
import model.service.DriverAppointmentService;
import model.service.DriverConfirmationService;
import model.service.LoginAsAdminService;
import model.service.LoginService;
import model.service.MakeAnAppointmentService;
import model.service.RegistrationService;
import model.service.ShowAllAppointmentsService;
import model.service.ShowAppointmentsService;
import model.service.ShowCarsService;
import model.service.ShowRoutesService;
import controller.command.AdminLoginPageCommand;
import controller.command.AllAppointmentCommand;
import controller.command.AppointmentCommand;
import controller.command.CancelAppointmentCommand;
import controller.command.CarCommand;
import controller.command.Command;
import controller.command.ConfirmAppointmentCommand;
import controller.command.ConfirmDriverByIdCommand;
import controller.command.CreateCarCommand;
import controller.command.CreateRouteCommand;
import controller.command.DeleteCarCommand;
import controller.command.DeleteRouteCommand;
import controller.command.DriverAppointmentCommand;
import controller.command.DriverConfirmationCommand;
import controller.command.ErrorCommand;
import controller.command.InputIntegerCommand;
import controller.command.LoginAsAdminCommand;
import controller.command.LoginCommand;
import controller.command.LoginExistPageCommand;
import controller.command.LoginPageCommand;
import controller.command.LogoutCommand;
import controller.command.MakeAnAppointmentCommand;
import controller.command.PasswordExistPageCommand;
import controller.command.RegistrationCommand;
import controller.command.RegistrationPageCommand;
import controller.command.RepeatErrorCommand;
import controller.command.RoutesCommand;
import controller.command.WrongRoleErrorCommand;

/**
 * Servlet implementation class Servlet
 */
public class Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Map<String, Command> commands = new HashMap<>();
	LoginService ls = new LoginService();
	
	public void init(){
		commands.put("login_as_admin", new LoginAsAdminCommand(new LoginAsAdminService()));
        commands.put("login", new LoginCommand(new LoginService()));
        commands.put("registration", new RegistrationCommand(new RegistrationService()));
        commands.put("logout", new LogoutCommand());
        commands.put("driver_confirmation", new DriverConfirmationCommand(new DriverConfirmationService()));
        commands.put("confirm_driver_by_id", new ConfirmDriverByIdCommand(new ConfirmDriverByIdService()));
        commands.put("routes", new RoutesCommand(new ShowRoutesService()));
        commands.put("create_route", new CreateRouteCommand(new CreateRouteService()));
        commands.put("delete_route", new DeleteRouteCommand(new DeleteRouteService()));
        commands.put("cars", new CarCommand(new ShowCarsService()));
        commands.put("create_car", new CreateCarCommand(new CreateCarService()));
        commands.put("delete_car", new DeleteCarCommand(new DeleteCarService()));
        commands.put("appointment", new AppointmentCommand(new ShowAppointmentsService()));
        commands.put("make_an_appointment", new MakeAnAppointmentCommand(new MakeAnAppointmentService()));
        commands.put("appointments", new AllAppointmentCommand(new ShowAllAppointmentsService()));
        commands.put("cancel_appointment", new CancelAppointmentCommand(new CancelAppointmentService()));
        commands.put("driver_appointment", new DriverAppointmentCommand(new DriverAppointmentService()));
        commands.put("confirm_appointment", new ConfirmAppointmentCommand(new ConfirmAppointmentService()));
        commands.put("input_integer", new InputIntegerCommand());
        commands.put("error", new ErrorCommand());
        commands.put("repeat_error", new RepeatErrorCommand());
        commands.put("login_page", new LoginPageCommand());
        commands.put("registration_page", new RegistrationPageCommand());
        commands.put("admin_login_page", new AdminLoginPageCommand());
        commands.put("wrong_role", new WrongRoleErrorCommand());
        commands.put("password_exist_error", new PasswordExistPageCommand());
        commands.put("login_exist_error", new LoginExistPageCommand());
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
