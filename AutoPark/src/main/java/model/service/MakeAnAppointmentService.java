package model.service;

import java.util.List;

import model.dao.AppointmentDao;
import model.dao.CarDao;
import model.dao.DaoFactory;
import model.dao.DriverDao;
import model.dao.RouteDao;
import model.entity.AppointmentDTO;
import model.entity.Car;
import model.entity.Driver;
import model.entity.Route;

public class MakeAnAppointmentService {
	public List<Route> getAllRoutes() {
		DaoFactory factory = DaoFactory.getInstance();		
        RouteDao dao = factory.createRouteDao();
        return dao.findAll();
	}
	public List<Car> getAllFreeCars() {
		DaoFactory factory = DaoFactory.getInstance();		
        CarDao dao = factory.createCarDao();
        return dao.findAllFreeCars();
	}
	public List<Driver> getAllFreeDrivers() {
		DaoFactory factory = DaoFactory.getInstance();		
        DriverDao dao = factory.createDriverDao();
        return dao.findAllFreeDrivers();
	}
	public String getModelByNumber(String number) {
		DaoFactory factory = DaoFactory.getInstance();		
        CarDao dao = factory.createCarDao();
		return dao.getModelByNumber(number);
	}
	public String getLoginById(int id) {
		DaoFactory factory = DaoFactory.getInstance();		
        DriverDao dao = factory.createDriverDao();
		return dao.getLoginById(id);
	}
	public void setDriverBusy(int id) {
		DaoFactory factory = DaoFactory.getInstance();		
        DriverDao dao = factory.createDriverDao();
		dao.setDriverBusy(id);
	}
	public void setCarBusy(String number) {
		DaoFactory factory = DaoFactory.getInstance();		
        CarDao dao = factory.createCarDao();
		dao.setCarBusy(number);
	}
	public void createAnAppointment(String r_name, int r_distance, String c_number, String c_model, int d_id, String d_login) {
		
		AppointmentDTO entity = new AppointmentDTO(r_name, r_distance, c_number, c_model, d_id, d_login);
		DaoFactory factory = DaoFactory.getInstance();		
        AppointmentDao dao = factory.createAppointmentDao();
        dao.create(entity);
	}
}
