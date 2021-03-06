package com.actualize.mortgage.datamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * represents PrepaidItemPayments in MISMO XML
 * @author sboragala
 *
 */
public class PrepaidItemPayments extends MISMODataAccessObject {
	private static final long serialVersionUID = -5918930292915569559L;
	public final PrepaidItemPayment[] prepaidItemPayments;
	public PrepaidItemPayments(Element element) {
		this(element,"");
	}
	
	public PrepaidItemPayments(Element element, String qualifier) {
		super(element);
		NodeList nodes = getElementsAddNS("PREPAID_ITEM_PAYMENT" + qualifier);
		prepaidItemPayments = new PrepaidItemPayment[nodes==null ? 0 : nodes.getLength()];
		for (int i = 0; i < prepaidItemPayments.length; i++)
			prepaidItemPayments[i] = new PrepaidItemPayment((Element)nodes.item(i));
	}
}
