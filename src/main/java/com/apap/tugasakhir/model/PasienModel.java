package com.apap.tugasakhir.model;

import java.io.Serializable;
import java.sql.Date;


public class PasienModel implements Serializable {	

	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	

	public StatusPasienModel getStatusPasien() {
		return statusPasien;
	}

	public void setStatusPasien(StatusPasienModel statusPasien) {
		this.statusPasien = statusPasien;
	}

	public PoliRujukanModel getPoliRujukan() {
		return poliRujukan;
	}

	public void setPoliRujukan(PoliRujukanModel poliRujukan) {
		this.poliRujukan = poliRujukan;
	}



	private String nama;
	
	private StatusPasienModel statusPasien;
	
	private PoliRujukanModel poliRujukan;
	
	private Date tanggalRujukan;

	public Date getTanggalRujukan() {
		return tanggalRujukan;
	}

	public void setTanggalRujukan(Date tanggalRujukan) {
		this.tanggalRujukan = tanggalRujukan;
	}

}