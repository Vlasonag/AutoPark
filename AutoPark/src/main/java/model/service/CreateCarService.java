package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.CarDao;
import model.dao.DaoFactory;
import model.entity.Car;

public class CreateCarService {
	public List<Car> getAll() {
		DaoFactory factory = DaoFactory.getInstance();		
        CarDao dao = factory.createCarDao();
        return dao.findAll();
	}
	 public void createCar(String model, String number) throws SQLException {
		 Car entity = new Car(model, number);
		 DaoFactory factory = DaoFactory.getInstance();		
	     CarDao dao = factory.createCarDao();
	     dao.create(entity);
	 }
}
