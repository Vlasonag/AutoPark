package model.dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.dao.AppointmentDao;
import model.entity.AppointmentDTO;

public class JDBCAppointmentDao implements AppointmentDao{
	
	private Connection connection;
	
	public JDBCAppointmentDao(Connection connection) {
        this.connection = connection;
    }
	@Override
	public void create(AppointmentDTO entity) {
		try (Statement ps = connection.createStatement()){
			ps.executeUpdate(
					"INSERT INTO `autopark`.`appointment` (`appointment_route_name`, `appointment_route_distance`, `appointment_car_number`, `appointment_car_model`, `appointment_driver_id`, `appointment_driver_login`) VALUES ('"+entity.getRoute_name()+"', '"+entity.getRoute_distance()+"', '"+entity.getCar_number()+"', '"+entity.getCar_model()+"', '"+entity.getDriver_id()+"', '"+entity.getDriver_login()+"');");			
		}
		catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	@Override
	public AppointmentDTO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppointmentDTO> findAll() {
		List<AppointmentDTO> applist = new ArrayList<>();
		try (Statement ps = connection.createStatement()){
			ResultSet rs = ps.executeQuery(
					"SELECT * FROM appointment");
			while ( rs.next() ){
				applist.add(new AppointmentDTO(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7)));
			}
		}
		catch (Exception e) {
            throw new RuntimeException(e);
        }
		return applist;
	}

	@Override
	public void update(AppointmentDTO entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void cancelAppointment(String id, String number) {
		final char dm = (char) 34;
		try (Statement ps = connection.createStatement()){
			ps.executeUpdate(
					"DELETE FROM `autopark`.`appointment` WHERE (`appointment_car_number` = " + dm +  number + dm +");");
			ps.executeUpdate(
					"UPDATE `autopark`.`car` SET `car_free` = '1' WHERE (`car_number` = " + dm + number + dm + ");");
			ps.executeUpdate(
					"UPDATE `autopark`.`driver` SET `driver_free` = '1' WHERE (`driver_id` = '" + id + "');");
					
		}
		catch (Exception e) {
            throw new RuntimeException(e);
        }
		
		
	}

}
