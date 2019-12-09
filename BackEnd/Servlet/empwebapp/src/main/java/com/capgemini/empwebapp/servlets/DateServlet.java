package com.capgemini.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DateServlet extends HttpServlet {
	
	public DateServlet() {
		System.out.println("Instantiation Phase");
	}
	
	public DateServlet(String msg) {
		System.out.println(msg);
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Init Phase");
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Service Phase");
		Date date = new Date();
		
		/*
		 * ServletContext context = getServletContext(); String companyNameVal =
		 * context.getInitParameter("companyName");
		 */

		//resp.setHeader("refresh", "1");
		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		/*
		 * out.println("<head>");
		 * out.println("<meta http-equiv='refresh' content='1'>");
		 * out.println("</head>");
		 */
		out.println("<body>");
		out.println("<h1>Current System Date and Time-<br>");
		out.println(date + "</h1>");
		out.println("<br><br>");
		//out.println("<h2>Context Param Company name Value is : "+ companyNameVal + "</h2>");
		out.println("</body>");
		out.println("</html>");
	}// End of doGet()
	
	@Override
	public void destroy() {
		System.out.println("Destroy Phase");
		super.destroy();
	}

}// End of Class

