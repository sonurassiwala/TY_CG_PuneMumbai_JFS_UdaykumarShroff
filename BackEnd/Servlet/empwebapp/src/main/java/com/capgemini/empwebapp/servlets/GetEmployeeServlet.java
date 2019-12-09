package com.capgemini.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetEmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String empIdVal = req.getParameter("empId");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Employee Id "+ empIdVal+" Found </h1>");
		out.println("<h3>Employee Name = Uday<br>");
		out.println("Salary = 20000<br>");
		out.println("Address = Pune<br>");
		out.println("Designation = SD</h3>");
		out.println("</body>");
		out.println("</html>");
		
	}//End of doGet()
	
}//End of class
