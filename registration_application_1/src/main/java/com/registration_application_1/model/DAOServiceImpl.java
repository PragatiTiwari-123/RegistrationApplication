package com.registration_application_1.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {
	private Connection con;
	private Statement stmnt;
	
	//overriding : am inherited incomplete method then completed that method in this particular class.
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "test");
			stmnt = con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean login(String username, String password) {
		try {
			ResultSet result = stmnt.executeQuery("Select * from login where email = '"+username+"'and password = '"+password+"'");
			return result.next();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void click(String name, String city, String email, String mobile) {
		 try {
			 stmnt.executeUpdate("insert into reg values('"+name+"', '"+city+"', '"+email+"', '"+mobile+"')");
	     } catch (SQLException e) {
	        e.printStackTrace();
	     }
	}

	@Override
	public boolean existByEmail(String email) {
		try {
			ResultSet result = stmnt.executeQuery("Select * from reg where email = '"+email+"'");
			return result.next();
		}catch(Exception e) {
			e.printStackTrace();
		}		return false;
	}

	@Override
	public boolean existByMobile(String mobile) {
		try {
			ResultSet result = stmnt.executeQuery("Select * from reg where mobile = '"+mobile+"'");
			return result.next();
		}catch(Exception e) {
			e.printStackTrace();		
			return false;
		}
	}

	@Override
	public ResultSet getAllRegistrations() {
		try {
			ResultSet result = stmnt.executeQuery("Select * from reg");
			return result;
		}catch(Exception e) {
			e.printStackTrace();		

		}return null;
	}
	@Override
	public void deleteByEmail(String email) {
		 try {
			 stmnt.executeUpdate("delete from reg where email = '"+email+"'");
	     } catch (Exception e) {
	        e.printStackTrace();
	     }		
	}
    
	@Override
	public void update_Registration(String email, String mobile) {
		try {
			 stmnt.executeUpdate("UPDATE reg SET mobile = '"+mobile+"' WHERE email = '"+email+"' ");
	     } catch (SQLException e) {
	        e.printStackTrace();
	     }		
	}
	
}
