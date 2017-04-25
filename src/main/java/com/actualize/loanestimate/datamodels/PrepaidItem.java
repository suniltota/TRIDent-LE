package com.actualize.loanestimate.datamodels;

import org.w3c.dom.Element;

import com.actualize.loanestimate.domainmodels.MISMODataAccessObject;
/**
 * Defines PrepaidItem from XML
 * @author sboragala
 *
 */
public class PrepaidItem extends MISMODataAccessObject {
	public final PrepaidItemDetail prepaidItemDetail;
	public final PrepaidItemPayments prepaidItemPayments;
	public final PrepaidItemPaidTo prepaidItemPaidTo;
	public PrepaidItem(Element element) {
		super(element);
		prepaidItemDetail = new PrepaidItemDetail((Element)getElementAddNS("PREPAID_ITEM_DETAIL"));
		prepaidItemPayments = new PrepaidItemPayments((Element)getElementAddNS("PREPAID_ITEM_PAYMENTS"));
		prepaidItemPaidTo = new PrepaidItemPaidTo((Element)getElementAddNS("PREPAID_ITEM_PAID_TO"));
	}
}
