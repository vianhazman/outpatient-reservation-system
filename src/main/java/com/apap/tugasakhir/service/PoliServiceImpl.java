package com.apap.tugasakhir.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugasakhir.model.PoliModel;
import com.apap.tugasakhir.repository.PoliDB;

@Service
@Transactional
public class PoliServiceImpl implements PoliService{
	@Autowired 
	private PoliDB poliDB;
	
	@Override
	public void add(PoliModel poli) {
		poliDB.save(poli);
	}
	
	@Override
	public PoliModel getDetailById(Long id) {
		return poliDB.getOne(id);
	}
	
	@Override
	public List<PoliModel> getAllPoli() {
		return poliDB.findAll();
	}
	
	@Override
	public PoliModel getPoliDetailByNama(String nama) {
		return poliDB.findByNama(nama);
	}
	
	@Override
	public void update(PoliModel poli) {
		PoliModel poliLama = poliDB.getOne(poli.getId());
		poliLama.setNama(poli.getNama());
		poliLama.setDeskripsi(poli.getDeskripsi());
		poliDB.save(poli);
	}
}

