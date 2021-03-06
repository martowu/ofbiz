
/*
 * 
 */

package com.siteview.cxf.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.2.6
 * Tue Feb 02 13:16:45 CST 2010
 * Generated source version: 2.2.6
 * 
 */


@WebServiceClient(name = "SvdbApiImplService", 
                  wsdlLocation = "file:SvdbApiImpl.wsdl",
                  targetNamespace = "http://svdb.siteview.com") 
public class SvdbApiImplService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://svdb.siteview.com", "SvdbApiImplService");
    public final static QName SvdbApiImpl = new QName("http://svdb.siteview.com", "SvdbApiImpl");
    static {
        URL url = null;
        try {
            url = new URL("file:SvdbApiImpl.wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from file:SvdbApiImpl.wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public SvdbApiImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public SvdbApiImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SvdbApiImplService() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns SvdbApiImpl
     */
    @WebEndpoint(name = "SvdbApiImpl")
    public SvdbApiImpl getSvdbApiImpl() {
        return super.getPort(SvdbApiImpl, SvdbApiImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SvdbApiImpl
     */
    @WebEndpoint(name = "SvdbApiImpl")
    public SvdbApiImpl getSvdbApiImpl(WebServiceFeature... features) {
        return super.getPort(SvdbApiImpl, SvdbApiImpl.class, features);
    }

}
