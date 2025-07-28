package com.sjkcollege.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;



@Entity
public class Student {

    @Id
    @NotBlank (message = "{student.rollNumber.required}")
    @Pattern (regexp = "^4JK25CV\\d{3}$", message = "{rollNumber.invalid}")
    private String rollNumber;
    
    @NotBlank (message = "{student.firstname.required}")
	private String firstName;
    
    private String lastName;
    
    @NotBlank(message = "{student.email.required}")
    @Email(message = "{student.email.invalid}")
    private String email;
    
    private String address;
    
    @NotBlank(message = "{student.department.required}")
    private String department;

    public Student() {
    }

	public Student(String rollNumber, String firstName, String lastName, String email, String address, String department) {
		this.rollNumber = rollNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.department = department;
	}

	public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", address=" + address + ", department=" + department + "]";
	}
    
    
}