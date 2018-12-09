package com.apap.tugasakhir.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugasakhir.model.RujukanRawatJalanModel;
import com.apap.tugasakhir.repository.RujukanRawatJalanDb;

@Service
@Transactional
public class RujukanRawatJalanServiceImpl implements RujukanRawatJalanService{

	@Autowired
	private RujukanRawatJalanDb rujukanDb;

	@Override
	public List<RujukanRawatJalanModel> listRujukan() {
		return rujukanDb.findAll();
	}
	
	@Override
	public RujukanRawatJalanModel getRujukanById(long id) {
		return rujukanDb.getOne(id);
	}

	@Override
	public RujukanRawatJalanModel getRujukanByIdPasien(long id) {
		return rujukanDb.findByidPasien(id);
	}
	
}
