package com.apap.tugasakhir.service;

import java.sql.Date;
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

	@Override
	public JadwalPoliModel getJadwalById(long id) {
		return jadwalDb.findById(id);
	}
	
	@Override
	public void update(long id, JadwalPoliModel jadwal) {
		JadwalPoliModel oldJadwal = this.getJadwalById(id);
		oldJadwal.setJamMulai(jadwal.getJamMulai().toString());
		oldJadwal.setJamSelesai(jadwal.getJamSelesai().toString());
		oldJadwal.setTanggal(jadwal.getTanggal());
		oldJadwal.setDokter(jadwal.getDokter());
		oldJadwal.setPoli(jadwal.getPoli());
	}

	@Override
	public void add(JadwalPoliModel jadwal) {
		jadwalDb.save(jadwal);
		
	}
	
	@Override
	public JadwalPoliModel getByTanggalAndDokter(Date tanggal, long dokter) {
		return jadwalDb.findByTanggalAndDokter(tanggal, dokter);
	}

}
