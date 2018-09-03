package model.dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.dao.RouteDao;
import model.entity.Route;

public class JDBCRouteDao implements RouteDao{
	private Connection connection;

    public JDBCRouteDao(Connection connection) {
        this.connection = connection;
    }

	@Override
	public void create(Route entity) {
		try (Statement ps = connection.createStatement()){
			ps.executeUpdate(
					"INSERT INTO autopark.route (route_distance, route_name) "
								+ "VALUES ('" + entity.getDistance() + "', '" + entity.getName() + "')");			
		}
		catch (Exception e) {
            throw new RuntimeException(e);
        }
		
	}

	@Override
	public Route findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Route> findAll() {
		List<Route> routelist = new ArrayList<>();
		try (Statement ps = connection.createStatement()){
			ResultSet rs = ps.executeQuery(
					"SELECT * FROM route");
			while ( rs.next() ){
				routelist.add(new Route(rs.getInt(1), rs.getInt(2), rs.getString(3)));
			}
		}
		catch (Exception e) {
            throw new RuntimeException(e);
        }
		return routelist;
	}

	@Override
	public void update(Route entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) throws SQLException {
		Statement ps = connection.createStatement();
			ps.executeUpdate(
					"DELETE FROM `autopark`.`route` WHERE (`route_id` = " + id + ")");			
		
	}
}
