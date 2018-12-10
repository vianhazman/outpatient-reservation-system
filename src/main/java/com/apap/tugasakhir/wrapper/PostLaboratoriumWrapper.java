package com.apap.tugasakhir.wrapper;

import java.io.Serializable;
import java.sql.Date;

public class PostLaboratoriumWrapper implements Serializable {
	private Date tanggalPengajuan;
	private long idPasien;
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
	public GetJenisPemeriksaanWrapper getJenisPemeriksaan() {
		return jenisPemeriksaan;
	}
	public void setJenisPemeriksaan(GetJenisPemeriksaanWrapper jenisPemeriksaan) {
		this.jenisPemeriksaan =jenisPemeriksaan;
	}
	private GetJenisPemeriksaanWrapper jenisPemeriksaan;
}

