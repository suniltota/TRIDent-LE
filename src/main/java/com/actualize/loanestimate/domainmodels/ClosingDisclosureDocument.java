package com.actualize.loanestimate.domainmodels;

import java.io.Serializable;

import com.actualize.mortgage.utils.DocumentDetails;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ClosingDisclosureDocument implements Serializable {
	
	private static final long serialVersionUID = 4671101480733733876L;
	
	private DocumentDetails documentDetails;
	private PageOne pageOne;
	private PageTwo pageTwo;
	private PageThree pageThree;
	
	public DocumentDetails getDocumentType() {
		return documentDetails;
	}
	public void setDocumentType(DocumentDetails documentDetails) {
		this.documentDetails = documentDetails;
	}
	public PageOne getPageOne() {
		return pageOne;
	}
	public void setPageOne(PageOne pageOne) {
		this.pageOne = pageOne;
	}
	public PageTwo getPageTwo() {
		return pageTwo;
	}
	public void setPageTwo(PageTwo pageTwo) {
		this.pageTwo = pageTwo;
	}
	public PageThree getPageThree() {
		return pageThree;
	}
	public void setPageThree(PageThree pageThree) {
		this.pageThree = pageThree;
	}
	

	

}
