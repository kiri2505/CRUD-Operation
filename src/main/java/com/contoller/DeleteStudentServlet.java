package com.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;
import com.service.StudentService;


@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public DeleteStudentServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		Student student=new Student();
		student.setId(id);
		
		StudentService service=new StudentService();
		int val=service.removeStudent(student);
		
		if (val>0) {
			out.print("<h3>Student Deleted</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("/ReadStudentServlet");
			rd.include(request, response);
//			use forward in place of include if don't want message in table page
//			SendRedirect
		}
		else {
			out.print("<h3>Student Deleted Failed</h3>");
		}
		
	}

}
