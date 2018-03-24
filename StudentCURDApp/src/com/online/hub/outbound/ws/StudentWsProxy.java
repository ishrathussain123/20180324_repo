package com.online.hub.outbound.ws;

public class StudentWsProxy implements com.online.hub.outbound.ws.StudentWs_PortType {
  private String _endpoint = null;
  private com.online.hub.outbound.ws.StudentWs_PortType studentWs_PortType = null;
  
  public StudentWsProxy() {
    _initStudentWsProxy();
  }
  
  public StudentWsProxy(String endpoint) {
    _endpoint = endpoint;
    _initStudentWsProxy();
  }
  
  private void _initStudentWsProxy() {
    try {
      studentWs_PortType = (new com.online.hub.outbound.ws.StudentWs_ServiceLocator()).getStudentWsPort();
      if (studentWs_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)studentWs_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)studentWs_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (studentWs_PortType != null)
      ((javax.xml.rpc.Stub)studentWs_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.online.hub.outbound.ws.StudentWs_PortType getStudentWs_PortType() {
    if (studentWs_PortType == null)
      _initStudentWsProxy();
    return studentWs_PortType;
  }
  
  public com.online.hub.outbound.ws.FetchAllStudentsRes getAllStudentList(com.online.hub.outbound.ws.FetchAllStudentsReq arg0) throws java.rmi.RemoteException{
    if (studentWs_PortType == null)
      _initStudentWsProxy();
    return studentWs_PortType.getAllStudentList(arg0);
  }
  
  public com.online.hub.outbound.ws.AddStudentRes addStudent(com.online.hub.outbound.ws.AddStudentReq arg0) throws java.rmi.RemoteException{
    if (studentWs_PortType == null)
      _initStudentWsProxy();
    return studentWs_PortType.addStudent(arg0);
  }
  
  public com.online.hub.outbound.ws.RemoveStudentRes removeStudent(com.online.hub.outbound.ws.RemoveStudentReq arg0) throws java.rmi.RemoteException{
    if (studentWs_PortType == null)
      _initStudentWsProxy();
    return studentWs_PortType.removeStudent(arg0);
  }
  
  public com.online.hub.outbound.ws.UpdateStudentRes updateStudent(com.online.hub.outbound.ws.UpdateStudentReq arg0) throws java.rmi.RemoteException{
    if (studentWs_PortType == null)
      _initStudentWsProxy();
    return studentWs_PortType.updateStudent(arg0);
  }
  
  public com.online.hub.outbound.ws.GetStudentByIdRes getStudentById(com.online.hub.outbound.ws.GetStudentByIdReq arg0) throws java.rmi.RemoteException{
    if (studentWs_PortType == null)
      _initStudentWsProxy();
    return studentWs_PortType.getStudentById(arg0);
  }
  
  
}