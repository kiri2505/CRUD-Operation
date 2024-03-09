package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.utility.DBUtility;

public class StudentDAO {

	public int insertStudent(Student student) {
		Connection con=DBUtility.getDBConnection();
		int val=0;
		
		String sql= "insert into student values(?, ?, ?)";
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			
			ps.setInt(1,student.getId());
			ps.setString(2,student.getName());
			ps.setDouble(3,student.getMarks());
			
			val = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Insertion Student" +e);
		}
		
		return val;
	}

	public int updtaeStudent(Student student) {
		Connection con=DBUtility.getDBConnection();
		int val=0;
		String sql="update student set name=?, mark=? where id=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(3,student.getId());
			ps.setString(1, student.getName());
			ps.setDouble(2,student.getMarks());
			
			val = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Updation Student" +e);
		}
		return val;
	}

	public int deleteStudent(Student student) {
		Connection con= DBUtility.getDBConnection();
		int val=0;
		String sql="delete from student where id=?";
		
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			
			ps.setInt(1, student.getId());
			val= ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Deletion Student"+e);
		}
		return val;
	}
	
	
	public Student getStudentById(int id) {
		Connection con=DBUtility.getDBConnection();
				
				String sql="SELECT * from student where id=?";
				Student student=new Student();
				
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1, id);
					ResultSet rs=ps.executeQuery();
					
					while (rs.next()) {
						
						student.setId(rs.getInt(1));
						student.setName(rs.getString(2));
						student.setMarks(rs.getDouble(3));
					}
				} catch (Exception e) {
					System.out.println("Selection"+e);
				}
				return student;

			

		}


	public List<Student> getAllStudent() {
		
	List<Student> studlist= new ArrayList<>();
	Connection con=DBUtility.getDBConnection();
	
	String sql= "SELECT * from student";
	
	
	try {
		PreparedStatement ps= con.prepareStatement(sql);
		ResultSet rs= ps.executeQuery();
		while (rs.next()) {
			Student student=new Student();
			student.setId(rs.getInt(1));
			student.setName(rs.getString(2));
			student.setMarks(rs.getDouble(3));
			
			studlist.add(student);
			
		}
	} catch (Exception e) {
		System.out.println(e);
	}
		return studlist;
	}
}

	
