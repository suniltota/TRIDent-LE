package com.actualize.mortgage.convertors;

import com.actualize.mortgage.datamodels.MISMODocument;
import com.actualize.mortgage.domainmodels.LoanEstimateDocument;


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
		return loanEstimateDocument;
	}
			
}
