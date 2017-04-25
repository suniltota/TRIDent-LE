package com.actualize.loanestimate.datamodels;

import org.w3c.dom.Element;

import com.actualize.loanestimate.domainmodels.MISMODataAccessObject;

public class URLA extends MISMODataAccessObject {
	public final UrlaDetail urlaDetail;

	public URLA(String NS, Element element) {
		super(element);
		urlaDetail = new UrlaDetail(element);
	}
}
