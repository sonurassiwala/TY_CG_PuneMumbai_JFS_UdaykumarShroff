package com.capgemini.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigParamServlet extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html");
			
			ServletConfig config = getServletConfig();
			String empNameVal1 = config.getInitParameter("empName");
			
			ServletContext context = getServletContext();
			String companyNameVal = context.getInitParameter("companyName");
			
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			
			out.println("<h2>Config Param  Name Value is : "+empNameVal1+"</h2>");
			out.println("<h2>Config Param Company Value is : "+companyNameVal+"</h2>");
			
			out.println("</body>");
			out.println("</html>");
			
			
		}
		
}
