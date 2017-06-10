package com.actualize.mortgage.services;

import java.io.InputStream;

import com.actualize.mortgage.domainmodels.LoanEstimateDocument;
/**
 * This class defines all the services required to prepare, plot and generate XML and PDF for loan Estimate
 * @author sboragala
 *
 */
public interface LoanEstimateServices {
	
	public LoanEstimateDocument createLoanEstimateDocumentObjectfromXMLDoc(InputStream inputXmlStream) throws Exception;
	
}
