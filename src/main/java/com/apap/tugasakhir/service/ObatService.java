package com.apap.tugasakhir.service;

import java.util.List;
import java.util.Optional;

import com.apap.tugasakhir.model.ObatModel;
import com.apap.tugasakhir.model.PenangananModel;

public interface ObatService {

	List<ObatModel> getAllObatAvailable();
	void addObat(ObatModel obat);
}
