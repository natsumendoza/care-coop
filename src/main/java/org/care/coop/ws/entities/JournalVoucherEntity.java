package org.care.coop.ws.entities;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="journal_voucher")
public class JournalVoucherEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long memberCode;
	private String title;
	private BigInteger debit;
	private BigInteger credit;
	
	public Long getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(Long memberCode) {
		this.memberCode = memberCode;
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
