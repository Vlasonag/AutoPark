package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DriverDao;
import model.entity.Driver;

public class ConfirmDriverByIdService {
	public void confirmDriverById(int id) throws SQLException {
		DaoFactory factory = DaoFactory.getInstance();		
	    DriverDao dao = factory.createDriverDao();
		dao.setConfirmTrueById(id);
	}
	public List<Driver> getUnconfirmedDriver() {
		DaoFactory factory = DaoFactory.getInstance();		
	    DriverDao dao = factory.createDriverDao();
		return dao.findAllUnconfirmed();
	}
}
