package model.service;

import java.util.List;

import model.dao.AppointmentDao;
import model.dao.DaoFactory;
import model.entity.AppointmentDTO;

public class CancelAppointmentService {
	public List<AppointmentDTO> getAll() {
		DaoFactory factory = DaoFactory.getInstance();		
        AppointmentDao dao = factory.createAppointmentDao();
        return dao.findAll();
	}
	
	public void cancelAppointment(String id, String number) {
		DaoFactory factory = DaoFactory.getInstance();		
        AppointmentDao dao = factory.createAppointmentDao();
        dao.cancelAppointment(id, number);
	}
}
