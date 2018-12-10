package com.apap.tugasakhir.service;

import java.sql.Date;
import java.util.List;

import com.apap.tugasakhir.model.JadwalPoliModel;


public interface JadwalService {
	List<JadwalPoliModel> findAll();
	JadwalPoliModel getJadwalById(long id);
	void update(long id, JadwalPoliModel jadwal);
	void add(JadwalPoliModel jadwal);
	JadwalPoliModel	getByTanggalAndDokter(Date tanggal, long dokter);


}
