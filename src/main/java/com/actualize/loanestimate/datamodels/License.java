package com.actualize.loanestimate.datamodels;

import org.w3c.dom.Element;

import com.actualize.loanestimate.domainmodels.MISMODataAccessObject;

public class License extends MISMODataAccessObject {
	public final LicenseDetail licenseDetail;

	public License(Element element) {
		super(element);
		licenseDetail = new LicenseDetail((Element)getElementAddNS("LICENSE_DETAIL"));
	}
}
