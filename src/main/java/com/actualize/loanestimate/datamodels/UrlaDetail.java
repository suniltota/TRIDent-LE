package com.actualize.loanestimate.datamodels;

import org.w3c.dom.Element;

import com.actualize.loanestimate.domainmodels.MISMODataAccessObject;

public class UrlaDetail extends MISMODataAccessObject {
	public final String BorrowerRequestedLoanAmount;

	public UrlaDetail(Element element) {
		super(element);
		BorrowerRequestedLoanAmount = getValueAddNS("BorrowerRequestedLoanAmount");
	}
}
