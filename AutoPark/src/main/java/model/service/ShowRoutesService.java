package model.service;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.RouteDao;
import model.entity.Route;

public class ShowRoutesService {
	
	public List<Route> getAll() {
		
		DaoFactory factory = DaoFactory.getInstance();		
        RouteDao dao = factory.createRouteDao();
        return dao.findAll();
	}
}
