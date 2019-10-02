package com.kakao.project.model;

import java.math.BigDecimal;

public class TransactionModel {
	
	private String name;	/*계좌명*/
	private String acctNo;	/*계좌번호*/
	private BigDecimal sumAmt;	/*합계금액,거래금액합계*/
	private BigDecimal year;	/*연도*/
	
	private String brName;	/*관리점명*/
	private String brCode;	/*관리점코드*/
	
	public String getBrName() {
		return brName;
	}

	public void setBrName(String brName) {
		this.brName = brName;
	}

	public String getBrCode() {
		return brCode;
	}

	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}

	public TransactionModel(BigDecimal year, String name, String acctNo, BigDecimal sumAmt) {
		super();
		this.year = year;
		this.name = name;
		this.acctNo = acctNo;
		this.sumAmt = sumAmt;
	}
	
	public BigDecimal getSumAmt() {
		return sumAmt;
	}

	public void setSumAmt(BigDecimal sumAmt) {
		this.sumAmt = sumAmt;
	}

	public BigDecimal getYear() {
		return year;
	}
	public void setYear(BigDecimal year) {
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}



}