package com.actualize.mortgage.convertors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.datamodels.Address;
import com.actualize.mortgage.datamodels.AmortizationRule;
import com.actualize.mortgage.datamodels.BuydownOccurence;
import com.actualize.mortgage.datamodels.BuydownRule;
import com.actualize.mortgage.datamodels.CashToCloseItem;
import com.actualize.mortgage.datamodels.CashToCloseItems;
import com.actualize.mortgage.datamodels.ClosingAdjustmentItem;
import com.actualize.mortgage.datamodels.ClosingCostFund;
import com.actualize.mortgage.datamodels.ClosingInformation;
import com.actualize.mortgage.datamodels.ClosingInformationDetail;
import com.actualize.mortgage.datamodels.Construction;
import com.actualize.mortgage.datamodels.Deal;
import com.actualize.mortgage.datamodels.Document;
import com.actualize.mortgage.datamodels.DocumentClass;
import com.actualize.mortgage.datamodels.DocumentClassification;
import com.actualize.mortgage.datamodels.EscrowItem;
import com.actualize.mortgage.datamodels.EscrowItemDetail;
import com.actualize.mortgage.datamodels.EscrowItemPayment;
import com.actualize.mortgage.datamodels.EscrowItems;
import com.actualize.mortgage.datamodels.EstimatedPropertyCostComponents;
import com.actualize.mortgage.datamodels.Fee;
import com.actualize.mortgage.datamodels.FeePayment;
import com.actualize.mortgage.datamodels.FeeSummaryDetail;
import com.actualize.mortgage.datamodels.Fees;
import com.actualize.mortgage.datamodels.Foreclosures;
import com.actualize.mortgage.datamodels.IntegratedDisclosureDetail;
import com.actualize.mortgage.datamodels.IntegratedDisclosureSectionSummaries;
import com.actualize.mortgage.datamodels.IntegratedDisclosureSectionSummary;
import com.actualize.mortgage.datamodels.IntegratedDisclosureSectionSummaryDetail;
import com.actualize.mortgage.datamodels.IntegratedDisclosureSubsectionPayment;
import com.actualize.mortgage.datamodels.IntegratedDisclosureSubsectionPayments;
import com.actualize.mortgage.datamodels.InterestOnly;
import com.actualize.mortgage.datamodels.InterestRateAdjustment;
import com.actualize.mortgage.datamodels.InterestRatePerChangeAdjustmentRule;
import com.actualize.mortgage.datamodels.LateChargeRule;
import com.actualize.mortgage.datamodels.Liabilities;
import com.actualize.mortgage.datamodels.Liability;
import com.actualize.mortgage.datamodels.LicenseDetail;
import com.actualize.mortgage.datamodels.LoanDetail;
import com.actualize.mortgage.datamodels.LoanIdentifiers;
import com.actualize.mortgage.datamodels.LoanProduct;
import com.actualize.mortgage.datamodels.Lock;
import com.actualize.mortgage.datamodels.MIDataDetail;
import com.actualize.mortgage.datamodels.MISMODocument;
import com.actualize.mortgage.datamodels.MaturityRule;
import com.actualize.mortgage.datamodels.Name;
import com.actualize.mortgage.datamodels.NegativeAmortization;
import com.actualize.mortgage.datamodels.Other;
import com.actualize.mortgage.datamodels.PartialPayment;
import com.actualize.mortgage.datamodels.Parties;
import com.actualize.mortgage.datamodels.Party;
import com.actualize.mortgage.datamodels.Payment;
import com.actualize.mortgage.datamodels.PrepaidItem;
import com.actualize.mortgage.datamodels.PrepaidItemPayment;
import com.actualize.mortgage.datamodels.PrepaidItems;
import com.actualize.mortgage.datamodels.PrepaymentPenaltyLifetimeRule;
import com.actualize.mortgage.datamodels.PrincipalAndInterestPaymentAdjustment;
import com.actualize.mortgage.datamodels.PrincipalAndInterestPaymentPerChangeAdjustmentRule;
import com.actualize.mortgage.datamodels.ProjectedPayment;
import com.actualize.mortgage.datamodels.ProjectedPayments;
import com.actualize.mortgage.datamodels.PropertyDetail;
import com.actualize.mortgage.datamodels.PropertyValuationDetail;
import com.actualize.mortgage.datamodels.ProrationItem;
import com.actualize.mortgage.datamodels.SalesContractDetail;
import com.actualize.mortgage.datamodels.TermsOfLoan;
import com.actualize.mortgage.datamodels.Underwriting;
import com.actualize.mortgage.domainmodels.AddressModel;
import com.actualize.mortgage.domainmodels.AutomatedUnderwritingsModel;
import com.actualize.mortgage.domainmodels.Borrower;
import com.actualize.mortgage.domainmodels.CashToClose;
import com.actualize.mortgage.domainmodels.CashToCloseModel;
import com.actualize.mortgage.domainmodels.ClosingAdjustmentItemModel;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsLoanCosts;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsOtherCosts;
import com.actualize.mortgage.domainmodels.ClosingCostFundModel;
import com.actualize.mortgage.domainmodels.ClosingCostProperties;
import com.actualize.mortgage.domainmodels.ClosingCostsTotal;
import com.actualize.mortgage.domainmodels.ClosingInformationDetailModel;
import com.actualize.mortgage.domainmodels.ClosingInformationModel;
import com.actualize.mortgage.domainmodels.ConstructionModel;
import com.actualize.mortgage.domainmodels.ContactInformationDetailModel;
import com.actualize.mortgage.domainmodels.ContactInformationModel;
import com.actualize.mortgage.domainmodels.CostsAtClosing;
import com.actualize.mortgage.domainmodels.CostsAtClosingCashToClose;
import com.actualize.mortgage.domainmodels.CostsAtClosingClosingCosts;
import com.actualize.mortgage.domainmodels.DocumentClassificationModel;
import com.actualize.mortgage.domainmodels.ETIA;
import com.actualize.mortgage.domainmodels.ETIASection;
import com.actualize.mortgage.domainmodels.EscrowItemModel;
import com.actualize.mortgage.domainmodels.IntegratedDisclosureDetailModel;
import com.actualize.mortgage.domainmodels.IntegratedDisclosureSectionSummaryDetailModel;
import com.actualize.mortgage.domainmodels.IntegratedDisclosureSectionSummaryModel;
import com.actualize.mortgage.domainmodels.IntegratedDisclosureSubsectionPaymentModel;
import com.actualize.mortgage.domainmodels.InterestOnlyModel;
import com.actualize.mortgage.domainmodels.InterestRateAdjustmentModel;
import com.actualize.mortgage.domainmodels.LateChargeRuleModel;
import com.actualize.mortgage.domainmodels.LiabilityModel;
import com.actualize.mortgage.domainmodels.LicenseDetailModel;
import com.actualize.mortgage.domainmodels.LoanCalculationModel;
import com.actualize.mortgage.domainmodels.LoanCalculationsQualifiedMortgage;
import com.actualize.mortgage.domainmodels.LoanDetailModel;
import com.actualize.mortgage.domainmodels.LoanEstimate;
import com.actualize.mortgage.domainmodels.LoanEstimateDocumentDetails;
import com.actualize.mortgage.domainmodels.LoanInformation;
import com.actualize.mortgage.domainmodels.LoanInformationLoanIdentifier;
import com.actualize.mortgage.domainmodels.LoanProductModel;
import com.actualize.mortgage.domainmodels.LoanTerms;
import com.actualize.mortgage.domainmodels.LoanTermsPrepaymentPenalty;
import com.actualize.mortgage.domainmodels.LoanTermsTemporaryBuydown;
import com.actualize.mortgage.domainmodels.LockModel;
import com.actualize.mortgage.domainmodels.MIDataDetailModel;
import com.actualize.mortgage.domainmodels.MaturityRuleModel;
import com.actualize.mortgage.domainmodels.NameModel;
import com.actualize.mortgage.domainmodels.NegativeAmortizationModel;
import com.actualize.mortgage.domainmodels.PartialPaymentModel;
import com.actualize.mortgage.domainmodels.PartialPaymentsModel;
import com.actualize.mortgage.domainmodels.PaymentModel;
import com.actualize.mortgage.domainmodels.PaymentRuleModel;
import com.actualize.mortgage.domainmodels.PaymentsModel;
import com.actualize.mortgage.domainmodels.PayoffsAndPayments;
import com.actualize.mortgage.domainmodels.Prepaids;
import com.actualize.mortgage.domainmodels.PrincipalAndInterestPaymentAdjustmentModel;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsDetails;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsEE;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsET;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsMI;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsPC;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsPI;
import com.actualize.mortgage.domainmodels.PropertyValuationDetailModel;
import com.actualize.mortgage.domainmodels.ProrationModel;
import com.actualize.mortgage.domainmodels.SalesContractDetailModel;
import com.actualize.mortgage.domainmodels.SummariesofTransactions;
import com.actualize.mortgage.domainmodels.SummariesofTransactionsDetailsBorrowerTransaction;
import com.actualize.mortgage.domainmodels.SummariesofTransactionsDetailsDueFromSellerAtClosing;
import com.actualize.mortgage.domainmodels.SummariesofTransactionsDetailsPaidByAlready;
import com.actualize.mortgage.domainmodels.SummariesofTransactionsDetailsSellerTransaction;
import com.actualize.mortgage.domainmodels.TermsOfLoanModel;
import com.actualize.mortgage.domainmodels.TransactionInformation;
import com.actualize.mortgage.utils.Convertor;


/**
 * 
 * @author sboragala
 *
 */
public class LoanEstimateConvertor {
	/**
	 * converts xml to JSON response
	 * @param document
	 * @return
	 * @throws Exception 
	 */
	public LoanEstimate convertXmltoJSON(MISMODocument mismodoc) throws Exception
	{
		LoanEstimate loanEstimateDocument = new LoanEstimate();
		Document document = null;
        NodeList nodes = mismodoc.getElementsAddNS("//DOCUMENT");
        if (nodes.getLength() > 0)
            document = new Document(Document.NS, (Element)nodes.item(0));
        
        Deal deal = new Deal(Deal.NS, (Element)document.getElementAddNS("DEAL_SETS/DEAL_SET/DEALS/DEAL"));

	        loanEstimateDocument.setLoanEstimateDocDetails(createClosingDisclosureDocumentDetails(document));
	        loanEstimateDocument.setTermsOfLoan(createTermsOfLoanModel(deal));
	    	loanEstimateDocument.setLoanDetail(createLoanDetailModel(deal));
	    	//loanEstimateDocument.setDocumentClassification(createDocumentClassificationModel(document));
        	loanEstimateDocument.setClosingInformation(createClosingInformation(deal));
        	loanEstimateDocument.setConstruction(createConstructionModel(deal));
        	loanEstimateDocument.setClosingInformationDetail(createClosingInformationDetail(deal));
	        loanEstimateDocument.setTransactionInformation(createTransactionInformation(deal));
	        loanEstimateDocument.setIntegratedDisclosureDetail(createIntegratedDisclosureDetail(deal));
	        loanEstimateDocument.setMiDataDetail(createMIDataDetailModel(deal));
	        loanEstimateDocument.setLoanInformation(createLoanInformation(deal));
	        loanEstimateDocument.setSalesContractDetail(createSalesContractDetailModel(deal));
	        loanEstimateDocument.setNegativeAmortization(createNegativeAmortizationModel(deal));
	        loanEstimateDocument.setInterestOnly(createInterestOnlyModel(deal));
	        loanEstimateDocument.setMaturityRule(createMaturityRuleModel(deal));
	        loanEstimateDocument.setLoanProduct(createLoanProductModel(deal));
	        loanEstimateDocument.setLoanTerms(createLoanTerms(deal));
	        loanEstimateDocument.setProjectedPayments(createProjectedPayments(deal));
	        loanEstimateDocument.setEtiaSection(createETIASection(deal));
	        //loanEstimateDocument.setCostsAtClosing(createCostsAtClosing(deal));
	        loanEstimateDocument.setClosingCostDetailsLoanCosts(createClosingCostDetailsLoanCosts(document));
	     	loanEstimateDocument.setClosingCostDetailsOtherCosts(createClosingCostOtherCosts(deal)); 
	     	loanEstimateDocument.setClosingCostsTotal(createClosingCostsTotal(deal));
	     	loanEstimateDocument.setCashToCloses(createCalculatingCashtoClose(deal));
	     	loanEstimateDocument.setPayoffsAndPayments(createPayoffsAndPayments(deal));
	     	loanEstimateDocument.setProrationsList(createProrationsModels(deal));
	     	loanEstimateDocument.setClosingAdjustmentItemList(createClosingAdjustmentModels(deal));
	     	loanEstimateDocument.setLiabilityList(createLiabilityModels(deal));
	     	loanEstimateDocument.setClosingCostFundList(createClosingCostFundModels(deal));
	     	loanEstimateDocument.setSummariesofTransactions(createSummariesofTransactions(deal));
	     	loanEstimateDocument.setInterestRateAdjustment(createInterestRateAdjustmentModel(deal)); //AIR Table
	     	loanEstimateDocument.setPrincipalAndInterestPaymentAdjustment(createPrincipalAndInterestPaymentAdjustmentModel(deal));
	     	loanEstimateDocument.setPayment(createPaymentModel(deal));
	     	loanEstimateDocument.setLateChargeRule(createLateChargeRuleModel(deal));
	     	loanEstimateDocument.setLoanCalculationsQualifiedMortgage(createLoanCalculationsQualifiedMortgage(deal));
	     	loanEstimateDocument.setContactInformation(createContactInformation(deal));
	     	
		
		return loanEstimateDocument;
	}
	
    /**
     * get all the details regarding the current document
     * @param mismodoc
     * @return LoanEstimateDocumentDetails
     */
    private LoanEstimateDocumentDetails createClosingDisclosureDocumentDetails(Document document) 
    {
    	LoanEstimateDocumentDetails loanEstimateDocumentDetails = new LoanEstimateDocumentDetails();
    	String type = "LoanEstimate";
		String formType = "";
		
		NodeList nodes = document.getElementsAddNS("//DOCUMENT");
        if (nodes.getLength() > 0)
            document = new Document(Document.NS, (Element)nodes.item(0));
        
        Deal deal = new Deal(Deal.NS, (Element)document.getElementAddNS("DEAL_SETS/DEAL_SET/DEALS/DEAL"));

        TermsOfLoan loanTerms = new TermsOfLoan((Element)deal.getElementAddNS("LOANS/LOAN/TERMS_OF_LOAN"));
        
        if("Purchase".equalsIgnoreCase(loanTerms.loanPurposeType))
        	formType = "Standard";
        else
        	formType = "AlternateForm";
        
    	if(null != document.documentClassification)
    	{
    		
	    	DocumentClassification docClassification = document.documentClassification;
	    	
	    	if(docClassification.documentClasses.documentClass.documentTypeOtherDescription.contains(":"))
    		{
    			type = docClassification.documentClasses.documentClass.documentTypeOtherDescription.split(":")[0];
    			formType = docClassification.documentClasses.documentClass.documentTypeOtherDescription.split(":")[1];
    		}
	        	
	      if(null != docClassification.documentClassificationDetail)
	      {
	    	  loanEstimateDocumentDetails.setDocumentFormIssuingEntityNameType(docClassification.documentClassificationDetail.documentFormIssuingEntityNameType);
	    	  loanEstimateDocumentDetails.setDocumentFormIssuingEntityVersionIdentifier(docClassification.documentClassificationDetail.documentFormIssuingEntityVersionIdentifier);
	    	  loanEstimateDocumentDetails.setDocumentSignatureRequiredIndicator(Boolean.parseBoolean(docClassification.documentClassificationDetail.other.documentSignatureRequiredIndicator));
	      }	
    	}
    	
    	loanEstimateDocumentDetails.setDocumentType(type);
    	loanEstimateDocumentDetails.setFormType(formType);
    	
    	
		return loanEstimateDocumentDetails;
    }
    
    
    /**
     * extracts ClosingInformation from xml and converts to JSON
     * @param mismodoc
     * @return closingInformationSection of PageOne
     */
    private ClosingInformationModel createClosingInformation(Deal deal)
    {
      String subjectProperty = "COLLATERALS/COLLATERAL/SUBJECT_PROPERTY";
      String propertyValuation = subjectProperty + "/PROPERTY_VALUATIONS/PROPERTY_VALUATION";
     
      PropertyValuationDetailModel propertyValuationDetailModel = new PropertyValuationDetailModel();
      ClosingInformationModel closingInformationSection = new ClosingInformationModel();
      IntegratedDisclosureDetail idDetail = new IntegratedDisclosureDetail((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_DETAIL"));
      Address propertyAddress = new Address((Element)deal.getElementAddNS(subjectProperty + "/ADDRESS"));
      PropertyDetail propertyDetail = new PropertyDetail((Element)deal.getElementAddNS(subjectProperty + "/PROPERTY_DETAIL"));
	  PropertyValuationDetail propertyValuationDetail = new PropertyValuationDetail((Element)deal.getElementAddNS(propertyValuation + "/PROPERTY_VALUATION_DETAIL"));
	 
      closingInformationSection.setDateIssued(idDetail.integratedDisclosureIssuedDate);
      closingInformationSection.setProperty(toAddressModel(propertyAddress));
        propertyValuationDetailModel.setAppraisalIdentifier(propertyValuationDetail.appraisalIdentifier);
      	propertyValuationDetailModel.setIdentifierOwnerURI(propertyValuationDetail.identifierOwnerURI);
      	propertyValuationDetailModel.setPropertyEstimatedValueAmount(propertyDetail.propertyEstimatedValueAmount);
      	propertyValuationDetailModel.setPropertyValuationAmount(propertyValuationDetail.propertyValuationAmount);
      	propertyValuationDetailModel.setPropertyValuationMethodType(propertyValuationDetail.propertyValuationMethodType);
      	propertyValuationDetailModel.setPropertyValuationMethodTypeOtherDescription(propertyValuationDetail.propertyValuationMethodTypeOtherDescription);
     	propertyValuationDetailModel.setPropertyValue(!"".equals(propertyDetail.propertyEstimatedValueAmount) ? "Estimated" : "Appraised");
      closingInformationSection.setPropertyValuationDetail(propertyValuationDetailModel);
      
        return closingInformationSection;
    }
    
    /**
     * converts SalesContractDetail to SalesContractDetailModel
     * @param deal
     * @return SalesContractDetailModel
     */
    private SalesContractDetailModel createSalesContractDetailModel(Deal deal)
    {
    	SalesContractDetailModel salesContractDetailModel = new SalesContractDetailModel();
    	
    	SalesContractDetail salesContractDetail = new SalesContractDetail((Element)deal.getElementAddNS("COLLATERALS/COLLATERAL/SUBJECT_PROPERTY/SALES_CONTRACTS/SALES_CONTRACT/SALES_CONTRACT_DETAIL"));
    	
    	salesContractDetailModel.setPersonalPropertyAmount(salesContractDetail.personalPropertyAmount);
      	salesContractDetailModel.setPersonalPropertyIndicator(Convertor.stringToBoolean(salesContractDetail.personalPropertyIncludedIndicator));
      	salesContractDetailModel.setRealPropertyAmount(salesContractDetail.realPropertyAmount);
      	salesContractDetailModel.setSaleContractAmount(salesContractDetail.salesContractAmount);
		return salesContractDetailModel;
    }
    
    /**
     * converts ClosingInformationDetail to ClosingInformationDetailModel
     * @param deal
     * @return ClosingInformationDetailModel
     */
    private ClosingInformationDetailModel createClosingInformationDetail(Deal deal) {
    	ClosingInformationDetailModel closingInformationDetailModel = new ClosingInformationDetailModel();
    	
    	ClosingInformationDetail closingInformationDetail = new ClosingInformationDetail((Element)deal.getElementAddNS("LOANS/LOAN/CLOSING_INFORMATION/CLOSING_INFORMATION_DETAIL"));
    	
    	closingInformationDetailModel.setCashFromBorrowerAtClosingAmount(closingInformationDetail.cashFromBorrowerAtClosingAmount);
    	closingInformationDetailModel.setCashFromSellerAtClosingAmount(closingInformationDetail.cashFromSellerAtClosingAmount);
    	closingInformationDetailModel.setCashToBorrowerAtClosingAmount(closingInformationDetail.cashToBorrowerAtClosingAmount);
    	closingInformationDetailModel.setCashToSellerAtClosingAmount(closingInformationDetail.cashToSellerAtClosingAmount);
    	closingInformationDetailModel.setClosingAgentOrderNumberIdentifier(closingInformationDetail.closingAgentOrderNumberIdentifier);
    	closingInformationDetailModel.setClosingDate(closingInformationDetail.closingDate);
    	closingInformationDetailModel.setClosingRateSetDate(closingInformationDetail.closingRateSetDate);
    	closingInformationDetailModel.setCurrentRateSetDate(closingInformationDetail.currentRateSetDate);
    	closingInformationDetailModel.setDisbursementDate(closingInformationDetail.disbursementDate);
    	closingInformationDetailModel.setDocumentOrderClassificationType(closingInformationDetail.documentOrderClassificationType);
    	
		return closingInformationDetailModel;
    	
	}
    
    /**
     * converts NegativeAmortization to NegativeAmortizationModel
     * @param deal
     * @return NegativeAmortizationModel
     */
    private NegativeAmortizationModel createNegativeAmortizationModel(Deal deal) {
    	NegativeAmortization negativeAmortization = new NegativeAmortization(null, (Element)deal.getElementAddNS("LOANS/LOAN/NEGATIVE_AMORTIZATION/NEGATIVE_AMORTIZATION_RULE"));
    	NegativeAmortizationModel negativeAmortizationModel = new NegativeAmortizationModel();
	    	negativeAmortizationModel.setNegativeAmortizationLimitMonthsCount(negativeAmortization.negativeAmortizationLimitMonthsCount);
	    	negativeAmortizationModel.setNegativeAmortizationMaximumLoanBalanceAmount(negativeAmortization.negativeAmortizationMaximumLoanBalanceAmount);
	    	negativeAmortizationModel.setNegativeAmortizationType(negativeAmortization.negativeAmortizationType);
    	
		return negativeAmortizationModel;
	}
    
    /**
     * converts InterestOnly to InterestOnlyModel
     * @param deal
     * @return InterestOnlyModel
     */
    private InterestOnlyModel createInterestOnlyModel(Deal deal) {
    	InterestOnlyModel interestOnlyModel = new InterestOnlyModel();
    	InterestOnly interestOnly = new InterestOnly((Element)deal.getElementAddNS("LOANS/LOAN/INTEREST_ONLY"));
    		interestOnlyModel.setInterestOnlyTermMonthsCount(interestOnly.interestOnlyTermMonthsCount);
		return interestOnlyModel;
	}

    /**
     * converts MaturityRule to MaturityRuleModel
     * @param deal
     * @return MaturityRuleModel
     */
    private MaturityRuleModel createMaturityRuleModel(Deal deal) {
    	MaturityRuleModel maturityRuleModel = new MaturityRuleModel();
    	MaturityRule maturityRule = new MaturityRule((Element)deal.getElementAddNS("LOANS/LOAN/MATURITY/MATURITY_RULE"));
    		maturityRuleModel.setLoanMaturityPeriodCount(maturityRule.loanMaturityPeriodCount);
    		maturityRuleModel.setLoanMaturityPeriodType(maturityRule.loanMaturityPeriodType);
    		maturityRuleModel.setLoanTermMaximumMonthsCount(maturityRule.loanTermMaximumMonthsCount);
    	
		return maturityRuleModel;
	}
    
    /**
     * converts LoanProduct to LoanProductModel
     * @param deal
     * @return LoanProductModel
     */
    private LoanProductModel createLoanProductModel(Deal deal) {
    	LoanProductModel loanProductModel = new LoanProductModel();
    	LockModel lockModel = new LockModel();
    	
    	LoanProduct loanProduct = new LoanProduct(null, (Element)deal.getElementAddNS("LOANS/LOAN/LOAN_PRODUCT"));
    	Lock lock = loanProduct.lock;
    	
    	loanProductModel.setLoanPriceQuoteInterestRatePercent(loanProduct.loanPriceQuoteInterestRatePercent);
    	
    	lockModel.setLockExpirationDatetime(lock.lockExpirationDatetime);
    	lockModel.setLockExpirationTimezoneType(lock.extension.other.lockExpirationTimezoneType);
    	lockModel.setLockStatusType(lock.lockStatusType);
    	
    	loanProductModel.setLock(lockModel);
    	
    	return loanProductModel;
	}

    /**
     * Creates Transaction Information from MISMODocument
     * @param deal
     * @return TransactionInformation
     */
    private TransactionInformation createTransactionInformation(Deal deal)
    {
    	TransactionInformation transactionInformation = new TransactionInformation();
        
    	String refinanceSameLenderIndicator = deal.getValueAddNS("LOANS/LOAN/REFINANCE/RefinanceSameLenderIndicator");
    	
		List borrowerParties = new LinkedList<Party>();
		List sellerParties = new LinkedList<Party>();
		List lenders = new LinkedList<Party>();
		
		Parties parties = new Parties((Element)deal.getElementAddNS("PARTIES"), null);
			
		if(parties.parties.length >0)
		for(int i=0;i<parties.parties.length; i++)
		{	
			if(null != parties.parties[i].roles.element)
			switch(parties.parties[i].roles.roles[0].roleDetail.PartyRoleType)
			{
				case "Borrower":
					borrowerParties.add(parties.parties[i]);
				break;
				case "NonTitleSpouse":
					borrowerParties.add(parties.parties[i]);
				break;
				case "TitleHolder":
					borrowerParties.add(parties.parties[i]);
				break;
				case "Other":
					borrowerParties.add(parties.parties[i]);
				break;
				case "NotePayTo":
					lenders.add(parties.parties[i]);
				break;
				case "PropertySeller":
					sellerParties.add(parties.parties[i]);
				break;
					
				}  		
		}
	
    	
    	transactionInformation.setBorrower(createBorrowers(borrowerParties));
    	transactionInformation.setSeller(createBorrowers(sellerParties));
    	transactionInformation.setLender(createBorrowers(lenders));
    	
    	
    	transactionInformation.setRefinanceSameLenderIndicator(Boolean.parseBoolean(refinanceSameLenderIndicator));
    	
		return transactionInformation;
    	
    }
    
    /**
     * Creates Loan Information from MISMODocument
     * @param mismodoc
     * @return
     */
    private LoanInformation createLoanInformation(Deal deal)
    {
    	LoanInformation loanInformationSection = new LoanInformation();

    	String loan = "LOANS/LOAN";
    	
        AmortizationRule amortization = new AmortizationRule((Element)deal.getElementAddNS(loan + "/AMORTIZATION/AMORTIZATION_RULE"));
        LoanIdentifiers loanidentifiers = new LoanIdentifiers((Element)deal.getElementAddNS(loan + "/LOAN_IDENTIFIERS"));
        Underwriting underwriting = new Underwriting(null, (Element)deal.getElementAddNS(loan+"/UNDERWRITING"));
        
        List<LoanInformationLoanIdentifier> loanInformationLoanIdentifiers = new LinkedList<>();
        List<AutomatedUnderwritingsModel> automatedUnderwritingsModelList = new LinkedList<>();
        
        if(underwriting.automatedUnderwritings.automatedUnderwriting.length >0)
        {
        	for(int i=0; i<underwriting.automatedUnderwritings.automatedUnderwriting.length;i++)
     	    {
        		AutomatedUnderwritingsModel automatedUnderwritingsModel = new AutomatedUnderwritingsModel();
        			automatedUnderwritingsModel.setAutomatedUnderwritingCaseIdentifier(underwriting.automatedUnderwritings.automatedUnderwriting[i].automatedUnderwritingCaseIdentifier);
        			automatedUnderwritingsModel.setAutomatedUnderwritingSystemType(underwriting.automatedUnderwritings.automatedUnderwriting[i].automatedUnderwritingSystemType);
        			automatedUnderwritingsModel.setAutomatedUnderwritingSystemTypeOtherDescription(underwriting.automatedUnderwritings.automatedUnderwriting[i].automatedUnderwritingSystemTypeOtherDescription);
        		automatedUnderwritingsModelList.add(automatedUnderwritingsModel);
     	    }
        }
        
        if(loanidentifiers.loanIdentifieries.length>0)
        for(int i=0; i<loanidentifiers.loanIdentifieries.length;i++)
 	    {
        	LoanInformationLoanIdentifier loanInformationLoanIdentifier = new LoanInformationLoanIdentifier();
 	  			loanInformationLoanIdentifier.setLoanIdentifier(loanidentifiers.loanIdentifieries[i].LoanIdentifier);
 	  			loanInformationLoanIdentifier.setLoanIdentifierType(loanidentifiers.loanIdentifieries[i].LoanIdentifierType);
 	  		loanInformationLoanIdentifiers.add(loanInformationLoanIdentifier);
 	  	}
 	  	
 	    loanInformationSection.setLoanIdentifiers(loanInformationLoanIdentifiers);
 	    loanInformationSection.setAmortizationType(amortization.AmortizationType);
 	    loanInformationSection.setAutomatedUnderwritings(automatedUnderwritingsModelList);
 	    loanInformationSection.setLoanManualUnderwritingIndicator(Boolean.parseBoolean(underwriting.underwritingDetail.loanManualUnderwritingIndicator));

 	    return loanInformationSection;
    }
    
    /**
     * converts construction to ConstructionModel
     * @param deal
     * @return ConstructionModel
     */
    private ConstructionModel createConstructionModel(Deal deal)
    {
    	ConstructionModel constructionModel = new ConstructionModel();
    	Construction construction = new Construction((Element)deal.getElementAddNS("LOANS/LOAN/CONSTRUCTION"));
    		constructionModel.setConstructionLoanTotalTermMonthsCount(construction.constructionLoanTotalTermMonthsCount);
    		constructionModel.setConstructionLoanType(construction.constructionLoanType);
    		constructionModel.setConstructionPeriodNumberOfMonthsCount(construction.constructionPeriodNumberOfMonthsCount);
    	
		return constructionModel;
    }
    
    /**
     * converts miDataDetail to MIDataDetailModel
     * @param deal
     * @return MIDataDetailModel
     */
    private MIDataDetailModel createMIDataDetailModel(Deal deal)
    {
    	MIDataDetailModel miDataDetailModel = new MIDataDetailModel();
    	MIDataDetail miDataDetail = new MIDataDetail((Element)deal.getElementAddNS("LOANS/LOAN/MI_DATA/MI_DATA_DETAIL"));
    		miDataDetailModel.setMiCertificateIdentifier(miDataDetail.miCertificateIdentifier);
    		miDataDetailModel.setMiCompanyNameType(miDataDetail.miCompanyNameType);
    		miDataDetailModel.setMiCompanyNameTypeOtherDescription(miDataDetail.miCompanyNameTypeOtherDescription);
    		miDataDetailModel.setMiInitialPremiumAmount(miDataDetail.miInitialPremiumAmount);
    		miDataDetailModel.setMiScheduledTerminationDate(miDataDetail.miScheduledTerminationDate);
    	
		return miDataDetailModel;
    	
    }
    
    /**
     * Creates Loan Terms Section from MISMODocument
     * @param mismodoc
     * @return
     */
    private LoanTerms createLoanTerms(Deal deal)
    {
    	LoanTerms loanTerms = new LoanTerms();
    	LoanTermsPrepaymentPenalty loanTermsPrepaymentPenalty = new LoanTermsPrepaymentPenalty();
    	LoanTermsTemporaryBuydown loanTermsTemporaryBuydown = new LoanTermsTemporaryBuydown();

	    String loan = "LOANS/LOAN";
    
        BuydownRule buydownRule = new BuydownRule((Element)deal.getElementAddNS(loan + "/BUYDOWN/BUYDOWN_RULE"));
        BuydownOccurence buydownOccurence = new BuydownOccurence((Element)deal.getElementAddNS(loan + "/BUYDOWN/BUYDOWN_OCCURRENCES/BUYDOWN_OCCURRENCE"));
        Other other = buydownRule.extension.other;
        PrepaymentPenaltyLifetimeRule prepaymentPenaltyLifetimeRule = new PrepaymentPenaltyLifetimeRule((Element)deal.getElementAddNS(loan + "/PREPAYMENT_PENALTY/PREPAYMENT_PENALTY_LIFETIME_RULE"));
  
		//loanTermsPrepaymentPenalty
		loanTermsPrepaymentPenalty.setPrepaymentPenaltyMaximumLifeOfLoanAmount(prepaymentPenaltyLifetimeRule.prepaymentPenaltyMaximumLifeOfLoanAmount);
		loanTermsPrepaymentPenalty.setPrepaymentPenaltyExpirationMonthsCount(prepaymentPenaltyLifetimeRule.prepaymentPenaltyExpirationMonthsCount);	
		
		//TemporaryBuydown
		loanTermsTemporaryBuydown.setGseBuydownReflectedInNoteIndicator(Convertor.stringToBoolean(other.buydownReflectedInNoteIndicator));
        loanTermsTemporaryBuydown.setBuydownInitialEffectiveInterestRatePercent(buydownOccurence.buydownInitialEffectiveInterestRatePercent);
        loanTermsTemporaryBuydown.setBuydownChangeFrequencyMonthsCount(buydownRule.buydownChangeFrequencyMonthsCount);
        loanTermsTemporaryBuydown.setBuydownIncreaseRatePercent(buydownRule.buydownIncreaseRatePercent);
        loanTermsTemporaryBuydown.setBuydownDurationMonthsCount(buydownRule.buydownDurationMonthsCount);
		
 	    loanTerms.setLoanTermsTemporaryBuydown(loanTermsTemporaryBuydown);
 	    loanTerms.setLoanTermsPrepaymentPenalty(loanTermsPrepaymentPenalty);
 	    
    	return loanTerms;
    }
    
    /**
     * creates ETIA section in response
     * @param deal
     * @return ETIASection
     */
  	private ETIASection createETIASection(Deal deal)
  	{
  		ETIASection etiaSection = new ETIASection();
  		List<String> escrowTypes = new LinkedList<>();
  		EstimatedPropertyCostComponents estimatedPropertyCostComponents = new EstimatedPropertyCostComponents((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/ESTIMATED_PROPERTY_COST/ESTIMATED_PROPERTY_COST_COMPONENTS"));
  		
  		String projectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount = deal.getValueAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/ESTIMATED_PROPERTY_COST/ESTIMATED_PROPERTY_COST_DETAIL/ProjectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount");
  		
  		List<ETIA>  eTIAs = new LinkedList<>();
  		
  		for(int i=0; i<estimatedPropertyCostComponents.estimatedPropertyCostComponent.length; i++){
  			if("Other".equalsIgnoreCase(estimatedPropertyCostComponents.estimatedPropertyCostComponent[i].projectedPaymentEstimatedTaxesInsuranceAssessmentComponentType) && !"".equalsIgnoreCase(estimatedPropertyCostComponents.estimatedPropertyCostComponent[i].projectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription))
  				escrowTypes.add(estimatedPropertyCostComponents.estimatedPropertyCostComponent[i].projectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription);
  			else
  				escrowTypes.add(estimatedPropertyCostComponents.estimatedPropertyCostComponent[i].projectedPaymentEstimatedTaxesInsuranceAssessmentComponentType);
  			
  			ETIA  eTIA = new ETIA();
  			eTIA.setProjectedPaymentEscrowedType(estimatedPropertyCostComponents.estimatedPropertyCostComponent[i].projectedPaymentEscrowedType);
  			eTIA.setProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType(estimatedPropertyCostComponents.estimatedPropertyCostComponent[i].projectedPaymentEstimatedTaxesInsuranceAssessmentComponentType);
  			eTIA.setProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription(estimatedPropertyCostComponents.estimatedPropertyCostComponent[i].projectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription);
  			eTIAs.add(eTIA);
  		}
  		
  		etiaSection.setDisplayLabel(estimatedPropertyCostComponents.displayLabel);
  		etiaSection.setEtiaValues(eTIAs);
		etiaSection.setProjectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount(projectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount);
  		etiaSection.setEscrowTypes(escrowTypes);
  		
  		return etiaSection;
  	}
  	
    /**
	 * calculates all the projected payments elements
	 * @param deal
	 * @return ProjectedPaymentsDetails
	 */
	private ProjectedPaymentsDetails createProjectedPayments(Deal deal)
	{
		ProjectedPayments payments = new ProjectedPayments((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/PROJECTED_PAYMENTS"));	
		LoanDetail loanDetail = new LoanDetail((Element)deal.getElementAddNS("LOANS/LOAN/LOAN_DETAIL"));
		InterestOnly interestOnly = new InterestOnly((Element)deal.getElementAddNS("LOANS/LOAN/INTEREST_ONLY"));
		
		ProjectedPaymentsDetails projectedPayments = new ProjectedPaymentsDetails();

		String monthscount  = interestOnly.interestOnlyTermMonthsCount;
		
		List<ProjectedPaymentsPC>  paymentCalculationList = new LinkedList<>();
		List<ProjectedPaymentsPI>  principalInterestList = new LinkedList<>();
		List<ProjectedPaymentsMI>  mortgageInsuranceList = new LinkedList<>();
		List<ProjectedPaymentsEE>  estimatedEscrowList = new LinkedList<>();
		List<ProjectedPaymentsET>  estimatedTotalList = new LinkedList<>();
		
		int interestOnlyTermMonthsCount = 0;
			if(null != monthscount && !"".equalsIgnoreCase(monthscount)){
				interestOnlyTermMonthsCount = Integer.parseInt(monthscount);
			}
			
		for (int i = 0; i < payments.projectedPayments.length && i < 4; i++) {
			
			ProjectedPayment payment = payments.projectedPayments[i];
			
			projectedPayments.setPaymentFrequencyType(payment.paymentFrequencyType);
			
			ProjectedPaymentsPC paymentCalculation = new ProjectedPaymentsPC();
			ProjectedPaymentsPI principalInterest = new ProjectedPaymentsPI();
			ProjectedPaymentsMI mortgageInsurance = new ProjectedPaymentsMI();
			ProjectedPaymentsEE estimatedEscrow = new ProjectedPaymentsEE();
			ProjectedPaymentsET estimatedTotal = new ProjectedPaymentsET();
			
			paymentCalculation.setProjectedPaymentCalculationPeriodEndNumber(payment.projectedPaymentCalculationPeriodEndNumber);
			paymentCalculation.setProjectedPaymentCalculationPeriodStartNumber(payment.projectedPaymentCalculationPeriodStartNumber);
			paymentCalculation.setProjectedPaymentCalculationPeriodTermType(payment.projectedPaymentCalculationPeriodTermType);
			paymentCalculation.setProjectedPaymentCalculationPeriodTermTypeOtherDescription(payment.projectedPaymentCalculationPeriodTermTypeOtherDescription);
			paymentCalculation.setSequenceNumber(payment.sequenceNumber);
		
			int startYear = 0;
			if(null != payment.projectedPaymentCalculationPeriodStartNumber && !payment.projectedPaymentCalculationPeriodStartNumber.isEmpty())
				startYear = Integer.parseInt(payment.projectedPaymentCalculationPeriodStartNumber);
			if ((startYear-1)*12 < interestOnlyTermMonthsCount && "true".equalsIgnoreCase(loanDetail.interestOnlyIndicator))
				principalInterest.setInterestOnlyStatus(true);
			else
				principalInterest.setInterestOnlyStatus(false);
			principalInterest.setProjectedPaymentPrincipalAndInterestMaximumPaymentAmount(payment.projectedPaymentPrincipalAndInterestMaximumPaymentAmount);
			principalInterest.setProjectedPaymentPrincipalAndInterestMinimumPaymentAmount(payment.projectedPaymentPrincipalAndInterestMinimumPaymentAmount);
				
			mortgageInsurance.setProjectedPaymentMIPaymentAmount(payment.projectedPaymentMIPaymentAmount);
			
			estimatedEscrow.setProjectedPaymentEstimatedEscrowPaymentAmount(payment.projectedPaymentEstimatedEscrowPaymentAmount);
			
			estimatedTotal.setProjectedPaymentEstimatedTotalMaximumPaymentAmount(payment.projectedPaymentEstimatedTotalMaximumPaymentAmount);
			estimatedTotal.setProjectedPaymentEstimatedTotalMinimumPaymentAmount(payment.projectedPaymentEstimatedTotalMinimumPaymentAmount);
			
			paymentCalculationList.add(paymentCalculation);
			principalInterestList.add(principalInterest);
			mortgageInsuranceList.add(mortgageInsurance);
			estimatedEscrowList.add(estimatedEscrow);
			estimatedTotalList.add(estimatedTotal);
				
		}
		
		projectedPayments.setEstimatedEscrow(estimatedEscrowList);
		projectedPayments.setEstimatedTotal(estimatedTotalList);
		projectedPayments.setMortgageInsurance(mortgageInsuranceList);
		projectedPayments.setPaymentCalculation(paymentCalculationList);
		projectedPayments.setPrincipalInterest(principalInterestList);
		projectedPayments.setMiMonthsDuration("");
		
		return projectedPayments;
	}
	
	/**
	 * creates CostsAtClosing UI response
	 * @param deal
	 * @return CostsAtClosing
	 */
	private CostsAtClosing createCostsAtClosing(Deal deal)
	{
		String idSummary = "LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_SECTION_SUMMARIES/INTEGRATED_DISCLOSURE_SECTION_SUMMARY";
		String idDetail = idSummary + "/INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL";
		String ciDetail = "LOANS/LOAN/CLOSING_INFORMATION/CLOSING_INFORMATION_DETAIL";
		String lenderCredits;
		
		DocumentClass documentClass = new DocumentClass((Element)deal.getElementAddNS("../../../../DOCUMENT_CLASSIFICATION/DOCUMENT_CLASSES/DOCUMENT_CLASS[DocumentType='Other']"));
		CostsAtClosingClosingCosts costsAtClosingClosingCosts = new CostsAtClosingClosingCosts();
		CostsAtClosingCashToClose costsAtClosingCashToClose = new CostsAtClosingCashToClose(); 
		ClosingInformationDetail closingDetail = new ClosingInformationDetail((Element)deal.getElementAddNS(ciDetail));
		IntegratedDisclosureSectionSummaryDetail idClosingDetail = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idDetail + "[IntegratedDisclosureSectionType='TotalClosingCosts'][IntegratedDisclosureSubsectionType='ClosingCostsSubtotal']"));
		IntegratedDisclosureSectionSummaryDetail totalLoanCosts = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idDetail + "[IntegratedDisclosureSectionType='TotalLoanCosts']"));
		IntegratedDisclosureSubsectionPayment idLenderCredits = new IntegratedDisclosureSubsectionPayment((Element)deal.getElementAddNS(idSummary + "[INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL/IntegratedDisclosureSubsectionType='LenderCredits']/INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENTS/INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENT"));

		if (idLenderCredits.integratedDisclosureSubsectionPaymentAmount.equals("")) {
			IntegratedDisclosureSectionSummaryDetail idLenderCreditTwo = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idDetail + "[IntegratedDisclosureSubsectionType='LenderCredits']"));
			lenderCredits = idLenderCreditTwo.integratedDisclosureSubsectionTotalAmount;
			costsAtClosingClosingCosts.setIntegratedDisclosureSubsectionTotalAmount(idLenderCreditTwo.integratedDisclosureSubsectionTotalAmount);
		} else
		{
			lenderCredits = idLenderCredits.integratedDisclosureSubsectionPaymentAmount;
			costsAtClosingClosingCosts.setIntegratedDisclosureSubsectionPaymentAmount(idLenderCredits.integratedDisclosureSubsectionPaymentAmount);
		}
		
			costsAtClosingClosingCosts.setAmount(idClosingDetail.integratedDisclosureSectionTotalAmount);
			costsAtClosingClosingCosts.setLenderCredits(lenderCredits);
			costsAtClosingClosingCosts.setTotalLoanCosts(totalLoanCosts.integratedDisclosureSectionTotalAmount);
			costsAtClosingCashToClose.setAmount(closingDetail.cashFromBorrowerAtClosingAmount.equals("") ? closingDetail.cashToBorrowerAtClosingAmount : closingDetail.cashFromBorrowerAtClosingAmount);
			costsAtClosingCashToClose.setCashFromBorrowerAtClosingAmount(closingDetail.cashFromBorrowerAtClosingAmount);
			costsAtClosingCashToClose.setCashToBorrowerAtClosingAmount(closingDetail.cashToBorrowerAtClosingAmount);
		
		if("ClosingDisclosure:AlternateForm".equalsIgnoreCase(documentClass.documentTypeOtherDescription)){
			costsAtClosingCashToClose.setFromType("".equals(closingDetail.cashFromBorrowerAtClosingAmount.trim()) ? false : true);
        }
		
		CostsAtClosing costsAtClosing = new CostsAtClosing();
		costsAtClosing.setCostsAtClosingClosingCosts(costsAtClosingClosingCosts);
		costsAtClosing.setCostsAtClosingCashToClose(costsAtClosingCashToClose);
		return costsAtClosing;
	}
	
	/**
	 * create ClosingCostDetailsLoanCosts UI response
	 * @param deal
	 * @return
	 */
	private ClosingCostDetailsLoanCosts createClosingCostDetailsLoanCosts(Document document)
	{
		String loan = "LOANS/LOAN";
		String idSummary = "LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_SECTION_SUMMARIES/INTEGRATED_DISCLOSURE_SECTION_SUMMARY";
		String idDetail = idSummary + "/INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL";
		ClosingCostProperties loanDiscountPoints = null;
		String type = "";
		
		ClosingCostDetailsLoanCosts closingCostDetailsLoanCosts = new ClosingCostDetailsLoanCosts();
		List<ClosingCostProperties> originationChargeList = new LinkedList<>();
		List<ClosingCostProperties> sbDidNotShopFors = new LinkedList<>();
		List<ClosingCostProperties> sbDidShopFors = new LinkedList<>();
		PaymentsModel tlCosts = new PaymentsModel();
		
		Deal deal = new Deal(Deal.NS, (Element)document.getElementAddNS("DEAL_SETS/DEAL_SET/DEALS/DEAL"));
		
		IntegratedDisclosureSectionSummaries integratedDisclosureSectionSummaries = new IntegratedDisclosureSectionSummaries((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_SECTION_SUMMARIES"));
		IntegratedDisclosureSectionSummaryDetail totalLoanCosts = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idDetail + "[IntegratedDisclosureSectionType='TotalLoanCosts']"));
		IntegratedDisclosureSectionSummaryDetail idOraganisationCharges = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idDetail + "[IntegratedDisclosureSectionType='OriginationCharges']"));
		IntegratedDisclosureSectionSummaryDetail idServicesBorrowerDidNotShopFor = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idDetail + "[IntegratedDisclosureSectionType='ServicesYouCannotShopFor']"));
		IntegratedDisclosureSectionSummaryDetail idServicesBorrowerDidShopFor = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idDetail + "[IntegratedDisclosureSectionType='ServicesYouCanShopFor']"));
		Fees fees = new Fees((Element)deal.getElementAddNS(loan + "/FEE_INFORMATION/FEES"));

		if(null != document.documentClassification)
    	{
    		DocumentClassification docClassification = new DocumentClassification(Document.NS, (Element)document.getElementAddNS("DOCUMENT_CLASSIFICATION"));
    		if(docClassification.documentClasses.documentClass.documentTypeOtherDescription.contains(":"))
    		{
    			type = docClassification.documentClasses.documentClass.documentTypeOtherDescription.split(":")[0];
    		}
    	}
		
		if("ClosingDisclosure".equalsIgnoreCase(type))
		{
			 idServicesBorrowerDidNotShopFor = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idDetail + "[IntegratedDisclosureSectionType='ServicesBorrowerDidNotShopFor']"));
			 idServicesBorrowerDidShopFor = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idDetail + "[IntegratedDisclosureSectionType='ServicesBorrowerDidShopFor']"));
		}
		
		closingCostDetailsLoanCosts.setOcTotalAmount(idOraganisationCharges.integratedDisclosureSectionTotalAmount);
		closingCostDetailsLoanCosts.setSbDidNotShopTotalAmount(idServicesBorrowerDidNotShopFor.integratedDisclosureSectionTotalAmount);
		closingCostDetailsLoanCosts.setSbDidShopTotalAmount(idServicesBorrowerDidShopFor.integratedDisclosureSectionTotalAmount);
		closingCostDetailsLoanCosts.setTlCostsTotalAmount(totalLoanCosts.integratedDisclosureSectionTotalAmount);
		tlCosts = calculateTLCosts(totalLoanCosts, integratedDisclosureSectionSummaries);
		
		if(null != fees.fees && fees.fees.length>0)
		for(Fee fee : fees.fees)
		{
			if("OriginationCharges".equalsIgnoreCase(fee.feeDetail.integratedDisclosureSectionType))
			{
				ClosingCostProperties closingCostProperties = new ClosingCostProperties();
					closingCostProperties = loanCostsTable(fee,"OriginationCharges");
					if(null != closingCostProperties.getFeeType() && !"LoanDiscountPoints".equalsIgnoreCase(closingCostProperties.getFeeType()))
						originationChargeList.add(closingCostProperties);
					else if("LoanDiscountPoints".equalsIgnoreCase(closingCostProperties.getFeeType()))
						loanDiscountPoints = closingCostProperties;
			}
			else if("ServicesYouCannotShopFor".equalsIgnoreCase(fee.feeDetail.integratedDisclosureSectionType))
			{
				ClosingCostProperties closingCostProperties = new ClosingCostProperties();
					closingCostProperties = loanCostsTable(fee,"ServicesYouCannotShopFor");
					if(null != closingCostProperties.getFeeType())
						sbDidNotShopFors.add(closingCostProperties);
			}
			else if("ServicesYouCanShopFor".equalsIgnoreCase(fee.feeDetail.integratedDisclosureSectionType))
			{
				ClosingCostProperties closingCostProperties = new ClosingCostProperties();
					closingCostProperties = loanCostsTable(fee,"ServicesYouCanShopFor");
					if(null != closingCostProperties.getFeeType())
						sbDidShopFors.add(closingCostProperties);
			}
			else if("ServicesBorrowerDidNotShopFor".equalsIgnoreCase(fee.feeDetail.integratedDisclosureSectionType))
			{
				ClosingCostProperties closingCostProperties = new ClosingCostProperties();
					closingCostProperties = loanCostsTable(fee,"ServicesYouCannotShopFor");
					if(null != closingCostProperties.getFeeType())
						sbDidNotShopFors.add(closingCostProperties);
			}
			else if("ServicesBorrowerDidShopFor".equalsIgnoreCase(fee.feeDetail.integratedDisclosureSectionType))
			{
				ClosingCostProperties closingCostProperties = new ClosingCostProperties();
					closingCostProperties = loanCostsTable(fee,"ServicesYouCanShopFor");
					if(null != closingCostProperties.getFeeType())
						sbDidShopFors.add(closingCostProperties);
			}
		}
		
		Collections.sort(originationChargeList,new Comparator<ClosingCostProperties>(){
			@Override
			public int compare(ClosingCostProperties o1, ClosingCostProperties o2) {
				return o1.getFeeType().compareTo(o2.getFeeType());
			}
		});
		
		if(null != loanDiscountPoints)
			originationChargeList.add(0, loanDiscountPoints);
		
		Collections.sort(sbDidNotShopFors,new Comparator<ClosingCostProperties>(){
			@Override
			public int compare(ClosingCostProperties o1, ClosingCostProperties o2) {
				return o1.getFeeType().compareTo(o2.getFeeType());
			}
		});
		
		Collections.sort(sbDidShopFors,new Comparator<ClosingCostProperties>(){
			@Override
			public int compare(ClosingCostProperties o1, ClosingCostProperties o2) {
				return o1.getFeeType().compareTo(o2.getFeeType());
			}
		});
		
		closingCostDetailsLoanCosts.setOriginationCharges(originationChargeList);
		closingCostDetailsLoanCosts.setSbDidNotShopFors(sbDidNotShopFors);
		closingCostDetailsLoanCosts.setSbDidShopFors(sbDidShopFors);
		closingCostDetailsLoanCosts.setTlCosts(tlCosts);
		
		return closingCostDetailsLoanCosts;
	}
		
	/**
     * create ClosingCostDetailsOtherCosts UI response
     * @param deal
     * @return ClosingCostDetailsOtherCosts
     */
    private ClosingCostDetailsOtherCosts createClosingCostOtherCosts(Deal deal)
    {
    	String loan = "LOANS/LOAN";
		String idSummaryBase = loan + "/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_SECTION_SUMMARIES/";
    			
    	ClosingCostDetailsOtherCosts closingCostDetailsOtherCosts = new ClosingCostDetailsOtherCosts();
    	PaymentsModel totalOtherCosts = new PaymentsModel();
    	
    	List<ClosingCostProperties> tOGovtFeesList = new ArrayList<>();
		List<Prepaids> prepaidsList = new LinkedList<>();
		List<EscrowItemModel> escrowItemsList = new LinkedList<>();
		List<ClosingCostProperties> otherCostsList = new LinkedList<>();
		
		IntegratedDisclosureSectionSummaries idSectionSummaries = new IntegratedDisclosureSectionSummaries((Element)deal.getElementAddNS(idSummaryBase));
		Fees taxesAndOtherGovernmentFees = new Fees((Element)deal.getElementAddNS("LOANS/LOAN/FEE_INFORMATION/FEES"),"[FEE_DETAIL/IntegratedDisclosureSectionType = 'TaxesAndOtherGovernmentFees']");
    	Fees otherFees = new Fees((Element)deal.getElementAddNS("LOANS/LOAN/FEE_INFORMATION/FEES"),"[FEE_DETAIL/IntegratedDisclosureSectionType = 'OtherCosts']");
    	EscrowItems escrowItems = new EscrowItems((Element)deal.getElementAddNS("LOANS/LOAN/ESCROW/ESCROW_ITEMS"));
    
    	for(int i=0; i<idSectionSummaries.integratedDisclosureSectionSummaries.length; i++)
    	{
    		if("OtherCosts".equalsIgnoreCase(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType))
    			closingCostDetailsOtherCosts.setOtherTotalAmount(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionTotalAmount);
    		else if("TaxesAndOtherGovernmentFees".equalsIgnoreCase(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType))
				closingCostDetailsOtherCosts.settOGovtFeesTotalAmount(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionTotalAmount);
    		else if("Prepaids".equalsIgnoreCase(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType))
				closingCostDetailsOtherCosts.setPrepaidsTotalAmount(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionTotalAmount);
    		else if("InitialEscrowPaymentAtClosing".equalsIgnoreCase(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType))
				closingCostDetailsOtherCosts.setEscrowItemsTotalAmount(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionTotalAmount);
    		else if("TotalOtherCosts".equalsIgnoreCase(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType))
				closingCostDetailsOtherCosts.setTotalOtherCostsTotalAmount(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionTotalAmount);
    	 if("OtherCostsSubtotal".equalsIgnoreCase(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSubsectionType))
    		{
    			IntegratedDisclosureSubsectionPayment[] integratedDisclosureSubsectionPayments = idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSubsectionPayments.integratedDisclosureSubsectionPayments;
    			for(int j=0; j< integratedDisclosureSubsectionPayments.length; j++)
    			{
    				String paidBy = integratedDisclosureSubsectionPayments[j].integratedDisclosureSubsectionPaidByType;
    				if("Buyer".equalsIgnoreCase(paidBy))
    				{
    					if("AtClosing".equalsIgnoreCase(integratedDisclosureSubsectionPayments[j].integratedDisclosureSubsectionPaymentTimingType))
    						totalOtherCosts.setBpAtClosing(integratedDisclosureSubsectionPayments[j].integratedDisclosureSubsectionPaymentAmount);
    					else if("BeforeClosing".equalsIgnoreCase(integratedDisclosureSubsectionPayments[j].integratedDisclosureSubsectionPaymentTimingType))
    						totalOtherCosts.setBpB4Closing(integratedDisclosureSubsectionPayments[j].integratedDisclosureSubsectionPaymentAmount);
    				}
    				else if("Seller".equalsIgnoreCase(paidBy))
    				{
    					if("AtClosing".equalsIgnoreCase(integratedDisclosureSubsectionPayments[j].integratedDisclosureSubsectionPaymentTimingType))
    						totalOtherCosts.setSpAtClosing(integratedDisclosureSubsectionPayments[j].integratedDisclosureSubsectionPaymentAmount);
    					else if("BeforeClosing".equalsIgnoreCase(integratedDisclosureSubsectionPayments[j].integratedDisclosureSubsectionPaymentTimingType))
    						totalOtherCosts.setSpB4Closing(integratedDisclosureSubsectionPayments[j].integratedDisclosureSubsectionPaymentAmount);
    				}
    				else
    					totalOtherCosts.setPaidByOthers(integratedDisclosureSubsectionPayments[j].integratedDisclosureSubsectionPaymentAmount);
    					
    					if("Lender".equalsIgnoreCase(paidBy))
    						totalOtherCosts.setLenderStatus(true);
    					else
    						totalOtherCosts.setLenderStatus(false);
    			}
    		}
    	}
    	
    	for(Fee fee : taxesAndOtherGovernmentFees.fees)
			tOGovtFeesList.add(feeCostsTableRow(fee, fee.feeDetail.integratedDisclosureSectionType));
    	
    	PrepaidItems prepaidItems = new PrepaidItems((Element)deal.getElementAddNS("LOANS/LOAN/CLOSING_INFORMATION/PREPAID_ITEMS"));
    	
    	List<String> prepaidItemsToDisplay = new LinkedList<>();
			prepaidItemsToDisplay.add("HomeownersInsurancePremium");
			prepaidItemsToDisplay.add("MortgageInsurancePremium");
			prepaidItemsToDisplay.add("PrepaidInterest");
		
		Map<String,PrepaidItem> prepaidItemMap = new HashMap<>();
		for(PrepaidItem prepaidItem :prepaidItems.prepaidItems)
			if(null != prepaidItem.prepaidItemDetail.prepaidItemType || "".equals(prepaidItem.prepaidItemDetail.prepaidItemType))
				prepaidItemMap.put(prepaidItem.prepaidItemDetail.prepaidItemType, prepaidItem);
		
		for(String prepaidItem : prepaidItemsToDisplay)
			if(null != prepaidItemMap.get(prepaidItem))
				prepaidsList.add(setPrepaids(prepaidItemMap.get(prepaidItem), true));
		 
		for(PrepaidItem prepaidItem :prepaidItems.prepaidItems)
			if(checkOtherPrepaids(prepaidItem.prepaidItemDetail.prepaidItemType))
				prepaidsList.add(setPrepaids(prepaidItem, true));
			else if(isPropertyTax(prepaidItem.prepaidItemDetail.prepaidItemType))
			{
				Prepaids prepaid = setPrepaids(prepaidItem, true);
				prepaid.setDisplayLabel("Property Taxes");
				prepaidsList.add(prepaid);
			}	
		//populate ESCROWS
		if(null != escrowItems.escrowItems)
		{
			List<String> escrowItemsToDisplay = new LinkedList<>();
				escrowItemsToDisplay.add("HomeownersInsurance");
				escrowItemsToDisplay.add("MortgageInsurance");
			
			for(String escrow : escrowItemsToDisplay)
			{
				EscrowItem escrowItem = getEscrowItem(escrowItems, escrow);
				 if (null != escrowItem.element)
					 escrowItemsList.add(getEscrowModel(escrowItem));
			}
			
			for(int i=0; i<escrowItems.escrowItems.length;i++)
	 	    {
				if (("Property Tax").equalsIgnoreCase(escrowItems.escrowItems[i].escrowItemDetail.displayLabelText)) {
					escrowItemsList.add(getEscrowModel(escrowItems.escrowItems[i]));
					break;
				} 
				else if (isPropertyTax(escrowItems.escrowItems[i].escrowItemDetail.escrowItemType)) {
					EscrowItemModel iePatClosing = new EscrowItemModel();
						iePatClosing = getEscrowModel(escrowItems.escrowItems[i]);
						iePatClosing.setDisplayLabel("Property Taxes");
					escrowItemsList.add(iePatClosing);
				}
	 	    }
			
			for(int i=0; i<escrowItems.escrowItems.length;i++)
				if(checkOtherEscrows(escrowItems.escrowItems[i].escrowItemDetail.escrowItemType))
					escrowItemsList.add(getEscrowModel(escrowItems.escrowItems[i]));
		}
		
		//OtherFees
		for(int i=0;i<otherFees.fees.length;i++)
			if(!"".equals(otherFees.fees[i].feeDetail.feeType))
				otherCostsList.add(feeCostsTableRow(otherFees.fees[i], otherFees.fees[i].feeDetail.integratedDisclosureSectionType));
		 
		closingCostDetailsOtherCosts.settOGovtFeesList(tOGovtFeesList);
		closingCostDetailsOtherCosts.setPrepaidsList(prepaidsList);
		closingCostDetailsOtherCosts.setEscrowItemsList(escrowItemsList);
		closingCostDetailsOtherCosts.setOtherCostsList(otherCostsList);
		
		return closingCostDetailsOtherCosts;
    	
    }
    
    /**
     * creates closing costs total
     * @param deal
     * @return ClosingCostsTotal
     */
    private ClosingCostsTotal createClosingCostsTotal(Deal deal)
    {
    	String loan = "LOANS/LOAN";
		String idSummaryBase = loan + "/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_SECTION_SUMMARIES/INTEGRATED_DISCLOSURE_SECTION_SUMMARY";
		String idSummary = idSummaryBase + "/INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL";
		
    	ClosingCostsTotal closingCostsTotal = new ClosingCostsTotal();
    	PaymentsModel closingCostsSubtotal = new PaymentsModel();

    	IntegratedDisclosureSubsectionPayment idPayment = new IntegratedDisclosureSubsectionPayment((Element)deal.getElementAddNS(idSummaryBase + "[INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL/IntegratedDisclosureSubsectionType='ClosingCostsSubtotal']/INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENTS/INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENT"));
    	IntegratedDisclosureSectionSummary integratedDisclosureSectionSummary = new IntegratedDisclosureSectionSummary((Element)deal.getElementAddNS(idSummaryBase + "[INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL/IntegratedDisclosureSubsectionType='ClosingCostsSubtotal']"));
    	IntegratedDisclosureSectionSummaryDetail idLenderCreditTwo = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idSummary + "[IntegratedDisclosureSubsectionType='LenderCredits']"));
    	
    	closingCostsTotal.setTotalClosingCosts(idPayment.integratedDisclosureSubsectionPaymentAmount);
    	idPayment = new IntegratedDisclosureSubsectionPayment((Element)deal.getElementAddNS(idSummaryBase + "[INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL/IntegratedDisclosureSubsectionType='LenderCredits']/INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENTS/INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENT"));
    	
    	if (idPayment.integratedDisclosureSubsectionPaymentAmount.equals("")) 
			closingCostsTotal.setLenderCredits(idLenderCreditTwo.integratedDisclosureSubsectionTotalAmount);
    	else
			closingCostsTotal.setLenderCredits(idPayment.integratedDisclosureSubsectionPaymentAmount);
    	
    	IntegratedDisclosureSubsectionPayments integratedDisclosureSubsectionPayments = integratedDisclosureSectionSummary.integratedDisclosureSubsectionPayments;

    	if(integratedDisclosureSubsectionPayments.integratedDisclosureSubsectionPayments.length>0)
		for(IntegratedDisclosureSubsectionPayment integrateddisclosuresubsectionpayment : integratedDisclosureSubsectionPayments.integratedDisclosureSubsectionPayments)
		{
			if(("Buyer").equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaidByType))
			{
				if(("AtClosing").equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentTimingType))
					closingCostsSubtotal.setBpAtClosing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
				else
					closingCostsSubtotal.setBpB4Closing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
			}
			else if(("Seller").equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaidByType))
			{
				if(("AtClosing").equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentTimingType))
					closingCostsSubtotal.setSpAtClosing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
				else
					closingCostsSubtotal.setSpB4Closing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
			}
			else
				closingCostsSubtotal.setPaidByOthers(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
			if("Lender".equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaidByType))
				closingCostsSubtotal.setLenderStatus(true);
		}
	    
    	closingCostsTotal.setClosingCostsSubtotal(closingCostsSubtotal);
    	closingCostsTotal.setLenderCreditToleranceCureAmount(idLenderCreditTwo.lenderCreditToleranceCureAmount);
    	
		return closingCostsTotal;
    }
    
    /**
     * Creates createCalculatingCashtoClose UI response
     * @param document
     * @return CashToClose
     */
    public CashToClose createCalculatingCashtoClose(Deal deal) {

    	CashToClose cashToClose = new CashToClose();
    	List<CashToCloseModel> cashToCloseModelList = new LinkedList<>();
    	
    	CashToCloseItems cashToCloseItems = new CashToCloseItems((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/CASH_TO_CLOSE_ITEMS"));
    	
    	for (CashToCloseItem cashToCloseItem : cashToCloseItems.cashToCloseItems) {
			switch (cashToCloseItem.integratedDisclosureCashToCloseItemType) {
				case "LoanAmount":
					cashToClose.setLoanAmount(setCashToClose(cashToCloseItem));
					break;
				case "TotalClosingCosts":
					cashToClose.setTotalClosingCosts(setCashToClose(cashToCloseItem));
					break;
				case "ClosingCostsPaidBeforeClosing":
					cashToClose.setClosingCostsPaidBeforeClosing(setCashToClose(cashToCloseItem));
					break;
				case "ClosingCostsFinanced":
					cashToClose.setClosingCostsFinanced(setCashToClose(cashToCloseItem));
					break;
				case "DownPayment":
					cashToClose.setDownPayment(setCashToClose(cashToCloseItem));
					break;
				case "TotalPayoffsAndPayments":
					cashToClose.setTotalPayoffsAndPayments(setCashToClose(cashToCloseItem));
					break;
				case "Deposit":
					cashToClose.setDeposit(setCashToClose(cashToCloseItem));
					break;
				case "FundsForBorrower":
					cashToClose.setFundsForBorrower(setCashToClose(cashToCloseItem));
					break;
				case "SellerCredits":
					cashToClose.setSellerCredits(setCashToClose(cashToCloseItem));
					break;
				case "AdjustmentsAndOtherCredits":
					cashToClose.setAdjustmentsAndOtherCredits(setCashToClose(cashToCloseItem));
					break;
				case "CashToCloseTotal":
					cashToCloseModelList.add(setCashToClose(cashToCloseItem));
					break;
			}
		}
		
    	cashToClose.setCashToCloseTotal(cashToCloseModelList);
		
		return cashToClose;
	}
    
    /**
     * this methods creates SummariesofTransactions response
     * @param deal
     * @return SummariesofTransactions
     */
    private SummariesofTransactions createSummariesofTransactions(Deal deal)
    {
    	String adjustmentTypes ="FuelCosts,RelocationFunds,Repairs,SellersEscrowAssumption,SellersMortgageInsuranceAssumption,SweatEquity.TenantSecurityDeposit,TradeEquity,Other";
		String cityTaxFees   = "CityPropertyTax,DistrictPropertyTax,TownPropertyTax";
		String countyTaxFees = "BoroughPropertyTax,CountyPropertyTax";
		String assesmentFees = "CondominiumAssociationSpecialAssessment,CooperativeAssociationSpecialAssessment,HomeownersAssociationSpecialAssessment";
		String[] adjustmentFees	 = {"CondominiumAssociationDues","CooperativeAssociationDues","EarthquakeInsurancePremium","FloodInsurancePremium",
								"GroundRent","HailInsurancePremium","HazardInsurancePremium","HomeownersAssociationDues",
								"HomeownersInsurancePremium","InterestOnLoanAssumption","MortgageInsurancePremium","PastDuePropertyTax",
								"RentFromSubjectProperty","StatePropertyTax","Utilities","VolcanoInsurancePremium","WindAndStormInsurancePremium","Other"};
		String paidAlready   =  "ProceedsOfSubordinateLiens,SatisfactionOfSubordinateLien,";
		String liabilityFromSeller = "DelinquentTaxes,HELOC,TaxLien,Taxes,ThirdPositionMortgage,Other";
		String subjectProperty = "COLLATERALS/COLLATERAL/SUBJECT_PROPERTY";
        String salesContract = subjectProperty + "/SALES_CONTRACTS/SALES_CONTRACT";
        String idSummary = "LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_SECTION_SUMMARIES/";
        
    	SummariesofTransactions summariesofTransactions = new SummariesofTransactions();
    	SummariesofTransactionsDetailsDueFromSellerAtClosing dueFromSellerAtClosing = new  SummariesofTransactionsDetailsDueFromSellerAtClosing();
    	
    
    	IntegratedDisclosureSectionSummaries integratedDisclosureSectionSummaryList = new IntegratedDisclosureSectionSummaries((Element)deal.getElementAddNS(idSummary));
    	ClosingInformation closingInformation =  new ClosingInformation(null, (Element)deal.getElementAddNS("LOANS/LOAN/CLOSING_INFORMATION"));
    	ClosingInformationDetail closingInformationDetail = new ClosingInformationDetail((Element)deal.getElementAddNS("LOANS/LOAN/CLOSING_INFORMATION/CLOSING_INFORMATION_DETAIL"));
/*
    	List<ProrationModel> prorationsModels = createProrationsModels(deal);
		List<LiabilityModel> liabilityModels = createLiabilityModels(deal);
		*/
		List<ClosingCostFundModel> closingCostFundModels = createClosingCostFundModels(deal);
		/*
		summariesofTransactions.setLiabilityList(liabilityModels);
		summariesofTransactions.setProrationList(prorationsModels);
		summariesofTransactions.setClosingAdjustmentItemList(closingAdjustmentItemModels);
		summariesofTransactions.setClosingCostFundList(closingCostFundModels);*/
		
		//Due From Borrower AtClosing
		/*SummariesofTransactionsDetailsDueFromBorrowerAtClosing duefromBorroweratClosing = new SummariesofTransactionsDetailsDueFromBorrowerAtClosing();
		List<LiabilityModel> duefromBorroweratClosingList = new LinkedList<>();
		List<ClosingAdjustmentItemModel> duefromBorroweratClosingAdjustmentsList = new LinkedList<>();
		List<ProrationModel> paidBySellerInAdvance = new LinkedList<>();*/
		
		//Paid Already By
		SummariesofTransactionsDetailsPaidByAlready paidByAlready = new SummariesofTransactionsDetailsPaidByAlready();
		List<ClosingAdjustmentItemModel> closingAdjustmentItemModels = createClosingAdjustmentModels(deal);
		ClosingAdjustmentItemModel subordinateLien = new ClosingAdjustmentItemModel();
		for(ClosingAdjustmentItemModel closingAdjustmentItem : closingAdjustmentItemModels)
		{
			if("PaidAlreadyByOrOnBehalfOfBorrowerAtClosing".equalsIgnoreCase(closingAdjustmentItem.getIntegratedDisclosureSectionType()) 
					&& "SellerCredit".equalsIgnoreCase(closingAdjustmentItem.getClosingAdjustmentItemType()))
			{
				if(!"OtherCredits".equalsIgnoreCase(closingAdjustmentItem.getIntegratedDisclosureSubsectionType()) && !"OtherCredits".equalsIgnoreCase(closingAdjustmentItem.getIntegratedDisclosureSubsectionType()))
				{
					if (paidAlready.contains(closingAdjustmentItem.getClosingAdjustmentItemType()) && paidAlready.contains(closingAdjustmentItem.getClosingAdjustmentItemTypeOtherDescription()))
					{
						subordinateLien = closingAdjustmentItem;
					}
				}
			}
		}
		
		paidByAlready.setSubordinateLien(subordinateLien);
		//Calculations
		SummariesofTransactionsDetailsBorrowerTransaction borrowerTransaction = new SummariesofTransactionsDetailsBorrowerTransaction();
		SummariesofTransactionsDetailsSellerTransaction sellerTransaction = new SummariesofTransactionsDetailsSellerTransaction();
		
		//Borrower Transaction
		IntegratedDisclosureSectionSummaryModel dueFromBorrowerAtClosingSummaryModel = new IntegratedDisclosureSectionSummaryModel();
		IntegratedDisclosureSectionSummaryModel paidAlreadyByOrOnBehalfOfBorrowerAtClosingSummaryModel = new IntegratedDisclosureSectionSummaryModel();
		
		for(int i=0;i<integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries.length;i++)
			if("DueFromBorrowerAtClosing".equalsIgnoreCase(integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType))
				dueFromBorrowerAtClosingSummaryModel = toIntegratedDisclosureSectionSummaryModel(integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries[i]);
			else if("PaidAlreadyByOrOnBehalfOfBorrowerAtClosing".equalsIgnoreCase(integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType))
				paidAlreadyByOrOnBehalfOfBorrowerAtClosingSummaryModel = toIntegratedDisclosureSectionSummaryModel(integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries[i]);
		
		summariesofTransactions.setBorrowerTransaction(borrowerTransaction);

		if("".equals(dueFromBorrowerAtClosingSummaryModel.getIntegratedDisclosureSectionSummaryDetailModel().getIntegratedDisclosureSectionTotalAmount()))
			dueFromBorrowerAtClosingSummaryModel.getIntegratedDisclosureSectionSummaryDetailModel().setIntegratedDisclosureSectionTotalAmount("0");
		
		if("".equals(paidAlreadyByOrOnBehalfOfBorrowerAtClosingSummaryModel.getIntegratedDisclosureSectionSummaryDetailModel().getIntegratedDisclosureSectionTotalAmount()))
			paidAlreadyByOrOnBehalfOfBorrowerAtClosingSummaryModel.getIntegratedDisclosureSectionSummaryDetailModel().setIntegratedDisclosureSectionTotalAmount("0");
		
		borrowerTransaction.setDueFromBorrowerAtClosing(dueFromBorrowerAtClosingSummaryModel);
		borrowerTransaction.setPaidAlreadyByOrOnBehalfOfBorrowerAtClosing(paidAlreadyByOrOnBehalfOfBorrowerAtClosingSummaryModel);
		
		//seller transaction
		IntegratedDisclosureSectionSummaryModel dueFromSellerAtClosingSummaryModel = new IntegratedDisclosureSectionSummaryModel();
		IntegratedDisclosureSectionSummaryModel dueToSellerAtClosingSummaryModel = new IntegratedDisclosureSectionSummaryModel();
		
		for(int i=0;i<integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries.length;i++)
			if("DueFromSellerAtClosing".equalsIgnoreCase(integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType))
				dueFromSellerAtClosingSummaryModel = toIntegratedDisclosureSectionSummaryModel(integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries[i]); 
			else if("DueToSellerAtClosing".equalsIgnoreCase(integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType))
				dueToSellerAtClosingSummaryModel = toIntegratedDisclosureSectionSummaryModel(integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries[i]);
		
		if("".equals(dueFromSellerAtClosingSummaryModel.getIntegratedDisclosureSectionSummaryDetailModel().getIntegratedDisclosureSectionTotalAmount()))
			dueFromSellerAtClosingSummaryModel.getIntegratedDisclosureSectionSummaryDetailModel().setIntegratedDisclosureSectionTotalAmount("0");
		
		if("".equals(dueToSellerAtClosingSummaryModel.getIntegratedDisclosureSectionSummaryDetailModel().getIntegratedDisclosureSectionTotalAmount()))
			dueToSellerAtClosingSummaryModel.getIntegratedDisclosureSectionSummaryDetailModel().setIntegratedDisclosureSectionTotalAmount("0");
			
		sellerTransaction.setFromSellerAtClosing(dueFromSellerAtClosingSummaryModel);
		sellerTransaction.setToSellerAtClosing(dueToSellerAtClosingSummaryModel);
		
		summariesofTransactions.setDueFromSeller(dueFromSellerAtClosing);
		summariesofTransactions.setSellerTransaction(sellerTransaction);
		
		summariesofTransactions.setPaidByAlready(paidByAlready);
			
		return summariesofTransactions;
    }
    
    /**
     * creates response for PayoffsAndPayments 
     * @param deal
     * @return PayoffsAndPayments
     */
    private PayoffsAndPayments createPayoffsAndPayments(Deal deal)
    {
    	PayoffsAndPayments payoffsAndPayments = new PayoffsAndPayments();
    	IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
    	IntegratedDisclosureSectionSummaries integratedDisclosureSectionSummaryList = new IntegratedDisclosureSectionSummaries((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_SECTION_SUMMARIES/"));
    	
    	for(int i=0;i<integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries.length;i++)
			if("PayoffsAndPayments".equalsIgnoreCase(integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType))
				integratedDisclosureSectionSummaryModel = toIntegratedDisclosureSectionSummaryModel(integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries[i]);
    	
    	payoffsAndPayments.setIntegratedDisclosureSectionSummary(integratedDisclosureSectionSummaryModel);
    	
		return payoffsAndPayments;
    }
    
    /**
     * creates InterestRateAdjustmentModel from InterestRateAdjustment, response for air table
     * @param deal
     * @return InterestRateAdjustmentModel
     */
    private InterestRateAdjustmentModel createInterestRateAdjustmentModel(Deal deal) //AIR Table Response
    {
    	InterestRateAdjustmentModel interestRateAdjustmentModel = new InterestRateAdjustmentModel();
		
		InterestRateAdjustment interestRateAdjustment = new InterestRateAdjustment((Element)deal.getElementAddNS("LOANS/LOAN/ADJUSTMENT/INTEREST_RATE_ADJUSTMENT"));
		
		interestRateAdjustmentModel.setCeilingRatePercent(interestRateAdjustment.interestRateLifetimeAdjustmentRule.ceilingRatePercent);
		interestRateAdjustmentModel.setCeilingRatePercentEarliestEffectiveMonthsCount(interestRateAdjustment.interestRateLifetimeAdjustmentRule.ceilingRatePercentEarliestEffectiveMonthsCount);
		interestRateAdjustmentModel.setFirstRateChangeMonthsCount(interestRateAdjustment.interestRateLifetimeAdjustmentRule.firstRateChangeMonthsCount);
		interestRateAdjustmentModel.setFloorRatePercent(interestRateAdjustment.interestRateLifetimeAdjustmentRule.floorRatePercent);
		interestRateAdjustmentModel.setIndexType(interestRateAdjustment.indexRule.indexType);
		interestRateAdjustmentModel.setIndexTypeOtherDescription(interestRateAdjustment.indexRule.indexTypeOtherDescription);
		interestRateAdjustmentModel.setMarginRatePercent(interestRateAdjustment.interestRateLifetimeAdjustmentRule.marginRatePercent);
		interestRateAdjustmentModel.setTotalStepCount(interestRateAdjustment.interestRateLifetimeAdjustmentRule.other.totalStepCount);
		
		for(int i=0; i<interestRateAdjustment.interestRatePerChangeAdjustmentRulesList.interestRatePerChangeAdjustmentRules.length; i++)
		{
			InterestRatePerChangeAdjustmentRule interestRatePerChangeAdjustmentRule = interestRateAdjustment.interestRatePerChangeAdjustmentRulesList.interestRatePerChangeAdjustmentRules[i];
			if("First".equalsIgnoreCase(interestRatePerChangeAdjustmentRule.adjustmentRuleType))
			{
				interestRateAdjustmentModel.setFirstAdjustmentRule(interestRatePerChangeAdjustmentRule.adjustmentRuleType);
				interestRateAdjustmentModel.setFirstPerChangeMaximumIncreaseRatePercent(interestRatePerChangeAdjustmentRule.perChangeMaximumIncreaseRatePercent);
				interestRateAdjustmentModel.setFirstPerChangeRateAdjustmentFrequencyMonthsCount(interestRatePerChangeAdjustmentRule.perChangeRateAdjustmentFrequencyMonthsCount);
			}
			else if("Subsequent".equalsIgnoreCase(interestRatePerChangeAdjustmentRule.adjustmentRuleType))
			{
				interestRateAdjustmentModel.setSubsequentAdjustmentRule(interestRatePerChangeAdjustmentRule.adjustmentRuleType);
				interestRateAdjustmentModel.setSubsequentPerChangeMaximumIncreaseRatePercent(interestRatePerChangeAdjustmentRule.perChangeMaximumIncreaseRatePercent);
				interestRateAdjustmentModel.setSubsequentPerChangeRateAdjustmentFrequencyMonthsCount(interestRatePerChangeAdjustmentRule.perChangeRateAdjustmentFrequencyMonthsCount);
			}
		}
		return interestRateAdjustmentModel;
    }
    
    /**
     * creates PrincipalAndInterestPaymentAdjustmentModel from principalAndInterestPaymentAdjustment, response for AP table
     * @param deal
     * @return PrincipalAndInterestPaymentAdjustmentModel
     */
    private PrincipalAndInterestPaymentAdjustmentModel createPrincipalAndInterestPaymentAdjustmentModel(Deal deal)
    {
    	PrincipalAndInterestPaymentAdjustmentModel principalAndInterestPaymentAdjustmentModel = new PrincipalAndInterestPaymentAdjustmentModel();
    	PrincipalAndInterestPaymentAdjustment principalAndInterestPaymentAdjustment = new PrincipalAndInterestPaymentAdjustment((Element)deal.getElementAddNS("LOANS/LOAN/ADJUSTMENT/PRINCIPAL_AND_INTEREST_PAYMENT_ADJUSTMENT"));
    	
    	principalAndInterestPaymentAdjustmentModel.setFirstPrincipalAndInterestPaymentChangeMonthsCount(principalAndInterestPaymentAdjustment.principalAndInterestPaymentLifetimeAdjustmentRule.firstPrincipalAndInterestPaymentChangeMonthsCount);
    	principalAndInterestPaymentAdjustmentModel.setPrincipalAndInterestPaymentMaximumAmount(principalAndInterestPaymentAdjustment.principalAndInterestPaymentLifetimeAdjustmentRule.principalAndInterestPaymentMaximumAmount);
    	principalAndInterestPaymentAdjustmentModel.setPrincipalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount(principalAndInterestPaymentAdjustment.principalAndInterestPaymentLifetimeAdjustmentRule.principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount);
    	
    	PrincipalAndInterestPaymentPerChangeAdjustmentRule[] principalAndInterestPaymentPerChangeAdjustmentRule = principalAndInterestPaymentAdjustment.principalAndInterestPaymentPerChangeAdjustmentRules.principalAndInterestPaymentPerChangeAdjustmentRules;
    	
    	for(int i=0; i<principalAndInterestPaymentPerChangeAdjustmentRule.length; i++)
    	{
    		if("First".equalsIgnoreCase(principalAndInterestPaymentPerChangeAdjustmentRule[i].adjustmentRuleType))
    		{
	    		principalAndInterestPaymentAdjustmentModel.setFirstAdjustmentRuleType(principalAndInterestPaymentPerChangeAdjustmentRule[i].adjustmentRuleType);
	        	principalAndInterestPaymentAdjustmentModel.setFirstPerChangeMaximumPrincipalAndInterestPaymentAmount(principalAndInterestPaymentPerChangeAdjustmentRule[i].perChangeMaximumPrincipalAndInterestPaymentAmount);
	        	principalAndInterestPaymentAdjustmentModel.setFirstPerChangeMinimumPrincipalAndInterestPaymentAmount(principalAndInterestPaymentPerChangeAdjustmentRule[i].perChangeMinimumPrincipalAndInterestPaymentAmount);
	        	principalAndInterestPaymentAdjustmentModel.setFirstPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount(principalAndInterestPaymentPerChangeAdjustmentRule[i].perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount);
    		}
    		else if("Subsequent".equalsIgnoreCase(principalAndInterestPaymentPerChangeAdjustmentRule[i].adjustmentRuleType))
    		{
	        	principalAndInterestPaymentAdjustmentModel.setSubsequentAdjustmentRuleType(principalAndInterestPaymentPerChangeAdjustmentRule[i].adjustmentRuleType);
	        	principalAndInterestPaymentAdjustmentModel.setSubsequentPerChangeMaximumPrincipalAndInterestPaymentAmount(principalAndInterestPaymentPerChangeAdjustmentRule[i].perChangeMaximumPrincipalAndInterestPaymentAmount);
	        	principalAndInterestPaymentAdjustmentModel.setSubsequentPerChangeMinimumPrincipalAndInterestPaymentAmount(principalAndInterestPaymentPerChangeAdjustmentRule[i].perChangeMinimumPrincipalAndInterestPaymentAmount);
	        	principalAndInterestPaymentAdjustmentModel.setSubsequentPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount(principalAndInterestPaymentPerChangeAdjustmentRule[i].perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount);
    		}
    	}
    	
    	return principalAndInterestPaymentAdjustmentModel;
    	
    }
    
    /**
     * create PaymentModel in JSON response
     * @param deal
     * @return PaymentModel
     */
    private PaymentModel createPaymentModel(Deal deal)
    {
    	PaymentModel paymentModel = new PaymentModel();
    	PartialPaymentsModel partialPaymentsModel = new PartialPaymentsModel();
    	PaymentRuleModel paymentRuleModel = new PaymentRuleModel();
    	
    	Payment payment = new Payment(null, (Element)deal.getElementAddNS("LOANS/LOAN/PAYMENT"));
    	
    	List<PartialPaymentModel> partialPaymentsModels = new LinkedList<>();
    	
    	PartialPayment[] partialPayments = payment.partialPayments.partialPayments;
    	
    	for(int i=0; i<partialPayments.length; i++)
    	{
    		PartialPaymentModel partialPayment = new PartialPaymentModel();
    			partialPayment.setPartialPaymentApplicationMethodType(partialPayments[i].partialPaymentApplicationMethodType);
    			partialPayment.setPartialPaymentApplicationMethodTypeOtherDescription(partialPayments[i].partialPaymentApplicationMethodTypeOtherDescription);
    		 partialPaymentsModels.add(partialPayment);
    	}
    	
	    	paymentRuleModel.setFullyIndexedInitialPrincipalAndInterestPaymentAmount(payment.paymentRule.fullyIndexedInitialPrincipalAndInterestPaymentAmount);
	    	paymentRuleModel.setInitialPrincipalAndInterestPaymentAmount(payment.paymentRule.initialPrincipalAndInterestPaymentAmount);
	    	paymentRuleModel.setPartialPaymentAllowedIndicator(Boolean.parseBoolean(payment.paymentRule.partialPaymentAllowedIndicator));
	    	paymentRuleModel.setPaymentFrequencyType(payment.paymentRule.paymentFrequencyType);
	    	paymentRuleModel.setPaymentOptionIndicator(Boolean.parseBoolean(payment.paymentRule.paymentOptionIndicator));
	    	paymentRuleModel.setSeasonalPaymentPeriodEndMonth(payment.paymentRule.seasonalPaymentPeriodEndMonth);
	    	paymentRuleModel.setSeasonalPaymentPeriodStartMonth(payment.paymentRule.seasonalPaymentPeriodStartMonth);
	    	paymentRuleModel.setTotalOptionalPaymentCount(payment.paymentRule.other.totalOptionalPaymentCount);
	    	paymentRuleModel.setTotalStepPaymentCount(payment.paymentRule.other.totalStepPaymentCount);
    	
    	partialPaymentsModel.setPartialPaymentModels(partialPaymentsModels);
    	paymentModel.setPartialPayments(partialPaymentsModel);
    	paymentModel.setPaymentRule(paymentRuleModel);
		return paymentModel;
    	
    }
    
    /**
     * converts LateChargeRule to LateChargeRuleModel
     * @param deal
     * @return LateChargeRuleModel
     */
    private LateChargeRuleModel createLateChargeRuleModel(Deal deal)
    {
    	LateChargeRuleModel lateChargeRuleModel = new LateChargeRuleModel();
    	
    	LateChargeRule lateChargeRule = new LateChargeRule((Element)deal.getElement("mismo:LOANS/mismo:LOAN/mismo:LATE_CHARGE/mismo:EXTENSION/mismo:OTHER/gse:LATE_CHARGE_RULES/gse:LATE_CHARGE_RULE"));
		
    	lateChargeRuleModel.setLateChargeAmount(lateChargeRule.lateChargeAmount);
    	lateChargeRuleModel.setLateChargeGracePeriodDaysCount(lateChargeRule.lateChargeGracePeriodDaysCount);
    	lateChargeRuleModel.setLateChargeRatePercent(lateChargeRule.lateChargeRatePercent);
    	lateChargeRuleModel.setLateChargeType(lateChargeRule.lateChargeType);
    	
    	return lateChargeRuleModel;
    }
    
    /**
     * converts IntegratedDisclosureDetail to IntegratedDisclosureDetailModel
     * @param deal
     * @return IntegratedDisclosureDetailModel
     */
    private IntegratedDisclosureDetailModel createIntegratedDisclosureDetail(Deal deal)
    {
    	IntegratedDisclosureDetailModel integratedDisclosureDetailModel = new IntegratedDisclosureDetailModel();
    	
    	IntegratedDisclosureDetail idDetail = new IntegratedDisclosureDetail((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_DETAIL"));
    	
	    	integratedDisclosureDetailModel.setFirstYearTotalEscrowPaymentAmount(idDetail.firstYearTotalEscrowPaymentAmount);
	    	integratedDisclosureDetailModel.setFirstYearTotalEscrowPaymentDescription(idDetail.firstYearTotalEscrowPaymentDescription);
	    	integratedDisclosureDetailModel.setFirstYearTotalNonEscrowPaymentAmount(idDetail.firstYearTotalNonEscrowPaymentAmount);
	    	integratedDisclosureDetailModel.setFirstYearTotalNonEscrowPaymentDescription(idDetail.firstYearTotalNonEscrowPaymentDescription);
	    	integratedDisclosureDetailModel.setIntegratedDisclosureHomeEquityLoanIndicator(Boolean.parseBoolean(idDetail.integratedDisclosureHomeEquityLoanIndicator));
	    	integratedDisclosureDetailModel.setIntegratedDisclosureIssuedDate(idDetail.integratedDisclosureIssuedDate);
	    	integratedDisclosureDetailModel.setIntegratedDisclosureLoanProductDescription(idDetail.integratedDisclosureLoanProductDescription);
	    	integratedDisclosureDetailModel.setFiveYearPrincipalReductionComparisonAmount(idDetail.fiveYearPrincipalReductionComparisonAmount);
	    	integratedDisclosureDetailModel.setFiveYearTotalOfPaymentsComparisonAmount(idDetail.fiveYearTotalOfPaymentsComparisonAmount);
	    	integratedDisclosureDetailModel.setIntegratedDisclosureEstimatedClosingCostsExpirationDatetime(idDetail.integratedDisclosureEstimatedClosingCostsExpirationDatetime);
		return integratedDisclosureDetailModel;
    }
    
    /**
     * creates LoanCalculations QualifiedMortgage for JSON Response 
     * @param deal
     * @return LoanCalculationsQualifiedMortgage
     */
    private LoanCalculationsQualifiedMortgage createLoanCalculationsQualifiedMortgage(Deal deal)
    {
    	LoanCalculationsQualifiedMortgage loanCalculationsQualifiedMortgage = new LoanCalculationsQualifiedMortgage();
    	LoanCalculationModel loanCalculationModel = new LoanCalculationModel();
    	
    	FeeSummaryDetail feeSummaryDetail = new FeeSummaryDetail((Element)deal.getElementAddNS("LOANS/LOAN/FEE_INFORMATION/FEES_SUMMARY/FEE_SUMMARY_DETAIL"));
    	//HighCostMortgages highCostMortgages = new HighCostMortgages(null, (Element)deal.getElementAddNS("LOANS/LOAN/HIGH_COST_MORTGAGES/HIGH_COST_MORTGAGE"));
    	Foreclosures foreclosures =  new Foreclosures(null, (Element)deal.getElementAddNS("LOANS/LOAN/FORECLOSURES/FORECLOSURE/FORECLOSURE_DETAIL"));
    	
    	loanCalculationModel.setAprPercent(feeSummaryDetail.aprPercent);
    	loanCalculationModel.setFeeSummaryTotalFinanceChargeAmount(feeSummaryDetail.feeSummaryTotalFinanceChargeAmount);
    	loanCalculationModel.setFeeSummaryTotalAmountFinancedAmount(feeSummaryDetail.feeSummaryTotalAmountFinancedAmount);
    	loanCalculationModel.setFeeSummaryTotalInterestPercent(feeSummaryDetail.feeSummaryTotalInterestPercent);
    	loanCalculationModel.setFeeSummaryTotalOfAllPaymentsAmount(feeSummaryDetail.feeSummaryTotalOfAllPaymentsAmount);
    	loanCalculationModel.setDeficiencyRightsPreservedIndicator(Boolean.parseBoolean(foreclosures.deficiencyRightsPreservedIndicator));
    	
    	loanCalculationsQualifiedMortgage.setLoanCalculationModel(loanCalculationModel);
		
    	return loanCalculationsQualifiedMortgage;
    }
    
    /**
     * create contact information for JSON response
     * @param deal
     * @return ContactInformationModel
     */
     private ContactInformationModel createContactInformation(Deal deal)
    {
    
		ContactInformationModel contactInformationModel = new ContactInformationModel();
		Parties parties = new Parties((Element)deal.getElementAddNS("PARTIES"));
		
		List<Party> closingAgent = new LinkedList<>();
		List<Party> lender = new LinkedList<>();
		List<Party> realEstateAgentB = new LinkedList<>();
		List<Party> realEstateAgentS = new LinkedList<>();
		List<Party> mortgageBroker = new LinkedList<>();
		
       	if(parties.parties.length >0)
		for(int i=0;i<parties.parties.length; i++)
		{	
			if(null != parties.parties[i].roles.element)
				switch(parties.parties[i].roles.roles[0].roleDetail.PartyRoleType)
				{
					case "ClosingAgent":
						closingAgent.add(parties.parties[i]);
					break;
					case "NotePayTo":
						lender.add(parties.parties[i]);
					break;
					case "RealEstateAgent":
						if ("Selling".equalsIgnoreCase(parties.parties[i].roles.roles[0].realEstateAgent.realEstateAgentType))
							realEstateAgentB.add(parties.parties[i]);
						else if("Listing".equalsIgnoreCase(parties.parties[i].roles.roles[0].realEstateAgent.realEstateAgentType))
							realEstateAgentS.add(parties.parties[i]);
					break;
					case "MortgageBroker":
						mortgageBroker.add(parties.parties[i]);
					break;
				}  		
		}
       	
   		if(lender.size()>0)
   			contactInformationModel.setLender(getContactInformationDetail(lender, "NotePayTo"));
   		if(mortgageBroker.size()>0)
   			contactInformationModel.setMortagageBroker(getContactInformationDetail(mortgageBroker, "MortgageBroker"));
   		if(realEstateAgentB.size()>0)
   			contactInformationModel.setRealEstateBrokerB(getContactInformationDetail(realEstateAgentB, "RealEstateAgent"));
   		if(realEstateAgentS.size()>0)
   			contactInformationModel.setRealEstateBrokerS(getContactInformationDetail(realEstateAgentS, "RealEstateAgent"));
   		if(closingAgent.size()>0)
   			contactInformationModel.setSettlementAgent(getContactInformationDetail(closingAgent, "ClosingAgent"));
        	
    		return contactInformationModel;
        	
        }
     
   /**
    * get all the details from party and assigns to contactinformationDetail
    * @param party
    * @return ContactInformationDetail
    */
    private ContactInformationDetailModel getContactInformationDetail(List<Party> parties, String partyType)
    {
    	ContactInformationDetailModel contactInformationDetailModel = new ContactInformationDetailModel();
    	AddressModel addressModel = new AddressModel();
		NameModel nameModel = new NameModel();
		LicenseDetailModel individualLicenseDetail = new LicenseDetailModel();
		LicenseDetailModel organizationLicenseDetail = new LicenseDetailModel();
		
    	parties.forEach(party ->{
    		
    		for(int i=0;i<party.addresses.addresses.length; i++)
	    	{
    			if(null != party.addresses.element && null != party.addresses.addresses[i].element)
    			{
    				Address address = party.addresses.addresses[i];
	    				addressModel.setAddressLineText(address.addressLineText);
	    				addressModel.setAddressType(address.addressType);
	    				addressModel.setCityName(address.cityName);
	    				addressModel.setStateCode(address.stateCode);
	    				addressModel.setCountryCode(address.countryCode);
	    				addressModel.setPostalCode(address.postalCode);
    			}
	    	}
    	
	    	contactInformationDetailModel.setPartyRoleType(partyType);
	    	
    	if(null != party.legalEntity.legalEntityDetail.element)
	   	{
    		contactInformationDetailModel.setOrganizationName(party.legalEntity.legalEntityDetail.fullName);
	    		
	    		if(null != party.roles.element && null != party.roles.roles[0].licenses.element && null != party.roles.roles[0].licenses.licenses[0].licenseDetail.element)
				{
					LicenseDetail licenseDetail = party.roles.roles[0].licenses.licenses[0].licenseDetail;
					
					organizationLicenseDetail.setIdentifierOwnerURI(licenseDetail.identifierOwnerURI);
					organizationLicenseDetail.setLicenseAuthorityLevelType(licenseDetail.licenseAuthorityLevelType);
					organizationLicenseDetail.setLicenseIdentifier(licenseDetail.licenseIdentifier);
					organizationLicenseDetail.setLicenseIssueDate(licenseDetail.licenseIssueDate);
					organizationLicenseDetail.setLicenseIssuingAuthorityName(licenseDetail.licenseIssuingAuthorityName);
					organizationLicenseDetail.setLicenseIssuingAuthorityStateCode(licenseDetail.licenseIssuingAuthorityStateCode);
				}
	    	}
	    	if(null != party.individual.element && null != party.individual.name.element)
	    	{	
	    		Name name = party.individual.name;
	    		
    			nameModel.setFirstName(name.firstName);
    			nameModel.setFullName(name.fullName);
    			nameModel.setLastName(name.lastName);
    			nameModel.setMiddleName(name.middleName);
    			nameModel.setSuffixName(name.suffixName);
				
				if(null != party.roles.element &&  null != party.roles.roles[0].licenses.element && null != party.roles.roles[0].licenses.licenses[0].licenseDetail.element)
				{
					LicenseDetail licenseDetail = party.roles.roles[0].licenses.licenses[0].licenseDetail;
					
					individualLicenseDetail.setIdentifierOwnerURI(licenseDetail.identifierOwnerURI);
					individualLicenseDetail.setLicenseAuthorityLevelType(licenseDetail.licenseAuthorityLevelType);
					individualLicenseDetail.setLicenseIdentifier(licenseDetail.licenseIdentifier);
					individualLicenseDetail.setLicenseIssueDate(licenseDetail.licenseIssueDate);
					individualLicenseDetail.setLicenseIssuingAuthorityName(licenseDetail.licenseIssuingAuthorityName);
					individualLicenseDetail.setLicenseIssuingAuthorityStateCode(licenseDetail.licenseIssuingAuthorityStateCode);
				}
	    	
    	}
	    	if(null != party.individual.element && null != party.individual.contactPoints.element)
	    	{	
	    		for(int i=0; i<party.individual.contactPoints.contactPoints.length; i++)
	    		{
	    			if(null != party.individual.contactPoints.contactPoints[i].contactPointEmail.element)
	    				contactInformationDetailModel.setIndividualEmail(party.individual.contactPoints.contactPoints[i].contactPointEmail.contactPointEmailValue);
	    			if(null != party.individual.contactPoints.contactPoints[i].contactPointTelephone.element)
	    				contactInformationDetailModel.setIndividualPhone(party.individual.contactPoints.contactPoints[i].contactPointTelephone.contactPointTelephoneValue);
	    		}
	    	}
    	});
    	
    	contactInformationDetailModel.setAddress(addressModel);
    	contactInformationDetailModel.setIndividualLicenseDetail(individualLicenseDetail);
    	contactInformationDetailModel.setOrganizationLicenseDetail(organizationLicenseDetail);
    	contactInformationDetailModel.setName(nameModel);
    	
		return contactInformationDetailModel;
    }
    
    /**
     * converts loan detail to LoanDetailModel
     * @param loanDetail
     * @return LoanDetailModel
     */
    private LoanDetailModel createLoanDetailModel(Deal deal)
    {
    	LoanDetail loanDetail = new LoanDetail((Element)deal.getElementAddNS("LOANS/LOAN/LOAN_DETAIL"));	
  	    
    	LoanDetailModel loanDetailModel = new LoanDetailModel();
	    	loanDetailModel.setAssumabilityIndicator(Boolean.parseBoolean(loanDetail.assumabilityIndicator));
	    	loanDetailModel.setBalloonIndicator(Boolean.parseBoolean(loanDetail.balloonIndicator));
	    	loanDetailModel.setBalloonPaymentAmount(loanDetail.balloonPaymentAmount);
	    	loanDetailModel.setBuydownTemporarySubsidyFundingIndicator(Boolean.parseBoolean(loanDetail.buydownTemporarySubsidyFundingIndicator));
	    	loanDetailModel.setConstructionLoanIndicator(Boolean.parseBoolean(loanDetail.constructionLoanIndicator));
	    	loanDetailModel.setCreditorServicingOfLoanStatementType(loanDetail.creditorServicingOfLoanStatementType);
	    	loanDetailModel.setDemandFeatureIndicator(Boolean.parseBoolean(loanDetail.demandFeatureIndicator));
	    	loanDetailModel.setEscrowAbsenceReasonType(loanDetail.escrowAbsenceReasonType);
	    	loanDetailModel.setEscrowIndicator(Boolean.parseBoolean(loanDetail.escrowIndicator));
	    	loanDetailModel.setInterestOnlyIndicator(Boolean.parseBoolean(loanDetail.interestOnlyIndicator));
	    	loanDetailModel.setInterestRateIncreaseIndicator(Boolean.parseBoolean(loanDetail.interestRateIncreaseIndicator));
	    	loanDetailModel.setLoanAmountIncreaseIndicator(Boolean.parseBoolean(loanDetail.loanAmountIncreaseIndicator));
	    	loanDetailModel.setMiRequiredIndicator(Boolean.parseBoolean(loanDetail.miRequiredIndicator));
	    	loanDetailModel.setNegativeAmortizationIndicator(Boolean.parseBoolean(loanDetail.negativeAmortizationIndicator));
	    	loanDetailModel.setPaymentIncreaseIndicator(Boolean.parseBoolean(loanDetail.paymentIncreaseIndicator));
	    	loanDetailModel.setPrepaymentPenaltyIndicator(Boolean.parseBoolean(loanDetail.prepaymentPenaltyIndicator));
	    	loanDetailModel.setSeasonalPaymentFeatureIndicator(Boolean.parseBoolean(loanDetail.seasonalPaymentFeatureIndicator));
	    	loanDetailModel.setStepPaymentsFeatureDescription(loanDetail.stepPaymentsFeatureDescription);
	    	loanDetailModel.setTotalSubordinateFinancingAmount(loanDetail.totalSubordinateFinancingAmount);
	    	loanDetailModel.setSubordinateFinancingIsNewIndicator(Boolean.parseBoolean(loanDetail.subordinateFinancingIsNewIndicator));
	    	
		return loanDetailModel;
    }
    
    /**
     * converts loanTerms to TermsOfLoanModel
     * @param loanTerms
     * @return TermsOfLoanModel
     */
    private TermsOfLoanModel createTermsOfLoanModel(Deal deal)
    {
    	TermsOfLoan loanTerms = new TermsOfLoan((Element)deal.getElementAddNS("LOANS/LOAN/TERMS_OF_LOAN"));
 	   
    	TermsOfLoanModel termsOfLoanModel = new TermsOfLoanModel();
	    	termsOfLoanModel.setAssumedLoanAmount(loanTerms.assumedLoanAmount);
	    	termsOfLoanModel.setDisclosedFullyIndexedRatePercent(loanTerms.disclosedFullyIndexedRatePercent);
	    	termsOfLoanModel.setLienPriorityType(loanTerms.lienPriorityType);
	    	termsOfLoanModel.setLoanPurposeType(loanTerms.loanPurposeType);
	    	termsOfLoanModel.setMortgageType(loanTerms.mortgageType);
	    	termsOfLoanModel.setMortgageTypeOtherDescription(loanTerms.mortgageTypeOtherDescription);
	    	termsOfLoanModel.setNoteAmount(loanTerms.noteAmount);
	    	termsOfLoanModel.setNoteRatePercent(loanTerms.noteRatePercent);
	    	termsOfLoanModel.setWeightedAverageInterestRatePercent(loanTerms.weightedAverageInterestRatePercent);
	    	
		return termsOfLoanModel;
    }
    
    /**
     * converts DocumentClassification to DocumentClassificationModel for JSON response
     * @param document
     * @return DocumentClassificationModel
     */
    private DocumentClassificationModel createDocumentClassificationModel(Document document)
    {
    	DocumentClassificationModel documentClassification = new DocumentClassificationModel();
    	if(null != document.documentClassification)
    	{
    		DocumentClassification docClassification = new DocumentClassification(Document.NS, (Element)document.getElementAddNS("DOCUMENT_CLASSIFICATION"));
	    	
	 	    if(null != docClassification.documentClassificationDetail)
	 	    {
		 	    documentClassification.setDocumentFormIssuingEntityNameType(docClassification.documentClassificationDetail.documentFormIssuingEntityNameType);
		 	    documentClassification.setDocumentFormIssuingEntityVersionIdentifier(docClassification.documentClassificationDetail.documentFormIssuingEntityVersionIdentifier);
		 	    documentClassification.setDocumentSignatureRequiredIndicator(Boolean.parseBoolean(docClassification.documentClassificationDetail.other.documentSignatureRequiredIndicator));
	 	    }
	 	    documentClassification.setDocumentType(docClassification.documentClasses.documentClass.documentType);
	 	    documentClassification.setDocumentTypeOtherDescription(docClassification.documentClasses.documentClass.documentTypeOtherDescription);
    	}
		return documentClassification;
    }
    
   /**
    * converts integratedDisclosureSectionSummary to IntegratedDisclosureSectionSummaryModel
    * @param integratedDisclosureSectionSummary
    * @return IntegratedDisclosureSectionSummaryModel
    */
    private IntegratedDisclosureSectionSummaryModel toIntegratedDisclosureSectionSummaryModel(IntegratedDisclosureSectionSummary integratedDisclosureSectionSummary)
    {
    	IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
    	IntegratedDisclosureSectionSummaryDetailModel integratedDisclosureSectionSummaryDetailModel = new IntegratedDisclosureSectionSummaryDetailModel();
    	IntegratedDisclosureSectionSummaryDetail integratedDisclosureSectionSummaryDetail = integratedDisclosureSectionSummary.integratedDisclosureSectionSummaryDetail;
    	
    	integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionTotalAmount(integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionTotalAmount);
    	integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionType(integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType);
    	integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSubsectionTotalAmount(integratedDisclosureSectionSummaryDetail.integratedDisclosureSubsectionTotalAmount);
    	integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSubsectionType(integratedDisclosureSectionSummaryDetail.integratedDisclosureSubsectionType);
    	integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSubsectionTypeOtherDescription(integratedDisclosureSectionSummaryDetail.integratedDisclosureSubsectionTypeOtherDescription);
    	integratedDisclosureSectionSummaryDetailModel.setLenderCreditToleranceCureAmount(integratedDisclosureSectionSummaryDetail.lenderCreditToleranceCureAmount);
    		
    	IntegratedDisclosureSubsectionPayment[] integratedDisclosureSubsectionPayments = integratedDisclosureSectionSummary.integratedDisclosureSubsectionPayments.integratedDisclosureSubsectionPayments;
    		
    	for(int i=0; i<integratedDisclosureSubsectionPayments.length; i++)
    	{
    		IntegratedDisclosureSubsectionPaymentModel integratedDisclosureSubsectionPaymentModel = new IntegratedDisclosureSubsectionPaymentModel();
    			integratedDisclosureSubsectionPaymentModel.setIntegratedDisclosureSubsectionPaidByType(integratedDisclosureSubsectionPayments[i].integratedDisclosureSubsectionPaidByType);
    			integratedDisclosureSubsectionPaymentModel.setIntegratedDisclosureSubsectionPaymentAmount(integratedDisclosureSubsectionPayments[i].integratedDisclosureSubsectionPaymentAmount);
    			integratedDisclosureSubsectionPaymentModel.setIntegratedDisclosureSubsectionPaymentTimingType(integratedDisclosureSubsectionPayments[i].integratedDisclosureSubsectionPaymentTimingType);
    		integratedDisclosureSectionSummaryModel.getIntegratedDisclosureSubsectionPayments().add(integratedDisclosureSubsectionPaymentModel);
    	}
    	
    	integratedDisclosureSectionSummaryModel.setIntegratedDisclosureSectionSummaryDetailModel(integratedDisclosureSectionSummaryDetailModel);
    	
		return integratedDisclosureSectionSummaryModel;
    }
    
    /**
     * converts closingCostFundList to ClosingCostFundModel list
     * @param closingCostFundList
     * @return ClosingCostFundModel List
     */
    private List<ClosingCostFundModel> createClosingCostFundModels(Deal deal) {
    	ClosingInformation closingInformation =  new ClosingInformation(null, (Element)deal.getElementAddNS("LOANS/LOAN/CLOSING_INFORMATION"));
    	
    	ClosingCostFund[] closingCostFundList = closingInformation.closingCostFunds.closingCostFundList;
    	
    	List<ClosingCostFundModel> closingCostFundModels = new LinkedList<>();
    	for(int i=0; i<closingCostFundList.length;i++)
    	{
    		ClosingCostFundModel closingCostFundModel = new ClosingCostFundModel();
    			closingCostFundModel.setClosingCostFundAmount(closingCostFundList[i].closingCostFundAmount);
    			closingCostFundModel.setFundsType(closingCostFundList[i].fundsType);
    			closingCostFundModel.setIntegratedDisclosureSectionType(closingCostFundList[i].integratedDisclosureSectionType);
    		closingCostFundModels.add(closingCostFundModel);
    	}
    	return closingCostFundModels;
	}

    /**
     * converts closingAdjustmentItemList to ClosingAdjustmentItemModel list
     * @param closingAdjustmentItemList
     * @return list of ClosingAdjustmentItemModel
     */
	private List<ClosingAdjustmentItemModel> createClosingAdjustmentModels(Deal deal) {
		ClosingInformation closingInformation =  new ClosingInformation(null, (Element)deal.getElementAddNS("LOANS/LOAN/CLOSING_INFORMATION"));
		
		ClosingAdjustmentItem[] closingAdjustmentItemList = closingInformation.closingAdjustmentItems.closingAdjustmentItemList;
    	
		List<ClosingAdjustmentItemModel> closingAdjustmentItemModels = new LinkedList<>();
    	
		for(int i=0;i<closingAdjustmentItemList.length;i++)
    	{
    		ClosingAdjustmentItemModel closingAdjustmentItemModel = new ClosingAdjustmentItemModel();
    			closingAdjustmentItemModel.setDisplayLabel(closingAdjustmentItemList[i].closingAdjustmentItemDetail.displayLabelText);
    			closingAdjustmentItemModel.setClosingAdjustmentItemAmount(closingAdjustmentItemList[i].closingAdjustmentItemDetail.closingAdjustmentItemAmount);
    			closingAdjustmentItemModel.setClosingAdjustmentItemPaidOutsideOfClosingIndicator(Boolean.parseBoolean(closingAdjustmentItemList[i].closingAdjustmentItemDetail.closingAdjustmentItemPaidOutsideOfClosingIndicator));
    			closingAdjustmentItemModel.setClosingAdjustmentItemType(closingAdjustmentItemList[i].closingAdjustmentItemDetail.closingAdjustmentItemType);
    			closingAdjustmentItemModel.setClosingAdjustmentItemTypeOtherDescription(closingAdjustmentItemList[i].closingAdjustmentItemDetail.closingAdjustmentItemTypeOtherDescription);
    			closingAdjustmentItemModel.setIntegratedDisclosureSectionType(closingAdjustmentItemList[i].closingAdjustmentItemDetail.integratedDisclosureSectionType);
    			closingAdjustmentItemModel.setIntegratedDisclosureSubsectionType(closingAdjustmentItemList[i].closingAdjustmentItemDetail.integratedDisclosureSubsectionType);
    			closingAdjustmentItemModel.setPaidByEntityFullName(closingAdjustmentItemList[i].paidBy.legalEntity.legalEntityDetail.fullName);
    			closingAdjustmentItemModel.setPaidByIndividualFullName(closingAdjustmentItemList[i].paidBy.individual.name.fullName);
    			closingAdjustmentItemModel.setPaidToEntityFullName(closingAdjustmentItemList[i].paidToEntityFullName);
    		closingAdjustmentItemModels.add(closingAdjustmentItemModel);
    		
    	}
    	
		return closingAdjustmentItemModels;
	}
	
	/**
	 * converts liability to liability Models 
	 * @param liability
	 * @return list of liability Model
	 */
	private List<LiabilityModel> createLiabilityModels(Deal deal) {
		Liabilities liabilities = new Liabilities(null, (Element)deal.getElementAddNS("LIABILITIES/")); 
		Liability[] liability = liabilities.liabilityList;
    	List<LiabilityModel> liabilityModels = new LinkedList<>();
    	
    	for(int i=0; i<liability.length; i++)
    	{
    		LiabilityModel liabilityModel = new LiabilityModel();
    			liabilityModel.setDisplayLabel(liability[i].liabilityDetail.displayLabelText);
	    		liabilityModel.setIntegratedDisclosureSectionType(liability[i].liabilityDetail.other.integratedDisclosureSectionType);
	    		liabilityModel.setLiabilityDescription(liability[i].liabilityDetail.liabilityDescription);
	    		liabilityModel.setLiabilityHolderFullName(liability[i].liabilityholderName.fullName);
	    		liabilityModel.setLiabilitySecuredBySubjectPropertyIndicator(Boolean.parseBoolean(liability[i].liabilityDetail.other.liabilitySecuredBySubjectPropertyIndicator));
	    		liabilityModel.setLiabilityType(liability[i].liabilityDetail.liabilityType);
	    		liabilityModel.setLiabilityTypeOtherDescription(liability[i].liabilityDetail.liabilityTypeOtherDescription);
	    		liabilityModel.setPayoffAmount(liability[i].payOff.payoffAmount);
	    		liabilityModel.setPayoffPrepaymentPenaltyAmount(liability[i].payOff.payoffPrepaymentPenaltyAmount);
	    		liabilityModel.setPayoffPartialIndicator(Boolean.parseBoolean(liability[i].payOff.payoffPartialIndicator));
	    	liabilityModels.add(liabilityModel);
    	}
		return liabilityModels;
	}
	
	/**
	 * converts ProrationItem to Proration Model
	 * @param prorationItemList
	 * @return List of ProrationModel
	 */
	private List<ProrationModel> createProrationsModels(Deal deal) {
		
		ClosingInformation closingInformation =  new ClosingInformation(null, (Element)deal.getElementAddNS("LOANS/LOAN/CLOSING_INFORMATION"));
		
		ProrationItem[] prorationItemList = closingInformation.prorationItems.prorationItemList;
		
		List<ProrationModel> prorationsModels = new LinkedList<>();
    	
    	for(int i=0; i<prorationItemList.length;i++)
    	{
    		ProrationModel prorationsModel = new ProrationModel();
    			prorationsModel.setDisplayLabel(prorationItemList[i].displayLabelText);
    			prorationsModel.setIntegratedDisclosureSectionType(prorationItemList[i].integratedDisclosureSectionType);
    			prorationsModel.setIntegratedDisclosureSubsectionType(prorationItemList[i].integratedDisclosureSubsectionType);
    			prorationsModel.setProrationItemAmount(prorationItemList[i].prorationItemAmount);
    			prorationsModel.setProrationItemPaidFromDate(prorationItemList[i].prorationItemPaidFromDate);
    			prorationsModel.setProrationItemPaidThroughDate(prorationItemList[i].prorationItemPaidThroughDate);
    			prorationsModel.setProrationItemType(prorationItemList[i].prorationItemType);
    			prorationsModel.setProrationItemTypeOtherDescription(prorationItemList[i].prorationItemTypeOtherDescription);
    		prorationsModels.add(prorationsModel);
    	}
    	
		return prorationsModels;
	}
	
	/**
     * insert values to UI response
     * @param cashToCloseItem
     * @param displayLabel
     * @param index
     * @return CashToCloseModel
     */
	private CashToCloseModel setCashToClose(CashToCloseItem cashToCloseItem)
	{
		CashToCloseModel cashToCashToCloseModel = new CashToCloseModel();
			cashToCashToCloseModel.setIntegratedDisclosureCashToCloseItemAmountChangedIndicator(Boolean.parseBoolean(cashToCloseItem.integratedDisclosureCashToCloseItemAmountChangedIndicator));
			cashToCashToCloseModel.setIntegratedDisclosureCashToCloseItemChangeDescription(cashToCloseItem.integratedDisclosureCashToCloseItemChangeDescription);
			cashToCashToCloseModel.setIntegratedDisclosureCashToCloseItemEstimatedAmount(cashToCloseItem.integratedDisclosureCashToCloseItemEstimatedAmount);
			cashToCashToCloseModel.setIntegratedDisclosureCashToCloseItemFinalAmount(cashToCloseItem.integratedDisclosureCashToCloseItemFinalAmount);
			cashToCashToCloseModel.setIntegratedDisclosureCashToCloseItemPaymentType(cashToCloseItem.integratedDisclosureCashToCloseItemPaymentType);
			cashToCashToCloseModel.setIntegratedDisclosureCashToCloseItemType(cashToCloseItem.integratedDisclosureCashToCloseItemType);
		return cashToCashToCloseModel;
	}
	
    /**
     * Populates the EscrowItem from XML for a given escrow type
     * @param escrowItems
     * @param escrowType
     * @return EscrowsModel
     */
    private EscrowItem getEscrowItem(EscrowItems escrowItems, String escrowType){
		EscrowItem escrowItem = new EscrowItem(null);
		
		for(int i=0; i<escrowItems.escrowItems.length;i++)
 	    {
        	EscrowItemDetail escrowItemDetail = escrowItems.escrowItems[i].escrowItemDetail;
        	
        	if(escrowType.equalsIgnoreCase(escrowItemDetail.escrowItemType))
        	{
        		   escrowItem = escrowItems.escrowItems[i];
        	}
 	    }
		return escrowItem;
	}
    
	/**
	 * calculates the salePrice
	 * @param loanTerms
	 * @param salesContractDetail
	 * @param propertyValuationDetail
	 * @param propertyDetail
	 * @return saleprice as a String
	 */
	private static String salePrice(TermsOfLoan loanTerms, SalesContractDetail salesContractDetail, PropertyValuationDetail propertyValuationDetail, PropertyDetail propertyDetail) {
		if (!loanTerms.loanPurposeType.equalsIgnoreCase("Purchase"))
			if (propertyValuationDetail.propertyValuationAmount.equals(""))
				return propertyDetail.propertyEstimatedValueAmount;
			else
				return propertyValuationDetail.propertyValuationAmount;		
		if (salesContractDetail.personalPropertyIncludedIndicator.equalsIgnoreCase("true"))
			return salesContractDetail.realPropertyAmount;
		return salesContractDetail.salesContractAmount;
	}
	
	/**
	 * fetch the Name Model from XML
	 * @param name
	 * @return name detail
	 */
	private static NameModel toNameModel(Name name) {
		NameModel nameModel = new NameModel();
		String fullName = "";
		if (!name.fullName.equals(""))
		{
			fullName = name.fullName;
			nameModel.setFirstName(fullName);
		}
		if (!name.firstName.equals(""))
		{
			if(!fullName.isEmpty())
				nameModel.setFirstName(fullName+" "+name.firstName);
			else
				nameModel.setFirstName(name.firstName);
		}
		if (!name.middleName.equals("")) 
			nameModel.setMiddleName(name.middleName);
		if (!name.lastName.equals("")) 
			nameModel.setLastName(name.lastName);
		if (!name.suffixName.equals("")) 
			nameModel.setSuffixName(name.suffixName);
		
		return nameModel;
	}
	
	/**
	 * fetch the address model from XML
	 * @param address
	 * @return address Model
	 */
	private static AddressModel toAddressModel(Address address) {
	AddressModel addressModel = new AddressModel();
		
		if (!"".equals(address.addressType))
			addressModel.setAddressType(address.addressType);
		if (!"".equals(address.cityName))
			addressModel.setCityName(address.cityName);
		if (!"".equals(address.addressLineText))
			addressModel.setAddressLineText(address.addressLineText);
		if (!"".equals(address.stateCode))
			addressModel.setStateCode(address.stateCode);
		if (!"".equals(address.postalCode)) 
			addressModel.setPostalCode(address.postalCode);
		if (!"".equals(address.countryCode)) 
			addressModel.setCountryCode(address.countryCode);
		return addressModel;
	}
	
	/**
	 * calculates the loan term
	 * @param loanDetail
	 * @param maturityRule
	 * @param construction
	 * @return loanTerm as a string
	 */
	private static String loanTerm(LoanDetail loanDetail, MaturityRule maturityRule, Construction construction) {
		if (loanDetail.constructionLoanIndicator.equalsIgnoreCase("true")) {
			if (construction.constructionLoanType.equalsIgnoreCase("ConstructionOnly"))
				return construction.constructionPeriodNumberOfMonthsCount;
			return construction.constructionLoanTotalTermMonthsCount;
		}
		return maturityRule.loanMaturityPeriodCount;
	}
	
	
    /**
     * converts parties from xml to borrower model for JSON Model
     * @param partyList
     * @return list of parties
     */
	private List<Borrower> createBorrowers(List<Party> partyList) {
		
		List<Borrower> borrowersList = new LinkedList<>();
		
		for(Party party : partyList)
		{
			Borrower borrower = new Borrower();
			NameModel applicant = new NameModel();
			AddressModel addressModel = new AddressModel();
			if (!party.legalEntity.legalEntityDetail.fullName.equals(""))
			{	
				applicant.setFullName(party.legalEntity.legalEntityDetail.fullName);
				borrower.setType("O");
			}
			else
			{
				applicant = toNameModel(party.individual.name);
				borrower.setType("I");
			}
			addressModel = toAddressModel(new Address((Element)party.getElementAddNS("ADDRESSES/ADDRESS[AddressType='Mailing']")));
			String status = party.getValueAddNS("LEGAL_DESCRIPTIONS/LEGAL_DESCRIPTION/UNPARSED_LEGAL_DESCRIPTIONS/UNPARSED_LEGAL_DESCRIPTION/UnparsedLegalDescription");
			addressModel.setUnparsedLegalDescription(status);
			addressModel.setLegalDescription(status.length() >0 ? true : false);
			borrower.setNameModel(applicant);
			borrower.setAddress(addressModel);
			borrower.setPartyRoleType(party.roles.roles[0].roleDetail.PartyRoleType);
			borrowersList.add(borrower);
		}	
	
		return borrowersList;
	}
	
	/**
	 * Insert Fee to Loan Costs Table
	 * @param fee
	 * @param sectionType
	 * @return ClosingCostProperties
	 */
	private ClosingCostProperties loanCostsTable(Fee fee,String sectionType) 
	{
		ClosingCostProperties closingCostProperties = new ClosingCostProperties();
		
			if (("LoanDiscountPoints").equalsIgnoreCase(fee.feeDetail.feeType))
				if(!"".equals(fee.feeDetail.feeTotalPercent) && !"0.0000".equalsIgnoreCase(fee.feeDetail.feeTotalPercent)&& !"".equals(fee.feeDetail.feePaidToType))
				{
					closingCostProperties = feeCostsTableRow(fee, sectionType);
				}
				else
				{
					closingCostProperties = feeCostsTableRow(fee, sectionType);
				}
			else
				closingCostProperties = feeCostsTableRow(fee, sectionType);
		return closingCostProperties;
	}
	
    /**
     * Insert Fee Details
     * @param fee
     * @param withTo
     * @param label
     * @param to
     * @return ClosingCostProperties
     */
	private ClosingCostProperties feeCostsTableRow(Fee fee,String sectionType) 
	{
		ClosingCostProperties closingCostProperties = new ClosingCostProperties();
		
		  if ("true".equals(fee.feeDetail.optionalCostIndicator) && !"".equals(fee.feeDetail.feePaidToTypeOtherDescription) && !fee.feeDetail.feePaidToTypeOtherDescription.toLowerCase().contains("optional"))
			  fee.feeDetail.displayLabelText += " (optional)";
		  
		closingCostProperties.setFeeType(fee.feeDetail.feeType);
		closingCostProperties.setFeeTypeOtherDescription(fee.feeDetail.feePaidToTypeOtherDescription);
		closingCostProperties.setOptionalCostIndicator(Convertor.stringToBoolean(fee.feeDetail.optionalCostIndicator));
		closingCostProperties.setFeePaidToType(fee.feeDetail.feePaidToType);
		closingCostProperties.setFeePaidToTypeOtherDescription(fee.feeDetail.feePaidToTypeOtherDescription);
		closingCostProperties.setIntegratedDisclosureSectionType(sectionType);
		closingCostProperties.setFeePercentBasisType(fee.feeDetail.feePercentBasisType);
		closingCostProperties.setRegulationZPointsAndFeesIndicator(Convertor.stringToBoolean(fee.feeDetail.regulationZPointsAndFeesIndicator));
		closingCostProperties.setPaymentIncludedInAPRIndicator(Convertor.stringToBoolean(fee.feeDetail.paymentIncludedInAPRIndicator));
		closingCostProperties.setFeeTotalPercent(fee.feeDetail.feeTotalPercent);
		closingCostProperties.setFeePaidToFullName(fee.feePaidTo.legalEntity.legalEntityDetail.fullName);
		closingCostProperties.setFeeActualTotalAmount(fee.feeDetail.feeActualTotalAmount);
		closingCostProperties.setFeeEstimatedTotalAmount(fee.feeDetail.feeEstimatedTotalAmount);
		
		if(!"".equals(fee.feeDetail.displayLabelText))
			closingCostProperties.setDisplayLabel(fee.feeDetail.displayLabelText);
		//else if("Other".equalsIgnoreCase(fee.feeDetail.feeType))
			//    closingCostProperties.setDisplayLabel(StringFormatter.CAMEL.formatString(fee.feeDetail.feeTypeOtherDescription));
		
		if(fee.feePayments.feePayments.length > 0 && fee.feeDetail.feeEstimatedTotalAmount.isEmpty())
		for(FeePayment feepay :fee.feePayments.feePayments)
		{
			if(!"".equals(feepay.feePaymentPaidByType))
			{
				String paidByType = feepay.feePaymentPaidByType;
				if( "Buyer".equalsIgnoreCase(paidByType)) 
					if("false".equalsIgnoreCase(feepay.feePaymentPaidOutsideOfClosingIndicator))
			            closingCostProperties.setFeeEstimatedTotalAmount(feepay.feeActualPaymentAmount);
					//else
					  //  closingCostProperties.setFeeEstimatedTotalAmount(feepay.feeActualPaymentAmount);
			}
		}
		return closingCostProperties;
	}
	
	/**
	 * Calculate Total Loan Costs
	 * @param totalLoanCosts
	 * @param integratedDisclosureSectionSummaries
	 * @return
	 */
	private PaymentsModel calculateTLCosts(IntegratedDisclosureSectionSummaryDetail totalLoanCosts, IntegratedDisclosureSectionSummaries integratedDisclosureSectionSummaries)
	{
		PaymentsModel tlCosts = new PaymentsModel();
        	
		if(null != integratedDisclosureSectionSummaries.integratedDisclosureSectionSummaries)	
		for(IntegratedDisclosureSectionSummary integratedDisclosureSectionSummary : integratedDisclosureSectionSummaries.integratedDisclosureSectionSummaries){	
			if("TotalLoanCosts".equalsIgnoreCase(integratedDisclosureSectionSummary.integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType) && "LoanCostsSubtotal".equalsIgnoreCase(integratedDisclosureSectionSummary.integratedDisclosureSectionSummaryDetail.integratedDisclosureSubsectionType))
			{
				IntegratedDisclosureSubsectionPayments integratedDisclosureSubsectionPayments = integratedDisclosureSectionSummary.integratedDisclosureSubsectionPayments;
			    if(integratedDisclosureSubsectionPayments.integratedDisclosureSubsectionPayments.length>0)
				for(IntegratedDisclosureSubsectionPayment integrateddisclosuresubsectionpayment : integratedDisclosureSubsectionPayments.integratedDisclosureSubsectionPayments)
				{
										
					if(("Buyer").equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaidByType))
					{
						if(("AtClosing").equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentTimingType))
							tlCosts.setBpAtClosing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
						else
							tlCosts.setBpB4Closing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
					}
					else if(("Seller").equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaidByType))
					{
						if(("AtClosing").equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentTimingType))
							tlCosts.setSpAtClosing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
						else
							tlCosts.setSpB4Closing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
					}
					else
						tlCosts.setPaidByOthers(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
					if("Lender".equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaidByType))
						tlCosts.setLenderStatus(true);
					
				}
			}
		}
		return tlCosts;
	}
	
	/**
	 * Extracts the elements from PrepaidItem and sets to Prepaids Model
	 * @param prepaidItem
	 * @param to
	 * @return Prepaids Model
	 */
	private Prepaids setPrepaids(PrepaidItem prepaidItem, boolean to)
	{
		Prepaids prepaid = new Prepaids();
		
		prepaid.setPrepaidItemType(prepaidItem.prepaidItemDetail.prepaidItemType);
		prepaid.setPrepaidItemTypeOtherDescription(prepaidItem.prepaidItemDetail.prepaidItemTypeOtherDescription);
		prepaid.setDisplayLabel(prepaidItem.prepaidItemDetail.displayLabelText);
		
		prepaid.setPrepaidItemPerDiemAmount(prepaidItem.prepaidItemDetail.prepaidItemPerDiemAmount);
		prepaid.setPrepaidItemPaidFromDate(prepaidItem.prepaidItemDetail.prepaidItemPaidFromDate);
		prepaid.setPrepaidItemPaidThroughDate(prepaidItem.prepaidItemDetail.prepaidItemPaidThroughDate);
		prepaid.setPrepaidItemMonthsPaidCount(prepaidItem.prepaidItemDetail.prepaidItemMonthsPaidCount);
		prepaid.setFeePaidToType(prepaidItem.prepaidItemDetail.feePaidToType);
		prepaid.setFeePaidToTypeOtherDescription(prepaidItem.prepaidItemDetail.feePaidToTypeOtherDescription);
		prepaid.setIntegratedDisclosureSectionType(prepaidItem.prepaidItemDetail.integratedDisclosureSectionType);
		prepaid.setPrepaidItemPerDiemCalculationMethodType(prepaidItem.prepaidItemDetail.prepaidItemPerDiemCalculationMethodType);
	 	prepaid.setPrepaidPaidToFullName(prepaidItem.prepaidItemPaidTo.legalEntity.legalEntityDetail.fullName);
		prepaid.setPrepaidItemEstimatedTotalAmount(prepaidItem.prepaidItemDetail.prepaidItemEstimatedTotalAmount);
		prepaid.setPrepaidItemNumberOfDaysCount(prepaidItem.prepaidItemDetail.prepaidItemNumberOfDaysCount);
		prepaid.setPaymentIncludedInAPRIndicator(Boolean.parseBoolean(prepaidItem.prepaidItemDetail.paymentIncludedInAPRIndicator));
	 	prepaid.setRegulationZPointsAndFeesIndicator(Boolean.parseBoolean(prepaidItem.prepaidItemDetail.regulationZPointsAndFeesIndicator));
	 	
	 	if(prepaidItem.prepaidItemDetail.prepaidItemEstimatedTotalAmount.isEmpty())
			for(PrepaidItemPayment prepaidPayment: prepaidItem.prepaidItemPayments.prepaidItemPayments)
			{
				if( null != prepaidPayment.prepaidItemPaymentPaidByType)
				{
					String paidBy = prepaidPayment.prepaidItemPaymentPaidByType;
					if( "Buyer".equalsIgnoreCase(paidBy)) 
						if(!"BeforeClosing".equalsIgnoreCase(prepaidPayment.prepaidItemPaymentTimingType))
							prepaid.setPrepaidItemEstimatedTotalAmount(prepaidPayment.prepaidItemActualPaymentAmount);
				}
			}
		
		return prepaid;		
	}
	
	/**
	 * Checks for property Tax
	 * @param type
	 * @return boolean
	 */
	private boolean isPropertyTax(String type)
	{
		if(null != type)
		return	   type.equalsIgnoreCase("BoroughPropertyTax")
				|| type.equalsIgnoreCase("CityPropertyTax")
				|| type.equalsIgnoreCase("CountyPropertyTax")
				|| type.equalsIgnoreCase("DistrictPropertyTax")
				|| type.equalsIgnoreCase("PropertyTaxes")
				|| type.equalsIgnoreCase("StatePropertyTax")
				|| type.equalsIgnoreCase("TownPropertyTax");
		return false;
	}
	
	/**
	 * Checks for OtherTypePrepaids
	 * @param prepaidType
	 * @return boolean
	 */
	private boolean checkOtherPrepaids(String prepaidType)
	{
		if("HomeownersInsurancePremium".equalsIgnoreCase(prepaidType) || "MortgageInsurancePremium".equalsIgnoreCase(prepaidType) || "PrepaidInterest".equalsIgnoreCase(prepaidType)
				||"Property Taxes".equalsIgnoreCase(prepaidType) || isPropertyTax(prepaidType) || null == prepaidType || ("").equals(prepaidType) )
			return false;
		return true;
	}
	
	/**
	 * Extracts the elements from escrowItem and sets to IEPatClosing Model for UI response
	 * @param escrowItem
	 * @return IEPatClosing
	 */
	private EscrowItemModel getEscrowModel(EscrowItem escrowItem)
	{
		EscrowItemModel iePatClosing = new EscrowItemModel();
		
		EscrowItemDetail escrowItemDetail = escrowItem.escrowItemDetail;  
		
		iePatClosing.setDisplayLabel(escrowItemDetail.displayLabelText);
		iePatClosing.setEscrowItemType(escrowItemDetail.escrowItemType);
		iePatClosing.setEscrowItemTypeOtherDescription(escrowItemDetail.escrowItemTypeOtherDescription);
		iePatClosing.setEscrowCollectedNumberOfMonthsCount(escrowItemDetail.escrowCollectedNumberOfMonthsCount);
		iePatClosing.setEscrowMonthlyPaymentAmount(escrowItemDetail.escrowMonthlyPaymentAmount);
		iePatClosing.setFeePaidToType(escrowItemDetail.feePaidToType);
		iePatClosing.setFeePaidToTypeOtherDescription(escrowItemDetail.feePaidToTypeOtherDescription);
		iePatClosing.setIntegratedDisclosureSectionType(escrowItemDetail.integratedDisclosureSectionType);
		iePatClosing.setRegulationZPointsAndFeesIndicator(Boolean.parseBoolean(escrowItemDetail.regulationZPointsAndFeesIndicator));
		iePatClosing.setPaymentIncludedInAPRIndicator(Boolean.parseBoolean(escrowItemDetail.paymentIncludedInAPRIndicator));
		iePatClosing.setEscrowItemEstimatedTotalAmount(escrowItemDetail.escrowItemEstimatedTotalAmount);
		if(escrowItemDetail.escrowItemEstimatedTotalAmount.isEmpty())
		for(EscrowItemPayment escrowitempayment : escrowItem.escrowItemPayments.escrowItemPayment)
		{
			String paidBy = escrowitempayment.escrowItemPaymentPaidByType;
			
			if ("Buyer".equalsIgnoreCase(paidBy)) 
				if ("BeforeClosing".equalsIgnoreCase(escrowitempayment.escrowItemPaymentTimingType))
					iePatClosing.setBpB4Closing(escrowitempayment.escrowItemActualPaymentAmount);
				else
					iePatClosing.setEscrowItemEstimatedTotalAmount(escrowitempayment.escrowItemActualPaymentAmount);
			/*else if ("Seller".equalsIgnoreCase(paidBy))
				if ("BeforeClosing".equalsIgnoreCase(escrowitempayment.escrowItemPaymentTimingType))
					iePatClosing.setSpB4Closing(escrowitempayment.escrowItemActualPaymentAmount);
				else
					iePatClosing.setSpAtClosing(escrowitempayment.escrowItemActualPaymentAmount);
			else
				iePatClosing.setPaidByOthers(escrowitempayment.escrowItemActualPaymentAmount);
			
			if ("Lender".equalsIgnoreCase(paidBy))
				iePatClosing.setLenderStatus(true);
			else
				
				iePatClosing.setLenderStatus(false);*/
		}
		return iePatClosing;
	}

	/**
	 * Checks for other type of escrows
	 * @param escrowType
	 * @return boolean
	 */
	private boolean checkOtherEscrows(String escrowType)
	{
		if("HomeownersInsurance".equalsIgnoreCase(escrowType) || "MortgageInsurance".equalsIgnoreCase(escrowType) || "PrepaidInterest".equalsIgnoreCase(escrowType)
				||"Property Taxes".equalsIgnoreCase(escrowType) || isPropertyTax(escrowType) ||null == escrowType || "".equals(escrowType))
			return false;
		return true;
	}

			
}
