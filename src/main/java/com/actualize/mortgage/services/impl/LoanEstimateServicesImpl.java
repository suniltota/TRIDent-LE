package com.actualize.mortgage.services.impl;

import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.actualize.mortgage.convertors.LoanEstimateConvertor;
import com.actualize.mortgage.datamodels.MISMODocument;
import com.actualize.mortgage.domainmodels.LoanEstimate;
import com.actualize.mortgage.utils.JsonToUcd;
/**
 * This class implements all the services required to prepare, plot and generate XML and PDF for loan Estimate
 * @author sboragala
 *
 */
@Service
public class LoanEstimateServicesImpl {
	
	private static final Logger LOG = LogManager.getLogger(LoanEstimateServicesImpl.class);

	
	public LoanEstimate createLoanEstimateDocumentObjectfromXMLDoc(InputStream inputXmlStream)
			throws Exception {
			MISMODocument document = new MISMODocument(inputXmlStream); 
			LoanEstimateConvertor loanEstimateConvertor = new LoanEstimateConvertor();
			LoanEstimate loanEstimateDocument = loanEstimateConvertor.convertXmltoJSON(document);	
		return loanEstimateDocument;
	}

	public String createLoanEstimateXMLfromObject(LoanEstimate loanEstimateJSON) throws Exception {
		JsonToUcd jsonToUcd = new JsonToUcd();
		return jsonToUcd.transform(loanEstimateJSON);
    }
	
}
