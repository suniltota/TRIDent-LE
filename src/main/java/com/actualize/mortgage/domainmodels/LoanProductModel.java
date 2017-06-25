/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * defines LoanProduct in JSON Response
 * @author sboragala
 *
 */
public class LoanProductModel implements Serializable {
	
	private static final long serialVersionUID = 4563513628139754860L;
	private String loanPriceQuoteInterestRatePercent;
	private LockModel lock;

	/**
	 * @return the loanPriceQuoteInterestRatePercent
	 */
	public String getLoanPriceQuoteInterestRatePercent() {
		return loanPriceQuoteInterestRatePercent;
	}

	/**
	 * @param loanPriceQuoteInterestRatePercent the loanPriceQuoteInterestRatePercent to set
	 */
	public void setLoanPriceQuoteInterestRatePercent(String loanPriceQuoteInterestRatePercent) {
		this.loanPriceQuoteInterestRatePercent = loanPriceQuoteInterestRatePercent;
	}

	/**
	 * @return the lock
	 */
	public LockModel getLock() {
		return lock;
	}

	/**
	 * @param lock the lock to set
	 */
	public void setLock(LockModel lock) {
		this.lock = lock;
	}

}
