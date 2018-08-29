package model.dao;

import model.entity.Admin;

public interface AdminDao extends GenericDao<Admin> {

	boolean isAdminExist(String login, String password);

}
