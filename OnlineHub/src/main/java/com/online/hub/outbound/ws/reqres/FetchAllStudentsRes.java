package com.online.hub.outbound.ws.reqres;

import java.util.List;

import com.online.hub.outbound.ws.dto.StudentDto;

public class FetchAllStudentsRes extends BaseResponse  {

	private List<StudentDto> students;

	public List<StudentDto> getStudents() {
		return students;
	}

	public void setStudents(List<StudentDto> students) {
		this.students = students;
	}
	
	
	
}
