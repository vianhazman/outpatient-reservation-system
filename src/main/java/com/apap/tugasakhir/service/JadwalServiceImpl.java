package com.apap.tugasakhir.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugasakhir.model.JadwalPoliModel;
import com.apap.tugasakhir.repository.JadwalPoliDb;

@Service
@Transactional
public class JadwalServiceImpl implements JadwalService {
	@Autowired
	private JadwalPoliDb jadwalDb;

	@Override
	public List<JadwalPoliModel> findAll() {
		return jadwalDb.findAll();
	}

}
