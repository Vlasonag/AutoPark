package model.dao;


import java.sql.SQLException;
import java.util.List;

import model.entity.Driver;

public interface DriverDao extends GenericDao<Driver> {
	
	boolean isDriverExist(String login,String password) throws SQLException;
	
	List<Driver> findAllUnconfirmed();
	
	void setConfirmTrueById(int id) throws SQLException;
	
	boolean isDriverConfirmed(String login, String password);
	
	List<Driver> findAllFreeDrivers();
	
	String getLoginById(int id);
	
	void setDriverBusy(int id);
	
	boolean isDriverConfirmedAndExist(String login, String password);
	
}
