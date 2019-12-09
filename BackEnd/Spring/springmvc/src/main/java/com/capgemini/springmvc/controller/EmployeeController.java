package com.capgemini.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.springmvc.beans.EmployeeInfoBean;
import com.capgemini.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/empLoginForm")
	public String displayEmpLoginForm() {
		return "empLoginForm";
	}// end of displaylogin

	@PostMapping("/empLogin")
	public String empLogin(int empId, String password, ModelMap modelMap, HttpServletRequest req) {
		EmployeeInfoBean employeeInfoBean = service.authenticate(empId, password);
		if (employeeInfoBean != null) {
			//valid credentials
			HttpSession session = req.getSession(true);
			session.setAttribute("employeeInfoBean", employeeInfoBean);
			
			return "empHomePage";
		} else {
			//Invalid Credentials
			modelMap.addAttribute("msg", "Invalid UserName and Password");
			return "empLoginForm";
		}
	}// end of emplogin

	@GetMapping("/addEmployeeForm")
	public String displayAddEmployee(HttpSession session, ModelMap modelMap) {
		if(session.isNew()) {
			modelMap.addAttribute("msg", "Please Login First..");
			return "empLoginForm";
		}else {
			return "addEmpForm";
		}
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(EmployeeInfoBean employeeInfoBean, HttpSession session, ModelMap modelMap) {
		
		
		if(session.isNew()) {
			modelMap.addAttribute("msg", "Please Login First..");
			return "empLoginForm";
		}else {
			if(service.addEmployee(employeeInfoBean)) {
				modelMap.addAttribute("msg", "Employee Added Successfully..!!");
			}else {
				modelMap.addAttribute("msg","Uabble to Add Employee..!!");
			}
			return "addEmpForm";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap modelMap) {
		session.invalidate();
		modelMap.addAttribute("msg","Logged Out Successfully..!!");
		return "empLoginForm";
	}
	
	@GetMapping("/updateEmployeeForm")
	public String displayUpdateEmpForm(HttpSession session, ModelMap modelMap) {
		if(session.isNew()) {
			modelMap.addAttribute("msg", "Please Login First..!!");
			return "empLoginForm";
		}
		else {
			return "updateEmployeeForm";
		}
	}
	
	@PostMapping("/updateEmployee")
	public String updateEmployee(EmployeeInfoBean employeeInfoBean, HttpSession session, ModelMap modelMap) {
		if(session.isNew()) {
			modelMap.addAttribute("msg", "Please Login First..!!");
			return "empLoginForm";
		}
		else {
			if(service.updateEmployee(employeeInfoBean)) {
				modelMap.addAttribute("msg", "Employee Details Updated Successfully..!!");
				
			}else {
				modelMap.addAttribute("msg", "Unable to Update Employee Details..");
			}
			return "updateEmployeeForm";
		}
	}
	
	@GetMapping("/searchEmployeeForm")
	public String displaySearchEmployeeForm(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "empLoginForm";
		
		} else {
			// Valid Session
			return "searchEmployeeForm";
		}
	}// End of displaySearchEmployeeForm()
	
	@GetMapping("/searchEmployee")
	public String searchEmployee(int empId, HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "empLoginForm";
		
		} else {
			EmployeeInfoBean employeeInfoBean = service.getEmployee(empId);
			if (employeeInfoBean != null) {
				modelMap.addAttribute("employeeInfoBean", employeeInfoBean);
			} else {
				modelMap.addAttribute("msg", "Employee ID " + empId + " Not Found!!!");
			}
			
			return "searchEmployeeForm";
		}
	}// End of searchEmployee()
	
	@GetMapping("/deleteEmployeeForm")
	public String displayDeleteEmployeeForm(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "empLoginForm";
		
		} else {
			// Valid Session
			return "deleteEmployeeForm";
		}
	}// End of displaySearchEmployeeForm()
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(int empId, HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "empLoginForm";
		
		} else {
			// Valid Session
			if(service.deleteEmployee(empId)) {
				modelMap.addAttribute("msg", "Employee Deleted Successfully!");
			} else {
				modelMap.addAttribute("msg", "Employee ID " + empId + " Not Found!");
			}
			
			return "deleteEmployeeForm";
		}
	}// End of searchEmployee()
	
	@GetMapping("/seeAllEmployees")
	public String getAllEmployees(HttpSession session, ModelMap modelMap) {
		
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "empLoginForm";
		
		} else {
			// Valid Session
			List<EmployeeInfoBean> employeesList = service.getAllEmployees();
			modelMap.addAttribute("employeesList", employeesList);
			
			return "displayAllEmployees";
		}
	}// End of getAllEmployees()
	
	@GetMapping("/home")
	public String displayEmpHomePage(HttpSession session, ModelMap modelMap) {

		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "empLoginForm";
		
		} else {
			// Valid Session
			return "empHomePage";
		}
	}// End of displayEmpHomePage()
}



















