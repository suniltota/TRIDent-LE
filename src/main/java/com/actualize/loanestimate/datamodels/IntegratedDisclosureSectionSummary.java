package com.actualize.loanestimate.datamodels;

import org.w3c.dom.Element;

import com.actualize.loanestimate.domainmodels.MISMODataAccessObject;

public class IntegratedDisclosureSectionSummary extends MISMODataAccessObject {
	public final IntegratedDisclosureSectionSummaryDetail integratedDisclosureSectionSummaryDetail;
	public final IntegratedDisclosureSubsectionPayments integratedDisclosureSubsectionPayments;

	public IntegratedDisclosureSectionSummary(Element element) {
		super(element);
		integratedDisclosureSectionSummaryDetail = new IntegratedDisclosureSectionSummaryDetail((Element)getElementAddNS("INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL"));
		integratedDisclosureSubsectionPayments = new IntegratedDisclosureSubsectionPayments((Element)getElementAddNS("INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENTS"));
	}
}
