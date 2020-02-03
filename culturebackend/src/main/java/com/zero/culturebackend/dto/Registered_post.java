package com.zero.culturebackend.dto;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Registered_post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int regId;
	private int react;
	private int seen;
	private boolean visible;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date = new Date();
	private String statusTitle;
	private String status;
	private String imgUrl;
	@Transient
	private MultipartFile file;

	public Registered_post() {
		this.imgUrl = "POST"+ UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRegId() {
		return regId;
	}

	public void setRegId(int regId) {
		this.regId = regId;
	}

	public int getReact() {
		return react;
	}

	public void setReact(int react) {
		this.react = react;
	}

	public int getSeen() {
		return seen;
	}

	public void setSeen(int seen) {
		this.seen = seen;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatusTitle() {
		return statusTitle;
	}

	public void setStatusTitle(String statusTitle) {
		this.statusTitle = statusTitle;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Registered_post [id=" + id + ", regId=" + regId + ", react=" + react + ", seen=" + seen + ", visible="
				+ visible + ", date=" + date + ", statusTitle=" + statusTitle + ", status=" + status + ", imgUrl="
				+ imgUrl + ", file=" + file + "]";
	}


}
