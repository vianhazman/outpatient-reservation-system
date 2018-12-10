package com.apap.tugasakhir.service;

import java.util.List;

//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.apap.tugasakhir.model.PoliModel;
import com.apap.tugasakhir.repository.PoliDB;

@Service
@Transactional
public class PoliServiceImpl implements PoliService {
	
	@Autowired
	private PoliDB poliDb;

	@Override
	public PoliModel getPoliById(long id) {
		return poliDb.findById(id);
	}

	@Override
	public List<PoliModel> findAll() {
		return poliDb.findAll();
	}
	
	@Override
	public void add(PoliModel poli) {
		poliDb.save(poli);
	}
	
	@Override
	public PoliModel getDetailById(Long id) {
		return poliDb.getOne(id);
	}
	
	@Override
	public List<PoliModel> getAllPoli() {
		return poliDb.findAll();
	}
	
	@Override
	public PoliModel getPoliDetailByNama(String nama) {
		return poliDb.findByNama(nama);
	}
	
	@Override
	public void update(PoliModel poli) {
		PoliModel poliLama = poliDb.getOne(poli.getId());
		poliLama.setNama(poli.getNama());
		poliLama.setDeskripsi(poli.getDeskripsi());
		poliDb.save(poli);
	}
}
