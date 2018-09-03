package model.dao.Impl;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.dao.AdminDao;
import model.entity.Admin;

public class JDBCAdminDao implements AdminDao{
	
	private Connection connection;

    public JDBCAdminDao(Connection connection) {
        this.connection = connection;
    }
	@Override
	public void create(Admin entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Admin findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> findAll() {
		List<Admin> adminlist = new ArrayList<>();
		try (Statement ps = connection.createStatement()){
			ResultSet rs = ps.executeQuery(
					"SELECT * FROM admin");
			while ( rs.next() ){
				adminlist.add(new Admin(rs.getString(2), rs.getString(3)));
			}
		}
		catch (Exception e) {
            throw new RuntimeException(e);
        }
		return adminlist;
	}

	
	@Override
	public void update(Admin entity) {
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
	public boolean isAdminExist(String login, String password) {
		List<Admin> adminlist = new ArrayList<>();
		try (Statement ps = connection.createStatement()){
			ResultSet rs = ps.executeQuery(
					"SELECT * FROM admin");
			while ( rs.next() ){
				adminlist.add(new Admin(rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		for(int i = 0; i < adminlist.size(); i++) {
			if ((login.equals(adminlist.get(i).getLogin())) 
										&& (password.equals(adminlist.get(i).getPassword()))) {
				return true;
			}		
		}
		return false;
	}
	

}
