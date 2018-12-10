package com.apap.tugasakhir.service;

import java.util.Date;
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
	public List<RujukanRawatJalanModel> getAllRujukan() {
		return rujukanDb.findAll();
	}
	
	@Override
	public RujukanRawatJalanModel getRujukanByIdPasien(long idPasien) {
		// TODO Auto-generated method stub
		return rujukanDb.findByIdPasien(idPasien);
	}
	
	@Override
	public RujukanRawatJalanModel getRujukanByIdPasienAndTanggalRujukan(long idPasien, Date tanggalRujuk) {
		return rujukanDb.findByidPasienAndTanggalRujuk(idPasien, tanggalRujuk);
	}
	
	@Override
	public RujukanRawatJalanModel saveRujukan(RujukanRawatJalanModel rujukan) {
		return rujukanDb.save(rujukan);
	}
}
