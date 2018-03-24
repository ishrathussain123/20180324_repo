package com.online.hub.service;

import java.util.List;

import com.online.hub.model.StudentModel;

public interface StudentService {

	public void addStudent(StudentModel student);
	public void updateStudent(StudentModel student);
	public List<StudentModel> listStudents();
	public StudentModel getStudentById(int id);
	public void removeStudent(int id);
	
}