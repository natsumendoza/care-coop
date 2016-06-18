package org.care.coop.ws.entities;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="general_ledger")
public class GeneralLedgerEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long clientNo;
	private Long accountNo;
	private String accountTitle;
	private String particulars;
	private BigInteger debit;
	private BigInteger credit;
	private BigInteger balance;
	
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	private int month;
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getClientNo() {
		return clientNo;
	}
	public void setClientNo(Long clientNo) {
		this.clientNo = clientNo;
	}
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountTitle() {
		return accountTitle;
	}
	public void setAccountTitle(String accountTitle) {
		this.accountTitle = accountTitle;
	}
	public String getParticulars() {
		return particulars;
	}
	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}
	public BigInteger getDebit() {
		return debit;
	}
	public void setDebit(BigInteger debit) {
		this.debit = debit;
	}
	public BigInteger getCredit() {
		return credit;
	}
	public void setCredit(BigInteger credit) {
		this.credit = credit;
	}
	public BigInteger getBalance() {
		return balance;
	}
	public void setBalance(BigInteger balance) {
		this.balance = balance;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
}
