package model.dao;

import model.entity.Route;

public interface RouteDao extends GenericDao<Route> {
	void deleteById(String id);
}
