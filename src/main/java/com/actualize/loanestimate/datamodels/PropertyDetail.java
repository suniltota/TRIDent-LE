package com.actualize.loanestimate.datamodels;

import org.w3c.dom.Element;

import com.actualize.loanestimate.domainmodels.MISMODataAccessObject;

public class PropertyDetail extends MISMODataAccessObject {
	public final String PropertyEstimatedValueAmount;
	
	public PropertyDetail(Element element) {
		super(element);
		PropertyEstimatedValueAmount = getValueAddNS("PropertyEstimatedValueAmount");
	}
}
