package com.registration_application_1.model;

import java.sql.ResultSet;

// when developing model layer i develop the interface DAOService & inherited member to DAOServiceImpl inheritance.
public interface DAOService {
	public void connectDB(); 
	public boolean login(String username, String password);
	public void click(String name, String city, String email, String mobile);
	public boolean existByEmail(String email);
	public boolean existByMobile(String mobile);
	public ResultSet getAllRegistrations();
	public void deleteByEmail(String email);
	public void update_Registration(String email, String mobile);


}
