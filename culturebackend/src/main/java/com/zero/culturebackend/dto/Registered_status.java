package com.zero.culturebackend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Registered_status {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private boolean varified;
	private boolean active ;
	private boolean live;
	private int reg_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isVarified() {
		return varified;
	}
	public void setVarified(boolean varified) {
		this.varified = varified;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public int getReg_id() {
		return reg_id;
	}
	public void setReg_id(int reg_id) {
		this.reg_id = reg_id;
	}
	@Override
	public String toString() {
		return "Registered_status [id=" + id + ", varified=" + varified + ", active=" + active + ", live=" + live
				+ ", reg_id=" + reg_id + "]";
	}
}
