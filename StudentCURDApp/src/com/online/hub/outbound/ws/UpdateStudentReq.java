/**
 * UpdateStudentReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.online.hub.outbound.ws;

public class UpdateStudentReq  implements java.io.Serializable {
    private com.online.hub.outbound.ws.StudentDto studentDto;

    public UpdateStudentReq() {
    }

    public UpdateStudentReq(
           com.online.hub.outbound.ws.StudentDto studentDto) {
           this.studentDto = studentDto;
    }


    /**
     * Gets the studentDto value for this UpdateStudentReq.
     * 
     * @return studentDto
     */
    public com.online.hub.outbound.ws.StudentDto getStudentDto() {
        return studentDto;
    }


    /**
     * Sets the studentDto value for this UpdateStudentReq.
     * 
     * @param studentDto
     */
    public void setStudentDto(com.online.hub.outbound.ws.StudentDto studentDto) {
        this.studentDto = studentDto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UpdateStudentReq)) return false;
        UpdateStudentReq other = (UpdateStudentReq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.studentDto==null && other.getStudentDto()==null) || 
             (this.studentDto!=null &&
              this.studentDto.equals(other.getStudentDto())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getStudentDto() != null) {
            _hashCode += getStudentDto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UpdateStudentReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.outbound.hub.online.com/", "updateStudentReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("studentDto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "studentDto"));
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
