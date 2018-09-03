package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.RouteDao;
import model.entity.Route;

public class DeleteRouteService {
	
	public List<Route> getAll() {
		
		DaoFactory factory = DaoFactory.getInstance();		
        RouteDao dao = factory.createRouteDao();
        return dao.findAll();
	}
	 public void deleteRoute(int id) throws SQLException {
		 
		 DaoFactory factory = DaoFactory.getInstance();		
	     RouteDao dao = factory.createRouteDao();
	     dao.deleteById(id);
	 }
}
