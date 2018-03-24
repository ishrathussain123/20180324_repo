/**
 * StudentWs_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.online.hub.outbound.ws;

public class StudentWs_ServiceLocator extends org.apache.axis.client.Service implements com.online.hub.outbound.ws.StudentWs_Service {

    public StudentWs_ServiceLocator() {
    }


    public StudentWs_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public StudentWs_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for StudentWsPort
    private java.lang.String StudentWsPort_address = "http://localhost:8080/OnlineHub/StudentWs";

    public java.lang.String getStudentWsPortAddress() {
        return StudentWsPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String StudentWsPortWSDDServiceName = "StudentWsPort";

    public java.lang.String getStudentWsPortWSDDServiceName() {
        return StudentWsPortWSDDServiceName;
    }

    public void setStudentWsPortWSDDServiceName(java.lang.String name) {
        StudentWsPortWSDDServiceName = name;
    }

    public com.online.hub.outbound.ws.StudentWs_PortType getStudentWsPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(StudentWsPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getStudentWsPort(endpoint);
    }

    public com.online.hub.outbound.ws.StudentWs_PortType getStudentWsPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.online.hub.outbound.ws.StudentWsPortBindingStub _stub = new com.online.hub.outbound.ws.StudentWsPortBindingStub(portAddress, this);
            _stub.setPortName(getStudentWsPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setStudentWsPortEndpointAddress(java.lang.String address) {
        StudentWsPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.online.hub.outbound.ws.StudentWs_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.online.hub.outbound.ws.StudentWsPortBindingStub _stub = new com.online.hub.outbound.ws.StudentWsPortBindingStub(new java.net.URL(StudentWsPort_address), this);
                _stub.setPortName(getStudentWsPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("StudentWsPort".equals(inputPortName)) {
            return getStudentWsPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.outbound.hub.online.com/", "StudentWs");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.outbound.hub.online.com/", "StudentWsPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("StudentWsPort".equals(portName)) {
            setStudentWsPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
