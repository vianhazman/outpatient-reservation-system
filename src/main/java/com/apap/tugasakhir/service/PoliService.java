package com.apap.tugasakhir.service;

import java.util.List;

import com.apap.tugasakhir.model.PoliModel;

public interface PoliService {
	PoliModel getPoliById(long id);
	List<PoliModel> findAll();

}
