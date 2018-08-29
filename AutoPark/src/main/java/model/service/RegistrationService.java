package model.service;

import java.util.List;




import model.dao.DaoFactory;
import model.dao.DriverDao;
import model.entity.Driver;

public class RegistrationService {
	
		
	public boolean isExist(String login, String password) {
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
	public void regDriver(String login, String password) {
		DaoFactory factory = DaoFactory.getInstance();		
        DriverDao dao = factory.createDriverDao();
        Driver driver = new Driver(login, password);
        dao.create(driver);
	}
}
