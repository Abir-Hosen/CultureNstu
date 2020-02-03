package com.zero.culturebackend.dao;

import java.util.List;

import com.zero.culturebackend.dto.Registered_details;

public interface RegDetailsDao {

	boolean addRegDetails(Registered_details registered_details);
	Registered_details getByRegId(int regId);
	List<Registered_details> regDetailsList();
	boolean updateRegDetails(Registered_details registered_details);
	boolean deleteRegDetails(Registered_details registered_details);

}
