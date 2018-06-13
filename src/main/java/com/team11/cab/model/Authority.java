package com.team11.cab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String authority;

	@ManyToOne
	@JoinColumn(insertable=true, name="username", referencedColumnName="username", unique=true)
	private Member member;

	public String getAuthority() {
		return authority;
	}

	public Member getMember() {
		return member;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
