package model.service;

import java.util.List;

import model.dao.CarDao;
import model.dao.DaoFactory;
import model.dao.DriverDao;
import model.dao.RouteDao;
import model.entity.Car;
import model.entity.Driver;
import model.entity.Route;

public class ShowAppointmentsService {
	
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
}
