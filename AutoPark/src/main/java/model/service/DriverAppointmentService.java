package model.service;

import java.sql.SQLException;

import model.dao.AppointmentDao;
import model.dao.DaoFactory;
import model.dao.DriverDao;
import model.entity.AppointmentDTO;

public class DriverAppointmentService {
	
	public AppointmentDTO getAppointmentByLogin(String login) {
		
		DaoFactory factory = DaoFactory.getInstance();		
	    AppointmentDao dao = factory.createAppointmentDao();
		return dao.getAppointmentByLogin(login);
	}	
	public boolean isDriverExist(String login, String password) throws SQLException	{
		
		DaoFactory factory = DaoFactory.getInstance();		
        DriverDao dao = factory.createDriverDao();
		return dao.isDriverExist(login, password);
	}
	public boolean isDriverConfirmed(String login, String password) throws SQLException	{
		
		DaoFactory factory = DaoFactory.getInstance();		
        DriverDao dao = factory.createDriverDao();
		return dao.isDriverConfirmed(login, password);
	}
	
}
