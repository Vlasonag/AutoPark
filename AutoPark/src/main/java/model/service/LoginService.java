package model.service;


import java.sql.SQLException;

import model.dao.DaoFactory;
import model.dao.DriverDao;

public class LoginService {
	
	public boolean isDriverExist(String login, String password) throws SQLException
	{
		DaoFactory factory = DaoFactory.getInstance();		
        DriverDao dao = factory.createDriverDao();
		return dao.isDriverConfirmed(login, password);
	}
}
