package com.capgemini.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.empwebapp.beans.EmployeeInfoBean;
import com.capgemini.empwebapp.dao.EmployeeDAO;
import com.capgemini.empwebapp.dao.EmployeeDAOjpaImpl;

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			HttpSession session = req.getSession(false);
			if(session != null) {
				//valid session
				//Get the form data
				int empId = Integer.parseInt(req.getParameter("empId"));
				String empName = req.getParameter("empName");
				String password = req.getParameter("password");
				String designation = req.getParameter("designation");
				String gender = req.getParameter("gender");
				String salary = req.getParameter("salary");
				String age = req.getParameter("age");
				String mobile = req.getParameter("mobile");
				
				EmployeeInfoBean employeeInfoBean = new EmployeeInfoBean();
				employeeInfoBean.setEmpId(empId);
				if(empName != null && !empName.isEmpty()) {
				employeeInfoBean.setEmpName(empName);
				}
				if(age != null && !age.isEmpty()) {
				employeeInfoBean.setAge(Integer.parseInt(age));
				}
				if(designation != null && !designation.isEmpty()) {
				employeeInfoBean.setDesignation(designation);
				}
				if(salary != null && !salary.isEmpty()) {
				employeeInfoBean.setSalary(Integer.parseInt(salary));
				}
				if(mobile != null && !mobile.isEmpty()) {
				employeeInfoBean.setMobile(Long.parseLong(mobile));
				}
				if(gender != null && !gender.isEmpty()) {
				employeeInfoBean.setGender(gender.charAt(0));
				}
				if(password != null && !password.isEmpty()) {
				employeeInfoBean.setPassword(password);
				}
				
				
				EmployeeDAO dao = new EmployeeDAOjpaImpl();
				boolean isUpdated = dao.updateEmployee(employeeInfoBean);
				
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<body>");
				if(isUpdated) {
					out.println("<h2 style='color:red'>Employee Updated</h2>");
				}else {
					out.println("<h2 style='color:red'>something went wrong</h2>");
					
				}
				out.println("</body>");
				out.println("</html>");
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("./updateEmployeeForm.html");
				dispatcher.include(req, resp);
				
				
			}else {
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<body>");
				out.println("<h2 style='color:red'>Please Login</h2>");
				out.println("</body>");
				out.println("</html>");
				RequestDispatcher dispatcher = req.getRequestDispatcher("./loginForm.html");
				dispatcher.include(req, resp);
				}
		
		}
		
}
