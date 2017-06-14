package com.actualize.mortgage.services.impl;

import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.actualize.mortgage.convertors.LoanEstimateConvertor;
import com.actualize.mortgage.datamodels.MISMODocument;
import com.actualize.mortgage.domainmodels.LoanEstimate;
/**
 * This class implements all the services required to prepare, plot and generate XML and PDF for loan Estimate
 * @author sboragala
 *
 */
public class LoanEstimateServicesImpl {
	
	private static final Logger LOG = LogManager.getLogger(LoanEstimateServicesImpl.class);

	/*
	 * (non-Javadoc)
	 * @see com.actualize.mortgage.leservices.LoanEstimateServices#createLoanEstimateDocumentObjectfromXMLDoc(java.io.InputStream)
	 */
	//@Override
	public LoanEstimate createLoanEstimateDocumentObjectfromXMLDoc(InputStream inputXmlStream)
			throws Exception {
			MISMODocument document = new MISMODocument(inputXmlStream); 
			LoanEstimateConvertor loanEstimateConvertor = new LoanEstimateConvertor();
			LoanEstimate loanEstimateDocument = loanEstimateConvertor.convertXmltoJSON(document);	
		return loanEstimateDocument;
	}

	
	
}
