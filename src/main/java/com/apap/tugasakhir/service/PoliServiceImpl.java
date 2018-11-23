package com.apap.tugasakhir.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apap.tugasakhir.model.PoliModel;
import com.apap.tugasakhir.repository.PoliDb;

@Service
@Transactional
public class PoliServiceImpl implements PoliService {
	
	@Autowired
	private PoliDb poliDb;

	@Override
	public PoliModel getPoliById(long id) {
		return poliDb.findById(id);
	}

	@Override
	public List<PoliModel> findAll() {
		return poliDb.findAll();
	}

}
