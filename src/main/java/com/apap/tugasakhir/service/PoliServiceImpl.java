package com.apap.tugasakhir.service;

import java.util.List;

import javax.transaction.Transactional;

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
		return poliDb.findById(id).get();
	}

	@Override
	public List<PoliModel> findAll() {
		return poliDb.findAll();
	}

}
