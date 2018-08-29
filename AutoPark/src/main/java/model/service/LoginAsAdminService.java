package model.service;

import java.util.List;

import model.dao.AdminDao;
import model.dao.DaoFactory;
import model.entity.Admin;

public class LoginAsAdminService {
	public boolean isAdminExist(String login, String password)
	{
		DaoFactory factory = DaoFactory.getInstance();		
        AdminDao dao = factory.createAdminDao();
		List<Admin> al = dao.findAll();
		for(int i = 0; i < al.size(); i++) {
			if ((login.equals(al.get(i).getLogin())) && (password.equals(al.get(i).getPassword()))) {
				return true;
			}		
		}
		return false;
	}
}
