/**
 * GetStudentByIdRes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.online.hub.outbound.ws;

public class GetStudentByIdRes  extends com.online.hub.outbound.ws.BaseResponse  implements java.io.Serializable {
    private com.online.hub.outbound.ws.StudentDto students;

    public GetStudentByIdRes() {
    }

    public GetStudentByIdRes(
           java.lang.String errorCode,
           java.lang.String errorMessage,
           com.online.hub.outbound.ws.StudentDto students) {
        super(
            errorCode,
            errorMessage);
        this.students = students;
    }


    /**
     * Gets the students value for this GetStudentByIdRes.
     * 
     * @return students
     */
    public com.online.hub.outbound.ws.StudentDto getStudents() {
        return students;
    }


    /**
     * Sets the students value for this GetStudentByIdRes.
     * 
     * @param students
     */
    public void setStudents(com.online.hub.outbound.ws.StudentDto students) {
        this.students = students;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetStudentByIdRes)) return false;
        GetStudentByIdRes other = (GetStudentByIdRes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.students==null && other.getStudents()==null) || 
             (this.students!=null &&
              this.students.equals(other.getStudents())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getStudents() != null) {
            _hashCode += getStudents().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetStudentByIdRes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.outbound.hub.online.com/", "getStudentByIdRes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("students");
        elemField.setXmlName(new javax.xml.namespace.QName("", "students"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.outbound.hub.online.com/", "studentDto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
