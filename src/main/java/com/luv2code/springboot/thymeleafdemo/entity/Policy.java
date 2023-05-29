package com.luv2code.springboot.thymeleafdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="polisa")
public class Policy {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="data_koncowa")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endingDate;

	@Column(name="imie")
	private String firstName;
	
	@Column(name="nazwisko")
	private String lastName;
	
	@Column(name="pesel")
	private String pesel;

	@Column(name="adres")
	private String address;

	@Column(name="nr_telefonu")
	private String phoneNumber;

	@Column(name="email")
	private String email;

	@Column(name="nr_polisy")
	private String policyNumber;

	@Column(name="ubezpieczyciel")
	private String insurer;

	@Column(name="typ_polisy")
	private String policyType;

	@Column(name="marka_samochodu")
	private String carMake;

	@Column(name="nr_rejestracyjny")
	private String registrationNumber;
	
		
	// define constructors
	
	public Policy() {
		
	}

	public Policy(int id, Date endingDate, String firstName, String lastName, String pesel, String address,
				  String phoneNumber, String email, String policyNumber, String insurer,
				  String policyType, String carMake, String registrationNumber) {
		this.endingDate = endingDate;
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.policyNumber = policyNumber;
		this.insurer = insurer;
		this.policyType = policyType;
		this.carMake = carMake;
		this.registrationNumber = registrationNumber;
	}

	// define getter/setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getInsurer() {
		return insurer;
	}

	public void setInsurer(String insurer) {
		this.insurer = insurer;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	// define toString


	@Override
	public String toString() {
		return "Policy{" +
				"id=" + id +
				", endingDate='" + endingDate + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", pesel='" + pesel + '\'' +
				", address='" + address + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", email='" + email + '\'' +
				", policyNumber='" + policyNumber + '\'' +
				", insurer='" + insurer + '\'' +
				", policyType='" + policyType + '\'' +
				", carMake='" + carMake + '\'' +
				", registrationNumber='" + registrationNumber + '\'' +
				'}';
	}
}











