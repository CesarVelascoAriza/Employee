package com.scotiabank.colpatria.test.dev.entiti;

import java.io.Serializable;
import java.util.Date;

import com.scotiabank.colpatria.test.dev.validators.IsValidDateBirth;
import com.scotiabank.colpatria.test.dev.validators.IsValidHireDate;

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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "must not be empty")
	@NotNull(message = "must not be null")
	private String firstName;
	@NotEmpty(message = "must not be empty")
	@NotNull(message = "must not be null")
	private String middleName;
	@NotEmpty(message = "must not be empty")
	@NotNull(message = "must not be null")
	private String lastName;
	@NotNull(message = "must not be null")
	@ManyToOne
	@JoinColumn(name = "locationCity")
	private City locationCity;
	@NotEmpty(message = "must not be empty")
	@NotNull(message = "must not be null")
	//@Pattern(regexp = "^(Cl|Carrera|Cr|Cll|Transv|Transversal|Diagonal|Diag|Avenida|Av)\\s\\d+[A-Z]?\\s#\\s\\d+-\\d+$",message = "not comply with the format")
	@Size(min = 6 ,max=100, message = "It must have a length between 6 and a maximum of 100")
	@Pattern(regexp = "^[a-zA-Z0-9\s#]*$", message = "not comply with the format" )
	private String address;
	@NotNull(message = "must not be null")
	@IsValidDateBirth()
	@Temporal(TemporalType.DATE)
	private Date dateBirth;
	@NotEmpty(message = "must not be empty")
	@NotNull(message = "must not be null")
	@Size(min = 10, max = 10 , message = "number is not valid")
	private String telephone;
	@NotEmpty(message = "must not be empty")
	@NotNull(message = "must not be null")
	private String positionTitle;
	@NotNull(message = "must not be null")
	@IsValidHireDate(message = "date is not valid")
	@Temporal(TemporalType.DATE)
	private Date hireDate;
	@NotEmpty(message = "must not be empty")
	@NotNull(message = "must not be null")
	@Email(message = "format not valid")
	private String email;
	@Min(value = 1000, message = "Invalid amount")
	private double salary;
	@NotNull(message = "must not be null")
	@Temporal(TemporalType.DATE)
	private Date dateArrival;
	@NotNull(message = "must not be null")
	@ManyToOne
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
