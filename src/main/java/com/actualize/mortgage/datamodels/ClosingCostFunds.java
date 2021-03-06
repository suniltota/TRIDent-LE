/**
 * 
 */
package com.actualize.mortgage.datamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

/**
 * this class defines ClosingCostFunds in MISMO XML
 * @author sboragala
 *
 */
public class ClosingCostFunds extends MISMODataAccessObject {

	private static final long serialVersionUID = 6008502879702997456L;
	public final ClosingCostFund closingCostFundList[];
	
	protected ClosingCostFunds(Element e) {
		super(e);
		NodeList nodes = getElementsAddNS("CLOSING_COST_FUND");
		closingCostFundList = new ClosingCostFund[nodes==null ? 0 : nodes.getLength()];
		for (int i = 0; i < closingCostFundList.length; i++)
			closingCostFundList[i] = new ClosingCostFund((Element)nodes.item(i));
		
	}

}
