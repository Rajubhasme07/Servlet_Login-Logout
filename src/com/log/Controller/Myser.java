package com.log.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.log.Dao.Conn;
import com.log.Model.Customer;


@WebServlet("/myser")
public class Myser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String Uname=request.getParameter("uname");
		String Upass=request.getParameter("upass");
		 Customer c = new Customer();
		   c.setUname(Uname);
		   c.setUpass(Upass);
		   int status= Conn.autho(c);
		
		if(status>0){
			
			response.sendRedirect("home.html");
			
			
		}
		else
		{
			request.getRequestDispatcher("/index.html").include(request, response);
			out.print("Login Failed");
		}
	
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
