package com.siteview.cxf.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.2.6
 * Tue Feb 02 13:16:44 CST 2010
 * Generated source version: 2.2.6
 * 
 */
 
@WebService(targetNamespace = "http://svdb.siteview.com", name = "SvdbApiImpl")
@XmlSeeAlso({ObjectFactory.class})
public interface SvdbApiImpl {

    @RequestWrapper(localName = "appendRecord", targetNamespace = "http://svdb.siteview.com", className = "com.siteview.cxf.client.AppendRecord")
    @ResponseWrapper(localName = "appendRecordResponse", targetNamespace = "http://svdb.siteview.com", className = "com.siteview.cxf.client.AppendRecordResponse")
    @WebMethod
    public void appendRecord(
        @WebParam(name = "id", targetNamespace = "http://svdb.siteview.com")
        java.lang.String id,
        @WebParam(name = "text", targetNamespace = "http://svdb.siteview.com")
        java.lang.String text
    );
}