package com.zero.culturebackend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Registered_details {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int reg_id;
	private String slogan;
	private String aim;
	private String about;
	private String address;
	private String hall_room;
	private String session;
	private String department;
	private String roll;
	private String graduation_program;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReg_id() {
		return reg_id;
	}
	public void setReg_id(int reg_id) {
		this.reg_id = reg_id;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	public String getAim() {
		return aim;
	}
	public void setAim(String aim) {
		this.aim = aim;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHall_room() {
		return hall_room;
	}
	public void setHall_room(String hall_room) {
		this.hall_room = hall_room;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getGraduation_program() {
		return graduation_program;
	}
	public void setGraduation_program(String graduation_program) {
		this.graduation_program = graduation_program;
	}
	@Override
	public String toString() {
		return "Registered_details [id=" + id + ", reg_id=" + reg_id + ", slogan=" + slogan + ", aim=" + aim
				+ ", about=" + about + ", address=" + address + ", hall_room=" + hall_room + ", session=" + session
				+ ", department=" + department + ", roll=" + roll + ", graduation_program=" + graduation_program + "]";
	}
}
