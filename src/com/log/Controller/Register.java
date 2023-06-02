package com.log.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.log.Dao.Conn;
import com.log.Model.Customer;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	   String uname = request.getParameter("uname");
	   String upass = request.getParameter("upass");

	   Customer c = new Customer();
	   c.setUname(uname);
	   c.setUpass(upass);
	   
	  int status= Conn.Registered(c);
	  
	  if(status>0){
		  request.getRequestDispatcher("/index.html").include(request, response);
		  out.print("Registration Successfully");
	  }
	  else{
		  System.out.println("Something went's Wrong");
	  }
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
