package com.actualize.mortgage.services.impl;

import java.io.InputStream;

import com.actualize.mortgage.domainmodels.LoanEstimate;

public interface ILoanEstimateServices {

	/**
	 * create loan estimate Dom from XML
	 * @param inputXmlStream
	 * @return
	 * @throws Exception
	 */
	public LoanEstimate createLoanEstimateDocumentObjectfromXMLDoc(InputStream inputXmlStream) throws Exception;
	
	/**
	 * create loan estimate XML from JSON
	 * @param loanEstimateJSON
	 * @return
	 * @throws Exception
	 */
	public String createLoanEstimateXMLfromObject(LoanEstimate loanEstimateJSON) throws Exception;
}
