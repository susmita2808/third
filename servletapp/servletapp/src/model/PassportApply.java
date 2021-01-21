package model;

import java.util.Date;

public class PassportApply {
	private String applicationId;  
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String placeOfBirth;
	private Long contactNumber;
	private Long aadharNumber ;
	private String address;
	private String nationality;
	private String state;
	private String city;
	
	public PassportApply() {
		
	}

	public PassportApply(String firstName, String lastName, Date dateOfBirth, String placeOfBirth, Long contactNumber,
			Long aadharNumber, String address, String nationality, String state, String city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.contactNumber = contactNumber;
		this.aadharNumber = aadharNumber;
		this.address = address;
		this.nationality = nationality;
		this.state = state;
		this.city = city;
	}

	public String getFirstName() {
		return firstName;
	}

	public PassportApply(String applicationId, String firstName, String lastName, Date dateOfBirth, String placeOfBirth,
			Long contactNumber, Long aadharNumber, String address, String nationality, String state, String city) {
		super();
		this.applicationId = applicationId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.contactNumber = contactNumber;
		this.aadharNumber = aadharNumber;
		this.address = address;
		this.nationality = nationality;
		this.state = state;
		this.city = city;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Long getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(Long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	@Override
	public String toString() {
		return "PassportApply [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", placeOfBirth=" + placeOfBirth + ", contactNumber=" + contactNumber + ", aadharNumber="
				+ aadharNumber + ", address=" + address + ", nationality=" + nationality + ", state=" + state
				+ ", city=" + city + "]";
	}
	
}