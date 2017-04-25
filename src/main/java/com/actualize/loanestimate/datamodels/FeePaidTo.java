package com.actualize.loanestimate.datamodels;

import org.w3c.dom.Element;

import com.actualize.loanestimate.domainmodels.MISMODataAccessObject;

public class FeePaidTo extends MISMODataAccessObject {
	public LegalEntity legalEntity;

	public FeePaidTo(Element element) {
		super(element);
		legalEntity = new LegalEntity((Element)getElementAddNS("LEGAL_ENTITY"));
	}
}
