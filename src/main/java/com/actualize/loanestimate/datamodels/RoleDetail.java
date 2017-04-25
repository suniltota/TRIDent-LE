package com.actualize.loanestimate.datamodels;

import org.w3c.dom.Element;

import com.actualize.loanestimate.domainmodels.MISMODataAccessObject;

public class RoleDetail extends MISMODataAccessObject {
	public final String PartyRoleType;
	
	public RoleDetail(Element element) {
		super(element);
		PartyRoleType = getValueAddNS("PartyRoleType");
	}
}
