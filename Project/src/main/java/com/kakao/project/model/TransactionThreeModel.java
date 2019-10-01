package com.kakao.project.model;

public class TransactionThreeModel {

	private String brName;	/*관리점명*/
	private String brCode;	/*관리점코드*/
	private int sumAmt;	/*합계금액,거래금액합계*/

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
	public int getSumAmt() {
		return sumAmt;
	}
	public void setSumAmt(int sumAmt) {
		this.sumAmt = sumAmt;
	}
	
	
}

