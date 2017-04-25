package com.actualize.loanestimate.datamodels;

import org.w3c.dom.Element;

import com.actualize.loanestimate.domainmodels.MISMODataAccessObject;

public class EscrowDetail extends MISMODataAccessObject{
	
    public final String EscrowAggregateAccountingAdjustmentAmount;
    
	protected EscrowDetail(Element element) {
		super(element);
		// TODO 
		EscrowAggregateAccountingAdjustmentAmount = getValue("EscrowAggregateAccountingAdjustmentAmount");
	}

}
