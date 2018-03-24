package com.online.hub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.hub.dao.StudentDAO;
import com.online.hub.model.StudentModel;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO StudentDAO;

	public void setStudentDAO(StudentDAO StudentDAO) {
		this.StudentDAO = StudentDAO;
	}

	
	@Transactional
	public void addStudent(StudentModel student) {
		this.StudentDAO.addStudent(student);
	}

	
	@Transactional
	public void updateStudent(StudentModel student) {
		this.StudentDAO.updateStudent(student);
	}

	
	@Transactional
	public List<StudentModel> listStudents() {
		return this.StudentDAO.listStudents();
	}

	
	@Transactional
	public StudentModel getStudentById(int id) {
		return this.StudentDAO.getStudentById(id);
	}

	
	@Transactional
	public void removeStudent(int id) {
		this.StudentDAO.removeStudent(id);
	}

}