package com.actualize.loanestimate.datamodels;

import org.w3c.dom.Element;

import com.actualize.loanestimate.domainmodels.MISMODataAccessObject;

public class IndexRule extends MISMODataAccessObject {
	public final String IndexType;
	public final String IndexTypeOtherDescription;
	
	public IndexRule(Element element) {
		super(element);
		IndexType = getValueAddNS("IndexType");
		IndexTypeOtherDescription = getValueAddNS("IndexTypeOtherDescription");
	}
}
