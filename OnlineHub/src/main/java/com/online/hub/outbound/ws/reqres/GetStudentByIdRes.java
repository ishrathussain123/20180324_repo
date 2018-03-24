package com.online.hub.outbound.ws.reqres;

import java.util.List;

import com.online.hub.outbound.ws.dto.StudentDto;

public class GetStudentByIdRes extends BaseResponse  {

	private StudentDto students;

	public StudentDto getStudents() {
		return students;
	}

	public void setStudents(StudentDto students) {
		this.students = students;
	}

	
	
	
	
	
}
