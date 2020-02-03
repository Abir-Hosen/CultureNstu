package com.zero.culturenstu.model;

public class RegisteredModel{

	/**
	 * 
	 */
	
	private int id;
	private String fullname;
	private String email;
	private String roll;
	private String slogan;
	private String aim;
	private String about;
	private String adress;
	private String hall;
	private String session;
	private String department;
	private String rollId;
	private String graduate;
	private String catName;
	private String gender;
	private String blood_group;
	private String dob;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getHall() {
		return hall;
	}
	public void setHall(String hall) {
		this.hall = hall;
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
	public String getRollId() {
		return rollId;
	}
	public void setRollId(String rollId) {
		this.rollId = rollId;
	}
	public String getGraduate() {
		return graduate;
	}
	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "RegisteredModel [id=" + id + ", fullname=" + fullname + ", email=" + email + ", roll=" + roll
				+ ", slogan=" + slogan + ", aim=" + aim + ", about=" + about + ", adress=" + adress + ", hall=" + hall
				+ ", session=" + session + ", department=" + department + ", rollId=" + rollId + ", graduate="
				+ graduate + ", catName=" + catName + ", gender=" + gender + ", blood_group=" + blood_group + ", dob="
				+ dob + "]";
	}
}
