/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines LoanCalculationsQualifiedMortgage in JSON response
 * @author sboragala
 *
 */
public class LoanCalculationsQualifiedMortgage implements Serializable {

	private static final long serialVersionUID = 3253437764724780003L;
	
	private LoanCalculationModel loanCalculationModel;
	
	/**
	 * @return the loanCalculationModel
	 */
	public LoanCalculationModel getLoanCalculationModel() {
		return loanCalculationModel;
	}
	/**
	 * @param loanCalculationModel the loanCalculationModel to set
	 */
	public void setLoanCalculationModel(LoanCalculationModel loanCalculationModel) {
		this.loanCalculationModel = loanCalculationModel;
	}
	

}
