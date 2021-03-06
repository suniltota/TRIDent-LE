package com.actualize.mortgage.utils;

public class Expenses {
	private String  label;
	private String  type;
	private String  typeOtherDescription;
	private String  paidToType;
	private String  integratedDisclosureSectionType;
	private boolean paidOutsideOfClosingIndicator;
	private String  paymentAmount;
	private String  paymentPaidByType;
	private String  paymentTimingType;
	private String  paymentToEntity;

	public String getPaidToType() {
		return paidToType;
	}
	public void setPaidToType(String paidToType) {
		this.paidToType = paidToType;
	}
	public String getPaymentPaidByType() {
		return paymentPaidByType;
	}
	public void setPaymentPaidByType(String paymentPaidByType) {
		this.paymentPaidByType = paymentPaidByType;
	}
	public String getPaymentTimingType() {
		return paymentTimingType;
	}
	public void setPaymentTimingType(String paymentTimingType) {
		this.paymentTimingType = paymentTimingType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeOtherDescription() {
		return typeOtherDescription;
	}
	public void setTypeOtherDescription(String type) {
		this.typeOtherDescription = type;
	}
	public String getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getIntegratedDisclosureSectionType() {
		return integratedDisclosureSectionType;
	}
	public void setIntegratedDisclosureSectionType(String integratedDisclosureSectionType) {
		this.integratedDisclosureSectionType = integratedDisclosureSectionType;
	}
	public boolean isPaidOutsideOfClosingIndicator() {
		return paidOutsideOfClosingIndicator;
	}
	public void setPaidOutsideOfClosingIndicator(boolean paidOutsideOfClosingIndicator) {
		this.paidOutsideOfClosingIndicator = paidOutsideOfClosingIndicator;
	}
	public String getPaymentToEntity() {
		return paymentToEntity;
	}
	public void setPaymentToEntity(String paymentToEntity) {
		this.paymentToEntity = paymentToEntity;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
}
