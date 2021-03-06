/**
 * 
 */
package com.actualize.mortgage.datamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

/**
 * represents PrincipalAndInterestPaymentAdjustment in MISMO XML
 * @author sboragala
 *
 */
public class PrincipalAndInterestPaymentAdjustment extends MISMODataAccessObject {

	private static final long serialVersionUID = 5520948311147832005L;
	public final PrincipalAndInterestPaymentLifetimeAdjustmentRule principalAndInterestPaymentLifetimeAdjustmentRule;
	public final PrincipalAndInterestPaymentPerChangeAdjustmentRules principalAndInterestPaymentPerChangeAdjustmentRules;
	public PrincipalAndInterestPaymentAdjustment(Element e) {
		super(e);
		principalAndInterestPaymentLifetimeAdjustmentRule = new PrincipalAndInterestPaymentLifetimeAdjustmentRule((Element)getElementAddNS("PRINCIPAL_AND_INTEREST_PAYMENT_LIFETIME_ADJUSTMENT_RULE"));
		principalAndInterestPaymentPerChangeAdjustmentRules = new  PrincipalAndInterestPaymentPerChangeAdjustmentRules((Element)getElementAddNS("PRINCIPAL_AND_INTEREST_PAYMENT_PER_CHANGE_ADJUSTMENT_RULES"));
	}

}
