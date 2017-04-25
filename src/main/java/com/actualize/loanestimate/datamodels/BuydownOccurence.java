package com.actualize.loanestimate.datamodels;

import org.w3c.dom.Element;

import com.actualize.loanestimate.domainmodels.MISMODataAccessObject;

public class BuydownOccurence extends MISMODataAccessObject {
	public final String BuydownInitialEffectiveInterestRatePercent;
	
	public BuydownOccurence(Element element) {
		super(element);
		BuydownInitialEffectiveInterestRatePercent = getValueAddNS("BuydownInitialEffectiveInterestRatePercent");
	}
}
