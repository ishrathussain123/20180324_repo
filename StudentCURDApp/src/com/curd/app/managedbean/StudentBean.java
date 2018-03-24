package com.curd.app.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.curd.app.controller.OnlineHubController;
import com.curd.app.dto.OnlineHubDto;
import com.curd.app.dto.StudentDto;
import com.curd.app.utils.CommonUtils;

@ManagedBean
@RequestScoped
public class StudentBean {
	
	
	private StudentDto studentDto = new StudentDto();

	public List<StudentDto> studentsListFromDB;

	public StudentDto getStudentDto() {
		return studentDto;
	}

	public void setStudentDto(StudentDto studentDto) {
		this.studentDto = studentDto;
	}

	public List<StudentDto> getStudentsListFromDB() {
		return studentsListFromDB;
	}

	public void setStudentsListFromDB(List<StudentDto> studentsListFromDB) {
		this.studentsListFromDB = studentsListFromDB;
	}

	@PostConstruct
	public void init() {

		studentsListFromDB = new ArrayList<StudentDto>();
		OnlineHubDto dto = new OnlineHubDto();
		new OnlineHubController().getAllStudents(dto);

		if (CommonUtils.isNotNull(dto.getErrorCode()) && dto.getErrorCode().equalsIgnoreCase("00")) {
			if (CommonUtils.isNotNullAndEmpty(dto.getStudent()))
				for (StudentDto res : dto.getStudent()) {
					StudentDto student = new StudentDto();
					student.setAddress(res.getAddress());
					student.setGender(res.getGender());
					student.setId(res.getId());
					student.setName(res.getName());
					studentsListFromDB.add(student);
				}
		}

	}

	public String saveStudentDetails(StudentDto newStudentObj) {

		String navigationResult = "";

		OnlineHubDto dto = new OnlineHubDto();

		dto.setStudentDto(newStudentObj);

		new OnlineHubController().addStudent(dto);

		if (CommonUtils.isNotNull(dto.getErrorCode()) && dto.getErrorCode().equalsIgnoreCase("00")) {
			navigationResult = "studentsList.xhtml?faces-redirect=true";
		} else {
			navigationResult = "createStudent.xhtml?faces-redirect=true";
		}
		return navigationResult;

	}

	public String editStudentRecord(int studentId) throws IOException {
		
		
		OnlineHubDto dto = new OnlineHubDto();
		StudentDto student = new StudentDto() ;
		student.setId(studentId);
		dto.setStudentDto(student);
		new OnlineHubController().getStudentById(dto);

		if (CommonUtils.isNotNull(dto.getErrorCode()) && dto.getErrorCode().equalsIgnoreCase("00")) {
					
					if(CommonUtils.isNotNull(dto.getStudentDto()))
					{
						
						setStudentDto(dto.getStudentDto());
						// FacesContext.getCurrentInstance().getExternalContext().redirect("editStudent.xhtml");
						return "/editStudent.xhtml";
					}
				}
		
	
	return "";
	}

	public String updateStudentDetails(StudentDto updateStudentObj) {
		OnlineHubDto dto = new OnlineHubDto();

		dto.setStudentDto(updateStudentObj);

		new OnlineHubController().updateStudent(dto);

		if (CommonUtils.isNotNull(dto.getErrorCode()) && dto.getErrorCode().equalsIgnoreCase("00")) {
			return "/studentsList.xhtml?faces-redirect=true";
		}
		return "/studentsList.xhtml?faces-redirect=true";
	}

	public String deleteStudentRecord(int studentId) {

		OnlineHubDto dto = new OnlineHubDto();
		StudentDto studentDto = new StudentDto();
		studentDto.setId(studentId);
		dto.setStudentDto(studentDto);

		new OnlineHubController().removeStudent(dto);

		if (CommonUtils.isNotNull(dto.getErrorCode()) && dto.getErrorCode().equalsIgnoreCase("00")) {
			return "/studentsList.xhtml?faces-redirect=true";
		}
		return "/studentsList.xhtml?faces-redirect=true";
	}
}