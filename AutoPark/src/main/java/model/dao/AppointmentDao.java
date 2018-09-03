package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.entity.AppointmentDTO;

public interface AppointmentDao extends GenericDao<AppointmentDTO>  {

	void cancelAppointment(int id, String car_number);

	AppointmentDTO getAppointmentByLogin(String login);

	void confirmAppointment(String login);

	int getNumberOfAppointments();
	
	List<AppointmentDTO> findAllForPage(int start, int recordsOnPage) throws SQLException;
}
