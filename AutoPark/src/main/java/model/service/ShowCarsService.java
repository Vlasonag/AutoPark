package model.service;

import java.util.List;

import model.dao.CarDao;
import model.dao.DaoFactory;
import model.entity.Car;

public class ShowCarsService {
	
	public List<Car> getAll() {
		
		DaoFactory factory = DaoFactory.getInstance();		
        CarDao dao = factory.createCarDao();
        return dao.findAll();
	}
}
