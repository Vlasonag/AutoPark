package model.service;

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
	 public void createRoute(String distance, String name) {
		 Route entity = new Route(distance, name);
		 DaoFactory factory = DaoFactory.getInstance();		
	     RouteDao dao = factory.createRouteDao();
	     dao.create(entity);
	 }
}
