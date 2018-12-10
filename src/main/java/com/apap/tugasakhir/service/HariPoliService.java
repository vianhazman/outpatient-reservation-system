package com.apap.tugasakhir.service;
import java.util.List;

import com.apap.tugasakhir.model.HariPoliModel;


public interface HariPoliService {

	List<HariPoliModel> getAllHari();
	List<HariPoliModel> findHariById_Poli(HariPoliModel hari);
	HariPoliModel getDetailById(long id);
	
}

