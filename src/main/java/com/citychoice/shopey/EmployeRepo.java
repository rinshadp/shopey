package com.citychoice.shopey;

import com.citychoice.shopey.DbUtil;
import com.citychoice.shopey.Employe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EmployeRepo{
	private Connection dbConnection;

	public EmployeRepo(){
		this.dbConnection = DbUtil.getConnection();
	}

	public String saveEmploye(Employe employe){
		String result = "failed";
		try {
			PreparedStatement prepStatement = dbConnection.prepareStatement("insert into customer (id , name , address) values (? , ? , ?)" , Statement.RETURN_GENERATED_KEYS);
			prepStatement.setInt(1, employe.getId());
			prepStatement.setString(2, employe.getName());
			prepStatement.setString(3, employe.getAddress());
			ResultSet resultSet = null;
			Integer affectedRow = prepStatement.executeUpdate();
			if(affectedRow == 1){
				result = "succesfull";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = e.toString();
		}

		return result;
	}

	public Employe getEmploye(Integer id){
		Employe emp = new Employe();
		try {
			PreparedStatement prepStatement = dbConnection.prepareStatement("select Name , Address from customer where id = ?");
			prepStatement.setInt(1, id);
			ResultSet result = prepStatement.executeQuery();
			if (result != null) {
				if(result.next()){ 
					emp.setId(id);
					emp.setName(result.getString("Name"));
					emp.setAddress(result.getString("Address"));
				}
				else{
					emp.setId(0);
					emp.setName("--not fount--");
					emp.setAddress("--not fount--");	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
}