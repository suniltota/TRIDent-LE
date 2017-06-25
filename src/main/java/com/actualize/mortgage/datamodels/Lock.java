package com.actualize.mortgage.datamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * represents Lock in MISMO XML
 * @author sboragala
 *
 */
public class Lock extends MISMODataAccessObject {
	private static final long serialVersionUID = -7772437665729206243L;
	public final String lockExpirationDatetime;
	public final String lockStatusType;
	public final Extension extension;
	
	public Lock(Element element) {
		super(element);
		lockExpirationDatetime = getValueAddNS("LockExpirationDatetime");
		lockStatusType = getValueAddNS("LockStatusType");
		extension = new Extension((Element)getElementAddNS("EXTENSION"));
	}
}
