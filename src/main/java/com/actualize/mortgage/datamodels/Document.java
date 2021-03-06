package com.actualize.mortgage.datamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class Document extends MISMODataAccessObject {
 
	private static final long serialVersionUID = -5074824198375635005L;
	public final AuditTrail auditTrail;
	public final DealSets dealSets;
	public final Signatories signatories;
	public final Views views;
	public final AboutVersions aboutVersions;
	public DocumentClassification documentClassification;

	public Document(String NS, Element element) {
		super(element);
		Element elem;
		elem = getElement(element, NS + "AUDIT_TRAIL");
		auditTrail = new AuditTrail(NS, elem);
		elem = getElement(element, NS + "DEAL_SETS");
		dealSets = new DealSets(NS, elem);
		elem = getElement(element, NS + "SIGNATORIES");
		signatories = new Signatories(NS, elem);
		elem = getElement(element, NS + "VIEWS");
		views = new Views(NS, elem);
		elem = getElement(element, NS + "ABOUT_VERSIONS");
		aboutVersions = new AboutVersions(NS, elem);
		elem = getElement(element, NS + "DOCUMENT_CLASSIFICATION");
		if(null != elem)
			documentClassification = new DocumentClassification(NS, elem);
	}
}
