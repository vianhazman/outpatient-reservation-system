package com.apap.tugasakhir.service;

import com.apap.tugasakhir.model.ObatModel;
import com.apap.tugasakhir.repository.ObatDB;
import com.apap.tugasakhir.repository.PenangananDB;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ObatServiceImpl implements ObatService{
	
	@Autowired
	private ObatDB obatDb;
	
	@Override

	public List<ObatModel> getAllObatAvailable() {
		List<ObatModel> temp = obatDb.findAll();
		List<ObatModel> result = obatDb.findAll();
		result.clear();
		for(int i = 0; i < temp.size(); i++) {
			if(temp.get(i).getJumlah() > 0) {
				result.add(temp.get(i));
			}
		}
		return result;
	}

	@Override
	public void addObat(ObatModel obat) {
		// TODO Auto-generated method stub
		obatDb.save(obat);

	}

	@Override
	public ObatModel getObatById(long id) {
		// TODO Auto-generated method stub
		return obatDb.findById(id).get();
	}

}
