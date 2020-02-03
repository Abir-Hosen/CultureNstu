package com.zero.culturebackend.dao;

import java.util.List;

import com.zero.culturebackend.dto.Registered;

public interface RegisteredDao {

	boolean addRegistered(Registered registered);
	Registered getById(int regId);
	Registered getByEmail(String string);
	List<Registered> registeredList();
	boolean updateRegistered(Registered registered);
	boolean deleteRegistered(Registered registered);
	
}
