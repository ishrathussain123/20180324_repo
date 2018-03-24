package com.curd.app.dto;

import java.util.ArrayList;
import java.util.List;

public class OnlineHubDto {

    private String errorCode;

    private String errorMessage;
    private StudentDto studentDto;
    
    
    
    
	public StudentDto getStudentDto() {
		return studentDto;
	}

	public void setStudentDto(StudentDto studentDto) {
		this.studentDto = studentDto;
	}

	private List<StudentDto> student = new ArrayList<StudentDto>();

	public List<StudentDto> getStudent() {
		return student;
	}

	public void setStudent(List<StudentDto> student) {
		this.student = student;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
}