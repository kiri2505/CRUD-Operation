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


@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateStudentServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("uname");
		double marks=Double.parseDouble(request.getParameter("marks"));
		
		Student student =new Student(id,name,marks);
		
		StudentService service=new StudentService();
		int val=service.modifyStudent(student);
		
		if (val>0) {
			out.print("<h3>Student Modified</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("/ReadStudentServlet");
			rd.include(request, response);
			
		}
		else {
			out.print("<h3>Student Modified Failed</h3>");
		}
	}

}
