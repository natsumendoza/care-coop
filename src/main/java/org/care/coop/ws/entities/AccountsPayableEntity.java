package org.care.coop.ws.entities;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="accounts_payable")
class AccountsPayableEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private BigInteger debit;
	private BigInteger credit;
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
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
