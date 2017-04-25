package com.actualize.loanestimate.datamodels;

import org.w3c.dom.Element;

import com.actualize.loanestimate.domainmodels.MISMODataAccessObject;

public class Extension extends MISMODataAccessObject {
	public final Other other;
	
	public Extension(Element element) {
		super(element);
		other = new Other((Element)getElementAddNS("OTHER"));
	}
}
