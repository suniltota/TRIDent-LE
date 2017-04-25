//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.01 at 06:02:48 PM IST 
//


package org.mismo.residential._2009.schemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Information regarding individual escrow types handled by the escrow account.  Holds all occurrences of ESCROW_ITEM.
 * 
 * <p>Java class for ESCROW_ITEMS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ESCROW_ITEMS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ESCROW_ITEM" type="{http://www.mismo.org/residential/2009/schemas}ESCROW_ITEM" maxOccurs="10" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESCROW_ITEMS", propOrder = {
    "escrowitem"
})
public class ESCROWITEMS {

    @XmlElement(name = "ESCROW_ITEM")
    protected List<ESCROWITEM> escrowitem;

    /**
     * Gets the value of the escrowitem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the escrowitem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getESCROWITEM().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ESCROWITEM }
     * 
     * 
     */
    public List<ESCROWITEM> getESCROWITEM() {
        if (escrowitem == null) {
            escrowitem = new ArrayList<ESCROWITEM>();
        }
        return this.escrowitem;
    }

}
