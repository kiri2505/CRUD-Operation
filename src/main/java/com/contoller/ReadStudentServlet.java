package com.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;
import com.service.StudentService;


@WebServlet("/ReadStudentServlet")
public class ReadStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReadStudentServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		StudentService service=new StudentService();
		List<Student> list=service.displayAllStudent();
		
		out.print("<head>");
		out.print("<link rel='stylesheet' href='style/table.css'>"); 
		out.print("<link rel='stylesheet' href='style/read.css'>"); 
		out.print("</head>");
		Iterator<Student> itr=	list.iterator();
		out.print("<a href='student.html'>");
				out.print("<button class='btn'>Add</button>");
				out.print("</a>");

		out.print("<table>");
		out.print("<tr>");
		out.print("<th> ID </th>");
		out.print("<th> Name </th>");
		out.print("<th> Marks </th>");
		out.print("<th> Actions </th>");
		out.print("</tr>");
		
		while (itr.hasNext()) {
			Student student=itr.next();
			
			out.print("<tr>");
			out.print("<td>" +student.getId()+ "</td>");
			out.print("<td>" +student.getName()+ "</td>");
			out.print("<td>" +student.getMarks()+ "</td>");
			out.print("<td>") ;
//			out.print("<a href='DeleteStudentServlet?id="+student.getId()+"'>"+"<button>Delete  </butoon>"+"</a>");
			out.print("<a href='DeleteStudentServlet?id="+student.getId()+"'>"+"<button>  Delete  </button>"+"</a>");
			out.print("<a href='UpdateStudentForm?id="+student.getId()+"'>"+"<button>  Update  </button>"+"</a>");

			out.print("</td>");
			out.print("</tr>");
			
		}
		out.print("</table>");
	}
}
	
