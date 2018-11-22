package com.apap.tugasakhir.model;

import java.io.Serializable;

import com.apap.tugasakhir.wrapper.statusPasienWrapper;

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

	public statusPasienWrapper getStatusPasien() {
		return statusPasien;
	}

	public void setStatusPasien(statusPasienWrapper statusPasien) {
		this.statusPasien = statusPasien;
	}

	public int getPoliRujukan() {
		return poliRujukan;
	}

	public void setPoliRujukan(int poliRujukan) {
		this.poliRujukan = poliRujukan;
	}

	private String nama;
	
	private statusPasienWrapper statusPasien;
	
	private int poliRujukan;

}
