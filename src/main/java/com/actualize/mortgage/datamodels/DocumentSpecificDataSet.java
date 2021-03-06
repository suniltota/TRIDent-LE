package com.actualize.mortgage.datamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * represents DocumentSpecificDataSet in MISMO XMLs
 * @author sboragala
 *
 */
public class DocumentSpecificDataSet extends MISMODataAccessObject {

	private static final long serialVersionUID = 4469056756327264346L;
	public final Execution execution;
	public final IntegratedDisclosure integratedDisclosure;
	public final URLA urla;

	public DocumentSpecificDataSet(String NS, Element element) {
		super(element);
		execution = new Execution(NS, element);
		integratedDisclosure = new IntegratedDisclosure(NS, element);
		urla = new URLA(NS, element);
	}

}
