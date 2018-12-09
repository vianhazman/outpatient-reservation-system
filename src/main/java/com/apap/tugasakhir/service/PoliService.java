package com.apap.tugasakhir.service;

import java.util.List;

import com.apap.tugasakhir.model.PoliModel;

public interface PoliService {
	void add(PoliModel poli);
	PoliModel getDetailById(Long id);
	List<PoliModel> getAllPoli();
	PoliModel getPoliDetailByNama(String nama);
	void update(PoliModel poli);
}