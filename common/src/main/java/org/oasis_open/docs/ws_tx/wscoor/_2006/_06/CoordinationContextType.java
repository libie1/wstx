
package org.oasis_open.docs.ws_tx.wscoor._2006._06;

import org.apache.cxf.ws.addressing.EndpointReferenceType;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>Java class for CoordinationContextType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CoordinationContextType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Identifier">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>anyURI">
 *                 &lt;anyAttribute namespace='##other'/>
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://docs.oasis-open.org/ws-tx/wscoor/2006/06}Expires" minOccurs="0"/>
 *         &lt;element name="CoordinationType" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="RegistrationService" type="{http://www.w3.org/2005/08/addressing}EndpointReferenceType"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CoordinationContextType", propOrder = {
    "identifier",
    "expires",
    "coordinationType",
    "registrationService"
})
@XmlSeeAlso({
    CoordinationContext.class
})
public class CoordinationContextType {

    @XmlElement(name = "Identifier", required = true)
    protected CoordinationContextType.Identifier identifier;
    @XmlElement(name = "Expires")
    protected Expires expires;
    @XmlElement(name = "CoordinationType", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String coordinationType;
    @XmlElement(name = "RegistrationService", required = true)
    protected EndpointReferenceType registrationService;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the identifier property.
     * 
     * @return
     *     possible object is
     *     {@link CoordinationContextType.Identifier }
     *     
     */
    public CoordinationContextType.Identifier getIdentifier() {
        return identifier;
    }

    /**
     * Sets the value of the identifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoordinationContextType.Identifier }
     *     
     */
    public void setIdentifier(CoordinationContextType.Identifier value) {
        this.identifier = value;
    }

    /**
     * Gets the value of the expires property.
     * 
     * @return
     *     possible object is
     *     {@link Expires }
     *     
     */
    public Expires getExpires() {
        return expires;
    }

    /**
     * Sets the value of the expires property.
     * 
     * @param value
     *     allowed object is
     *     {@link Expires }
     *     
     */
    public void setExpires(Expires value) {
        this.expires = value;
    }

    /**
     * Gets the value of the coordinationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoordinationType() {
        return coordinationType;
    }

    /**
     * Sets the value of the coordinationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoordinationType(String value) {
        this.coordinationType = value;
    }

    /**
     * Gets the value of the registrationService property.
     * 
     * @return
     *     possible object is
     *     {@link EndpointReferenceType }
     *     
     */
    public EndpointReferenceType getRegistrationService() {
        return registrationService;
    }

    /**
     * Sets the value of the registrationService property.
     * 
     * @param value
     *     allowed object is
     *     {@link EndpointReferenceType }
     *     
     */
    public void setRegistrationService(EndpointReferenceType value) {
        this.registrationService = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>anyURI">
     *       &lt;anyAttribute namespace='##other'/>
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Identifier {

        @XmlValue
        @XmlSchemaType(name = "anyURI")
        protected String value;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets a map that contains attributes that aren't bound to any typed property on this class.
         * 
         * <p>
         * the map is keyed by the name of the attribute and 
         * the value is the string value of the attribute.
         * 
         * the map returned by this method is live, and you can add new attribute
         * by updating the map directly. Because of this design, there's no setter.
         * 
         * 
         * @return
         *     always non-null
         */
        public Map<QName, String> getOtherAttributes() {
            return otherAttributes;
        }

    }

}
