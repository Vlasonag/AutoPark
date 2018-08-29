package model.service;

import java.sql.SQLException;
import java.util.List;




import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.dao.AdminDao;
import model.dao.DaoFactory;
import model.dao.DriverDao;
import model.entity.Admin;
import model.entity.Driver;

public class RegistrationService {
	
	Pattern pattern;
    Matcher matcher;
	public boolean isDriverExist(String login, String password) {
        DaoFactory factory = DaoFactory.getInstance();		
        DriverDao dao = factory.createDriverDao();
    	List<Driver> dl = dao.findAll();
    	for(int i = 0; i < dl.size(); i++) {
    		if ((login.equals(dl.get(i).getLogin())) || (password.equals(dl.get(i).getPassword()))) {
    			return true;
    		}		
    	}
    	return false;
    }
	public boolean isAdminExist(String login, String password) {
        DaoFactory factory = DaoFactory.getInstance();		
        AdminDao dao = factory.createAdminDao();
    	List<Admin> al = dao.findAll();
    	for(int i = 0; i < al.size(); i++) {
    		if ((login.equals(al.get(i).getLogin())) || (password.equals(al.get(i).getPassword()))) {
    			return true;
    		}		
    	}
    	return false;
    }
	public void regDriver(String login, String password) throws SQLException {
		DaoFactory factory = DaoFactory.getInstance();		
        DriverDao dao = factory.createDriverDao();
	    Driver driver = new Driver(login, password);
	    dao.create(driver);
        
	}
}
