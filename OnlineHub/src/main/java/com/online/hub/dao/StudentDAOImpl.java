 package com.online.hub.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.hub.model.StudentModel;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addStudent(StudentModel student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(student);
		logger.info("Student saved successfully, StudentModel Details="+student);
	}

	public void updateStudent(StudentModel student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(student);
		logger.info("Student updated successfully, StudentModel Details="+student);
	}

	@SuppressWarnings("unchecked")
	
	public List<StudentModel> listStudents() {
		Session session = this.sessionFactory.getCurrentSession();
		List<StudentModel> StudentsList = session.createQuery("from StudentModel").list();
		for(StudentModel std : StudentsList){
			logger.info("Student List::"+std);
		}
		return StudentsList;
	}


	public StudentModel getStudentById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		StudentModel student = (StudentModel) session.load(StudentModel.class, new Integer(id));
		logger.info("Student loaded successfully, StudentModel details="+student);
		return student;
	}


	public void removeStudent(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		StudentModel student = (StudentModel) session.load(StudentModel.class, new Integer(id));
		if(null != student){
			session.delete(student);
		}
		logger.info("Student deleted successfully, StudentModel details="+student);
	}

}