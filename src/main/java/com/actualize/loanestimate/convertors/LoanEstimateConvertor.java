package com.actualize.loanestimate.convertors;

import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.loanestimate.datamodels.Address;
import com.actualize.loanestimate.datamodels.Construction;
import com.actualize.loanestimate.datamodels.Deal;
import com.actualize.loanestimate.datamodels.Document;
import com.actualize.loanestimate.datamodels.IntegratedDisclosureDetail;
import com.actualize.loanestimate.datamodels.LegalEntityDetail;
import com.actualize.loanestimate.datamodels.LoanDetail;
import com.actualize.loanestimate.datamodels.LoanIdentifier;
import com.actualize.loanestimate.datamodels.Locks;
import com.actualize.loanestimate.datamodels.MISMODocument;
import com.actualize.loanestimate.datamodels.MaturityRule;
import com.actualize.loanestimate.datamodels.Name;
import com.actualize.loanestimate.datamodels.Parties;
import com.actualize.loanestimate.datamodels.PropertyDetail;
import com.actualize.loanestimate.datamodels.PropertyValuationDetail;
import com.actualize.loanestimate.datamodels.SalesContractDetail;
import com.actualize.loanestimate.datamodels.TermsOfLoan;
import com.actualize.loanestimate.domainmodels.LoanEstimateDocument;
import com.actualize.loanestimate.domainmodels.LoanEstimatePageOne;
import com.actualize.loanestimate.domainmodels.LoanEstimateSection;
import com.actualize.loanestimate.domainmodels.LoanEstimateSectionBorrower;
import com.actualize.loanestimate.domainmodels.LoanEstimateSectionRateLock;
import com.actualize.loanestimate.domainmodels.NameModel;
import com.actualize.mortgage.utils.Formatter;
import com.actualize.mortgage.utils.StringFormatter;


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
	public LoanEstimateDocument convertXmltoJSON(MISMODocument mismodoc) throws Exception
	{
		LoanEstimateDocument loanEstimateDocument = new LoanEstimateDocument();
		LoanEstimatePageOne loanEstimatePageOne = new LoanEstimatePageOne();
			loanEstimatePageOne.setLoanEstimateSection(createLoanEstimateSection(mismodoc));
			loanEstimateDocument.setLoanEstimatePageOne(loanEstimatePageOne);
		return loanEstimateDocument;
	}
	
	/**
	 * creates loan estimate section 
	 * @param deal
	 * @return
	 * @throws Exception
	 */
	private LoanEstimateSection createLoanEstimateSection(MISMODocument mismodoc) throws Exception {
			
		LoanEstimateSection loanEstimateSection = new LoanEstimateSection();
		Document document = null;
		NodeList nodes = mismodoc.getElementsAddNS("//DOCUMENT");
        if (nodes.getLength() > 0)
            document = new Document(Document.NS, (Element)nodes.item(0));
        Deal deal = new Deal(Deal.NS, (Element)document.getElementAddNS("DEAL_SETS/DEAL_SET/DEALS/DEAL"));
		
		// Data query helper strings
		String loan = "LOANS/LOAN";
		String lender = "PARTIES/PARTY[ROLES/ROLE/ROLE_DETAIL/PartyRoleType='NotePayTo'][LEGAL_ENTITY]";
		String subjectProperty = "COLLATERALS/COLLATERAL/SUBJECT_PROPERTY";
		String propertyValuation = subjectProperty + "/PROPERTY_VALUATIONS/PROPERTY_VALUATION";
		String salesContract = subjectProperty + "/SALES_CONTRACTS/SALES_CONTRACT";
		// Data containers
		Address lenderAddress = new Address((Element)deal.getElementAddNS(lender + "/ADDRESSES/ADDRESS[AddressType='Mailing']"));
		Address propertyAddress = new Address((Element)deal.getElementAddNS(subjectProperty + "/ADDRESS"));
		Parties borrowerParties = new Parties((Element)deal.getElementAddNS("PARTIES"), "[ROLES/ROLE/ROLE_DETAIL/PartyRoleType='Borrower']");
		Construction construction = new Construction((Element)deal.getElementAddNS(loan + "/CONSTRUCTION"));
		IntegratedDisclosureDetail idDetail = new IntegratedDisclosureDetail((Element)deal.getElementAddNS(loan + "/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_DETAIL"));
		LegalEntityDetail lenderDetail = new LegalEntityDetail((Element)deal.getElementAddNS(lender + "/LEGAL_ENTITY/LEGAL_ENTITY_DETAIL"));
		LoanDetail loanDetail = new LoanDetail((Element)deal.getElementAddNS(loan + "/LOAN_DETAIL"));
		LoanIdentifier loanIdentifier = new LoanIdentifier((Element)deal.getElementAddNS(loan + "/LOAN_IDENTIFIERS/LOAN_IDENTIFIER[LoanIdentifierType='LenderLoan']"));
		Locks locks = new Locks((Element)deal.getElementAddNS(loan + "/LOAN_PRODUCT/LOCKS"));
		MaturityRule maturityRule = new MaturityRule((Element)deal.getElementAddNS(loan + "/MATURITY/MATURITY_RULE[LoanMaturityPeriodType='Month']"));
		PropertyDetail propertyDetail = new PropertyDetail((Element)deal.getElementAddNS(subjectProperty + "/PROPERTY_DETAIL"));
		PropertyValuationDetail propertyValuationDetail = new PropertyValuationDetail((Element)deal.getElementAddNS(propertyValuation + "/PROPERTY_VALUATION_DETAIL"));
		SalesContractDetail salesContractDetail = new SalesContractDetail((Element)deal.getElementAddNS(salesContract + "/SALES_CONTRACT_DETAIL"));
		TermsOfLoan loanTerms = new TermsOfLoan((Element)deal.getElementAddNS(loan + "/TERMS_OF_LOAN"));
		String loanType = loanTerms.mortgageType;
		
		loanEstimateSection.setLenderFullName(StringFormatter.STRINGCLEAN.formatString(lenderDetail.fullName));
		loanEstimateSection.setLenderAddress(toAddressModel(lenderAddress));
		loanEstimateSection.setDateIssued(Formatter.DATE.format(idDetail.IntegratedDisclosureIssuedDate));
		loanEstimateSection.setApplicants(applicants(borrowerParties));
		loanEstimateSection.setEstimatedPropValue(Formatter.ZEROTRUNCDOLLARS.format(salePrice(loanTerms, salesContractDetail, propertyValuationDetail, propertyDetail)));
		loanEstimateSection.setLoanTerm(Formatter.YEARSMONTHS.format(loanTerm(loanDetail, maturityRule, construction)));
		loanEstimateSection.setPurpose(loanTerms.loanPurposeType);
		loanEstimateSection.setProduct(idDetail.IntegratedDisclosureLoanProductDescription);
		loanEstimateSection.setLoanType("Other".equalsIgnoreCase(loanType) ? loanTerms.mortgageTypeOtherDescription :loanType);
		loanEstimateSection.setLoanId(loanIdentifier.LoanIdentifier);
		loanEstimateSection.setProperty(toAddressModel(propertyAddress));
		loanEstimateSection.setLoanEstimateSectionRateLock(rateLock(locks, idDetail));
		return loanEstimateSection;

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
			if (propertyValuationDetail.PropertyValuationAmount.equals(""))
				return propertyDetail.PropertyEstimatedValueAmount;
			else
				return propertyValuationDetail.PropertyValuationAmount;		
		if (salesContractDetail.PersonalPropertyIncludedIndicator.equalsIgnoreCase("true"))
			return salesContractDetail.RealPropertyAmount;
		return salesContractDetail.SalesContractAmount;
	}
	
	/**
	 * fetch the Name Model from XML
	 * @param name
	 * @return name detail
	 */
	private static NameModel toNameModel(Name name) {
		NameModel nameModel = new NameModel();
		
		if (!name.FullName.equals(""))
			nameModel.setFullName(name.FullName);
		if (!name.MiddleName.equals("")) 
			nameModel.setMiddleName(name.MiddleName);
		if (!name.LastName.equals("")) 
			nameModel.setLastName(name.LastName);
		if (!name.SuffixName.equals("")) 
			nameModel.setSuffixName(name.SuffixName);
		
		return nameModel;
	}
	
	/**
	 * fetch the address model from XML
	 * @param address
	 * @return address Model
	 */
	private static com.actualize.loanestimate.domainmodels.Address toAddressModel(Address address) {
	com.actualize.loanestimate.domainmodels.Address addressModel = new com.actualize.loanestimate.domainmodels.Address();
		
		if (!address.CityName.equals(""))
			addressModel.setCityName(address.CityName);
		if (!address.AddressLineText.equals(""))
			addressModel.setAddressLineText(address.AddressLineText);
		if (!address.StateCode.equals(""))
			addressModel.setStateCode(address.StateCode);
		if (!address.PostalCode.equals("")) 
			addressModel.setPostalCode(address.PostalCode);
		
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
			if (construction.ConstructionLoanType.equalsIgnoreCase("ConstructionOnly"))
				return construction.ConstructionPeriodNumberOfMonthsCount;
			return construction.ConstructionLoanTotalTermMonthsCount;
		}
		return maturityRule.LoanMaturityPeriodCount;
	}
	
	/**
	 * fetches the list of borrowers from the XMl 
	 * @param borrowers
	 * @return borrowers List
	 */
	private static List<LoanEstimateSectionBorrower> applicants(Parties borrowers) {
		
		List<LoanEstimateSectionBorrower> loanEstimateSectionBorrowers = new LinkedList<>();
		if (borrowers.parties.length > 0) {
			LoanEstimateSectionBorrower loanEstimateSectionBorrower = new LoanEstimateSectionBorrower();
			NameModel applicant = new NameModel();
			com.actualize.loanestimate.domainmodels.Address addressModel = new com.actualize.loanestimate.domainmodels.Address();
			if (!borrowers.parties[0].legalEntity.legalEntityDetail.fullName.equals(""))
				applicant.setFullName(borrowers.parties[0].legalEntity.legalEntityDetail.fullName);
			else
				applicant = toNameModel(borrowers.parties[0].individual.name);
			addressModel = toAddressModel(new Address((Element)borrowers.parties[0].getElementAddNS("ADDRESSES/ADDRESS[AddressType='Mailing']")));
			loanEstimateSectionBorrower.setName(applicant);
			loanEstimateSectionBorrower.setAddress(addressModel);
			loanEstimateSectionBorrowers.add(loanEstimateSectionBorrower);
			}
		return loanEstimateSectionBorrowers;
	}
	
	/**
	 * calculates the rateLock
	 * @param locks
	 * @param idDetail
	 * @return LoanEstimateSectionRateLock object
	 */
	public static LoanEstimateSectionRateLock rateLock(Locks locks, IntegratedDisclosureDetail idDetail) {
	
		LoanEstimateSectionRateLock loanEstimateSectionRateLock = new LoanEstimateSectionRateLock();
		// Get lock date/time
		String time = "";
		String timezone = "";
		if (locks.locks.length > 0)
			if (locks.locks[locks.locks.length - 1].LockStatusType.equalsIgnoreCase("Locked")) {
				loanEstimateSectionRateLock.setUntillDate(Formatter.DATETIME.format(locks.locks[locks.locks.length - 1].LockExpirationDatetime)) ;
				loanEstimateSectionRateLock.setUntillTimeZone(locks.locks[locks.locks.length - 1].extension.other.LockExpirationTimezoneType);
			}
	
		// Build first line
		time = loanEstimateSectionRateLock.getExpireDate();
		if (("").equals(time))
			loanEstimateSectionRateLock.setRateLock("false");
		else
			loanEstimateSectionRateLock.setRateLock("true");
	
		
		// Append subsequent lines
		timezone = idDetail.extension.other.IntegratedDisclosureEstimatedClosingCostsExpirationTimezoneType;
		String formattedTimezone = timezone.equals("") ? "" : (" " + timezone);
			loanEstimateSectionRateLock.setExpireDate(Formatter.DATE.format(idDetail.IntegratedDisclosureEstimatedClosingCostsExpirationDatetime));
			loanEstimateSectionRateLock.setExpireTime(Formatter.TIME.format(idDetail.IntegratedDisclosureEstimatedClosingCostsExpirationDatetime));
			loanEstimateSectionRateLock.setExpireTimeZone(formattedTimezone);
	
		return loanEstimateSectionRateLock;
	}
	
		
}
