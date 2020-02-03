package com.zero.culturebackend.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Registered {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message="Please enter the name")
	private String name;
	@NotBlank(message="Please enter the email")
	private String email;
	private int category;
	@NotBlank(message="Please enter the password")
	private String password;
	private boolean enabled;
	private String role;
	@Transient
	private String confirmPassword;
	@NotBlank(message="Please enter the Date of birth")
	private String dob;
	@NotBlank(message="Please enter your Gender")
	private String gender;
	@NotBlank(message="Please enter your blood group")
	private String blood_group;
	@NotBlank(message="Please enter your department name")
	private String department;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Registered [id=" + id + ", name=" + name + ", email=" + email + ", category=" + category + ", password="
				+ password + ", enabled=" + enabled + ", role=" + role + ", confirmPassword=" + confirmPassword
				+ ", dob=" + dob + ", gender=" + gender + ", blood_group=" + blood_group + ", department=" + department
				+ "]";
	}
}
