package com.capgemini.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/include")
public class IncludeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		//String url = "./currentDate";
		String Url = "./searchEmployeeForm.html";
		String url = "./date.html";
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello World</h1><br><br>");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(Url);
		dispatcher.include(req, resp);
		
		out.println("<h1>Samay hua hai : <br><br></h1>");
		
		RequestDispatcher dispatcher1 = req.getRequestDispatcher(url);
		dispatcher1.include(req, resp);
		
		out.println("</body>");
		out.println("</html>");
		
	}
	
}
