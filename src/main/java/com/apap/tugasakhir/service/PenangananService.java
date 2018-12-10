package com.apap.tugasakhir.service;

import java.util.List;
import java.util.Optional;

import com.apap.tugasakhir.model.PenangananModel;

public interface PenangananService {
	List<PenangananModel> getAllPenanganan(Long idPasienRawatJalan);

	void addPenanganan(PenangananModel penanganan);
}
