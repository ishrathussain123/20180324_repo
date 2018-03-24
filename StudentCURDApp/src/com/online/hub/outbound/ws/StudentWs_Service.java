/**
 * StudentWs_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.online.hub.outbound.ws;

public interface StudentWs_Service extends javax.xml.rpc.Service {
    public java.lang.String getStudentWsPortAddress();

    public com.online.hub.outbound.ws.StudentWs_PortType getStudentWsPort() throws javax.xml.rpc.ServiceException;

    public com.online.hub.outbound.ws.StudentWs_PortType getStudentWsPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
