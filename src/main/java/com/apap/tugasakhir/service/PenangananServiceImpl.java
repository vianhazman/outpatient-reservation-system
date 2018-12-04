package com.apap.tugasakhir.service;

import com.apap.tugasakhir.model.PenangananModel;
import com.apap.tugasakhir.repository.PenangananDB;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PenangananServiceImpl implements PenangananService{
	@Autowired
	private PenangananDB penangananDb;
	
	@Override
	public List<PenangananModel> getAllPenanganan(Long idPasienRawatJalan) {
		List<PenangananModel> temp = penangananDb.findAll();
		List<PenangananModel> result = penangananDb.findAll();
		result.clear();
		for(int i = 0; i < temp.size(); i++) {
			if(temp.get(i).getIdPasienRawatJalan() == idPasienRawatJalan) {
				result.add(temp.get(i));
			}
		}
		return result;
	}

}
