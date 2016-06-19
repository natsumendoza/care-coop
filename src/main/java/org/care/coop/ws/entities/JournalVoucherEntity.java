package org.care.coop.ws.entities;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="journal_voucher")
public class JournalVoucherEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long clientNo;
	private Long accountNo;
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long transactionCode;
	private String title;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<AccountsReceivableEntity> accountsReceivables;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<AccountsPayableEntity> accountsPayables;
	
	@Column(nullable=true)
	private BigInteger debit;
	
	@Column(nullable=true)
	private BigInteger credit;
	
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	private String particulars;
	
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getParticulars() {
		return particulars;
	}
	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}
	public Long getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(Long transactionCode) {
		this.transactionCode = transactionCode;
	}
	
	public List<AccountsReceivableEntity> getAccountsReceivables() {
		return accountsReceivables;
	}
	public void setAccountsReceivables(List<AccountsReceivableEntity> accountsReceivables) {
		this.accountsReceivables = accountsReceivables;
	}
	
	public List<AccountsPayableEntity> getAccountsPayables() {
		return accountsPayables;
	}
	public void setAccountsPayables(List<AccountsPayableEntity> accountsPayables) {
		this.accountsPayables = accountsPayables;
	}
	public Long getClientNo() {
		return clientNo;
	}
	public void setClientNo(Long clientNo) {
		this.clientNo = clientNo;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	
	
}
