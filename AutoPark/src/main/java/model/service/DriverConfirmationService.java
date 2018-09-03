package model.service;

import java.util.List;

import model.dao.AdminDao;
import model.dao.DaoFactory;
import model.dao.DriverDao;
import model.entity.Admin;
import model.entity.Driver;

public class DriverConfirmationService {
	
	public List<Driver> getUnconfirmedDriver() {
		
		DaoFactory factory = DaoFactory.getInstance();		
	    DriverDao dao = factory.createDriverDao();
		return dao.findAllUnconfirmed();
	}
	public boolean isAdminExist(String login, String password) {
		
		DaoFactory factory = DaoFactory.getInstance();		
        AdminDao dao = factory.createAdminDao();
		List<Admin> al = dao.findAll();
		for(int i = 0; i < al.size(); i++) {
			if ((login.equals(al.get(i).getLogin())) && (password.equals(al.get(i).getPassword()))) {
				return false;
			}		
		}
		return false;
	}	
}
