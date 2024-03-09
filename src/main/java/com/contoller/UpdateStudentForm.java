package com.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;
import com.service.StudentService;

@WebServlet("/UpdateStudentForm")
public class UpdateStudentForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateStudentForm() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			 int id= Integer.parseInt(request.getParameter("id"));
			 
			 StudentService service=new StudentService();
			 Student student=service.getStudent(id);
			 out.print("<head>");
			 out.print("<link rel='stylesheet' href='style/update.css'>"); 
			 out.print("</head>");
			 
			 out.print("<form action='UpdateStudentServlet' method='get'>");
			  out.print("<label for='fname'>ID</label>")  ;
			   out.print("<input type='text' id='fname' name='id' value='"+student.getId()+"' readonly >") ;

			   out.print("<label for='fname'>Name</label>")  ;
			   out.print("<input type='text' id='fname' name='uname' value='"+student.getName()+"' >") ;

			   out.print("<label for='fname'>Marks</label>")  ;
			   out.print("<input type='text' id='fname' name='marks' value='"+student.getMarks()+"' >") ;

			  
			   out.print("<input type='submit' value='Update Data'>") ;
			   
			 out.print(" </form>");

	}

	
	
}
