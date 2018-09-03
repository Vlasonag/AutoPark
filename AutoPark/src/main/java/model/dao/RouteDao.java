package model.dao;

import java.sql.SQLException;

import model.entity.Route;

public interface RouteDao extends GenericDao<Route> {
	
	void deleteById(int id) throws SQLException;
}
