package com.log.Dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.log.Model.Customer;



public class Conn {


	private static String url="jdbc:mysql://localhost:3306/Servlet_login";
	private static String sname="root";
	private static String spass="abc123";
			
	
	
	public static Connection getcon()
	{
	Connection con =null;
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Registerd");
			try {
				 con=DriverManager.getConnection(url, sname, spass);
				System.out.println("Connection Established");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
    	
    	
    	
    	
    	catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	

	public static int Registered(Customer c){
		int status =0;
		Connection con = getcon();
		
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO u_login(sname,spass)values (?,?)");
			ps.setString(1, c.getUname());
			ps.setString(2, c.getUpass());
			status= ps.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return status;
	}
	
	public static int autho(Customer c){
		int status =0;
		Connection con =getcon();
		
		try {
			PreparedStatement ps = con.prepareStatement("Select * from u_login where sname=? and spass=?");
			ps.setString(1, c.getUname());
			ps.setString(2, c.getUpass());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				status=1;
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return status;
		
	}
	
	
	
	
	
}
