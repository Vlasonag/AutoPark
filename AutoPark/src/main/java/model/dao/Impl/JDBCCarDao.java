package model.dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.dao.CarDao;
import model.entity.Car;

public class JDBCCarDao implements CarDao{
	private Connection connection;

    public JDBCCarDao(Connection connection) {
        this.connection = connection;
    }
	
	@Override
	public void create(Car entity) throws SQLException {
		Statement ps = connection.createStatement();
			ps.executeUpdate(
					"INSERT INTO autopark.car (car_number, car_model) VALUES ('" + entity.getNumber() + "', '" + entity.getModel() + "')");			
		
		
		
		
	}

	@Override
	public Car findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> findAll() {
		List<Car> carlist = new ArrayList<>();
		try (Statement ps = connection.createStatement()){
			ResultSet rs = ps.executeQuery(
					"SELECT * FROM car");
			while ( rs.next() ){
				carlist.add(new Car(rs.getString(1), rs.getString(2), rs.getBoolean(3)));
			}
		}
		catch (Exception e) {
            throw new RuntimeException(e);
        }
		return carlist;
	}

	@Override
	public void update(Car entity) {
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
	public void deleteByNumber(String number) {
		try (Statement ps = connection.createStatement()){
			ps.executeUpdate(
					"DELETE FROM `autopark`.`car` WHERE (`car_number` = '" + number + "')");			
		}
		catch (Exception e) {
            throw new RuntimeException(e);
        }
		
	}

	@Override
	public List<Car> findAllFreeCars() {
		List<Car> carlist = new ArrayList<>();
		try (Statement ps = connection.createStatement()){
			ResultSet rs = ps.executeQuery(
					"SELECT * FROM car WHERE car_free=1");
			while ( rs.next() ){
					carlist.add(new Car(rs.getString(1), rs.getString(2), rs.getBoolean(3)));
			}
		}
		catch (Exception e) {
            throw new RuntimeException(e);
        }
		return carlist;
	}

	@Override
	public String getModelByNumber(String number) {
		String result = null;
		final char dm = (char) 34;
		try (Statement ps = connection.createStatement()){
			ResultSet rs = ps.executeQuery(
					"SELECT car_model FROM autopark.car WHERE car_number=" + dm + number + dm + "");
			while (rs.next()) {
				result = rs.getString(1);
			}
		}
		catch (Exception e) {
            throw new RuntimeException(e);
        }
		return result;
	}

	@Override
	public void setCarBusy(String number) {
		try (Statement ps = connection.createStatement()){
			ps.executeUpdate("UPDATE `autopark`.`car` SET `car_free` = '0' WHERE (`car_number` = '" + number + "')");	
		}
		catch (Exception e) {
            throw new RuntimeException(e);
        }
		
	}
}
