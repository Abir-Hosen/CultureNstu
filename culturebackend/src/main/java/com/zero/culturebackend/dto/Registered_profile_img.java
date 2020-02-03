package com.zero.culturebackend.dto;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Registered_profile_img {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int reg_id;
	private boolean active;
	private String description;
	private String imgProfUrl;

	@Transient
	private MultipartFile file;
	
	public Registered_profile_img() {
		this.imgProfUrl = "PROFILE"+ UUID.randomUUID().toString().substring(26).toUpperCase();
	}

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgProfUrl() {
		return imgProfUrl;
	}

	public void setImgProfUrl(String imgProfUrl) {
		this.imgProfUrl = imgProfUrl;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Registered_profile_img [id=" + id + ", reg_id=" + reg_id + ", active=" + active + ", description="
				+ description + ", imgProfUrl=" + imgProfUrl + ", file=" + file + "]";
	}

}
