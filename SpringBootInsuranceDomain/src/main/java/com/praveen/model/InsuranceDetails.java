package com.praveen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="insurancedetails")
public class InsuranceDetails{
	@Id
	@Column
	int policyNo;
	@Column
	String proposerName;
	@Column
	String insuranceType;
	@Column
	int tenure;
	@Column
	String customerDueDeligence;
	@Column
	String enhancedDueDeligence;
	
	public int getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(int policyNo) {
		this.policyNo = policyNo;
	}
	public String getProposerName() {
		return proposerName;
	}
	public void setProposerName(String proposerName) {
		this.proposerName = proposerName;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	
	public String getCustomerDueDeligence() {
		return customerDueDeligence;
	}
	public void setCustomerDueDiligence(String customerDueDiligence) {
		this.customerDueDeligence = customerDueDiligence;
	}
	
	public String getEnhancedDueDeligence() {
		return enhancedDueDeligence;
	}
	public void setEnhancedDueDeligence(String enhancedDueDeligence ) {
		this.enhancedDueDeligence = enhancedDueDeligence;
	}
	
	public String toString() {
		String details = "policyno:" +policyNo+"\t Proposer Name: "+ proposerName+"\t Insurance Type : "+
				insuranceType + "\t Tenure: " + tenure+ "\t CDD : "+ customerDueDeligence+ "\t EDD :" + enhancedDueDeligence;
		return details;
	}
	
}	
	