package com.apap.tugasakhir.wrapper;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class PostLaboratoriumWrapper {
	private long id;
	private Date tanggalPengajuan;
	private long idPasien;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getTanggalPengajuan() {
		return tanggalPengajuan;
	}
	public void setTanggalPengajuan(Date tanggalPengajuan) {
		this.tanggalPengajuan = tanggalPengajuan;
	}
	public long getIdPasien() {
		return idPasien;
	}
	public void setIdPasien(long idPasien) {
		this.idPasien = idPasien;
	}
	public Map<String, Long> getJenisPemeriksaan() {
		return jenisPemeriksaan;
	}
	public void setJenisPemeriksaan(long id) {
		this.jenisPemeriksaan = new HashMap<String,Long>();
		this.jenisPemeriksaan.put("id", id);
	}
	private Map<String,Long> jenisPemeriksaan;
}

