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
	public ObatModel getObat() {
		return null;
	}

}
