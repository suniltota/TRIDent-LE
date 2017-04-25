//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.01 at 06:02:48 PM IST 
//


package org.mismo.residential._2009.schemas;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrepaidItemBase.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PrepaidItemBase">
 *   &lt;restriction base="{http://www.mismo.org/residential/2009/schemas}MISMOEnum_Base">
 *     &lt;enumeration value="BoroughPropertyTax"/>
 *     &lt;enumeration value="CityPropertyTax"/>
 *     &lt;enumeration value="CondominiumAssociationDues"/>
 *     &lt;enumeration value="CondominiumAssociationSpecialAssessment"/>
 *     &lt;enumeration value="CooperativeAssociationDues"/>
 *     &lt;enumeration value="CooperativeAssociationSpecialAssessment"/>
 *     &lt;enumeration value="CountyPropertyTax"/>
 *     &lt;enumeration value="DistrictPropertyTax"/>
 *     &lt;enumeration value="EarthquakeInsurancePremium"/>
 *     &lt;enumeration value="FloodInsurancePremium"/>
 *     &lt;enumeration value="HailInsurancePremium"/>
 *     &lt;enumeration value="HazardInsurancePremium"/>
 *     &lt;enumeration value="HomeownersAssociationDues"/>
 *     &lt;enumeration value="HomeownersAssociationSpecialAssessment"/>
 *     &lt;enumeration value="HomeownersInsurancePremium"/>
 *     &lt;enumeration value="MortgageInsurancePremium"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="PrepaidInterest"/>
 *     &lt;enumeration value="StatePropertyTax"/>
 *     &lt;enumeration value="TownPropertyTax"/>
 *     &lt;enumeration value="VolcanoInsurancePremium"/>
 *     &lt;enumeration value="WindAndStormInsurancePremium"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PrepaidItemBase")
@XmlEnum
public enum PrepaidItemBase {


    /**
     * Property tax levied by the borough in which the subject property is located.
     * 
     */
    @XmlEnumValue("BoroughPropertyTax")
    BOROUGH_PROPERTY_TAX("BoroughPropertyTax"),

    /**
     * Property tax levied by the city in which the subject property is located.
     * 
     */
    @XmlEnumValue("CityPropertyTax")
    CITY_PROPERTY_TAX("CityPropertyTax"),

    /**
     * Fee payable to condominium association in which the subject property is located, which is intended to pay electricity bills for street lights, landscaping, and maintenance and repairs to community facilities like clubhouses, pools, and exercise rooms and may also cover insurance on community assets, the salaries of condominium association employees and/or third party management fees.
     * 
     */
    @XmlEnumValue("CondominiumAssociationDues")
    CONDOMINIUM_ASSOCIATION_DUES("CondominiumAssociationDues"),

    /**
     * Fee payable to condominium association in which the subject property is located for capital improvements, utility service upgrades, etc. that are assessed in addition to the regularly occurring condominium dues.
     * 
     */
    @XmlEnumValue("CondominiumAssociationSpecialAssessment")
    CONDOMINIUM_ASSOCIATION_SPECIAL_ASSESSMENT("CondominiumAssociationSpecialAssessment"),

    /**
     * Fee payable to cooperative in which the subject property is located, which is intended to pay common utilities, landscaping, and maintenance and repairs to cooperative facilities and may also cover insurance on cooperative assets, the salaries of cooperative employees and/or third party management fees.
     * 
     */
    @XmlEnumValue("CooperativeAssociationDues")
    COOPERATIVE_ASSOCIATION_DUES("CooperativeAssociationDues"),

    /**
     * Fee payable to cooperative association or corporation in which the subject property is located for capital improvements, utility service upgrades, etc. that are assessed in addition to the regularly occurring dues, fees or debt service.
     * 
     */
    @XmlEnumValue("CooperativeAssociationSpecialAssessment")
    COOPERATIVE_ASSOCIATION_SPECIAL_ASSESSMENT("CooperativeAssociationSpecialAssessment"),

    /**
     * Property tax levied by the county in which the subject property is located.
     * 
     */
    @XmlEnumValue("CountyPropertyTax")
    COUNTY_PROPERTY_TAX("CountyPropertyTax"),

    /**
     * Property tax levied by the district in which the subject property is located.
     * 
     */
    @XmlEnumValue("DistrictPropertyTax")
    DISTRICT_PROPERTY_TAX("DistrictPropertyTax"),

    /**
     * Fee payable to insurer to provide property insurance against loss from earthquake, land tremors, landslide, mudflow, or other earth movement whether the damage is caused by an earthquake. 
     * 
     */
    @XmlEnumValue("EarthquakeInsurancePremium")
    EARTHQUAKE_INSURANCE_PREMIUM("EarthquakeInsurancePremium"),

    /**
     * Fee paid for flood insurance coverage on the subject property and may include coverage for contents.
     * 
     */
    @XmlEnumValue("FloodInsurancePremium")
    FLOOD_INSURANCE_PREMIUM("FloodInsurancePremium"),

    /**
     * Cost of coverage for hail damage insurance, which typically covers the cost of rebuilding the subject property if losses are caused by hail storms.
     * 
     */
    @XmlEnumValue("HailInsurancePremium")
    HAIL_INSURANCE_PREMIUM("HailInsurancePremium"),

    /**
     * Fee paid for coverage on the subject property for losses or damage due to fire or other named perils.
     * 
     */
    @XmlEnumValue("HazardInsurancePremium")
    HAZARD_INSURANCE_PREMIUM("HazardInsurancePremium"),

    /**
     * Fee payable to homeowners or neighborhood association for the planned unit development or neighborhood within which the subject property is located, which is intended to pay electricity bills for street lights, landscaping, and maintenance and repairs to community facilities like clubhouses, pools, and exercise rooms and may also cover insurance on community assets, the salaries of HOA employees or third party management fees.
     * 
     */
    @XmlEnumValue("HomeownersAssociationDues")
    HOMEOWNERS_ASSOCIATION_DUES("HomeownersAssociationDues"),

    /**
     * Fee payable to homeowners or neighborhood association in which the subject property is located for capital improvements, utility service upgrades, etc., that are assessed in addition to the regularly occurring association dues.
     * 
     */
    @XmlEnumValue("HomeownersAssociationSpecialAssessment")
    HOMEOWNERS_ASSOCIATION_SPECIAL_ASSESSMENT("HomeownersAssociationSpecialAssessment"),

    /**
     * Periodic amount paid for coverage against hazards, theft and other losses on the insured subject property and sometimes insured contents of personal property, and other improvements (fences, porches, patios, driveways, landscaping, accessory buildings, in ground pools, etc.) May or may not include riders to insure against losses caused by windstorms, hurricanes, etc.
     * 
     */
    @XmlEnumValue("HomeownersInsurancePremium")
    HOMEOWNERS_INSURANCE_PREMIUM("HomeownersInsurancePremium"),

    /**
     * Fee for Insurance or guaranty to protect lender against the non-payment of, or default on, an individual mortgage.
     * 
     */
    @XmlEnumValue("MortgageInsurancePremium")
    MORTGAGE_INSURANCE_PREMIUM("MortgageInsurancePremium"),
    @XmlEnumValue("Other")
    OTHER("Other"),

    /**
     * Interest collected at settlement for a part of the month or other period between settlement and the date from which interest will be collected with the first regular monthly payment.
     * 
     */
    @XmlEnumValue("PrepaidInterest")
    PREPAID_INTEREST("PrepaidInterest"),

    /**
     * Property tax levied by the state in which the subject property is located.
     * 
     */
    @XmlEnumValue("StatePropertyTax")
    STATE_PROPERTY_TAX("StatePropertyTax"),

    /**
     * Property tax levied by the town in which the subject property is located.
     * 
     */
    @XmlEnumValue("TownPropertyTax")
    TOWN_PROPERTY_TAX("TownPropertyTax"),

    /**
     * Periodic amount paid for coverage against losses on the insured subject property and sometimes insured contents of personal property, and other improvements (fences, porches, patios, driveways, landscaping, accessory buildings, in ground pools, etc.) associated with volcano eruptions near the subject property.
     * 
     */
    @XmlEnumValue("VolcanoInsurancePremium")
    VOLCANO_INSURANCE_PREMIUM("VolcanoInsurancePremium"),

    /**
     * Periodic amount paid for coverage against losses on the insured subject property and sometimes insured contents of personal property, and other improvements (fences, porches, patios, driveways, landscaping, accessory buildings, in ground pools, etc.) associated with windstorms, tornadoes and hurricanes affecting the subject property.
     * 
     */
    @XmlEnumValue("WindAndStormInsurancePremium")
    WIND_AND_STORM_INSURANCE_PREMIUM("WindAndStormInsurancePremium");
    private final String value;

    PrepaidItemBase(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PrepaidItemBase fromValue(String v) {
        for (PrepaidItemBase c: PrepaidItemBase.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
