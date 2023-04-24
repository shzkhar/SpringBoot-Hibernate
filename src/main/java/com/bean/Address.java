package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aid;
	private String citynama;
	private String distname;
	private String state;
	private String pincode;
	
//	@OneToOne(mappedBy = "address")
//	PersonDetails personDetails;
	
//	public PersonDetails getPersonDetails() {
//		return personDetails;
//	}
//	public void setPersonDetails(PersonDetails personDetails) {
//		this.personDetails = personDetails;
//	}
	
	public String getCitynama() {
		return citynama;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public void setCitynama(String citynama) {
		this.citynama = citynama;
	}
	public String getDistname() {
		return distname;
	}
	public void setDistname(String distname) {
		this.distname = distname;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
}
