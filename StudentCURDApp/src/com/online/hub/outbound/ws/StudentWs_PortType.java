/**
 * StudentWs_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.online.hub.outbound.ws;

public interface StudentWs_PortType extends java.rmi.Remote {
    public com.online.hub.outbound.ws.FetchAllStudentsRes getAllStudentList(com.online.hub.outbound.ws.FetchAllStudentsReq arg0) throws java.rmi.RemoteException;
    public com.online.hub.outbound.ws.GetStudentByIdRes getStudentById(com.online.hub.outbound.ws.GetStudentByIdReq arg0) throws java.rmi.RemoteException;
    public com.online.hub.outbound.ws.AddStudentRes addStudent(com.online.hub.outbound.ws.AddStudentReq arg0) throws java.rmi.RemoteException;
    public com.online.hub.outbound.ws.UpdateStudentRes updateStudent(com.online.hub.outbound.ws.UpdateStudentReq arg0) throws java.rmi.RemoteException;
    public com.online.hub.outbound.ws.RemoveStudentRes removeStudent(com.online.hub.outbound.ws.RemoveStudentReq arg0) throws java.rmi.RemoteException;
}
