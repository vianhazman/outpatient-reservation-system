package com.apap.tugasakhir.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugasakhir.model.JadwalPoliModel;
import com.apap.tugasakhir.repository.JadwalPoliDB;

@Service
@Transactional
public class JadwalServiceImpl implements JadwalService {
	@Autowired
	private JadwalPoliDB jadwalDb;

	@Override
	public List<JadwalPoliModel> findAll() {
		return jadwalDb.findAll();
	}

	@Override
	public JadwalPoliModel getJadwalById(long id) {
		return jadwalDb.findById(id).get();
	}
	
	@Override
	public void update(long id, JadwalPoliModel jadwal) {
		JadwalPoliModel oldJadwal = this.getJadwalById(id);
		oldJadwal.setJamMulai(jadwal.getJamMulai());
		oldJadwal.setJamSelesai(jadwal.getJamSelesai());
		oldJadwal.setTanggal(jadwal.getTanggal());
		oldJadwal.setDokter(jadwal.getDokter());
		oldJadwal.setPoli(jadwal.getPoli());
	}

	@Override
	public void add(JadwalPoliModel jadwal) {
		jadwalDb.save(jadwal);
		
	}

}
