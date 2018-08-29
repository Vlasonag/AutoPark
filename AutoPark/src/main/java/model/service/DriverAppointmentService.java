package model.service;

import model.dao.AppointmentDao;
import model.dao.DaoFactory;
import model.entity.AppointmentDTO;

public class DriverAppointmentService {
	
	public AppointmentDTO getAppointmentByLogin(String login) {
		DaoFactory factory = DaoFactory.getInstance();		
	    AppointmentDao dao = factory.createAppointmentDao();
		return dao.getAppointmentByLogin(login);
	}	
}
