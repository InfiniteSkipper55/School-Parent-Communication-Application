package com.cg.spc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ADDRESS_1")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BUILDING_NAME")
	private String buildingName;
	
	@Column(name = "STREET_NAME")
	private String streetName;
	
	@Column(name = "CITY_NAME")
	private String cityName;
	
	@Column(name = "PIN_CODE")
	private String pinCode;
	
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public Address(String buildingName, String streetName, String cityName, String pinCode) {
		super();
		this.buildingName = buildingName;
		this.streetName = streetName;
		this.cityName = cityName;
		this.pinCode = pinCode;
	}
	public Address() {
		super();
	}
	
	

}
