package com.actualize.mortgage.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import com.actualize.mortgage.domainmodels.ClosingCostProperties;
import com.actualize.mortgage.domainmodels.IntegratedDisclosureSectionSummaryDetailModel;
import com.actualize.mortgage.domainmodels.IntegratedDisclosureSectionSummaryModel;
import com.actualize.mortgage.domainmodels.IntegratedDisclosureSubsectionPaymentModel;
import com.actualize.mortgage.domainmodels.LoanEstimate;
import com.actualize.mortgage.domainmodels.MismoPaymentsModel;
import com.actualize.mortgage.domainmodels.MismoProjectedPaymentsModel;
import com.actualize.mortgage.domainmodels.PaymentsModel;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsDetails;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsPC;

/**
 * This class is perform various operations such as conversions of JSON objects to MISMO Objects
 * @author sboragala
 *
 */
public class Convertor {
	
	/**
	 * converts payment model to Fee payments for inserting into MISMO XML 
	 * @param paymentsModel
	 * @return List of MismoFeePaymentsModels
	 */
	public static List<MismoPaymentsModel> toMismoFeePayments(PaymentsModel paymentsModel, String type)
	{
		List<MismoPaymentsModel> mismoFeePaymentList = new LinkedList<>();
		
		if("FEE".equalsIgnoreCase(type))
		{
			if( null != paymentsModel.getBpAtClosing() && !"".equals(paymentsModel.getBpAtClosing()))
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getBpAtClosing());
					mismoPaymentsModel.setPaidByType("Buyer");
					mismoPaymentsModel.setClosingIndicator("false");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(null != paymentsModel.getBpB4Closing() && !"".equals(paymentsModel.getBpB4Closing()))
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getBpB4Closing());
					mismoPaymentsModel.setPaidByType("Buyer");
					mismoPaymentsModel.setClosingIndicator("true");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if( null != paymentsModel.getSpAtClosing() && !"".equals(paymentsModel.getSpAtClosing()) )
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getSpAtClosing());
					mismoPaymentsModel.setPaidByType("Seller");
					mismoPaymentsModel.setClosingIndicator("false");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if( null != paymentsModel.getSpB4Closing() && !"".equals(paymentsModel.getSpB4Closing()))
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getSpB4Closing());
					mismoPaymentsModel.setPaidByType("Seller");
					mismoPaymentsModel.setClosingIndicator("true");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if( null != paymentsModel.getPaidByOthers() && !"".equals(paymentsModel.getPaidByOthers()))
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getPaidByOthers());
					if(paymentsModel.isLenderStatus())
						mismoPaymentsModel.setPaidByType("Lender");
					else
						mismoPaymentsModel.setPaidByType("ThirdParty");
					mismoPaymentsModel.setClosingIndicator("");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
		}
		else if("ESCROW".equalsIgnoreCase(type))
		{
			if(null != paymentsModel.getBpAtClosing() && !"".equals(paymentsModel.getBpAtClosing()))
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getBpAtClosing());
					mismoPaymentsModel.setPaidByType("Buyer");
					mismoPaymentsModel.setClosingIndicator("AtClosing");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(null != paymentsModel.getBpB4Closing() && !"".equals(paymentsModel.getBpB4Closing()))
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getBpB4Closing());
					mismoPaymentsModel.setPaidByType("Buyer");
					mismoPaymentsModel.setClosingIndicator("false");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(null != paymentsModel.getSpAtClosing() && !"".equals(paymentsModel.getSpAtClosing()))
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getSpAtClosing());
					mismoPaymentsModel.setPaidByType("Seller");
					mismoPaymentsModel.setClosingIndicator("AtClosing");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(null != paymentsModel.getSpB4Closing() && !"".equals(paymentsModel.getSpB4Closing()))
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getSpB4Closing());
					mismoPaymentsModel.setPaidByType("Seller");
					mismoPaymentsModel.setClosingIndicator("false");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(null != paymentsModel.getPaidByOthers() && !"".equals(paymentsModel.getPaidByOthers()))
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getPaidByOthers());
					if(paymentsModel.isLenderStatus())
						mismoPaymentsModel.setPaidByType("Lender");
					else
						mismoPaymentsModel.setPaidByType("ThirdParty");
					mismoPaymentsModel.setClosingIndicator("");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
		}
		else if("PREPAID".equalsIgnoreCase(type))
		{
			if(null != paymentsModel.getBpAtClosing() && !"".equals(paymentsModel.getBpAtClosing()) )
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getBpAtClosing());
					mismoPaymentsModel.setPaidByType("Buyer");
					mismoPaymentsModel.setClosingIndicator("AtClosing");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(null != paymentsModel.getBpB4Closing() && !"".equals(paymentsModel.getBpB4Closing()))
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getBpB4Closing());
					mismoPaymentsModel.setPaidByType("Buyer");
					mismoPaymentsModel.setClosingIndicator("BeforeClosing");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(null != paymentsModel.getSpAtClosing() && !"".equals(paymentsModel.getSpAtClosing()))
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getSpAtClosing());
					mismoPaymentsModel.setPaidByType("Seller");
					mismoPaymentsModel.setClosingIndicator("AtClosing");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(null != paymentsModel.getSpB4Closing() && !"".equals(paymentsModel.getSpB4Closing()))
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getSpB4Closing());
					mismoPaymentsModel.setPaidByType("Seller");
					mismoPaymentsModel.setClosingIndicator("BeforeClosing");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(null != paymentsModel.getPaidByOthers() && !"".equals(paymentsModel.getPaidByOthers()))
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getPaidByOthers());
					if(paymentsModel.isLenderStatus())
						mismoPaymentsModel.setPaidByType("Lender");
					else
						mismoPaymentsModel.setPaidByType("ThirdParty");
					mismoPaymentsModel.setClosingIndicator("");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
		}
		return mismoFeePaymentList;
	}
	
	/**
	 * converts ProjectedPaymentsDetails to MismoProjectedPaymentsModel
	 * @param projectedPayments
	 * @return list of MismoProjectedPaymentsModel 
	 */
	public static List<MismoProjectedPaymentsModel> createMismoProjectedPayments(ProjectedPaymentsDetails projectedPayments)
	{
		List<MismoProjectedPaymentsModel> mismoProjectedPaymentsModels = new LinkedList<>();
		
		for(ProjectedPaymentsPC projectedPaymentsPC : projectedPayments.getPaymentCalculation())
		{
			MismoProjectedPaymentsModel mismoProjectedPaymentsModel = new MismoProjectedPaymentsModel();
				mismoProjectedPaymentsModel.setPaymentFrequencyType(projectedPayments.getPaymentFrequencyType());
				mismoProjectedPaymentsModel.setProjectedPaymentCalculationPeriodEndNumber(projectedPaymentsPC.getProjectedPaymentCalculationPeriodEndNumber());
				mismoProjectedPaymentsModel.setProjectedPaymentCalculationPeriodStartNumber(projectedPaymentsPC.getProjectedPaymentCalculationPeriodStartNumber());
				mismoProjectedPaymentsModel.setSequenceNumber(projectedPaymentsPC.getSequenceNumber());
				mismoProjectedPaymentsModel.setProjectedPaymentCalculationPeriodTermType(projectedPaymentsPC.getProjectedPaymentCalculationPeriodTermType());
				mismoProjectedPaymentsModel.setProjectedPaymentCalculationPeriodTermTypeOtherDescription(projectedPaymentsPC.getProjectedPaymentCalculationPeriodTermTypeOtherDescription());				
			mismoProjectedPaymentsModels.add(mismoProjectedPaymentsModel);
		}
		
		for(int i=0; i<projectedPayments.getPrincipalInterest().size(); i++)
		{
			mismoProjectedPaymentsModels.get(i).setProjectedPaymentPrincipalAndInterestMaximumPaymentAmount(projectedPayments.getPrincipalInterest().get(i).getProjectedPaymentPrincipalAndInterestMaximumPaymentAmount());
			mismoProjectedPaymentsModels.get(i).setProjectedPaymentPrincipalAndInterestMinimumPaymentAmount(projectedPayments.getPrincipalInterest().get(i).getProjectedPaymentPrincipalAndInterestMinimumPaymentAmount());
		}
		
		for(int i=0; i<projectedPayments.getMortgageInsurance().size(); i++)
			mismoProjectedPaymentsModels.get(i).setProjectedPaymentMIPaymentAmount(projectedPayments.getMortgageInsurance().get(i).getProjectedPaymentMIPaymentAmount());
		
		for(int i=0; i<projectedPayments.getEstimatedEscrow().size(); i++)
			mismoProjectedPaymentsModels.get(i).setProjectedPaymentEstimatedEscrowPaymentAmount(projectedPayments.getEstimatedEscrow().get(i).getProjectedPaymentEstimatedEscrowPaymentAmount());
		
		for(int i=0; i<projectedPayments.getEstimatedTotal().size(); i++)
		{
			mismoProjectedPaymentsModels.get(i).setProjectedPaymentEstimatedTotalMaximumPaymentAmount(projectedPayments.getEstimatedTotal().get(i).getProjectedPaymentEstimatedTotalMaximumPaymentAmount());
			mismoProjectedPaymentsModels.get(i).setProjectedPaymentEstimatedTotalMinimumPaymentAmount(projectedPayments.getEstimatedTotal().get(i).getProjectedPaymentEstimatedTotalMinimumPaymentAmount());
		}
		
		return mismoProjectedPaymentsModels;
	}
	
	/**
	 * calculates IntegratedDisclosureSectionSummaryModels to insert into MISMO XML
	 * @param json
	 * @return list of IntegratedDisclosureSectionSummaryModel
	 */
	public static List<IntegratedDisclosureSectionSummaryModel> createIntegratedDisclosureSectionSummaryModels(LoanEstimate json)
	{
		List<IntegratedDisclosureSectionSummaryModel> integratedDisclosureSectionSummaryModels = new LinkedList<>();
		
		if(null != json.getClosingCostDetailsLoanCosts().getOcTotalAmount() && !"".equals(json.getClosingCostDetailsLoanCosts().getOcTotalAmount()))
		{
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
			
			integratedDisclosureSectionSummaryModel = createIntegratedDisclosureSectionSummaryModel(json.getClosingCostDetailsLoanCosts().getOcTotalAmount(), "OriginationCharges", "", 
					"", false, null);			
			
			integratedDisclosureSectionSummaryModels.add(integratedDisclosureSectionSummaryModel);
		}
		
		if(null != json.getClosingCostDetailsLoanCosts().getSbDidShopTotalAmount() && !"".equals(json.getClosingCostDetailsLoanCosts().getSbDidShopTotalAmount()))
		{
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
			
			integratedDisclosureSectionSummaryModel = createIntegratedDisclosureSectionSummaryModel(json.getClosingCostDetailsLoanCosts().getSbDidShopTotalAmount(),
			"ServicesBorrowerDidShopFor", "","", false, null);			
			
			integratedDisclosureSectionSummaryModels.add(integratedDisclosureSectionSummaryModel);
		}
		
		if(null != json.getClosingCostDetailsLoanCosts().getSbDidNotShopTotalAmount() && !"".equals(json.getClosingCostDetailsLoanCosts().getSbDidNotShopTotalAmount()))
		{
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
			
			integratedDisclosureSectionSummaryModel = createIntegratedDisclosureSectionSummaryModel(json.getClosingCostDetailsLoanCosts().getSbDidNotShopTotalAmount(),
			"ServicesBorrowerDidNotShopFor", "","", false, null);			
			
			integratedDisclosureSectionSummaryModels.add(integratedDisclosureSectionSummaryModel);
		}
		
		if(null != json.getClosingCostDetailsLoanCosts().getTlCostsTotalAmount() && !"".equals(json.getClosingCostDetailsLoanCosts().getTlCostsTotalAmount()))
		{
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
			
			
			integratedDisclosureSectionSummaryModel = createIntegratedDisclosureSectionSummaryModel(json.getClosingCostDetailsLoanCosts().getTlCostsTotalAmount(),
			"TotalLoanCosts", "","LoanCostsSubtotal", true, json.getClosingCostDetailsLoanCosts().getTlCosts());			
			
			integratedDisclosureSectionSummaryModels.add(integratedDisclosureSectionSummaryModel);
		}
		
		if(null != json.getClosingCostDetailsOtherCosts().gettOGovtFeesTotalAmount() && !"".equals(json.getClosingCostDetailsOtherCosts().gettOGovtFeesTotalAmount()))
		{
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
						
			integratedDisclosureSectionSummaryModel = createIntegratedDisclosureSectionSummaryModel(json.getClosingCostDetailsOtherCosts().gettOGovtFeesTotalAmount(),
			"TaxesAndOtherGovernmentFees", "","", false, null);		
			
			integratedDisclosureSectionSummaryModels.add(integratedDisclosureSectionSummaryModel);
		}
		
		if(null != json.getClosingCostDetailsOtherCosts().getPrepaidsTotalAmount() && !"".equals(json.getClosingCostDetailsOtherCosts().getPrepaidsTotalAmount()))
		{
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
						
			integratedDisclosureSectionSummaryModel = createIntegratedDisclosureSectionSummaryModel(json.getClosingCostDetailsOtherCosts().getPrepaidsTotalAmount(),
			"Prepaids", "","", false, null);		
			
			integratedDisclosureSectionSummaryModels.add(integratedDisclosureSectionSummaryModel);
		}
		
		if(null != json.getClosingCostDetailsOtherCosts().getEscrowItemsTotalAmount() && !"".equals(json.getClosingCostDetailsOtherCosts().getEscrowItemsTotalAmount()))
		{
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
			IntegratedDisclosureSectionSummaryDetailModel integratedDisclosureSectionSummaryDetailModel = new IntegratedDisclosureSectionSummaryDetailModel();
						
			integratedDisclosureSectionSummaryModel = createIntegratedDisclosureSectionSummaryModel(json.getClosingCostDetailsOtherCosts().getEscrowItemsTotalAmount(),
			"InitialEscrowPaymentAtClosing", "","", false, null);		
			
			integratedDisclosureSectionSummaryModels.add(integratedDisclosureSectionSummaryModel);
		}
		
		if(null != json.getClosingCostDetailsOtherCosts().getOtherTotalAmount() && !"".equals(json.getClosingCostDetailsOtherCosts().getOtherTotalAmount()))
		{
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
			
			integratedDisclosureSectionSummaryModel = createIntegratedDisclosureSectionSummaryModel(json.getClosingCostDetailsOtherCosts().getOtherTotalAmount(),
			"OtherCosts", "","", false, null);		
			
			integratedDisclosureSectionSummaryModels.add(integratedDisclosureSectionSummaryModel);
		}
		
		if(null != json.getClosingCostDetailsOtherCosts().getTotalOtherCostsTotalAmount() && !"".equals(json.getClosingCostDetailsOtherCosts().getTotalOtherCostsTotalAmount()))
		{
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
			
			integratedDisclosureSectionSummaryModel = createIntegratedDisclosureSectionSummaryModel(json.getClosingCostDetailsOtherCosts().getTotalOtherCostsTotalAmount(),
			"TotalOtherCosts", "","OtherCostsSubtotal", true, json.getClosingCostDetailsOtherCosts().getTotalOtherCosts());
			
			integratedDisclosureSectionSummaryModels.add(integratedDisclosureSectionSummaryModel);
		}
		
		
		//ClosingCostsTotal
		if(null != json.getClosingCostsTotal().getTotalClosingCosts() && !"".equals(json.getClosingCostsTotal().getTotalClosingCosts()))
		{
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
			
			integratedDisclosureSectionSummaryModel = createIntegratedDisclosureSectionSummaryModel(json.getClosingCostsTotal().getTotalClosingCosts(),
			"TotalClosingCosts", "","ClosingCostsSubtotal", true, json.getClosingCostsTotal().getClosingCostsSubtotal());
			
			integratedDisclosureSectionSummaryModels.add(integratedDisclosureSectionSummaryModel);
		}
		
		if(null != json.getClosingCostsTotal().getLenderCredits() && !"".equals(json.getClosingCostsTotal().getLenderCredits()))
		{
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
			PaymentsModel lenderCredits = new PaymentsModel();
				lenderCredits.setBpAtClosing(json.getClosingCostsTotal().getLenderCredits());
			
			integratedDisclosureSectionSummaryModel = createIntegratedDisclosureSectionSummaryModel("",
			"TotalClosingCosts", "","LenderCredits", true, lenderCredits);
			
			integratedDisclosureSectionSummaryModel.getIntegratedDisclosureSectionSummaryDetailModel()
				.setLenderCreditToleranceCureAmount(json.getClosingCostsTotal().getLenderCreditToleranceCureAmount());
			
			integratedDisclosureSectionSummaryModels.add(integratedDisclosureSectionSummaryModel);
		}
		
		if(null != json.getSummariesofTransactions().getBorrowerTransaction().getPaidAlreadyByOrOnBehalfOfBorrowerAtClosing().
			getIntegratedDisclosureSectionSummaryDetailModel().getIntegratedDisclosureSectionTotalAmount()
				&& !"".equals(json.getSummariesofTransactions().getBorrowerTransaction().getPaidAlreadyByOrOnBehalfOfBorrowerAtClosing()
						.getIntegratedDisclosureSectionSummaryDetailModel().getIntegratedDisclosureSectionTotalAmount()))
			integratedDisclosureSectionSummaryModels.add(json.getSummariesofTransactions().getBorrowerTransaction().getPaidAlreadyByOrOnBehalfOfBorrowerAtClosing());

		if(!"".equals(json.getSummariesofTransactions().getBorrowerTransaction().getDueFromBorrowerAtClosing()
			.getIntegratedDisclosureSectionSummaryDetailModel().getIntegratedDisclosureSectionTotalAmount()) 
				&& null != json.getSummariesofTransactions().getBorrowerTransaction().getDueFromBorrowerAtClosing()
						.getIntegratedDisclosureSectionSummaryDetailModel().getIntegratedDisclosureSectionTotalAmount())
			integratedDisclosureSectionSummaryModels.add(json.getSummariesofTransactions().getBorrowerTransaction().getDueFromBorrowerAtClosing());	
		
		
		if(!"".equals(json.getSummariesofTransactions().getSellerTransaction().getFromSellerAtClosing()
				.getIntegratedDisclosureSectionSummaryDetailModel().getIntegratedDisclosureSectionTotalAmount()) 
					&& null != json.getSummariesofTransactions().getBorrowerTransaction().getPaidAlreadyByOrOnBehalfOfBorrowerAtClosing()
							.getIntegratedDisclosureSectionSummaryDetailModel().getIntegratedDisclosureSectionTotalAmount())
			integratedDisclosureSectionSummaryModels.add(json.getSummariesofTransactions().getSellerTransaction().getFromSellerAtClosing());

		if(!"".equals(json.getSummariesofTransactions().getSellerTransaction().getToSellerAtClosing()
			.getIntegratedDisclosureSectionSummaryDetailModel().getIntegratedDisclosureSectionTotalAmount()) 
				&& null != json.getSummariesofTransactions().getBorrowerTransaction().getDueFromBorrowerAtClosing()
						.getIntegratedDisclosureSectionSummaryDetailModel().getIntegratedDisclosureSectionTotalAmount())
			integratedDisclosureSectionSummaryModels.add(json.getSummariesofTransactions().getSellerTransaction().getToSellerAtClosing());	
		
		if(null != json.getPayoffsAndPayments() && null != json.getPayoffsAndPayments().getIntegratedDisclosureSectionSummary().getIntegratedDisclosureSectionSummaryDetailModel().getIntegratedDisclosureSectionTotalAmount()
					&& !json.getPayoffsAndPayments().getIntegratedDisclosureSectionSummary().getIntegratedDisclosureSectionSummaryDetailModel().getIntegratedDisclosureSectionTotalAmount().isEmpty())
		{
			integratedDisclosureSectionSummaryModels.add(json.getPayoffsAndPayments().getIntegratedDisclosureSectionSummary());
		}
		
		return integratedDisclosureSectionSummaryModels;
	}
	
	
	private static IntegratedDisclosureSectionSummaryModel createIntegratedDisclosureSectionSummaryModel(String secAmount, String sectionType, String subAmount, String subSectionType, boolean hasPayments, PaymentsModel paymentsModel)
	{
		IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
		IntegratedDisclosureSectionSummaryDetailModel integratedDisclosureSectionSummaryDetail = new IntegratedDisclosureSectionSummaryDetailModel();
		List<IntegratedDisclosureSubsectionPaymentModel> integratedDisclosureSubsectionPaymentModels = new LinkedList<>();
		
		integratedDisclosureSectionSummaryDetail.setIntegratedDisclosureSectionTotalAmount(secAmount);
		integratedDisclosureSectionSummaryDetail.setIntegratedDisclosureSectionType(sectionType);
		integratedDisclosureSectionSummaryDetail.setIntegratedDisclosureSubsectionTotalAmount(subAmount);
		integratedDisclosureSectionSummaryDetail.setIntegratedDisclosureSubsectionType(subSectionType);
		
		if(hasPayments)
		{
			List<MismoPaymentsModel> mismoPaymentsModels = toMismoFeePayments(paymentsModel, "PREPAID");
			for(MismoPaymentsModel payment : mismoPaymentsModels)
			{
				IntegratedDisclosureSubsectionPaymentModel integratedDisclosureSubsectionPayment = new IntegratedDisclosureSubsectionPaymentModel();
					integratedDisclosureSubsectionPayment.setIntegratedDisclosureSubsectionPaidByType(payment.getPaidByType());
					integratedDisclosureSubsectionPayment.setIntegratedDisclosureSubsectionPaymentAmount(payment.getAmount());
					integratedDisclosureSubsectionPayment.setIntegratedDisclosureSubsectionPaymentTimingType(payment.getClosingIndicator());
				
			   integratedDisclosureSubsectionPaymentModels.add(integratedDisclosureSubsectionPayment);
			}
			integratedDisclosureSectionSummaryModel.setIntegratedDisclosureSubsectionPayments(integratedDisclosureSubsectionPaymentModels);
		}
		integratedDisclosureSectionSummaryModel.setIntegratedDisclosureSectionSummaryDetailModel(integratedDisclosureSectionSummaryDetail);
		
		return integratedDisclosureSectionSummaryModel;
	}
	
	/**
	 * checks for null and empty
	 * @param amount
	 * @return boolean
	 */
	public static boolean checkNotNull(String amount)
	{
		if(null != amount && !amount.isEmpty() && !"0".equalsIgnoreCase(amount) && !"0.00".equalsIgnoreCase(amount))
			return true;
		return false;
	}
	
	public static String booleanToString(boolean status)
	{
		if(status)
			return "true";
		return "false";
	}
	
	public static boolean stringToBoolean(String status)
	{
		if(status.equalsIgnoreCase("true"))
			return true;
		return false;
	}
	
	public int convertYearsToMonthsFormat(String yearsdata){
		if(null != yearsdata || "".equals(yearsdata.trim()))
		{
			String[] years = yearsdata.split(" ");
			int month = Math.round(Integer.parseInt(years[0])*12);
	        return month;
		}
		
			return 0;        
	}
	
	/**
	 * get the current date and time with UTC time zone formatted as yyyy-MM-dd'T'HH:mm:ss.SSS'Z
	 * @return date as String 
	 */
	public static String getUTCDate()
	{
		Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        return formatter.format(date);  
		
	}
	
	/**
	 * checks whether to insert payments section to MISMO XML
	 * @param payment
	 * @return boolean
	 */
	public static boolean isInsertFee(PaymentsModel payment)
	{
		if(null != payment.getBpAtClosing() && !payment.getBpAtClosing().isEmpty())
			return true;
		else if(null != payment.getBpB4Closing() && !payment.getBpB4Closing().isEmpty())
			return true;
		else if(null != payment.getSpAtClosing() && !payment.getSpAtClosing().isEmpty())
			return true;
		else if(null != payment.getSpB4Closing() && !payment.getSpB4Closing().isEmpty())
			return true;
		else if(null != payment.getPaidByOthers() && !payment.getPaidByOthers().isEmpty())
			return true;
		return false;
	}
	
	/**
	 * to get the sequence number for specific party depending up on it's role and type
	 * @param partyRole type of the party borrower, seller etc., 
	 * @param partyType Organisation or individual
	 * @param reType type of real estate agent 
	 * @return the repsective Xlink label for specific party
	 */
	public static String getSNumber(String partyRole, String partyType, String reType)
	{
		if("NotePayTo".equalsIgnoreCase(partyRole))
		{
			if("O".equalsIgnoreCase(partyType))
				return "1";
			else if("I".equalsIgnoreCase(partyType))
				return "2";
		}
		else if("MortgageBroker".equalsIgnoreCase(partyRole))
		{
			if("O".equalsIgnoreCase(partyType))
				return "3";
			else if("I".equalsIgnoreCase(partyType))
				return "4";
		}
		else if("RealEstateAgent".equalsIgnoreCase(partyRole))
		{
			if("Selling".equalsIgnoreCase(reType))
			{
				if("O".equalsIgnoreCase(partyType))
					return "5";
				else if("I".equalsIgnoreCase(partyType))
					return "6";
			}
			else if("Listing".equalsIgnoreCase(reType))
			{
				if("O".equalsIgnoreCase(partyType))
					return "7";
				else if("I".equalsIgnoreCase(partyType))
					return "8";
			}
		}
		else if("ClosingAgent".equalsIgnoreCase(partyRole))
		{
			if("O".equalsIgnoreCase(partyType))
				return "9";
			else if("I".equalsIgnoreCase(partyType))
				return "10";
		}
		
		return "";
	}
	
	/**
	 * to get the xlink label for specific party depending up on it's role and type
	 * @param partyRole type of the party borrower, seller etc., 
	 * @param partyType Organisation or individual
	 * @param reType type of real estate agent 
	 * @return the repsective Xlink label for specific party
	 */
	public static String getXLink(String partyRole, String partyType, String reType)
	{
		if("NotePayTo".equalsIgnoreCase(partyRole))
		{
			if("O".equalsIgnoreCase(partyType))
				return "PARTY1_ROLE1";
			else if("I".equalsIgnoreCase(partyType))
				return "PARTY2_ROLE1";
		}
		else if("MortgageBroker".equalsIgnoreCase(partyRole))
		{
			if("O".equalsIgnoreCase(partyType))
				return "PARTY3_ROLE1";
			else if("I".equalsIgnoreCase(partyType))
				return "PARTY4_ROLE1";
		}
		else if("RealEstateAgent".equalsIgnoreCase(partyRole))
		{
			if("Selling".equalsIgnoreCase(reType))
			{
				if("O".equalsIgnoreCase(partyType))
					return "PARTY5_ROLE1";
				else if("I".equalsIgnoreCase(partyType))
					return "PARTY6_ROLE1";
			}
			else if("Listing".equalsIgnoreCase(reType))
			{
				if("O".equalsIgnoreCase(partyType))
					return "PARTY7_ROLE1";
				else if("I".equalsIgnoreCase(partyType))
					return "PARTY8_ROLE1";
			}
		}
		else if("ClosingAgent".equalsIgnoreCase(partyRole))
		{
			if("O".equalsIgnoreCase(partyType))
				return "PARTY9_ROLE1";
			else if("I".equalsIgnoreCase(partyType))
				return "PARTY10_ROLE1";
		}
		
		return "";
	}
	
	/**
	 * checks for null of Fee Actual Total Amount
	 * @param closingCostProperties
	 * @return boolean
	 */
	public static boolean checkFeeActualTotalAmount(ClosingCostProperties closingCostProperties)
	{
		if(isInsertFee(closingCostProperties))
			return true;
		else if(checkNotNull(closingCostProperties.getFeeActualTotalAmount()))
			return true;
		return false;
	}
}
