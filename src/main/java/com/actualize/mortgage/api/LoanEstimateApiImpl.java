package com.actualize.mortgage.api;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.actualize.mortgage.domainmodels.LoanEstimateDocument;
import com.actualize.mortgage.services.impl.LoanEstimateServicesImpl;
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
	
    

    /**
     * Generates the JSON response for LE on uploading xml
     * 
     * @param xmldoc
     * @return JSON response for LE
     * @throws Exception
     */
    @RequestMapping(value = "/{version}/letojson", method = { RequestMethod.POST })
    public LoanEstimateDocument generateresponse(@RequestParam String version, @RequestBody String xmldoc) throws Exception {
        InputStream inputStream = new ByteArrayInputStream(xmldoc.getBytes(StandardCharsets.UTF_8));
        LoanEstimateServicesImpl loanEstimateServicesImpl = new LoanEstimateServicesImpl();
        return loanEstimateServicesImpl.createLoanEstimateDocumentObjectfromXMLDoc(inputStream);
    }
    
    /**
     * Generates the MISMO XML for LE on uploading JSON response
     * 
     * @param loanEstimateJSON
     * @return MISMO XML for LE
     * @throws Exception
     */
    @RequestMapping(value = "/{version}/jsontole", method = { RequestMethod.POST })
    public String generateMISMOxml(@RequestParam String version, @RequestBody LoanEstimateDocument loanEstimateJSON) throws Exception {
		return "TODO";
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
