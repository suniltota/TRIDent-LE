package com.actualize.loanestimate.datamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.loanestimate.domainmodels.MISMODataAccessObject;

public class Deals extends MISMODataAccessObject {
	public final Deal[] deal;

	public Deals(String NS, Element element) {
		super(element);
		NodeList nodes = getElements(element, NS + "DEAL");
		if (nodes.getLength() > 0) {
			deal = new Deal[nodes.getLength()];
			for (int i = 0; i < nodes.getLength(); i++)
				deal[i] = new Deal(NS, (Element)nodes.item(i));
		}
		else
			deal = null;
	}
}
