package com.actualize.loanestimate.datamodels;

import org.w3c.dom.Element;

import com.actualize.loanestimate.domainmodels.MISMODataAccessObject;
/**
 * 
 * @author sboragala
 *
 */
public class LoanIdentifier extends MISMODataAccessObject {
	public final String LoanIdentifier;
	public final String LoanIdentifierType;
	
	public LoanIdentifier(Element element) {
		super(element);
		LoanIdentifier = getValueAddNS("LoanIdentifier");
		LoanIdentifierType = getValueAddNS("LoanIdentifierType");
	}
}
