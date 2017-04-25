package com.actualize.loanestimate.datamodels;

import org.w3c.dom.Element;

import com.actualize.loanestimate.domainmodels.MISMODataAccessObject;

public class EstimatedPropertyCostDetail extends MISMODataAccessObject {
	public final String ProjectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount;
	
	public EstimatedPropertyCostDetail(Element element) {
		super(element);
		ProjectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount = getValueAddNS("ProjectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount");
	}
}
