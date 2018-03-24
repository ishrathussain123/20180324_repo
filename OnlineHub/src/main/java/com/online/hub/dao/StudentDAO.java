 package com.online.hub.dao;

import java.util.List;

import com.online.hub.model.StudentModel;

public interface StudentDAO {

	public void addStudent(StudentModel p);
	public void updateStudent(StudentModel p);
	public List<StudentModel> listStudents();
	public StudentModel getStudentById(int id);
	public void removeStudent(int id);
}