package com.curd.app.controller;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.axis.AxisFault;

import com.curd.app.dto.OnlineHubDto;
import com.curd.app.dto.StudentDto;
import com.curd.app.utils.CommonUtils;
import com.online.hub.outbound.ws.AddStudentReq;
import com.online.hub.outbound.ws.AddStudentRes;
import com.online.hub.outbound.ws.FetchAllStudentsReq;
import com.online.hub.outbound.ws.FetchAllStudentsRes;
import com.online.hub.outbound.ws.GetStudentByIdReq;
import com.online.hub.outbound.ws.GetStudentByIdRes;
import com.online.hub.outbound.ws.RemoveStudentReq;
import com.online.hub.outbound.ws.RemoveStudentRes;
import com.online.hub.outbound.ws.StudentWsPortBindingStub;
import com.online.hub.outbound.ws.UpdateStudentReq;
import com.online.hub.outbound.ws.UpdateStudentRes;

public class OnlineHubController {

	StudentWsPortBindingStub stub = null;

	public OnlineHubController() {

		try {
			stub = new StudentWsPortBindingStub(new URL("http://localhost:8080/OnlineHub/StudentWs"), null);
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getAllStudents(OnlineHubDto dto) {
		try {
			FetchAllStudentsRes response = stub.getAllStudentList(new FetchAllStudentsReq());

			if (CommonUtils.isNotNull(response)) {

				if (CommonUtils.isNotNullAndEmpty(response.getErrorCode())
						&& response.getErrorCode().equalsIgnoreCase("00")) {

					if (CommonUtils.isNotNull(response.getStudents()) && response.getStudents().length > 0) {

						for (int index = 0; index < response.getStudents().length; index++) {
							StudentDto studentDto = new StudentDto();
							studentDto.setAddress(response.getStudents()[index].getAddress());
							studentDto.setGender(response.getStudents()[index].getGender());
							studentDto.setName(response.getStudents()[index].getName());
							studentDto.setId(response.getStudents()[index].getId());

							dto.getStudent().add(studentDto);
						}
					}

				}

				dto.setErrorCode(response.getErrorCode());
				dto.setErrorMessage(response.getErrorMessage());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addStudent(OnlineHubDto dto) {
		try {
			AddStudentRes response = stub.addStudent(populateAddStudentRequest(dto));

			if (CommonUtils.isNotNull(response)) {
				dto.setErrorCode(response.getErrorCode());
				dto.setErrorMessage(response.getErrorMessage());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void removeStudent(OnlineHubDto dto) {
		try {
			RemoveStudentRes response = stub.removeStudent(new RemoveStudentReq(dto.getStudentDto().getId()));

			if (CommonUtils.isNotNull(response)) {
				dto.setErrorCode(response.getErrorCode());
				dto.setErrorMessage(response.getErrorMessage());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateStudent(OnlineHubDto dto) {
		try {
			UpdateStudentRes response = stub.updateStudent(populateUpdateStudentRequest(dto));

			if (CommonUtils.isNotNull(response)) {
				dto.setErrorCode(response.getErrorCode());
				dto.setErrorMessage(response.getErrorMessage());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void getStudentById(OnlineHubDto dto) {
		try {
			GetStudentByIdRes response = stub.getStudentById(populateGetStudentById(dto));

			if (CommonUtils.isNotNull(response)) {

				if (CommonUtils.isNotNullAndEmpty(response.getErrorCode())
						&& response.getErrorCode().equalsIgnoreCase("00")) {
							
							if(CommonUtils.isNotNull(response.getStudents()))
							{
								StudentDto studentDto = new StudentDto();
								studentDto.setAddress(response.getStudents().getAddress());
								studentDto.setGender(response.getStudents().getGender());
								studentDto.setName(response.getStudents().getName());
								studentDto.setId(response.getStudents().getId());
								dto.setStudentDto(studentDto);	
									
								
							}
							
						}
					

				

				dto.setErrorCode(response.getErrorCode());
				dto.setErrorMessage(response.getErrorMessage());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private GetStudentByIdReq populateGetStudentById(OnlineHubDto dto) {
		// TODO Auto-generated method stub
		return new GetStudentByIdReq(dto.getStudentDto().getId());
	}

	private UpdateStudentReq populateUpdateStudentRequest(OnlineHubDto dto) {
		return new UpdateStudentReq(new com.online.hub.outbound.ws.StudentDto(dto.getStudentDto().getAddress(),
				dto.getStudentDto().getGender(), dto.getStudentDto().getId(), dto.getStudentDto().getName()));

	}

	private AddStudentReq populateAddStudentRequest(OnlineHubDto dto) {

		return new AddStudentReq(new com.online.hub.outbound.ws.StudentDto(dto.getStudentDto().getAddress(),
				dto.getStudentDto().getGender(), dto.getStudentDto().getId(), dto.getStudentDto().getName()));
	}
}