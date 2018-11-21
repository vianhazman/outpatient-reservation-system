package com.apap.tugasakhir.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugasakhir.model.DokterModel;
import com.apap.tugasakhir.repository.DokterDb;

@Service
@Transactional
public class DokterServiceImpl implements DokterService{ 

	@Autowired
	private DokterDb dokterDb;
	
	@Override
	public List<DokterModel> findAll() {
		return dokterDb.findAll();
	}

}
