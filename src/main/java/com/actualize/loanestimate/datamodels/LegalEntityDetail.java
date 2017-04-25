package com.actualize.loanestimate.datamodels;

import org.w3c.dom.Element;

import com.actualize.loanestimate.domainmodels.MISMODataAccessObject;
/**
 * Maps to LegalEntityDetail in XML
 * @author sboragala
 *
 */
public class LegalEntityDetail extends MISMODataAccessObject {
	public final String fullName;
	
	public LegalEntityDetail(Element element) {
		super(element);
		fullName = getValueAddNS("FullName");
	}
}
