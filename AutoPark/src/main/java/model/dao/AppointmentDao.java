package model.dao;

import model.entity.AppointmentDTO;

public interface AppointmentDao extends GenericDao<AppointmentDTO>  {

	void cancelAppointment(int id, String car_number);

	AppointmentDTO getAppointmentByLogin(String login);

	void confirmAppointment(String login);
	
}
