package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.AppointmentDao;
import model.dao.DaoFactory;
import model.entity.AppointmentDTO;

public class CancelAppointmentService {
	public List<AppointmentDTO> getAllForPage(int i, int recordsPerPage)  throws SQLException{
		DaoFactory factory = DaoFactory.getInstance();		
        AppointmentDao dao = factory.createAppointmentDao();
        return dao.findAllForPage(i, recordsPerPage);
	}
	
	public void cancelAppointment(int id, String number) {
		DaoFactory factory = DaoFactory.getInstance();
        AppointmentDao dao = factory.createAppointmentDao();
        dao.cancelAppointment(id, number);
	}
	public int getNumberOfAppointments() {
		DaoFactory factory = DaoFactory.getInstance();
        AppointmentDao dao = factory.createAppointmentDao();
        return dao.getNumberOfAppointments();
	}
}
