package com.actualize.loanestimate.datamodels;

import org.w3c.dom.Element;

import com.actualize.loanestimate.domainmodels.MISMODataAccessObject;

public class SalesContractDetail extends MISMODataAccessObject {
	public final String PersonalPropertyAmount;
	public final String PersonalPropertyIncludedIndicator;
	public final String RealPropertyAmount;
	public final String SalesContractAmount;
	
	public SalesContractDetail(Element element) {
		super(element);
		PersonalPropertyAmount = getValueAddNS("PersonalPropertyAmount");
		PersonalPropertyIncludedIndicator = getValueAddNS("PersonalPropertyIncludedIndicator");
		RealPropertyAmount = getValueAddNS("RealPropertyAmount");
		SalesContractAmount = getValueAddNS("SalesContractAmount");
	}
}
