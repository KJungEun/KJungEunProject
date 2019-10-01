package com.kakao.project.model;

public class TransactionOneModel {
	
	private int year;	/*연도*/
	private String name;	/*계좌명*/
	private String acctNo;	/*계좌번호*/
	private int sumAmt;	/*합계금액,거래금액합계*/
	
	public TransactionOneModel(int year, String name, String acctNo, int sumAmt) {
		super();
		this.year = year;
		this.name = name;
		this.acctNo = acctNo;
		this.sumAmt = sumAmt;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
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
	public int getSumAmt() {
		return sumAmt;
	}
	public void setSumAmt(int sumAmt) {
		this.sumAmt = sumAmt;
	}
	
	


}