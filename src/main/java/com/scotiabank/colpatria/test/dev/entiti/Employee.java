package com.scotiabank.colpatria.test.dev.entiti;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "is required")
	@NotEmpty(message = "not emty")
	@NotNull(message = "not null")
	private String firstName;
	@NotEmpty(message = "not emty")
	@NotNull(message = "not null")
	private String middleName;
	@NotBlank(message = "is required")
	@NotEmpty(message = "not emty")
	@NotNull(message = "not null")
	private String lastName;
	@NotNull(message = "not null")
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "locationCity")
	private City locationCity;
	@NotBlank(message = "is required")
	@NotEmpty(message = "not emty")
	@NotNull(message = "not null")
	@Pattern(regexp = "^(Calle|Carrera|Diagonal)\\s\\d{2}\\s#\\d{2}-\\d{2}\\s[a-zA-Z\\s]+$",message = "not comply with the format")
	private String address;
	@NotNull(message = "not null")
	private Date dateBirth;
	@NotBlank(message = "is required")
	@NotEmpty(message = "not emty")
	@NotNull(message = "not null")
	@Size(min = 10 ,max = 10 ,message = "The number must have 10 numbers")
	private String telephone;
	@NotBlank(message = "is required")
	@NotEmpty(message = "not emty")
	@NotNull(message = "not null")
	private String positionTitle;
	@NotNull(message = "not null")
	@Temporal(TemporalType.DATE)
	private Date hireDate;
	@NotBlank(message = "is required")
	@NotEmpty(message = "not emty")
	@NotNull(message = "not null")
	@Email(message = "is not valid")
	private String email;
	@NotNull(message = "not null") 
	private double salary;
	@NotNull(message = "not null")
	@Temporal(TemporalType.DATE)
	private Date dateArrival;
	@NotNull(message = "not null")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "state")
	private State state;

	public Employee() {
	}

	
	public Employee(Long id, String firstName, String middleName, String lastName, City locationCity, String address,
			Date dateBirth, String telephone, String positionTitle, Date hireDate, String email, double salary,
			State state,Date dateArrival) {
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.locationCity = locationCity;
		this.address = address;
		this.dateBirth = dateBirth;
		this.telephone = telephone;
		this.positionTitle = positionTitle;
		this.hireDate = hireDate;
		this.email = email;
		this.salary = salary;
		this.state = state;
		this.dateArrival = dateArrival;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public City getLocationCity() {
		return locationCity;
	}

	public void setLocationCity(City locationCity) {
		this.locationCity = locationCity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPositionTitle() {
		return positionTitle;
	}

	public void setPositionTitle(String positionTitle) {
		this.positionTitle = positionTitle;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}


	public Date getDateArrival() {
		return dateArrival;
	}


	public void setDateArrival(Date dateArrival) {
		this.dateArrival = dateArrival;
	}
	
 
}
