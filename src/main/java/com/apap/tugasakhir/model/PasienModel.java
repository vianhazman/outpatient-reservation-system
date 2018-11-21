package com.apap.tugasakhir.model;

import java.io.Serializable;
import java.util.HashMap;

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

	public HashMap<String, Integer> getStatusPasien() {
		return statusPasien;
	}

	public void setStatusPasien(Integer id) {
		this.statusPasien.put("id", id);
	}

	public HashMap<String, Integer> getPoliRujukan() {
		return poliRujukan;
	}

	public void setPoliRujukan(Integer id) {
		this.poliRujukan.put("id", id);
	}

	private String nama;
	
	private HashMap<String,Integer> statusPasien;
	
	private HashMap<String,Integer> poliRujukan;

}
