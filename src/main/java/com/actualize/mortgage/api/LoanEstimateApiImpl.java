package com.actualize.mortgage.api;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.actualize.mortgage.domainmodels.LoanEstimate;
import com.actualize.mortgage.services.impl.ILoanEstimateServices;
/**
 * This class is the rest controller which defines the all the APIs associated for generation of JSON from MISMO XML and vice versa for Loan Estimate 
 * @author sboragala
 * @version 1.0
 * 
 */
@RestController
@RequestMapping(value = "/actualize/transformx/trident/le")
public class LoanEstimateApiImpl {

	private static final Logger LOG = LogManager.getLogger(LoanEstimateApiImpl.class);
	
	@Autowired
	private ILoanEstimateServices loanEstimateServices;
    

    /**
     * Generates the JSON response for LE on uploading xml
     * 
     * @param xmldoc
     * @return JSON response for LE
     * @throws Exception
     */
    @RequestMapping(value = "/{version}/letojson", method = { RequestMethod.POST })
    public LoanEstimate generateresponse(@PathVariable String version, @RequestBody String xmldoc) throws Exception {
    	LOG.info("Service: letojson called");
        InputStream inputStream = new ByteArrayInputStream(xmldoc.getBytes(StandardCharsets.UTF_8));
        return loanEstimateServices.createLoanEstimateDocumentObjectfromXMLDoc(inputStream);
    }
    
    /**
     * Generates the MISMO XML for LE on uploading JSON response
     * 
     * @param loanEstimateJSON
     * @return MISMO XML for LE
     * @throws Exception
     */
    @RequestMapping(value = "/{version}/jsontole", method = { RequestMethod.POST })
    public String generateMISMOxml(@PathVariable String version, @RequestBody LoanEstimate loanEstimateJSON) throws Exception {
    	LOG.info("Service: jsontole called");
    	return loanEstimateServices.createLoanEstimateXMLfromObject(loanEstimateJSON);
    }
    
    /**
     * Generates the MISMO XML for LE on uploading JSON response
     * 
     * @param loanEstimateJSON
     * @return MISMO XML for LE
     * @throws Exception
     */
    @RequestMapping(value = "/{version}/ping", method = { RequestMethod.GET })
    public String generateMISMOxml(@RequestParam String version) throws Exception {
		return "The Service to generate JSON from XML and vice versa is running and ready to accept the requests";
    }
}
