package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.RouteDao;
import model.entity.Route;

public class CreateRouteService {
	public List<Route> getAll() {
		DaoFactory factory = DaoFactory.getInstance();		
        RouteDao dao = factory.createRouteDao();
        return dao.findAll();
	}
	 public void createRoute(int distance, String name) throws SQLException {
		 Route entity = new Route(distance, name);
		 DaoFactory factory = DaoFactory.getInstance();		
	     RouteDao dao = factory.createRouteDao();
	     dao.create(entity);
	 }
}
