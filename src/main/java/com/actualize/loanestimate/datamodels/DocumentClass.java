package com.actualize.loanestimate.datamodels;

import org.w3c.dom.Element;

import com.actualize.loanestimate.domainmodels.MISMODataAccessObject;

public class DocumentClass extends MISMODataAccessObject {
    public final String documentType;
    public final String documentTypeOtherDescription;
    
	public DocumentClass(Element element) {
		super(element);
		documentType = getValueAddNS("DocumentType");
		documentTypeOtherDescription = getValueAddNS("DocumentTypeOtherDescription");
	}
}
