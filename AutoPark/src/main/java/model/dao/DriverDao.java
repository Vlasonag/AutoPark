package model.dao;


import java.sql.SQLException;
import java.util.List;

import model.entity.Driver;

public interface DriverDao extends GenericDao<Driver> {
	boolean isDriverExist(String login,String password) throws SQLException;
	List<Driver> findAllUnconfirmed();
	void setConfirmTrueById(String id);
	boolean isDriverConfirmed(String login, String password);
	List<Driver> findAllFreeDrivers();
	String getLoginById(String id);
	void setDriverBusy(String id);
	
}
