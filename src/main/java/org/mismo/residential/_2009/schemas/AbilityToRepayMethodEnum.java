//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.01 at 06:02:48 PM IST 
//


package org.mismo.residential._2009.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Specifies the method by which the creditor satisfied Regulation Z Ability-to-Repay requirements.
 * 
 * <p>Java class for AbilityToRepayMethodEnum complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbilityToRepayMethodEnum">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.mismo.org/residential/2009/schemas>AbilityToRepayMethodBase">
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbilityToRepayMethodEnum", propOrder = {
    "value"
})
public class AbilityToRepayMethodEnum {

    @XmlValue
    protected AbilityToRepayMethodBase value;

    /**
     * Term: Ability To Repay Method Type Definition: Specifies the method by which the creditor satisfied Regulation Z Ability-to-Repay requirements.
     * 
     * @return
     *     possible object is
     *     {@link AbilityToRepayMethodBase }
     *     
     */
    public AbilityToRepayMethodBase getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link AbilityToRepayMethodBase }
     *     
     */
    public void setValue(AbilityToRepayMethodBase value) {
        this.value = value;
    }

}
