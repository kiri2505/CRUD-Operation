package com.service;

import java.util.List;

import com.dao.StudentDAO;
import com.model.Student;

public class StudentService {
	StudentDAO dao=new StudentDAO();
	
	public int addStudent(Student student) {
		return dao.insertStudent(student);
	}
	
	public int modifyStudent(Student student) {
		return dao.updtaeStudent(student);
	}
	
	public int removeStudent(Student student) {
		return dao.deleteStudent(student);
	}
	
	public List<Student> displayAllStudent(){
		return dao.getAllStudent();
	}
	
	public Student getStudent(int id) {
		return dao.getStudentById(id);
	}
}
