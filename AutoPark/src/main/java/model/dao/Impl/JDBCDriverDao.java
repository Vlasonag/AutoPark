package model.dao.Impl;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.dao.DriverDao;
import model.entity.Driver;

public class JDBCDriverDao implements DriverDao {
	
	private Connection connection;

    public JDBCDriverDao(Connection connection) {
        this.connection = connection;
    }

	@Override
	public void create(Driver entity) {
		try (Statement ps = connection.createStatement()){
			ps.executeUpdate(
					"INSERT INTO autopark.driver (driver_login, driver_password, confirmed) VALUES ('"+entity.getLogin()+"', '"+entity.getPassword()+"', '0')");			
		}
		catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	@Override
	public boolean isDriverExist(String login, String password) {
		List<Driver> driverlist = new ArrayList<>();
		try (Statement ps = connection.createStatement()){
			ResultSet rs = ps.executeQuery(
					"SELECT * FROM driver");
			while ( rs.next() ){
				driverlist.add(new Driver(rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		for(int i = 0; i < driverlist.size(); i++) {
			if ((login.equals(driverlist.get(i).getLogin())) && (password.equals(driverlist.get(i).getPassword()))) {
				return true;
			}		
		}
		return false;
	}
	
	@Override
	public Driver findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Driver> findAll() {
		List<Driver> driverlist = new ArrayList<>();
		try (Statement ps = connection.createStatement()){
			ResultSet rs = ps.executeQuery(
					"SELECT * FROM driver");
			while ( rs.next() ){
				driverlist.add(new Driver(rs.getString(2), rs.getString(3)));
			}
		}
		catch (Exception e) {
            throw new RuntimeException(e);
        }
		return driverlist;
	}

	@Override
	public void update(Driver entity) {
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
	public List<Driver> findAllUnconfirmed() {
		List<Driver> driverlist = new ArrayList<>();
		try (Statement ps = connection.createStatement()){
			ResultSet rs = ps.executeQuery(
					"SELECT * FROM driver WHERE confirmed=0");
			while ( rs.next() ){
				driverlist.add(new Driver(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		}
		catch (Exception e) {
            throw new RuntimeException(e);
        }
		return driverlist;
	}

	@Override
	public void setConfirmTrueById(String id) {
		try (Statement ps = connection.createStatement()){
			ps.executeUpdate("UPDATE `autopark`.`driver` SET `confirmed` = '1' WHERE (`driver_id` = '" + id + "')");	
		}
		catch (Exception e) {
            throw new RuntimeException(e);
        }
		
	}

	@Override
	public boolean isDriverConfirmed(String login, String password) {
		List<Driver> driverlist = new ArrayList<>();
		try (Statement ps = connection.createStatement()){
			ResultSet rs = ps.executeQuery(
					"SELECT * FROM driver");
			while ( rs.next() ){
				driverlist.add(new Driver(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		for(int i = 0; i < driverlist.size(); i++) {
			if ((login.equals(driverlist.get(i).getLogin())) && (password.equals(driverlist.get(i).getPassword())) && (driverlist.get(i).isConfirmed())) {
				return true;
			}		
		}
		return false;
	}

	@Override
	public List<Driver> findAllFreeDrivers() {
		List<Driver> driverlist = new ArrayList<>();
		try (Statement ps = connection.createStatement()){
			ResultSet rs = ps.executeQuery(
					"SELECT * FROM driver WHERE driver_free=1 and confirmed=1");
			while ( rs.next() ){
				driverlist.add(new Driver(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		}
		catch (Exception e) {
            throw new RuntimeException(e);
        }
		return driverlist;
	}

	@Override
	public String getLoginById(String id) {
		String login = null;
		try (Statement ps = connection.createStatement()){
			ResultSet rs = ps.executeQuery(
					"SELECT driver_login FROM driver WHERE driver_id=" + id +"");
			while (rs.next()) {
				login = rs.getString(1);
			}
		}
		catch (Exception e) {
            throw new RuntimeException(e);
        }
		return login;
	}

	@Override
	public void setDriverBusy(String id) {
		try (Statement ps = connection.createStatement()){
			ps.executeUpdate("UPDATE `autopark`.`driver` SET `driver_free` = '0' WHERE (`driver_id` = '" + id + "')");	
		}
		catch (Exception e) {
            throw new RuntimeException(e);
        }
		
	}
}

