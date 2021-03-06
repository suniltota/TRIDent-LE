package com.actualize.mortgage.datamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines gse datapoints and other under Other Container in MISMO XML
 * @author sboragala
 *
 */
public class Other extends MISMODataAccessObject {
	
	private static final long serialVersionUID = 5349881057802484851L;
	
	public final String integratedDisclosureEstimatedClosingCostsExpirationTimezoneType;
	public final String lockExpirationTimezoneType;
	public final String buydownReflectedInNoteIndicator;                                 
	public final String documentSignatureRequiredIndicator;                              
	public final String escrowAccountRolloverAmount;                                     
	public final String integratedDisclosureSectionType;                                 
	public final String liabilitySecuredBySubjectPropertyIndicator;                      
	public final String totalOptionalPaymentCount;                                       
	public final String totalStepCount;                                                  
	public final String totalStepPaymentCount;                                           
	public final String subordinateFinancingIsNewIndicator;
	public final String escrowAggregateAccountingAdjustmentPaidByType;
	public final String escrowAggregateAccountingAdjustmentPaymentTimingType;
	
	public Other(Element element) {
		super(element);
		integratedDisclosureEstimatedClosingCostsExpirationTimezoneType = getValue("gse:IntegratedDisclosureEstimatedClosingCostsExpirationTimezoneType");
		lockExpirationTimezoneType = getValue("gse:LockExpirationTimezoneType");
		buydownReflectedInNoteIndicator = getValue("gse:BuydownReflectedInNoteIndicator");
		documentSignatureRequiredIndicator = getValue("gse:DocumentSignatureRequiredIndicator");
		escrowAccountRolloverAmount = getValue("gse:EscrowAccountRolloverAmount");
		integratedDisclosureSectionType = getValue("gse:IntegratedDisclosureSectionType");
		liabilitySecuredBySubjectPropertyIndicator = getValue("gse:LiabilitySecuredBySubjectPropertyIndicator");
		totalOptionalPaymentCount = getValue("gse:TotalOptionalPaymentCount");
		totalStepCount = getValue("gse:TotalStepCount");
		totalStepPaymentCount = getValue("gse:TotalStepPaymentCount");
		subordinateFinancingIsNewIndicator = getValue("gse:SubordinateFinancingIsNewIndicator");
		escrowAggregateAccountingAdjustmentPaidByType = getValue("gse:EscrowAggregateAccountingAdjustmentPaidByType");
		escrowAggregateAccountingAdjustmentPaymentTimingType = getValue("gse:EscrowAggregateAccountingAdjustmentPaymentTimingType");
	}
}
