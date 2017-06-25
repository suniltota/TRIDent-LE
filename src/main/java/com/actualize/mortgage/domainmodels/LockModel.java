/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * defines the lock container in UI response
 * @author sboragala
 *
 */
public class LockModel implements Serializable {
	
	
	private static final long serialVersionUID = 1798270694027066969L;
	
	private String lockExpirationDatetime = "";
	private String lockStatusType = "";
	private String lockExpirationTimezoneType = "";
	
	/**
	 * @return the lockExpirationDatetime
	 */
	public String getLockExpirationDatetime() {
		return lockExpirationDatetime;
	}
	/**
	 * @param lockExpirationDatetime the lockExpirationDatetime to set
	 */
	public void setLockExpirationDatetime(String lockExpirationDatetime) {
		this.lockExpirationDatetime = lockExpirationDatetime;
	}
	/**
	 * @return the lockStatusType
	 */
	public String getLockStatusType() {
		return lockStatusType;
	}
	/**
	 * @param lockStatusType the lockStatusType to set
	 */
	public void setLockStatusType(String lockStatusType) {
		this.lockStatusType = lockStatusType;
	}
	/**
	 * @return the lockExpirationTimezoneType
	 */
	public String getLockExpirationTimezoneType() {
		return lockExpirationTimezoneType;
	}
	/**
	 * @param lockExpirationTimezoneType the lockExpirationTimezoneType to set
	 */
	public void setLockExpirationTimezoneType(String lockExpirationTimezoneType) {
		this.lockExpirationTimezoneType = lockExpirationTimezoneType;
	}
	
	
}
