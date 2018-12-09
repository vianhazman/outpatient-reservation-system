package com.apap.tugasakhir.service;

import java.util.List;

import com.apap.tugasakhir.model.RujukanRawatJalanModel;

public interface RujukanRawatJalanService {
	List<RujukanRawatJalanModel> listRujukan();
	RujukanRawatJalanModel getRujukanById(long id);
	RujukanRawatJalanModel getRujukanByIdPasien(long id);
}
