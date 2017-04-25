package com.actualize.loanestimate.services.impl;

import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.actualize.loanestimate.convertors.LoanEstimateConvertor;
import com.actualize.loanestimate.datamodels.MISMODocument;
import com.actualize.loanestimate.domainmodels.LoanEstimateDocument;
import com.actualize.loanestimate.services.LoanEstimateServices;
/**
 * This class implements all the services required to prepare, plot and generate XML and PDF for loan Estimate
 * @author sboragala
 *
 */
public class LoanEstimateServicesImpl implements LoanEstimateServices {
	
	private static final Logger LOG = LogManager.getLogger(LoanEstimateServicesImpl.class);

	/*
	 * (non-Javadoc)
	 * @see com.actualize.mortgage.leservices.LoanEstimateServices#createLoanEstimateDocumentObjectfromXMLDoc(java.io.InputStream)
	 */
	@Override
	public LoanEstimateDocument createLoanEstimateDocumentObjectfromXMLDoc(InputStream inputXmlStream)
			throws Exception {
			MISMODocument document = new MISMODocument(inputXmlStream); 
			LoanEstimateConvertor loanEstimateConvertor = new LoanEstimateConvertor();
			LoanEstimateDocument loanEstimateDocument = loanEstimateConvertor.convertXmltoJSON(document);	
		return loanEstimateDocument;
	}

	
	
}
