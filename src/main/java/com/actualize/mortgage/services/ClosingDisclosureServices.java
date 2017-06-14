package com.actualize.mortgage.services;

import java.io.InputStream;

import com.actualize.mortgage.domainmodels.LoanEstimate;
/**
 * This is service interface for the Closing Disclosure which is used to define 
 * different methods for example create LoanEstimate XML / PDF and generate Page Objects to represents
 * the all the pages present in Closing Disclosure.
 * 
 * @author rsudula
 * @version 1.0
 * 
 */
public interface ClosingDisclosureServices {

    public LoanEstimate createClosingDisclosureObjectfromXMLDoc(InputStream inputXmlStream) throws Exception;
    
    public String createClosingDisclosureXMLfromObject(LoanEstimate loanEstimate) throws Exception;

}
