
package org.oasis_open.docs.ws_tx.wscoor._2006._06;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "RegistrationPortType", targetNamespace = "http://docs.oasis-open.org/ws-tx/wscoor/2006/06")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    org.oasis_open.docs.ws_tx.wscoor._2006._06.ObjectFactory.class,
    org.w3._2005._08.addressing.ObjectFactory.class
})
public interface RegistrationPortType {


    /**
     * 
     * @param parameters
     * @return
     *     returns org.oasis_open.docs.ws_tx.wscoor._2006._06.RegisterResponseType
     */
    @WebMethod(operationName = "RegisterOperation", action = "http://docs.oasis-open.org/ws-tx/wscoor/2006/06/Register")
    @WebResult(name = "RegisterResponse", targetNamespace = "http://docs.oasis-open.org/ws-tx/wscoor/2006/06", partName = "parameters")
    public RegisterResponseType registerOperation(
        @WebParam(name = "Register", targetNamespace = "http://docs.oasis-open.org/ws-tx/wscoor/2006/06", partName = "parameters")
        RegisterType parameters);

}
