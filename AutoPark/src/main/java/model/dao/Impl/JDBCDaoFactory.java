package model.dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.dao.AdminDao;
import model.dao.AppointmentDao;
import model.dao.CarDao;
import model.dao.DaoFactory;
import model.dao.DriverDao;
import model.dao.RouteDao;

public class JDBCDaoFactory extends DaoFactory{
	@Override
    public AdminDao createAdminDao() {
        return new JDBCAdminDao(getConnection());
    }
	
	@Override
	public DriverDao createDriverDao() {
		return new JDBCDriverDao(getConnection());
	}
	
	@Override
	public RouteDao createRouteDao() {
		return new JDBCRouteDao(getConnection());
	}
	
	@Override
	public CarDao createCarDao() {
		return new JDBCCarDao(getConnection());
	}
	
	@Override
	public AppointmentDao createAppointmentDao() {
		return new JDBCAppointmentDao(getConnection());
	}
	
    public Connection getConnection(){
        try {
        	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/autopark?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root" ,
                    "root" );
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

	

	
	
    
	
}
