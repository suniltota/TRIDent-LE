package com.actualize.mortgage.datamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * represents IntegratedDisclosureSectionSummaries in MISMO XML
 * @author sboragala
 *
 */
public class IntegratedDisclosureSectionSummaries extends MISMODataAccessObject {
	private static final long serialVersionUID = 6055858010285214326L;
	public final IntegratedDisclosureSectionSummary[] integratedDisclosureSectionSummaries;
	public IntegratedDisclosureSectionSummaries(String NS, Element element) {
		super(element);
		NodeList nodes = getElementsAddNS((NS == null ? "" : NS)+"INTEGRATED_DISCLOSURE_SECTION_SUMMARY");
		integratedDisclosureSectionSummaries = new IntegratedDisclosureSectionSummary[nodes==null ? 0 : nodes.getLength()];
		for (int i = 0; i < integratedDisclosureSectionSummaries.length; i++)
			integratedDisclosureSectionSummaries[i] = new IntegratedDisclosureSectionSummary((Element)nodes.item(i));		
	}
	public IntegratedDisclosureSectionSummaries(Element element) {
		this(null,element);
		// TODO
	}
}
