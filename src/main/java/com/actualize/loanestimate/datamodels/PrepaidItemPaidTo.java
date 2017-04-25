package com.actualize.loanestimate.datamodels;

import org.w3c.dom.Element;

import com.actualize.loanestimate.domainmodels.MISMODataAccessObject;

public class PrepaidItemPaidTo extends MISMODataAccessObject{
	public final LegalEntity legalEntity;
	public PrepaidItemPaidTo(Element e) {
		super(e);
		legalEntity = new LegalEntity((Element)getElementAddNS("LEGAL_ENTITY"));
	}

}
