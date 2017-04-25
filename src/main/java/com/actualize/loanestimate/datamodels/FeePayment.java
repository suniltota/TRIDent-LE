package com.actualize.loanestimate.datamodels;

import org.w3c.dom.Element;

import com.actualize.loanestimate.domainmodels.MISMODataAccessObject;

public class FeePayment extends MISMODataAccessObject {

	public final String FeeActualPaymentAmount;
	public final String FeePaymentPaidByType;
	public final String FeePaymentPaidOutsideOfClosingIndicator;
		
	public FeePayment(Element element) {
		super(element);
		// TODO 
		FeeActualPaymentAmount = getValueAddNS("FeeActualPaymentAmount"); 
		FeePaymentPaidByType = getValueAddNS("FeePaymentPaidByType"); 
		FeePaymentPaidOutsideOfClosingIndicator = getValueAddNS("FeePaymentPaidOutsideOfClosingIndicator"); 
	}

}
