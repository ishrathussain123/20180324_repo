package com.online.hub.outbound.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.online.hub.commonUtils.CommonUtils;
import com.online.hub.model.StudentModel;
import com.online.hub.outbound.ws.dto.StudentDto;
import com.online.hub.outbound.ws.reqres.AddStudentReq;
import com.online.hub.outbound.ws.reqres.AddStudentRes;
import com.online.hub.outbound.ws.reqres.FetchAllStudentsReq;
import com.online.hub.outbound.ws.reqres.FetchAllStudentsRes;
import com.online.hub.outbound.ws.reqres.GetStudentByIdReq;
import com.online.hub.outbound.ws.reqres.GetStudentByIdRes;
import com.online.hub.outbound.ws.reqres.RemoveStudentReq;
import com.online.hub.outbound.ws.reqres.RemoveStudentRes;
import com.online.hub.outbound.ws.reqres.UpdateStudentReq;
import com.online.hub.outbound.ws.reqres.UpdateStudentRes;
import com.online.hub.service.StudentService;

@WebService(serviceName="StudentWs")
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
public class StudentWs{

	
	@Autowired
	StudentService studentService;


	

	@WebMethod(operationName="getAllStudentList")
	public FetchAllStudentsRes fetchAllStudents(FetchAllStudentsReq fetchAllStudentsReq)
	{
		FetchAllStudentsRes response = new FetchAllStudentsRes();

		List<StudentDto> students = new ArrayList<StudentDto>();

		try {
			List<StudentModel> persistedStudents = studentService.listStudents();
			if (CommonUtils.isNotNullAndEmpty(persistedStudents)) {
				for (StudentModel persistedStudent : persistedStudents) {

					StudentDto studentDto = new StudentDto();
					BeanUtils.copyProperties(persistedStudent, studentDto);
					students.add(studentDto);
				}
			}

			if (!CommonUtils.isNotNullAndEmpty(persistedStudents)) {
				response.setErrorCode("01");
				response.setErrorMessage("FAILURE");
			}

		} catch (Exception e) {
			response.setErrorCode("01");
			response.setErrorMessage("FAILURE");
			e.printStackTrace();
		}
		response.setStudents(students);

		return response;
	}
	
	
	
	@WebMethod(operationName="addStudent")
	public AddStudentRes addStudent(AddStudentReq student)
	{		
			AddStudentRes response = new AddStudentRes();
			try {
				
				StudentModel studentModel = new StudentModel();
				BeanUtils.copyProperties(student.getStudentDto(), studentModel);
				studentService.addStudent(studentModel);	
				
			}catch (Exception e) {
				response.setErrorCode("01");
				response.setErrorMessage("FAILURE");
				e.printStackTrace();
			}
	
			return response;
	}
	
	
	@WebMethod(operationName="removeStudent")
	public RemoveStudentRes removeStudent(RemoveStudentReq req)
	{
		 RemoveStudentRes response = new RemoveStudentRes();
			try {
				
				studentService.removeStudent(req.getStudentId());
				 	
				
			}catch (Exception e) {
				response.setErrorCode("01");
				response.setErrorMessage("FAILURE");
				e.printStackTrace();
			}
	
			return response;
	}
	
	
	
	@WebMethod(operationName="updateStudent")
	public UpdateStudentRes updateStudent(UpdateStudentReq req)
	{
		 
		UpdateStudentRes response = new UpdateStudentRes();
			try {
				
				StudentModel studentModel = new StudentModel();
				BeanUtils.copyProperties(req.getStudentDto(), studentModel);
				studentService.updateStudent(studentModel);
				 	
				
			}catch (Exception e) {
				response.setErrorCode("01");
				response.setErrorMessage("FAILURE");
				e.printStackTrace();
			}
	
			return response;
	}
	
	
	@WebMethod(operationName="getStudentById")
	public GetStudentByIdRes getStudentById(GetStudentByIdReq req)
	{
		
		
		GetStudentByIdRes response = new GetStudentByIdRes();

		StudentDto students = null;

		try {
			StudentModel persistedStudent = studentService.getStudentById(req.getStudentId());
			if (persistedStudent != null) {
				 students = new StudentDto();
				BeanUtils.copyProperties(persistedStudent, students);
				}
			

			if (students ==  null) {
				response.setErrorCode("01");
				response.setErrorMessage("FAILURE");
			}

		} catch (Exception e) {
			response.setErrorCode("01");
			response.setErrorMessage("FAILURE");
			e.printStackTrace();
		}
		response.setStudents(students);

		return response;
	}
	
	
	
	
	
	
}