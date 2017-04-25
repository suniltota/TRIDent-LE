package com.actualize.loanestimate.datamodels;

import org.w3c.dom.Element;

import com.actualize.loanestimate.domainmodels.MISMODataAccessObject;

public class ContactPointTelephone extends MISMODataAccessObject {
	public final String ContactPointTelephoneValue;
	
	public ContactPointTelephone(Element element) {
		super(element);
		ContactPointTelephoneValue = getValueAddNS("ContactPointTelephoneValue");
	}
}
