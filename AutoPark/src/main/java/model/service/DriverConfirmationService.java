package model.service;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DriverDao;
import model.entity.Driver;

public class DriverConfirmationService {
	public List<Driver> getUnconfirmedDriver() {
		DaoFactory factory = DaoFactory.getInstance();		
	    DriverDao dao = factory.createDriverDao();
		return dao.findAllUnconfirmed();
	}
}
