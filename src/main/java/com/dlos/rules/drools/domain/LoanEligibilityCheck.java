package com.dlos.rules.drools.domain;

public class LoanEligibilityCheck {
	// Input(Facts) to the Rule engine
	private Integer creditScore;
	private Integer income;
	// Output(Derived Fact) from the Rule Engine
	private Boolean isDeviation;

	public LoanEligibilityCheck(Integer creditScore, Integer income) {
		this.creditScore = creditScore;
		this.income = income;
	}

	public Integer getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(Integer creditScore) {
		this.creditScore = creditScore;
	}

	public Integer getIncome() {
		return income;
	}

	public void setIncome(Integer income) {
		this.income = income;
	}

	public Boolean getIsDeviation() {
		return isDeviation;
	}

	public void setIsDeviation(Boolean isDeviation) {
		this.isDeviation = isDeviation;
	}

}
