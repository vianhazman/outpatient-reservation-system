package com.apap.tugasakhir.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugasakhir.model.HariPoliModel;
import com.apap.tugasakhir.repository.HariPoliDB;


@Service
@Transactional
public class HariPoliServiceImpl implements HariPoliService {
	@Autowired
	private HariPoliDB hariPoliDB;

	@Override
	public List<HariPoliModel> getAllHari() {
		// TODO Auto-generated method stub
		return hariPoliDB.findAll();
	}

	@Override
	public List<HariPoliModel> findHariById_Poli(HariPoliModel hari) {
		// TODO Auto-generated method stub
		return hariPoliDB.findByHari(hari);
	}

	@Override
	public HariPoliModel getDetailById(long id) {
		// TODO Auto-generated method stub
		return hariPoliDB.findById(id);
	}
}
