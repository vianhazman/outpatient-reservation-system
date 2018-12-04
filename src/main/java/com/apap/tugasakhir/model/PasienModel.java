package com.apap.tugasakhir.model;

import java.io.Serializable;
import java.sql.Date;


public class PasienModel implements Serializable {	

	private long id;
	
	private String nama;
	
	private statusPasienWrapper statusPasien;
	
	private int poliRujukan;
	
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
}
