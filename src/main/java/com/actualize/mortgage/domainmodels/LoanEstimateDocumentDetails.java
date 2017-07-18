/**
 * @(#)ClosingDisclosureDocumentType.java 1.0 04/11/2017
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * This class is used to represent document level variables to quickly verify across all the pages.
 * @author rsudula
 * version : 1.0
 *
 */
public class LoanEstimateDocumentDetails implements Serializable {

    private static final long serialVersionUID = 1957140105029843535L;

    private String transactionType = "";
    private String documentType = "";
    private String formType = "";
	private String documentFormIssuingEntityNameType = "";
	private String documentFormIssuingEntityVersionIdentifier = "";
	private boolean documentSignatureRequiredIndicator = false;
	
	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}
	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	/**
	 * @return the documentType
	 */
	public String getDocumentType() {
		return documentType;
	}
	/**
	 * @param documentType the documentType to set
	 */
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	/**
	 * @return the formType
	 */
	public String getFormType() {
		return formType;
	}
	/**
	 * @param formType the formType to set
	 */
	public void setFormType(String formType) {
		this.formType = formType;
	}
	/**
	 * @return the documentFormIssuingEntityNameType
	 */
	public String getDocumentFormIssuingEntityNameType() {
		return documentFormIssuingEntityNameType;
	}
	/**
	 * @param documentFormIssuingEntityNameType the documentFormIssuingEntityNameType to set
	 */
	public void setDocumentFormIssuingEntityNameType(String documentFormIssuingEntityNameType) {
		this.documentFormIssuingEntityNameType = documentFormIssuingEntityNameType;
	}
	/**
	 * @return the documentFormIssuingEntityVersionIdentifier
	 */
	public String getDocumentFormIssuingEntityVersionIdentifier() {
		return documentFormIssuingEntityVersionIdentifier;
	}
	/**
	 * @param documentFormIssuingEntityVersionIdentifier the documentFormIssuingEntityVersionIdentifier to set
	 */
	public void setDocumentFormIssuingEntityVersionIdentifier(String documentFormIssuingEntityVersionIdentifier) {
		this.documentFormIssuingEntityVersionIdentifier = documentFormIssuingEntityVersionIdentifier;
	}
	/**
	 * @return the documentSignatureRequiredIndicator
	 */
	public boolean isDocumentSignatureRequiredIndicator() {
		return documentSignatureRequiredIndicator;
	}
	/**
	 * @param documentSignatureRequiredIndicator the documentSignatureRequiredIndicator to set
	 */
	public void setDocumentSignatureRequiredIndicator(boolean documentSignatureRequiredIndicator) {
		this.documentSignatureRequiredIndicator = documentSignatureRequiredIndicator;
	}
}
