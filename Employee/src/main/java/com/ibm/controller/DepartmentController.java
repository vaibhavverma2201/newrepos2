package com.ibm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.dao.DepartmentDAO;
import com.ibm.model.Department;




@WebServlet("/departments")
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		//get the location id from the form
		int locId = Integer.parseInt(request.getParameter("loc"));
		//get the list of department by using dao
		DepartmentDAO dao = new DepartmentDAO();
		ArrayList<Department> depts = dao.getDeptbyLoc(locId);
		
		//add the list as a request attribute
		request.setAttribute("depts", depts);
		//forward the request
		
		RequestDispatcher disp= request.getRequestDispatcher("departmentlist2.jsp");
		disp.forward(request, response);
		
	}

}
