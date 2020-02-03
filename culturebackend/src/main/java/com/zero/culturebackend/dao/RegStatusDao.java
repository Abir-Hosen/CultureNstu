package com.zero.culturebackend.dao;

import java.util.List;

import com.zero.culturebackend.dto.Registered_status;

public interface RegStatusDao {

	boolean addRegStatus(Registered_status registered_status);
	Registered_status getById(int regId);
	List<Registered_status> registeredList();
	boolean updateRegStatus(Registered_status registered_status);
	boolean deleteRegStatus(Registered_status registered_status);

}
